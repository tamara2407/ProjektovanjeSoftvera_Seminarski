/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.Kategorija;
import forme.DodajKategorijuForma;
import forme.FormaMod;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author gtama
 */
public class DodajKategorijuController {
    
    private final DodajKategorijuForma dkf;
    
    public DodajKategorijuController(DodajKategorijuForma dkf) {
        this.dkf = dkf;
        addActionListeners();
    }


    public void otvoriFormu(FormaMod mod) {
        pripremiFormu(mod);
        dkf.setVisible(true);   
    }

    private void addActionListeners(){
    
        dkf.dodajKategorijuAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dodaj(e);
            }

            private void dodaj(ActionEvent e) {
               
                String naziv = dkf.getjTextFieldNaziv().getText().trim();
                
                Kategorija k = new Kategorija(-1,naziv);                
                try{
                    komunikacija.Komunikacija.getInstance().dodajKategoriju(k);
                    JOptionPane.showMessageDialog(dkf, "USPEH","USPEH",JOptionPane.INFORMATION_MESSAGE);
                    dkf.dispose();
                }catch(Exception exc){
                    JOptionPane.showMessageDialog(dkf, "GRESKA","GRESKA",JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
        
        
        dkf.izmeniKategorijuAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                izmeni(e);
            }

            private void izmeni(ActionEvent e) {
               
                int id = Integer.parseInt(dkf.getjTextFieldID().getText());
                String naziv = dkf.getjTextFieldNaziv().getText().trim();
                
                Kategorija k = new Kategorija(id,naziv);                
                try{
                    komunikacija.Komunikacija.getInstance().azurirajKategoriju(k);
                    JOptionPane.showMessageDialog(dkf, "USPEH","USPEH",JOptionPane.INFORMATION_MESSAGE);
                    dkf.dispose();
                }catch(Exception exc){
                    JOptionPane.showMessageDialog(dkf, "GRESKA","GRESKA",JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
        
    }

     private void pripremiFormu(FormaMod mod) {
        switch (mod) {
            case DODAJ:
                dkf.getjTextFieldID().setEnabled(false);
                dkf.getjButtonAzuriraj().setVisible(false);
                dkf.getjButtonDodaj().setVisible(true);
                dkf.getjButtonDodaj().setEnabled(true);
                dkf.getjLabelID().setVisible(false);
                dkf.getjTextFieldID().setVisible(false);
                break;
            case IZMENI:
                dkf.getjButtonDodaj().setVisible(false);
                dkf.getjButtonAzuriraj().setVisible(true);
                dkf.getjButtonAzuriraj().setEnabled(true);    
                Kategorija k = (Kategorija) cordinator.Cordinator.getInstance().vratiParam("kategorija");
                dkf.getjTextFieldNaziv().setText(k.getNaziv());
                dkf.getjTextFieldID().setText(k.getKategorijaID()+"");
                dkf.getjTextFieldID().setEnabled(false);
                break;
            default:
                throw new AssertionError();
        }
        
    }
    
}
