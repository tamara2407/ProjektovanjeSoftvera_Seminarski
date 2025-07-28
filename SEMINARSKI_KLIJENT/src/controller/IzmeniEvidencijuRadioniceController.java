/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.EvidencijaRadionice;
import domen.Instruktor;
import domen.StavkaEvidencijeRadionice;
import forme.IzmeniEvidencijuRadioniceForma;
import forme.model.ModelTabeleEvidencijeRadionice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gtama
 */
public class IzmeniEvidencijuRadioniceController {
    
    private final IzmeniEvidencijuRadioniceForma ief;
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
    Instruktor ulogovani = cordinator.Cordinator.getInstance().getUlogovani();


    private List<StavkaEvidencijeRadionice> originalneStavke;

    public IzmeniEvidencijuRadioniceController(IzmeniEvidencijuRadioniceForma ief) {
        this.ief = ief;
        addActionListener();
    }

    public void otvoriFormu() {
        pripremiFormu();
        ief.setVisible(true);
    }

    public void pripremiFormu() {
        List<EvidencijaRadionice> evidencije = komunikacija.Komunikacija.getInstance().ucitajEvidencijeUlogovanog(ulogovani);
        ModelTabeleEvidencijeRadionice mte = new ModelTabeleEvidencijeRadionice(evidencije);
        ief.getjTableEvidencijeRadionica().setModel(mte);
    }

    private void addActionListener() {

        ief.pretraziAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String imePrezime = ief.getjTextFieldPolaznik().getText().trim();

                ModelTabeleEvidencijeRadionice mte = (ModelTabeleEvidencijeRadionice) ief.getjTableEvidencijeRadionica().getModel();
                mte.pretrazi(imePrezime);

                if (mte.getLista().isEmpty()) {
                    JOptionPane.showMessageDialog(ief, "Sistem ne može da nađe evidenciju radionice po zadatom kriterijumu", "NEUSPEŠNO", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(ief, "Sistem je našao evidencije radionice po zadatom kriterijumu", "USPEŠNO", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        });

        ief.resetujAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                pripremiFormu();
                ief.getjTextFieldPolaznik().setText("");
            }

        });

        ief.izmeniAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int red = ief.getjTableEvidencijeRadionica().getSelectedRow();
                if (red == -1) {
                    JOptionPane.showMessageDialog(ief, "Sistem ne može da nađe evidenciju radionice", "NEUSPEŠNO", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(ief, "Sistem je našao evidenciju radionice", "USPEŠNO", JOptionPane.INFORMATION_MESSAGE);
                    ModelTabeleEvidencijeRadionice mte = (ModelTabeleEvidencijeRadionice) ief.getjTableEvidencijeRadionica().getModel();

                    EvidencijaRadionice evidencijaRadionice = mte.getLista().get(red);
                    ief.setEvidencijaRadionice(evidencijaRadionice);

                    originalneStavke = komunikacija.Komunikacija.getInstance()
                            .ucitajStavkeZaEvidencijuRadionice(evidencijaRadionice.getEvidencijaRadioniceID());

                    cordinator.Cordinator.getInstance().otvoriIzmeniStavkuFormu(ief);
                    pripremiFormu();
                    ief.getjTextFieldPolaznik().setText("");
                }

            }

        });

    }

    public void setOriginalneStavke(List<StavkaEvidencijeRadionice> originalneStavke) {
        this.originalneStavke = originalneStavke;
    }

    public List<StavkaEvidencijeRadionice> getOriginalneStavke() {
        return originalneStavke;
    }
    
}
