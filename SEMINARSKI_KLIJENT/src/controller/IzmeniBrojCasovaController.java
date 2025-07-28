/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.StatusStavke;
import domen.StavkaEvidencijeRadionice;
import forme.IzmeniBrojCasovaForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author gtama
 */
public class IzmeniBrojCasovaController {
    private final IzmeniBrojCasovaForma ibcf;
    private StavkaEvidencijeRadionice stavka;

    public IzmeniBrojCasovaController(IzmeniBrojCasovaForma ibcf) {
        this.ibcf = ibcf;
        addActionListener();

    }

    public void otvoriFormu() {
        if (stavka != null) {
            ibcf.getjTextFieldBrojCasova().setText(String.valueOf(stavka.getBrojCasova()));
        }

        ibcf.setVisible(true);
    }

    public void setStavka(StavkaEvidencijeRadionice stavka) {
        this.stavka = stavka;
    }

    private void addActionListener() {
        ibcf.sacuvajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (stavka == null) {
                    JOptionPane.showMessageDialog(ibcf, "Morate selektovati stavku za izmenu.", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String kolicinaTekst = ibcf.getjTextFieldBrojCasova().getText().trim();
                if (kolicinaTekst.isEmpty()) {
                    JOptionPane.showMessageDialog(ibcf, "Morate uneti broj časova.", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int noviBrojCasova;
                try {
                    noviBrojCasova = Integer.parseInt(kolicinaTekst);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(ibcf, "Broj časova mora biti ceo broj.", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (noviBrojCasova <= 0) {
                    JOptionPane.showMessageDialog(ibcf, "Broj časova ne sme biti 0 ili manji od nule.", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (noviBrojCasova != stavka.getBrojCasova()) {
                    stavka.setBrojCasova(noviBrojCasova);
                    stavka.setCenaStavke(noviBrojCasova * stavka.getCenaFigure());
                    System.out.println("IKCONTROLLER BROJ CASOVA JE PROMENJENA");

                    if (stavka.getStatus() != StatusStavke.NOVA) {
                        stavka.setStatus(StatusStavke.IZMENJENA);
                    }

                }

                JOptionPane.showMessageDialog(ibcf, "Broj časova i cena stavke su uspešno izmenjeni.", "USPEŠNO", JOptionPane.INFORMATION_MESSAGE);
                ibcf.dispose();

            }

        });
    }
    
}
