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
public class AzurirajFiguruSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
//        if(param==null || !(param instanceof Figura)){
//        throw new Exception("Sistem ne može da doda figuru");
//        }
//        Figura f = (Figura) param;
//        if(f.getNaziv()==null || f.getNaziv().isEmpty()){
//            throw new Exception("Greška naziv");
//        }
//        if(f.getTezina()==null || f.getTezina().isEmpty()){
//             System.out.println("DEBUG: tezina je NULL ili prazna -> " + f.getTezina());
//            throw new Exception("Greška tezina");
//        }
        if (param == null || !(param instanceof Figura)) {
            throw new Exception("Sistem ne moze da zapamti figuru");
        }

    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
            broker.edit((Figura) param);
    }
    
}
