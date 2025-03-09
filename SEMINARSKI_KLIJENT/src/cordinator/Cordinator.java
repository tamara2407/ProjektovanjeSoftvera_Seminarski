/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cordinator;

import controller.DodajInstruktoraController;
import controller.GlavnaFormaController;
import controller.LoginController;
import controller.PrikazInstruktoraController;
import domen.Instruktor;
import forme.DodajInstruktoraForma;
import forme.GlavnaForma;
import forme.LoginForma;
import forme.PrikazInstruktoraForma;

/**
 *
 * @author gtama
 */
public class Cordinator {
    private static Cordinator instance;
    private Instruktor ulogovani;
    private LoginController loginController;
    private GlavnaFormaController glavnaFormaController;
    private PrikazInstruktoraController prikazInstruktoraController;
    private DodajInstruktoraController dodajInstruktoraController;
    
    
    
    private Cordinator(){
    
    }
    
    public static Cordinator getInstance(){
        if(instance==null){
            instance = new Cordinator();
        }
        
        return instance;
    }

    public void otvoriLoginFormu() {
        loginController = new LoginController(new LoginForma());
        loginController.otvoriFormu();
    }

    public void otvoriGlavnuFormu() {
        glavnaFormaController = new GlavnaFormaController(new GlavnaForma());
        glavnaFormaController.otvoriFormu();    }

    public Instruktor getUlogovani() {
        return ulogovani;
    }

    public void setUlogovani(Instruktor ulogovani) {
        this.ulogovani = ulogovani;
    }

    public void otvoriPrikazInstruktoraForma() {
        prikazInstruktoraController = new PrikazInstruktoraController(new PrikazInstruktoraForma());
        prikazInstruktoraController.otvoriFormu(); 
    }

    public void otvoriDodajInstruktoraFormu() {
        dodajInstruktoraController = new DodajInstruktoraController(new DodajInstruktoraForma());
        dodajInstruktoraController.otvoriFormu();
    }   
    
    
    
    
    
}

