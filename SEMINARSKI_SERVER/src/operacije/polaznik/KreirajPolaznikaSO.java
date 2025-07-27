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
public class KreirajPolaznikaSO extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Polaznik)) {

            throw new Exception("Sistem ne moze da kreira kupca");
        }
        Polaznik noviPolaznik = (Polaznik) param;

        String uslov = " JOIN kategorija ON polaznik.kategorija = kategorija.kategorijaID WHERE email = '" + noviPolaznik.getEmail() + "'";
        List<Polaznik> sviPolaznici = broker.getAll(noviPolaznik, uslov);

        /* for (Kupac k : sviKupci) {
            if (k.getEmail().equalsIgnoreCase(noviKupac.getEmail())) {
                throw new KupacVecPostojiException("Kupac sa tim email-om već postoji.");
            }
        }*/
        if (!sviPolaznici.isEmpty()) {
            System.out.println("GRESKA");
        }

    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.add((Polaznik)param);
    }
    
}
