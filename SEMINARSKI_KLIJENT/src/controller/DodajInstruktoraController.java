/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import forme.DodajInstruktoraForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import domen.Instruktor;

/**
 *
 * @author gtama
 */
public class DodajInstruktoraController {
    
    private final DodajInstruktoraForma dif;
    
    public DodajInstruktoraController(DodajInstruktoraForma dif) {
        this.dif = dif;
        addActionListeners();
    }


    public void otvoriFormu() {
        dif.setVisible(true);   
    }

    private void addActionListeners(){
    
        dif.dodajInstruktoraAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dodaj(e);
            }

            private void dodaj(ActionEvent e) {
               
                String ime = dif.getjTextFieldIme().getText().trim();
                String prezime = dif.getjTextFieldPrezime().getText().trim();
                String email = dif.getjTextFieldEmail().getText().trim();
                String korisnickoIme = dif.getjTextFieldKorisnickoIme().getText().trim();
                String lozinka = String.valueOf(dif.getjPasswordField1().getPassword());
                
                Instruktor i = new Instruktor(-1,ime,prezime,email,korisnickoIme,lozinka);                
                komunikacija.Komunikacija.getInstance().dodajInstruktora(i);
                
            }
        });
        
    }
    
}
