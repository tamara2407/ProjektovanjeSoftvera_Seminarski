/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.instruktori;

import domen.Instruktor;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author gtama
 */
public class KreirajInstruktoraSO extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param==null || !(param instanceof Instruktor)){
        throw new Exception("Sistem ne može da doda instruktora");
        }
        Instruktor i = (Instruktor) param;
        if(i.getIme()==null || i.getIme().isEmpty()){
            throw new Exception("Greška ime");
        }
        if(i.getPrezime()==null || i.getPrezime().isEmpty()){
            throw new Exception("Greška prezime");
        }
        if(i.getEmail()==null || !(i.getEmail().contains("@"))){
            throw new Exception("Greška email");
        }
        if(i.getKorisnickoIme()==null || i.getKorisnickoIme().isEmpty()){
            throw new Exception("Greška korisničko ime");
        }
        if(i.getLozinka()==null || i.getLozinka().isEmpty()){
            throw new Exception("Greška lozinka");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.add((Instruktor)param);
    }
    
    
}
