/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.polaznik;

import domen.Polaznik;
import java.util.List;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author gtama
 */
public class UcitajPolaznikeSO extends ApstraktnaGenerickaOperacija {

    List<Polaznik> polaznici;
    
    @Override
    protected void preduslovi(Object param) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        String uslov = " JOIN kategorija ON polaznik.kategorija = kategorija.kategorijaID";
        polaznici = broker.getAll(new Polaznik(),uslov);
    }

    public List<Polaznik> getPolaznike() {
        return polaznici;
    }
    
}
