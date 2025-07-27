/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.kategorija;

import domen.Kategorija;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author gtama
 */
public class ObrisiKategorijuSO extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param==null || !(param instanceof Kategorija)){
            throw new Exception("Sistem ne moze da obrise kategoriju");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.delete((Kategorija) param);
    }
    
}
