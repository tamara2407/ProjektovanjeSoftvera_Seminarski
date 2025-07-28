/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.EvidencijaRadionice;
import domen.Polaznik;
import domen.StavkaEvidencijeRadionice;
import forme.KreiranjeEvidencijeRadioniceForma;
import forme.model.ModelTabelePolaznik;
import forme.model.ModelTabeleStavke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author gtama
 */
public class KreirajEvidencijuRadioniceController {
    
    private final KreiranjeEvidencijeRadioniceForma kef;

    public KreirajEvidencijuRadioniceController(KreiranjeEvidencijeRadioniceForma kef) {
        this.kef = kef;
        addActionListeners();
    }

    double ukupnaCena;

    private void addActionListeners() {
        kef.pretraziAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String imePrezime = kef.getjTextFieldImePrezime().getText().trim();

                ModelTabelePolaznik mtk = (ModelTabelePolaznik) kef.getjTablePolaznici().getModel();
                mtk.pretrazi(imePrezime);
                if (mtk.getLista().isEmpty()) {
                    JOptionPane.showMessageDialog(kef, "Sistem ne može da nađe polaznike po zadatom kriterijumu", "NEUSPEŠNO", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(kef, "Sistem je našao polaznike po zadatom kriterijumu", "USPEŠNO", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        });
        kef.resetujAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                pripremiFormuUcitajPolaznike();
                kef.getjTextFieldImePrezime().setText("");
            }

        });
        kef.selektujAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = kef.getjTablePolaznici().getSelectedRow();

                if (red == -1) {
                    JOptionPane.showMessageDialog(kef, "Sistem ne može da nađe polaznika ", "NEUSPEŠNO", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(kef, "Sistem je našao polaznika ", "USPEŠNO", JOptionPane.INFORMATION_MESSAGE);
                    ModelTabelePolaznik mtp = (ModelTabelePolaznik) kef.getjTablePolaznici().getModel();
                    Polaznik polaznik = mtp.getLista().get(red);

                    kef.getjLabelSelektovani().setText(polaznik.getIme() + " " + polaznik.getPrezime());

                    kef.getEvidencijaRadionice().setPolaznik(polaznik);
                }

            }

        });

        kef.dodajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (kef.getEvidencijaRadionice().getPolaznik()== null) {
                    JOptionPane.showMessageDialog(kef, "Niste izabrali polaznika", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                do {
                    cordinator.Cordinator.getInstance().otvoriDodajStavkuFormu(kef);
                    pripremiFormuStavki();
                    ukupnaCena = 0;
                    for (StavkaEvidencijeRadionice s : kef.getEvidencijaRadionice().getStavke()) {
                        ukupnaCena += s.getCenaStavke();
                        kef.getjLabelUkupanIznos().setText(ukupnaCena + "");
                    }
                    kef.getEvidencijaRadionice().setCena(ukupnaCena);
                } while (JOptionPane.showConfirmDialog(null, "Želite li dodati još stavki?", "POTVRDA", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);

            }
        });
        
        
        
        kef.obrisiAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = kef.getjTableStavke().getSelectedRow();
                if(red == -1){
                    JOptionPane.showMessageDialog(kef, "Selektujte stavku koju želite da obrišete", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    int potvrda = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite da obrišete stavku?", "POTVRDA", JOptionPane.YES_NO_OPTION);
                    if(potvrda == JOptionPane.NO_OPTION || potvrda == JOptionPane.CLOSED_OPTION){
                        return;
                    }
                    ModelTabeleStavke mts = (ModelTabeleStavke) kef.getjTableStavke().getModel();
                    StavkaEvidencijeRadionice stavka = mts.getLista().get(red);
                    
                    mts.obrisiStavku(stavka);
                    pripremiFormuStavki();
                    
                    ukupnaCena =ukupnaCena- stavka.getCenaStavke();
                    kef.getEvidencijaRadionice().setCena(ukupnaCena);
                    kef.getjLabelUkupanIznos().setText(ukupnaCena+"");
                }
            }

        });
        
          kef.sacuvajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                double iznos = Double.parseDouble(kef.getjLabelUkupanIznos().getText());
                if(iznos <= 0){
                    JOptionPane.showMessageDialog(kef, "Sistem ne može da kreira evidenciju radionice", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                EvidencijaRadionice evidencijaRadionice = kef.getEvidencijaRadionice();
                evidencijaRadionice.setDatum(new Date());
                evidencijaRadionice.setInstruktor(cordinator.Cordinator.getInstance().getUlogovani());
                
                try{
                    komunikacija.Komunikacija.getInstance().dodajEvidencijuRadionice(evidencijaRadionice);
                    JOptionPane.showMessageDialog(kef, "Sistem je kreirao evidenciju radionice", "USPEŠNO", JOptionPane.INFORMATION_MESSAGE);
                    
                    int potvrda = JOptionPane.showConfirmDialog(null, "Da li želite da kreirate novu narudžbenicu?", "POTVRDA", JOptionPane.YES_NO_OPTION);
                    if(potvrda == JOptionPane.YES_OPTION){
                        cordinator.Cordinator.getInstance().otvoriKreiranjeEvidencijeRadioniceForma();
                    }
                    kef.dispose();
                }catch(Exception exc){
                    JOptionPane.showMessageDialog(kef, "Sistem ne može da kreira evidenciju radionice", "NEUSPEŠNO", JOptionPane.ERROR_MESSAGE);
                }
            }

        });
        
        
        
        

    }

    public void otvoriFormu() {
        pripremiFormuUcitajPolaznike();
        pripremiFormuStavki();
        kef.setVisible(true);
    }

    public void pripremiFormuUcitajPolaznike() {

        List<Polaznik> sviPolaznici = Komunikacija.getInstance().ucitajPolaznike();
        ModelTabelePolaznik mtp = new ModelTabelePolaznik(sviPolaznici);
        kef.getjTablePolaznici().setModel(mtp);

    }

    public void pripremiFormuStavki() {

        List<StavkaEvidencijeRadionice> stavke = kef.getEvidencijaRadionice().getStavke();
        ModelTabeleStavke mts = new ModelTabeleStavke(stavke);
        kef.getjTableStavke().setModel(mts);

    }
    
}
