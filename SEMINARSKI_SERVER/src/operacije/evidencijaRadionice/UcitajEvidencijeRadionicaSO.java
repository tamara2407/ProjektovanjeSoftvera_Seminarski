/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.evidencijaRadionice;

import domen.EvidencijaRadionice;
import java.util.List;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author gtama
 */
public class UcitajEvidencijeRadionicaSO extends ApstraktnaGenerickaOperacija {

    List<EvidencijaRadionice> evidencijeRadionica;
    
    @Override
    protected void preduslovi(Object param) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        evidencijeRadionica = broker.getAll(new EvidencijaRadionice(),"");
    }

    public List<EvidencijaRadionice> getEvidencijeRadionica() {
        return evidencijeRadionica;
    }
    
    
}
