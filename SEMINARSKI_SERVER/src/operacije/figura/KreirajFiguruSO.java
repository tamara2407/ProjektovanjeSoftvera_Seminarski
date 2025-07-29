/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.figura;


import domen.Figura;
import exception.FiguraVecPostojiException;
import java.util.List;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author gtama
 */
public class KreirajFiguruSO extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Figura)) {

            throw new Exception("Sistem ne moze da kreira figuru");
        }

        Figura novaFigura = (Figura) param;

        String uslov = " WHERE naziv = '" + novaFigura.getNaziv() + "'";
        
        Figura postojeca = (Figura) broker.get(novaFigura, uslov);
        if (postojeca != null) {
        throw new FiguraVecPostojiException("Figura sa tim nazivom već postoji.");
}
        
//        List<Figura> sveFigure = broker.getAll(novaFigura, uslov);
//
//        if (!sveFigure.isEmpty()) {
//            throw new FiguraVecPostojiException("Figura sa tim nazivom već postoji.");
//        }

    }
    
        protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
            broker.add((Figura) param);
    }
    
}
