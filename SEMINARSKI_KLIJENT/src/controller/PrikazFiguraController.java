 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.Figura;
import forme.PrikazFiguraForma;
import forme.model.ModelTabeleFigura;
import forme.model.ModelTabeleInstruktor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gtama
 */
public class PrikazFiguraController {
    
    private final PrikazFiguraForma pff;
    
    public PrikazFiguraController(PrikazFiguraForma pff) {
        this.pff = pff;
        addActionListeners();
    }

    private void addActionListeners() {
        
        pff.addBtnObrisiActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = pff.getjTableFigure().getSelectedRow();
                if(red==-1){
                    JOptionPane.showMessageDialog(pff, "Sistem ne moze da obrise figuru", "GRESKA", JOptionPane.ERROR_MESSAGE);
                }else{
                    ModelTabeleFigura mtf = (ModelTabeleFigura) pff.getjTableFigure().getModel();
                    Figura f = mtf.getLista().get(red);
                    try{
                        komunikacija.Komunikacija.getInstance().obrisiFiguru(f);
                        JOptionPane.showMessageDialog(pff, "Sistem je uspesno obrisao figuru" , "USPEH", JOptionPane.INFORMATION_MESSAGE);
                        pripremiFormu();
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(pff, "Sistem ne moze da obrise figuru" , "GRESKA", JOptionPane.ERROR_MESSAGE);
                    }
                }
     
            }
        });
        
        
        pff.addBtnAzurirajActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = pff.getjTableFigure().getSelectedRow();
                if(red==-1){
                    JOptionPane.showMessageDialog(pff, "Sistem ne moze da izmeni figuru", "GRESKA", JOptionPane.ERROR_MESSAGE);
                }else{
                    ModelTabeleFigura mtf = (ModelTabeleFigura) pff.getjTableFigure().getModel();
                    Figura f = mtf.getLista().get(red);
                    cordinator.Cordinator.getInstance().dodajParam("figura", f);
                    cordinator.Cordinator.getInstance().otvoriIzmeniFiguruFormu();
                            
                    
                }
                
                
            }
        });
        
        
        pff.addBtnPretraziActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String naziv = pff.getjTextFieldNaziv().getText().trim();
                
                ModelTabeleFigura mtf = (ModelTabeleFigura) pff.getjTableFigure().getModel();
                mtf.pretrazi(naziv);
                
            }
        });
        
        
                pff.addBtnResetujActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pripremiFormu();
                
            }
            
        });
        
    }

    public void otvoriFormu() {
        pripremiFormu();
        pff.setVisible(true);
        
    }
    
    public void osveziFormu() {
        pripremiFormu();
    }

    public void pripremiFormu() {
        List<Figura> figure = komunikacija.Komunikacija.getInstance().ucitajFigure();
        ModelTabeleFigura mtf = new ModelTabeleFigura(figure);
        pff.getjTableFigure().setModel(mtf);
    }

    
    
    
}
