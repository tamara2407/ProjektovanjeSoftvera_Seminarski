/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.evidencijaRadionice;

import domen.EvidencijaRadionice;
import domen.Instruktor;
import java.util.List;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author gtama
 */
public class UcitajEvidencijeZaposlenogSO extends ApstraktnaGenerickaOperacija {

   private List<EvidencijaRadionice> lista;

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Instruktor)) {
            throw new Exception("Parametar mora biti objekat klase Instruktori.");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        Instruktor instruktor = (Instruktor) param;

        String uslov = " JOIN polaznik ON evidencijaradionice.polaznik = polaznik.polaznikID " +
                       "JOIN instruktor ON evidencijaradionice.instruktor = instruktor.instruktorID " +
                       "JOIN kategorija ON polaznik.kategorija = kategorija.kategorijaID " +
                       "WHERE evidencijaradionice.instruktor = " + instruktor.getInstruktorID();

        lista = broker.getAll(new EvidencijaRadionice(), uslov);
    }

    public List<EvidencijaRadionice> getLista() {
        return lista;
    }
    
    
}
