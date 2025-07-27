/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.polaznik;

import domen.Polaznik;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author gtama
 */
public class KreirajPolaznikaSO extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param==null || !(param instanceof Polaznik)){
        throw new Exception("Sistem ne može da doda polaznika");
        }
        Polaznik i = (Polaznik) param;
        if(i.getIme()==null || i.getIme().isEmpty()){
            throw new Exception("Greška ime");
        }
        if(i.getPrezime()==null || i.getPrezime().isEmpty()){
            throw new Exception("Greška prezime");
        }
        if(i.getEmail()==null || !(i.getEmail().contains("@"))){
            throw new Exception("Greška email");
        }

    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.add((Polaznik)param);
    }
    
}
