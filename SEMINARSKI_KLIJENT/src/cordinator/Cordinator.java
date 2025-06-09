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
import forme.FormaMod;
import forme.GlavnaForma;
import forme.LoginForma;
import forme.PrikazInstruktoraForma;
import java.util.HashMap;
import java.util.Map;


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
    private Map<String, Object> parametri;
    
    
    
    private Cordinator(){
        parametri = new HashMap<>();
    
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
        dodajInstruktoraController.otvoriFormu(FormaMod.DODAJ);
    }   

    
   public void dodajParam(String s, Object o){
       parametri.put(s, o);
   }
   
   public Object vratiParam(String s){
       return parametri.get(s);
   }

    public void otvoriIzmeniInstruktoraForma() {
        dodajInstruktoraController = new DodajInstruktoraController(new DodajInstruktoraForma());
        dodajInstruktoraController.otvoriFormu(FormaMod.IZMENI);
    }

    public void osveziFormu() {
        prikazInstruktoraController.osveziFormu();
    }
    
    
}

