/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.figura;

import domen.Figura;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author gtama
 */
public class ObrisiFiguruSO extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param==null || !(param instanceof Figura)){
            throw new Exception("Sistem ne moze da obrise figuru");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.delete((Figura) param);
    }
    
}
