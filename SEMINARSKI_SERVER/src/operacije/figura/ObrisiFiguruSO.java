/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.figura;

import domen.Figura;
import domen.StavkaEvidencijeRadionice;
import exception.FiguraNeMozeDaSeObriseException;
import java.util.List;
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
        
        
        Figura figura = (Figura) param;

        StavkaEvidencijeRadionice stavka = new StavkaEvidencijeRadionice();

        String uslov = " JOIN figura ON stavkaevidencijeradionice.figura = figura.figuraID WHERE figura = " + figura.getFiguraID();;

        List<StavkaEvidencijeRadionice> stavke = broker.getAll(stavka, uslov);

        boolean proizvodPostoji = !stavke.isEmpty();

        if (proizvodPostoji) {
            throw new FiguraNeMozeDaSeObriseException("Figura postoji u nekoj stavci evidencije radionice.");

        }
        
        
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.delete((Figura) param);
    }
    
}
