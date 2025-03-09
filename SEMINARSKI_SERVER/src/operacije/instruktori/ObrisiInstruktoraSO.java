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
public class ObrisiInstruktoraSO extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param==null || !(param instanceof Instruktor)){
            throw new Exception("Sistem ne moze da obrise instruktora");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.delete((Instruktor) param);
    }
    
}
