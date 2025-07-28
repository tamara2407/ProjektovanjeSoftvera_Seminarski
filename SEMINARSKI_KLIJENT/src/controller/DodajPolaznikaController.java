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
                
                if (ime.isEmpty() && prezime.isEmpty() && email.isEmpty()) {
                    JOptionPane.showMessageDialog(dpf, "Sistem ne može da kreira polaznika", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (ime.isEmpty()) {
                    JOptionPane.showMessageDialog(dpf, "Potrebno je da unesete ime polaznika", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!ime.matches("[a-zA-ZšđčćžŠĐČĆŽ\\s]+") || ime.length() <= 2) {
                    JOptionPane.showMessageDialog(dpf, "Ime koje ste uneli nije odgovarajuće", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (prezime.isEmpty()) {
                    JOptionPane.showMessageDialog(dpf, "Potrebno je da unesete prezime polaznika", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!prezime.matches("[a-zA-ZšđčćžŠĐČĆŽ\\s]+") || prezime.length() <= 2) {
                    JOptionPane.showMessageDialog(dpf, "Prezime koje ste uneli nije odgovarajuće", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (email.isEmpty()) {
                    JOptionPane.showMessageDialog(dpf, "Potrebno je da unesete email polaznika", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!email.contains("@")) {
                    JOptionPane.showMessageDialog(dpf, "Email nije u odgovarajućem formatu", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                

                Kategorija kategorija = (Kategorija) dpf.getjComboBoxKategorija().getSelectedItem();
                
                if (kategorija == null || kategorija.getNaziv().equals("Odaberite kategoriju")) {
                    JOptionPane.showMessageDialog(dpf, "Potrebno je da selektujete kategoriju", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                Polaznik p = new Polaznik(-1, ime, prezime, email, kategorija);
                 
                try{
                    komunikacija.Komunikacija.getInstance().dodajPolaznika(p);
                    JOptionPane.showMessageDialog(dpf, "Sistem je kreirao polaznika", "USPEŠNO",JOptionPane.INFORMATION_MESSAGE);
                    dpf.dispose();
                }catch(Exception exc){
                    JOptionPane.showMessageDialog(dpf, exc.getMessage(), "NEUSPEŠNO",JOptionPane.ERROR_MESSAGE);
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
                
                
                if (ime.isEmpty() && prezime.isEmpty() && email.isEmpty()) {
                    JOptionPane.showMessageDialog(dpf, "Unesite potrebne podatke", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (ime.isEmpty()) {
                    JOptionPane.showMessageDialog(dpf, "Potrebno je da unesete ime polaznika", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!ime.matches("[a-zA-ZšđčćžŠĐČĆŽ\\s]+") || ime.length() <= 2) {
                    JOptionPane.showMessageDialog(dpf, "Ime koje ste uneli nije odgovarajuće", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (prezime.isEmpty()) {
                    JOptionPane.showMessageDialog(dpf, "Potrebno je da unesete prezime polaznika", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!prezime.matches("[a-zA-ZšđčćžŠĐČĆŽ\\s]+") || prezime.length() <= 2) {
                    JOptionPane.showMessageDialog(dpf, "Prezime koje ste uneli nije odgovarajuće", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (email.isEmpty()) {
                    JOptionPane.showMessageDialog(dpf, "Potrebno je da unesete email polaznika", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!email.contains("@")) {
                    JOptionPane.showMessageDialog(dpf, "Email nije u odgovarajućem formatu", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                
                Kategorija kategorija = (Kategorija) dpf.getjComboBoxKategorija().getSelectedItem();
                
                if (kategorija == null || kategorija.getNaziv().equals("Odaberite kategoriju")) {
                    JOptionPane.showMessageDialog(dpf, "Potrebno je da selektujete kategoriju", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                Polaznik p = new Polaznik(id,ime,prezime,email,kategorija);            
                try{
                    komunikacija.Komunikacija.getInstance().azurirajPolaznika(p);
                    JOptionPane.showMessageDialog(dpf, "Sistem je zapamtio polaznika", "USPEŠNO",JOptionPane.INFORMATION_MESSAGE);
                    dpf.dispose();
                }catch(Exception exc){
                    JOptionPane.showMessageDialog(dpf, "Sistem ne može da zapamti polaznika", "NEUSPEŠNO",JOptionPane.ERROR_MESSAGE);
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
                dpf.getjLabelID().setVisible(false);
                dpf.getjTextFieldID().setVisible(false);
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
