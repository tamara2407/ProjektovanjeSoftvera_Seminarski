/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.polaznik;

import domen.Polaznik;
import exception.PolaznikVecPostojiException;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author gtama
 */
public class IzmeniPolaznikaSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {

        if (param == null || !(param instanceof Polaznik)) {
            throw new Exception("Sistem ne moze da izmeni polaznika");
        }
        
        
        Polaznik noviPolaznik = (Polaznik) param;

        String uslov = " JOIN kategorija ON polaznik.kategorija = kategorija.kategorijaID WHERE email = '" + noviPolaznik.getEmail() + "'";
        Polaznik postojeci = (Polaznik) broker.get(noviPolaznik, uslov);
        if (postojeci != null) {
            throw new PolaznikVecPostojiException("Sistem ne može da zapamti polaznika");
        }

    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {

        broker.edit((Polaznik) param);

    }
    
}
