/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.EvidencijaRadionice;
import domen.Instruktor;
import forme.PrikazEvidencijeRadioniceForma;
import forme.model.ModelTabeleEvidencijeRadionice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gtama
 */
public class PrikazEvidencijeRadioniceController {
    private final PrikazEvidencijeRadioniceForma pef;

    Instruktor ulogovani = cordinator.Cordinator.getInstance().getUlogovani();

    public PrikazEvidencijeRadioniceController(PrikazEvidencijeRadioniceForma pef) {
        this.pef = pef;
        addActionListeners();

    }

    public void otvoriFormu() {
        pripremiFormu();
        pef.setVisible(true);
    }

    public void pripremiFormu() {
        List<EvidencijaRadionice> evidencijeRadionica = komunikacija.Komunikacija.getInstance().ucitajEvidencijeRadionica();
        ModelTabeleEvidencijeRadionice mte = new ModelTabeleEvidencijeRadionice(evidencijeRadionica);
        pef.getjTableEvidencijaRadionice().setModel(mte);
    }

    public void osveziFormu() {
        pripremiFormu();
    }

    private void addActionListeners() {
        
        pef.addBtnPretraziActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                String ime = pef.getjTextFieldIme().getText().trim();
                String prezime = pef.getjTextFieldPrezime().getText().trim();
                
                ModelTabeleEvidencijeRadionice mte = (ModelTabeleEvidencijeRadionice) pef.getjTableEvidencijaRadionice().getModel();
                mte.pretrazi(ime,prezime);
                if (mte.getLista().isEmpty()) {
                    JOptionPane.showMessageDialog(pef, "Sistem ne može da nađe evidencije radionice po zadatim kriterijumima", "NEUSPEŠNO", JOptionPane.ERROR_MESSAGE);
                    pripremiFormu();
                } else {
                    JOptionPane.showMessageDialog(pef, "Sistem je našao evidenciju radionice po zadatim kriterijumima", "USPEŠNO", JOptionPane.INFORMATION_MESSAGE);
                    
                }
                
            }
        });
        
        
        pef.addBtnResetujActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pripremiFormu();
                pef.getjTextFieldIme().setText("");
                pef.getjTextFieldPrezime().setText("");
                
            }
            
        });

    }
    
    
}
