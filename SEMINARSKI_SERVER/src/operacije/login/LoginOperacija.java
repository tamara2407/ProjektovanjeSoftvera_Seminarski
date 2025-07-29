/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.login;

import domen.Instruktor;
import exception.LoginException;
import java.util.List;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author gtama
 */
public class LoginOperacija extends ApstraktnaGenerickaOperacija {

    Instruktor instruktor;
    
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param==null || !(param instanceof Instruktor)){
            throw new Exception("Sistem ne moze da pronadje instruktora");
        }
    }
    
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
    
    instruktor = (Instruktor) param;

    String uslov = " WHERE korisnickoIme = '" + instruktor.getKorisnickoIme() +
                   "' AND lozinka = '" + instruktor.getLozinka() + "'";

    instruktor = (Instruktor) broker.get(instruktor, uslov);

    System.out.println("LOGIN Operacija: " + instruktor);
    
//    if (instruktor == null) {
//        throw new LoginException("Korisničko ime i šifra nisu ispravni");
//
//    }
    
}

    
    //true false, ne proveravaj sve
//    @Override
//    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
//        List<Instruktor> sviInstruktori = broker.getAll((Instruktor) param,null);
//        System.out.println("KLASA LoginOperacija SO "+sviInstruktori);
//        if(sviInstruktori.contains((Instruktor) param)){
//            for(Instruktor i : sviInstruktori){
//                if(i.equals((Instruktor)param)){
//                    instruktor = i;
//                    return;
//                }
//            }
//
//        }else{
//            instruktor=null;
//        }
//        
//    }

    public Instruktor getInstruktor() {
        return instruktor;
    }

    
    
    
}
