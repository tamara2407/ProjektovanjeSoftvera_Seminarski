/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.Kategorija;
import forme.PrikazKategorijeForma;
import forme.model.ModelTabeleInstruktor;
import forme.model.ModelTabeleKategorije;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gtama
 */
public class PrikazKategorijeController {
    
    private final PrikazKategorijeForma pkf;
    
    public PrikazKategorijeController(PrikazKategorijeForma pkf) {
        this.pkf = pkf;
        addActionListeners();
    }

    private void addActionListeners() {
        
//        pkf.addBtnObrisiActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int red = pkf.getjTableKategorije().getSelectedRow();
//                if(red==-1){
//                    JOptionPane.showMessageDialog(pkf, "Sistem ne moze da obrise kategoriju", "GRESKA", JOptionPane.ERROR_MESSAGE);
//                }else{
//                    ModelTabeleKategorije mtk = (ModelTabeleKategorije) pkf.getjTableKategorije().getModel();
//                    Kategorija k = mtk.getLista().get(red);
//                    try{
//                        komunikacija.Komunikacija.getInstance().obrisiKategoriju(k);
//                        JOptionPane.showMessageDialog(pkf, "Sistem je uspesno obrisao kategoriju" , "USPEH", JOptionPane.INFORMATION_MESSAGE);
//                        pripremiFormu();
//                    }catch(Exception ex){
//                        JOptionPane.showMessageDialog(pkf, "Sistem ne moze da obrise kategoriju" , "GRESKA", JOptionPane.ERROR_MESSAGE);
//                    }
//                }
//     
//            }
//        });
        
        
//        pkf.addBtnAzurirajActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int red = pkf.getjTableKategorije().getSelectedRow();
//                if(red==-1){
//                    JOptionPane.showMessageDialog(pkf, "Sistem ne moze da izmeni kategoriju", "GRESKA", JOptionPane.ERROR_MESSAGE);
//                }else{
//                    ModelTabeleKategorije mtk = (ModelTabeleKategorije) pkf.getjTableKategorije().getModel();
//                    Kategorija k = mtk.getLista().get(red);
//                    cordinator.Cordinator.getInstance().dodajParam("kategorija", k);
//                    cordinator.Cordinator.getInstance().otvoriIzmeniKategorijuFormu();
//                            
//                    
//                }
//                
//                
//            }
//        });
        
        
        pkf.addBtnPretraziActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String naziv = pkf.getjTextFieldNaziv().getText().trim();
                
                ModelTabeleKategorije mtk = (ModelTabeleKategorije) pkf.getjTableKategorije().getModel();
                mtk.pretrazi(naziv);
                if (mtk.getLista().isEmpty()) {
                    JOptionPane.showMessageDialog(pkf, "Sistem ne može da nađe kategorije po zadatom kriterijumu", "NEUSPEŠNO", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(pkf, "Sistem je našao kategoriju po zadatom kriterijumu", "USPEŠNO", JOptionPane.INFORMATION_MESSAGE);
                }
                
            }
            
            
            
        });
        
        
        pkf.addBtnResetujActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pripremiFormu();
                pkf.getjTextFieldNaziv().setText("");

            }
            
        });
        
    }

    public void otvoriFormu() {
        pripremiFormu();
        pkf.setVisible(true);
        
    }
    
    public void osveziFormu() {
        pripremiFormu();
    }

    public void pripremiFormu() {
        List<Kategorija> kategorije = komunikacija.Komunikacija.getInstance().ucitajKategorije();
        ModelTabeleKategorije mtk = new ModelTabeleKategorije(kategorije);
        pkf.getjTableKategorije().setModel(mtk);
    }

    
}
