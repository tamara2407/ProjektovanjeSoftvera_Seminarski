/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.Instruktor;
import forme.GlavnaForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author gtama
 */
public class GlavnaFormaController {
    
    private final GlavnaForma gf;
    
    public GlavnaFormaController(GlavnaForma gf) {
        this.gf = gf;
        addActionListeners();
    }


    public void otvoriFormu() {
        Instruktor ulogovani = cordinator.Cordinator.getInstance().getUlogovani();
        String imePrezime = ulogovani.getIme()+" "+ulogovani.getPrezime();
        gf.setVisible(true);
        gf.getjLabelUlogovani().setText(imePrezime);
    }
    
        private void addActionListeners() {
        gf.kreirajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cordinator.Cordinator.getInstance().otvoriKreirajEvidencijuRadioniceForma();

            }

        });
        gf.izmeniAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cordinator.Cordinator.getInstance().otvoriIzmeniEvidencijuRadioniceFormu();
                

            }

        });

    }
    
}
