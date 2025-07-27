/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.kategorija;

import domen.Kategorija;
import java.util.List;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author gtama
 */
public class UcitajKategorijeSO extends ApstraktnaGenerickaOperacija {

    List<Kategorija> kategorije;
    
    @Override
    protected void preduslovi(Object param) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        kategorije = broker.getAll(new Kategorija(),"");
    }

    public List<Kategorija> getKategorije() {
        return kategorije;
    }
    
    
}
