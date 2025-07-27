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

    private List<EvidencijaRadionice> evidencije;

    @Override
    protected void preduslovi(Object param) throws Exception {

    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        String uslov = " JOIN polaznik ON evidencijaradionice.polaznik = polaznik.polaznikID JOIN instruktor ON evidencijaradionice.instruktor = instruktor.instruktorID JOIN kategorija ON polaznik.kategorija = kategorija.kategorijaID";
        evidencije = broker.getAll(new EvidencijaRadionice(), uslov);
    }

    public List<EvidencijaRadionice> getEvidencije() {
        return evidencije;
    }
    
    
}
