/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.kategorija;

import domen.Kategorija;
import exception.KategorijaVecPostojiException;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author gtama
 */
public class KreirajKategorijuSO extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(Object param) throws Exception {
        
        if (param == null || !(param instanceof Kategorija)) {
            throw new Exception("Sistem ne može da doda kategoriju.");
        }

        Kategorija k = (Kategorija) param;

        if (k.getNaziv() == null || k.getNaziv().trim().isEmpty()) {
            throw new Exception("Naziv kategorije ne sme biti prazan.");
        }

        String uslov = " WHERE naziv = '" + k.getNaziv() + "'";
        Kategorija postojeca = (Kategorija) broker.get(k, uslov);
        if (postojeca != null) {
            throw new KategorijaVecPostojiException("Kategorija sa tim nazivom već postoji.");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.add((Kategorija)param);
    }
    
}
