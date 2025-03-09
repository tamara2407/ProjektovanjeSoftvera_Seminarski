/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.Instruktor;
import forme.PrikazInstruktoraForma;
import forme.model.ModelTabeleInstruktor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gtama
 */
public class PrikazInstruktoraController {
    
    private final PrikazInstruktoraForma pif;
    
    public PrikazInstruktoraController(PrikazInstruktoraForma pif) {
        this.pif = pif;
        addActionListeners();
    }

    private void addActionListeners() {
        
        pif.addBtnObrisiActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = pif.getjTableInstruktori().getSelectedRow();
                if(red==-1){
                    JOptionPane.showMessageDialog(pif, "Sistem ne moze da obrise instruktora", "GRESKA", JOptionPane.ERROR_MESSAGE);
                }else{
                    ModelTabeleInstruktor mti = (ModelTabeleInstruktor) pif.getjTableInstruktori().getModel();
                    Instruktor i = mti.getLista().get(red);
                    try{
                        komunikacija.Komunikacija.getInstance().obrisiInstruktora(i);
                        JOptionPane.showMessageDialog(pif, "Sistem je uspesno obrisao instruktora" , "USPEH", JOptionPane.INFORMATION_MESSAGE);
                        pripremiFormu();
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(pif, "Sistem ne moze da obrise instruktora" , "GRESKA", JOptionPane.ERROR_MESSAGE);
                    }
                }
                
                
            }
        });
        
    }

    public void otvoriFormu() {
        pripremiFormu();
        pif.setVisible(true);
        
    }

    private void pripremiFormu() {
        List<Instruktor> instruktori = komunikacija.Komunikacija.getInstance().ucitajInstruktore();
        ModelTabeleInstruktor mti = new ModelTabeleInstruktor(instruktori);
        pif.getjTableInstruktori().setModel(mti);
    }
    
}
