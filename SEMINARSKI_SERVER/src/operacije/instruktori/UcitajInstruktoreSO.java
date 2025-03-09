/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.instruktori;
import domen.Instruktor;
import java.util.List;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author gtama
 */
public class UcitajInstruktoreSO extends ApstraktnaGenerickaOperacija {

    List<Instruktor> instruktori;
    
    @Override
    protected void preduslovi(Object param) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        instruktori = broker.getAll(new Instruktor(),"");
    }

    public List<Instruktor> getInstruktori() {
        return instruktori;
    }
    
    
    
}
