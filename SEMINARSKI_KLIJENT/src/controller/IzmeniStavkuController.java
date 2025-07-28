/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.EvidencijaRadionice;
import domen.StatusStavke;
import domen.StavkaEvidencijeRadionice;
import forme.IzmeniEvidencijuRadioniceForma;
import forme.IzmeniStavkuForma;
import forme.model.ModelTabeleStavke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gtama
 */
public class IzmeniStavkuController {
    private final IzmeniStavkuForma isf;

    public IzmeniStavkuController(IzmeniStavkuForma isf) {
        this.isf = isf;
        addActionListener();
    }

    private void addActionListener() {

        isf.dodajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do {
                    cordinator.Cordinator.getInstance().otvoriDodajStavkuFormu(null);
                    

                    StavkaEvidencijeRadionice stavkaEvidencije = (StavkaEvidencijeRadionice) cordinator.Cordinator.getInstance().vratiParam("stavka");
                    if (stavkaEvidencije == null) {
                        return;
                    }

                    stavkaEvidencije.setEvidencijaRadionice(((IzmeniEvidencijuRadioniceForma)isf.getParent()).getEvidencijaRadionice());
                    ModelTabeleStavke mts = (ModelTabeleStavke) isf.getjTableStavke().getModel();

                    boolean postoji = false;
                    List<StavkaEvidencijeRadionice> stavke = mts.getLista();
                    for (StavkaEvidencijeRadionice s : stavke) {
                        if (s.getFigura().equals(stavkaEvidencije.getFigura())) {
                            int noviBrojCasova = s.getBrojCasova()+ stavkaEvidencije.getBrojCasova();
                            mts.obrisiStavku(s);
                            stavkaEvidencije.setBrojCasova(noviBrojCasova);
                            stavkaEvidencije.setCenaStavke(stavkaEvidencije.getCenaFigure()* noviBrojCasova);

                            if (s.getStatus() != StatusStavke.NOVA) {
                                stavkaEvidencije.setStatus(StatusStavke.IZMENJENA);
                            } else {
                                stavkaEvidencije.setStatus(StatusStavke.NOVA);
                            }
                            postoji = true;
                            break;

                        }
                    }

                    if (!postoji) {
                        stavkaEvidencije.setStatus(StatusStavke.NOVA);
                        mts.dodaj(stavkaEvidencije);
                        System.out.println("KLASA ISCONTROLEER STATUS STAVKE KOD NE POSTOJI: " + stavkaEvidencije.getStatus());
                    }

                    azurirajUkupnuCenu();
                    
                } while (JOptionPane.showConfirmDialog(null, "Želite li da dodate još stavki u evidenciju radionice?", "POTVRDA", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);

            }

        });
        isf.obrisiAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = isf.getjTableStavke().getSelectedRow();
                if (red == -1) {
                    JOptionPane.showMessageDialog(isf, "Morate da selektujete stavku", "NEUSPEŠNO", JOptionPane.ERROR_MESSAGE);
                } else {
                    int potvrda = JOptionPane.showConfirmDialog(null, "Da li ste sigurni?", "POTVRDA", JOptionPane.YES_NO_OPTION);
                    if (potvrda == JOptionPane.NO_OPTION || potvrda == JOptionPane.CLOSED_OPTION) {
                        return;
                    }
                    ModelTabeleStavke mts = (ModelTabeleStavke) isf.getjTableStavke().getModel();
                    
                    StavkaEvidencijeRadionice s = mts.getAktivneStavke().get(red);

                    s.setStatus(StatusStavke.OBRISANA);
                    mts.obrisiStavku(s);

                    System.out.println("KLASA ISCONTROLEER STATUS STAVKE: " + s.getStatus());
                    ukupnaCena -= s.getCenaStavke();
                    
                    ((IzmeniEvidencijuRadioniceForma) isf.getParent()).getEvidencijaRadionice().setCena(ukupnaCena);
                    isf.getjLabelUkupnaCena().setText(ukupnaCena + "");
                }
            }

        });

        isf.izmeniBrojCasovaAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = isf.getjTableStavke().getSelectedRow();
                if (red == -1) {
                    JOptionPane.showMessageDialog(isf, "Morate da selektujete stavku", "NEUSPEŠNO", JOptionPane.ERROR_MESSAGE);
                } else {

                    ModelTabeleStavke mts = (ModelTabeleStavke) isf.getjTableStavke().getModel();
                    StavkaEvidencijeRadionice s = mts.getAktivneStavke().get(red);

                    cordinator.Cordinator.getInstance().otvoriIzmeniBrojCasovaFormu(isf, s);
                    ((ModelTabeleStavke) isf.getjTableStavke().getModel()).fireTableDataChanged();
                    azurirajUkupnuCenu();

                }

            }

        });

        isf.sacuvajAddActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                EvidencijaRadionice er = ((IzmeniEvidencijuRadioniceForma)isf.getParent()).getEvidencijaRadionice();
                er.setDatum(new Date());

                ModelTabeleStavke mts = (ModelTabeleStavke) isf.getjTableStavke().getModel();

                er.setStavke(mts.getLista());

                er.setCena(ukupnaCena);

                try {

                    komunikacija.Komunikacija.getInstance().izmeniEvidencijuRadionice(er);
                    JOptionPane.showMessageDialog(isf, "Sistem je zapamtio evidenciju radionice", "USPEŠNO", JOptionPane.INFORMATION_MESSAGE);
                    isf.dispose();
                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(isf, "Sistem ne može da zapamti evidenciju radionice", "NEUPEŠNO", JOptionPane.ERROR_MESSAGE);
                }
            }

        }
        );

    }

    public void otvoriFormu() {
        pripremiFormu();
        isf.setVisible(true);

    }

    private double ukupnaCena = 0;

    private void pripremiFormu() {
        List<StavkaEvidencijeRadionice> stavke = komunikacija.Komunikacija.getInstance().ucitajStavkeZaEvidencijuRadionice(((IzmeniEvidencijuRadioniceForma)isf.getParent()).getEvidencijaRadionice().getEvidencijaRadioniceID());
        ModelTabeleStavke mts = new ModelTabeleStavke(stavke);
        isf.getjTableStavke().setModel(mts);

        for (StavkaEvidencijeRadionice se : stavke) {
            ukupnaCena = ukupnaCena + se.getCenaStavke();
        }
        isf.getjLabelUkupnaCena().setText(ukupnaCena + "");
    }
    
    private void azurirajUkupnuCenu() {
        ukupnaCena = 0;
        ModelTabeleStavke mts = (ModelTabeleStavke) isf.getjTableStavke().getModel();
        for (StavkaEvidencijeRadionice s : mts.getLista()) {
            if (s.getStatus() != StatusStavke.OBRISANA) {
                ukupnaCena += s.getCenaStavke();
            }
        }
        ((IzmeniEvidencijuRadioniceForma) isf.getParent()).getEvidencijaRadionice().setCena(ukupnaCena);
        isf.getjLabelUkupnaCena().setText(String.valueOf(ukupnaCena));
    }
    
}
