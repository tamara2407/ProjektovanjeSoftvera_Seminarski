/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.kategorija;

import domen.Instruktor;
import domen.Kategorija;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author gtama
 */
public class AzurirajKategorijuSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param==null || !(param instanceof Kategorija)){
        throw new Exception("Sistem ne može da izmeni kategoriju");
        }
        Kategorija k = (Kategorija) param;
        if(k.getNaziv()==null || k.getNaziv().isEmpty()){
            throw new Exception("Greška naziv");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
            broker.edit((Kategorija) param);
    }
    
}
