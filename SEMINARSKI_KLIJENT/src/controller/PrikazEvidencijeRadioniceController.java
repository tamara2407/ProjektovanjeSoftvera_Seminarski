/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.EvidencijaRadionice;
import forme.PrikazEvidencijeRadioniceForma;
import forme.model.ModelTabeleEvidencijaRadionice;
import java.util.List;

/**
 *
 * @author gtama
 */
public class PrikazEvidencijeRadioniceController {
    private final PrikazEvidencijeRadioniceForma pef;
    
    public PrikazEvidencijeRadioniceController(PrikazEvidencijeRadioniceForma pef) {
        this.pef = pef;
        addActionListeners();
    }

    private void addActionListeners() {
    }
    
    
    
        public void otvoriFormu() {
        pripremiFormu();
        //pef.setVisible(true);
        
    }


    public void pripremiFormu() {
        List<EvidencijaRadionice> evidencijeRadionica = komunikacija.Komunikacija.getInstance().ucitajEvidencijeRadionica();
        ModelTabeleEvidencijaRadionice mtr = new ModelTabeleEvidencijaRadionice(evidencijeRadionica);
        pef.getjTableEvidencijaRadionice().setModel(mtr);
    }
    
    
}
