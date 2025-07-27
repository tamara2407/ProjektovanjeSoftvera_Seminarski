/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import domen.Figura;
import domen.Tezina;
import forme.DodajFiguruForma;
import forme.FormaMod;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author gtama
 */
public class DodajFiguruController {
    
    private final DodajFiguruForma dff;
    
    public DodajFiguruController(DodajFiguruForma dff) {
        this.dff = dff;
        addActionListeners();
    }


    public void otvoriFormu(FormaMod mod) {
        pripremiFormu(mod);
        dff.setVisible(true);   
    }

    private void addActionListeners(){
    
        dff.dodajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dodaj(e);
            }

            private void dodaj(ActionEvent e) {
               
                String naziv = dff.getjTextFieldNaziv().getText().trim();
                String tezina = String.valueOf(dff.getjComboBoxTezina().getSelectedItem());
                double cena = Double.parseDouble(dff.getjTextFieldCena().getText());
                
                Figura f = new Figura(-1,naziv,tezina,cena);
                             
                try{
                    komunikacija.Komunikacija.getInstance().dodajFiguru(f);
                    JOptionPane.showMessageDialog(dff, "USPEH","USPEH",JOptionPane.INFORMATION_MESSAGE);
                    dff.dispose();
                }catch(Exception exc){
                    JOptionPane.showMessageDialog(dff, "GRESKA","GRESKA",JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
        
        
        dff.izmeniAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                izmeni(e);
            }

            private void izmeni(ActionEvent e) {
               
                int id = Integer.parseInt(dff.getjTextFieldID().getText());
                String naziv = dff.getjTextFieldNaziv().getText().trim();
                String tezina = String.valueOf(dff.getjComboBoxTezina().getSelectedItem());
                double cena = Double.parseDouble(dff.getjTextFieldCena().getText());
                
                Figura f = new Figura(id,naziv,tezina,cena);                
                try{
                    komunikacija.Komunikacija.getInstance().azurirajFiguru(f);
                    JOptionPane.showMessageDialog(dff, "USPEH","USPEH",JOptionPane.INFORMATION_MESSAGE);
                    dff.dispose();
                }catch(Exception exc){
                    JOptionPane.showMessageDialog(dff, "GRESKA","GRESKA",JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
        
    }
    
    
    
    

     private void pripremiFormu(FormaMod mod) {
         
         dff.getjComboBoxTezina().removeAllItems();
         
         for (Tezina tezina : Tezina.values()) {
             dff.getjComboBoxTezina().addItem(tezina.toString());
         }
         
        switch (mod) {
            case DODAJ:
                dff.getjTextFieldID().setEnabled(false);
                dff.getjButtonAzuriraj().setVisible(false);
                dff.getjButtonDodaj().setVisible(true);
                dff.getjButtonDodaj().setEnabled(true);
                break;
            case IZMENI:
                dff.getjButtonDodaj().setVisible(false);
                dff.getjButtonAzuriraj().setVisible(true);
                dff.getjButtonAzuriraj().setEnabled(true);    
                Figura f = (Figura) cordinator.Cordinator.getInstance().vratiParam("figura");
                dff.getjTextFieldNaziv().setText(f.getNaziv());
                dff.getjComboBoxTezina().setSelectedItem(f.getTezina());
                dff.getjTextFieldCena().setText(String.valueOf(f.getCena()));
                dff.getjTextFieldID().setText(f.getFiguraID()+"");
                dff.getjTextFieldID().setEnabled(false);
                break;
            default:
                throw new AssertionError();
        }
        
    }
    
}
