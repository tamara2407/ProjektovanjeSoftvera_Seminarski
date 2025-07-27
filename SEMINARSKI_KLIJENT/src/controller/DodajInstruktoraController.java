/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import forme.DodajInstruktoraForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import domen.Instruktor;
import forme.FormaMod;
import javax.swing.JOptionPane;

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


    public void otvoriFormu(FormaMod mod) {
        pripremiFormu(mod);
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
                String lozinka = String.valueOf(dif.getjPasswordFieldLozinka().getPassword());
                
                Instruktor i = new Instruktor(-1,ime,prezime,email,korisnickoIme,lozinka);                
                try{
                    komunikacija.Komunikacija.getInstance().dodajInstruktora(i);
                    JOptionPane.showMessageDialog(dif, "USPEH","USPEH",JOptionPane.INFORMATION_MESSAGE);
                    dif.dispose();
                }catch(Exception exc){
                    JOptionPane.showMessageDialog(dif, "GRESKA","GRESKA",JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
        
        
        dif.izmeniInstruktoraAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                izmeni(e);
            }

            private void izmeni(ActionEvent e) {
               
                int id = Integer.parseInt(dif.getjTextFieldID().getText());
                String ime = dif.getjTextFieldIme().getText().trim();
                String prezime = dif.getjTextFieldPrezime().getText().trim();
                String email = dif.getjTextFieldEmail().getText().trim();
                String korisnickoIme = dif.getjTextFieldKorisnickoIme().getText().trim();
                String lozinka = String.valueOf(dif.getjPasswordFieldLozinka().getPassword());
                
                Instruktor i = new Instruktor(id,ime,prezime,email,korisnickoIme,lozinka);                
                try{
                    komunikacija.Komunikacija.getInstance().azurirajInstruktora(i);
                    JOptionPane.showMessageDialog(dif, "USPEH","USPEH",JOptionPane.INFORMATION_MESSAGE);
                    dif.dispose();
                }catch(Exception exc){
                    JOptionPane.showMessageDialog(dif, "GRESKA","GRESKA",JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
        
    }

     private void pripremiFormu(FormaMod mod) {
        switch (mod) {
            case DODAJ:
                dif.getjTextFieldID().setEnabled(false);
                dif.getjButtonAzuriraj().setVisible(false);
                dif.getjButtonDodaj().setVisible(true);
                dif.getjButtonDodaj().setEnabled(true);
                break;
            case IZMENI:
                dif.getjButtonDodaj().setVisible(false);
                dif.getjButtonAzuriraj().setVisible(true);
                dif.getjButtonAzuriraj().setEnabled(true);    
                Instruktor i = (Instruktor) cordinator.Cordinator.getInstance().vratiParam("instruktor");
                dif.getjTextFieldIme().setText(i.getIme());
                dif.getjTextFieldPrezime().setText(i.getPrezime());
                dif.getjTextFieldEmail().setText(i.getEmail());
                dif.getjTextFieldKorisnickoIme().setText(i.getKorisnickoIme());
                dif.getjPasswordFieldLozinka().setText(i.getLozinka());
                dif.getjTextFieldID().setText(i.getInstruktorID()+"");
                dif.getjTextFieldID().setEnabled(false);
                break;
            default:
                throw new AssertionError();
        }
        
    }
    
}
