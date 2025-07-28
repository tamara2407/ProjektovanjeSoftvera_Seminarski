/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.instruktori;

import domen.Instruktor;
import exception.InstruktorVecPostojiException;
import exception.PolaznikVecPostojiException;
import java.util.List;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author gtama
 */
public class KreirajInstruktoraSO extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Instruktor)) {

            throw new Exception("Sistem ne moze da kreira kupca");
        }
        Instruktor noviInstruktor = (Instruktor) param;

        String uslov = " WHERE korisnickoIme = '" + noviInstruktor.getKorisnickoIme()+ "'";
        List<Instruktor> sviInstruktori = broker.getAll(noviInstruktor, uslov);

       
        if (!sviInstruktori.isEmpty()) {
            throw new InstruktorVecPostojiException("Instruktor sa tim korisničkim imenom već postoji.");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.add((Instruktor)param);
    }
    
    
}
