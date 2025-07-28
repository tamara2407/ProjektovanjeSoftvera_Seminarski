/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.Polaznik;
import forme.PrikazPolaznikaForma;
import forme.model.ModelTabelePolaznik;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gtama
 */
public class PrikazPolaznikaController {
    
    private final PrikazPolaznikaForma ppf;
    
    public PrikazPolaznikaController(PrikazPolaznikaForma ppf) {
        this.ppf = ppf;
        addActionListeners();
    }

    private void addActionListeners() {
        
        ppf.addBtnObrisiActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = ppf.getjTablePolaznici().getSelectedRow();
                if(red==-1){
                    JOptionPane.showMessageDialog(ppf, "Morate selektovati polaznika", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                }else{
                    
                    int potvrda = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite da obrišete polaznika?", "POTVRDA", JOptionPane.YES_NO_OPTION);
                    if (potvrda == JOptionPane.NO_OPTION || potvrda == JOptionPane.CLOSED_OPTION) {
                        return;
                    }
                    
                    ModelTabelePolaznik mtp = (ModelTabelePolaznik) ppf.getjTablePolaznici().getModel();
                    Polaznik p = mtp.getLista().get(red);
                    try{
                        komunikacija.Komunikacija.getInstance().obrisiPolaznika(p);
                        JOptionPane.showMessageDialog(ppf, "Sistem je uspešno obrisao polaznika", "USPEŠNO", JOptionPane.INFORMATION_MESSAGE);
                        pripremiFormu();
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(ppf, ex.getMessage(), "NEUSPEŠNO", JOptionPane.ERROR_MESSAGE);
                    }
                }
     
            }
                  
            
        });
        
        
        ppf.addBtnAzurirajActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = ppf.getjTablePolaznici().getSelectedRow();
                if(red==-1){
                    JOptionPane.showMessageDialog(ppf, "Morate selektovati polaznika!", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                }else{
                    ModelTabelePolaznik mtp = (ModelTabelePolaznik) ppf.getjTablePolaznici().getModel();
                    Polaznik p = mtp.getLista().get(red);
                    cordinator.Cordinator.getInstance().dodajParam("polaznik", p);
                    cordinator.Cordinator.getInstance().otvoriIzmeniPolaznikaFormu();
                            
                    
                }
                
                
            }
        });
        
        
//        ppf.addBtnPretraziActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String ime = ppf.getjTextFieldIme().getText().trim();
//                String prezime = ppf.getjTextFieldPrezime().getText().trim();
//                
//                ModelTabelePolaznik mti = (ModelTabelePolaznik) ppf.getjTablePolaznici().getModel();
//                mti.pretrazi(ime,prezime);
//                
//            }
//        });
//        
//        
//                pif.addBtnResetujActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                pripremiFormu();
//                
//            }
//            
//        });
        
    }

    public void otvoriFormu() {
        pripremiFormu();
        ppf.setVisible(true);
        
    }
    
    public void osveziFormu() {
        pripremiFormu();
    }

    public void pripremiFormu() {
        List<Polaznik> polaznici = komunikacija.Komunikacija.getInstance().ucitajPolaznike();
        ModelTabelePolaznik mtp = new ModelTabelePolaznik(polaznici);
        ppf.getjTablePolaznici().setModel(mtp);
    }
    
    
}
