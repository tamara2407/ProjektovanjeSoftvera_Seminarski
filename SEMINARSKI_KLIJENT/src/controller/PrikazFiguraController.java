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
                    JOptionPane.showMessageDialog(pff, "Sistem ne može da obriše proizvod", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                }else{
                    int potvrda = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite da obrišete figuru?", "POTVRDA", JOptionPane.YES_NO_OPTION);
                    if (potvrda == JOptionPane.NO_OPTION || potvrda == JOptionPane.CLOSED_OPTION) {
                        return;
                    }
                }
                    ModelTabeleFigura mtf = (ModelTabeleFigura) pff.getjTableFigure().getModel();
                    Figura f = mtf.getLista().get(red);
                    try{
                        komunikacija.Komunikacija.getInstance().obrisiFiguru(f);
                        JOptionPane.showMessageDialog(pff, "Sistem je uspešno obrisao proizvod", "USPEŠNO", JOptionPane.INFORMATION_MESSAGE);
                        pripremiFormu();
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(pff, ex.getMessage(), "NEUSPEŠNO", JOptionPane.ERROR_MESSAGE);
                    }
                }
     
            
                
            
            
        });
        
        
        pff.addBtnAzurirajActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = pff.getjTableFigure().getSelectedRow();
                if(red==-1){
                    JOptionPane.showMessageDialog(pff, "Morate selektovati figuru!", "NEUSPEŠNO", JOptionPane.ERROR_MESSAGE);
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
                if (mtf.getLista().isEmpty()) {
                    JOptionPane.showMessageDialog(pff, "Sistem ne može da nađe figure po zadatom kriterijumu", "NEUSPEŠNO", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(pff, "Sistem je našao figure po zadatom kriterijumu", "USPEŠNO", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });
        
        
                pff.addBtnResetujActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pripremiFormu();
                pff.getjTextFieldNaziv().setText("");
                
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
