/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.Kategorija;
import domen.Polaznik;
import domen.Tezina;
import forme.DodajPolaznikaForma;
import forme.FormaMod;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gtama
 */
public class DodajPolaznikaController {
    
    private final DodajPolaznikaForma dpf;
    
    public DodajPolaznikaController(DodajPolaznikaForma dpf) {
        this.dpf = dpf;
        addActionListeners();
    }


    public void otvoriFormu(FormaMod mod) {
        pripremiFormu();
        pripremiFormu(mod);
        dpf.setVisible(true);   
    }

    private void addActionListeners(){
    
        dpf.dodajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dodaj(e);
            }

            private void dodaj(ActionEvent e) {
               
                String ime = dpf.getjTextFieldIme().getText().trim();
                String prezime = dpf.getjTextFieldPrezime().getText().trim();
                String email = dpf.getjTextFieldEmail().getText().trim();
                Kategorija kategorija = (Kategorija) dpf.getjComboBoxKategorija().getSelectedItem();
                
                Polaznik p = new Polaznik(-1, ime, prezime, email, kategorija);
                try{
                    komunikacija.Komunikacija.getInstance().dodajPolaznika(p);
                    JOptionPane.showMessageDialog(dpf, "USPEH","USPEH",JOptionPane.INFORMATION_MESSAGE);
                    dpf.dispose();
                }catch(Exception exc){
                    JOptionPane.showMessageDialog(dpf, "GRESKA","GRESKA",JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
        
        
        dpf.izmeniAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                izmeni(e);
            }

            private void izmeni(ActionEvent e) {
               
                int id = Integer.parseInt(dpf.getjTextFieldID().getText());
                String ime = dpf.getjTextFieldIme().getText().trim();
                String prezime = dpf.getjTextFieldPrezime().getText().trim();
                String email = dpf.getjTextFieldEmail().getText().trim();
                Kategorija kategorija = (Kategorija) dpf.getjComboBoxKategorija().getSelectedItem();
                
                Polaznik p = new Polaznik(id,ime,prezime,email,kategorija);            
                try{
                    komunikacija.Komunikacija.getInstance().azurirajPolaznika(p);
                    JOptionPane.showMessageDialog(dpf, "USPEH","USPEH",JOptionPane.INFORMATION_MESSAGE);
                    dpf.dispose();
                }catch(Exception exc){
                    JOptionPane.showMessageDialog(dpf, "GRESKA","GRESKA",JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
        
    }
    
    
        private void pripremiFormu() {
        List<Kategorija> lista = komunikacija.Komunikacija.getInstance().ucitajKategorije();

        Kategorija prazno = new Kategorija();
        prazno.setNaziv("Odaberite kategoriju");
        lista.add(0, prazno);

        for (Kategorija k : lista) {
            dpf.getjComboBoxKategorija().addItem(k);

        }

    }
    

     private void pripremiFormu(FormaMod mod) {
         
        switch (mod) {
            case DODAJ:
                dpf.getjTextFieldID().setEnabled(false);
                dpf.getjButtonAzuriraj().setVisible(false);
                dpf.getjButtonDodaj().setVisible(true);
                dpf.getjButtonDodaj().setEnabled(true);
                dpf.getjComboBoxKategorija().removeAll();
                komunikacija.Komunikacija.getInstance().ucitajKategorije();
                
                break;
            case IZMENI:
                dpf.getjButtonDodaj().setVisible(false);
                dpf.getjButtonAzuriraj().setVisible(true);
                dpf.getjButtonAzuriraj().setEnabled(true);    
                Polaznik p = (Polaznik) cordinator.Cordinator.getInstance().vratiParam("polaznik");
                dpf.getjTextFieldIme().setText(p.getIme());
                dpf.getjTextFieldPrezime().setText(p.getPrezime());
                dpf.getjTextFieldEmail().setText(p.getEmail());
                dpf.getjComboBoxKategorija().setSelectedItem(p.getKategorija());
                dpf.getjTextFieldID().setText(p.getPolaznikID()+"");
                dpf.getjTextFieldID().setEnabled(false);
                break;
            default:
                throw new AssertionError();
        }
        
    }
    
}
