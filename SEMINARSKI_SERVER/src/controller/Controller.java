/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.Instruktor;
import java.util.List;
import operacije.instruktori.UcitajInstruktoreSO;
import operacije.instruktori.ObrisiInstruktoraSO;
import operacije.login.LoginOperacija;

/**
 *
 * @author gtama
 */
public class Controller {
    
    private static Controller instance;
    
    private Controller(){
    }
    
    public static Controller getInstance(){
        if(instance==null){
            instance = new Controller();
        }
        
        return instance;
    }

    public Instruktor login(Instruktor i) throws Exception {
        
        LoginOperacija operacija = new LoginOperacija();
        operacija.izvrsi(i, null);
        System.out.println("KLASA CONTROLLER: "+operacija.getInstruktor());
        return operacija.getInstruktor();
    }

    public List<Instruktor> ucitajInstruktore() throws Exception {
        UcitajInstruktoreSO operacija =new UcitajInstruktoreSO();
        operacija.izvrsi(null, null);
        System.out.println("KLASA CONTROLLER: "+operacija.getInstruktori());
        return operacija.getInstruktori();
    }

    public void obrisiInstruktora(Instruktor i) throws Exception {
        ObrisiInstruktoraSO operacija =new ObrisiInstruktoraSO();
        operacija.izvrsi(i, null);
    }
    
}
