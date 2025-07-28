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
public class ObrisiPolaznikaSO extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param==null || !(param instanceof Polaznik)){
            throw new Exception("Sistem ne moze da obriše polaznika");
        }
        
//                if (param == null || !(param instanceof Proizvod)) {
//            throw new Exception("Sistem ne moze da obrise proizvod");
//        }
//
//        Proizvod proizvod = (Proizvod) param;
//
//        StavkaNarudzbenice stavka = new StavkaNarudzbenice();
//
//        String uslov = "JOIN proizvod ON stavkanarudzbenica.proizvod = proizvod.idProizvod WHERE proizvod = " + proizvod.getIdProizvod();;
//
//        List<StavkaNarudzbenice> stavke = broker.getAll(stavka, uslov);
//
//        boolean proizvodPostoji = !stavke.isEmpty();
//
//        if (proizvodPostoji) {
//            throw new ProizvodNeMozeDaSeObriseException("Proizvod postoji u nekoj stavci narudzbenice.");
//
//        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.delete((Polaznik) param);
    }
    
}
