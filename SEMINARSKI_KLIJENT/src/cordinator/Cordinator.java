/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cordinator;

import controller.DodajFiguruController;
import controller.DodajInstruktoraController;
import controller.DodajKategorijuController;
import controller.DodajPolaznikaController;
import controller.DodajStavkuController;
//import controller.DodajPolaznikaController;
import controller.GlavnaFormaController;
import controller.LoginController;
import controller.PrikazEvidencijeRadioniceController;
import controller.PrikazFiguraController;
import controller.PrikazInstruktoraController;
import controller.PrikazKategorijeController;
import controller.PrikazPolaznikaController;
import controller.KreirajEvidencijuRadioniceController;
import domen.Instruktor;
import forme.DodajFiguruForma;
import forme.DodajInstruktoraForma;
import forme.DodajKategorijuForma;
import forme.DodajPolaznikaForma;
import forme.DodajStavkuForma;
import forme.FormaMod;
import forme.GlavnaForma;
import forme.KreiranjeEvidencijeRadioniceForma;
import forme.LoginForma;
import forme.PrikazEvidencijeRadioniceForma;
import forme.PrikazFiguraForma;
import forme.PrikazInstruktoraForma;
import forme.PrikazKategorijeForma;
import forme.PrikazPolaznikaForma;
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
    private PrikazEvidencijeRadioniceController prikazEvidencijeRadioniceController;
    private DodajPolaznikaController dodajPolaznikaController;
    private PrikazPolaznikaController prikazPolaznikaController;
    private DodajFiguruController dodajFiguruController;
    private PrikazFiguraController prikazFiguraController;
    private PrikazKategorijeController prikazKategorijeController;
    private DodajKategorijuController dodajKategorijuController;
    public KreirajEvidencijuRadioniceController kreirajEvidencijuRadioniceController;
    private DodajStavkuController dodajStavkuController;
    
    
    
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

    
    public void otvoriPrikazInstruktoraFormu() {
        prikazInstruktoraController = new PrikazInstruktoraController(new PrikazInstruktoraForma());
        prikazInstruktoraController.otvoriFormu(); 
    }

    public void otvoriDodajInstruktoraFormu() {
        dodajInstruktoraController = new DodajInstruktoraController(new DodajInstruktoraForma());
        dodajInstruktoraController.otvoriFormu(FormaMod.DODAJ);
    }   

    public void otvoriIzmeniInstruktoraFormu() {
        dodajInstruktoraController = new DodajInstruktoraController(new DodajInstruktoraForma());
        dodajInstruktoraController.otvoriFormu(FormaMod.IZMENI);
    }
    
    public void otvoriPrikazEvidencijeRadionicaFormu() {
        prikazEvidencijeRadioniceController = new PrikazEvidencijeRadioniceController(new PrikazEvidencijeRadioniceForma());
        prikazEvidencijeRadioniceController.otvoriFormu(); 
    }
   
        public void otvoriDodajPolaznikaFormu() {
        dodajPolaznikaController = new DodajPolaznikaController(new DodajPolaznikaForma());
        dodajPolaznikaController.otvoriFormu(FormaMod.DODAJ);    
        }
    
    
    public void otvoriDodajFiguruFormu() {
        dodajFiguruController = new DodajFiguruController(new DodajFiguruForma());
        dodajFiguruController.otvoriFormu(FormaMod.DODAJ);
    }  
    
    public void otvoriPrikazFiguraFormu() {
        prikazFiguraController = new PrikazFiguraController(new PrikazFiguraForma());
        prikazFiguraController.otvoriFormu();
    }
    
    public void otvoriIzmeniFiguruFormu() {
        dodajFiguruController = new DodajFiguruController(new DodajFiguruForma());
        dodajFiguruController.otvoriFormu(FormaMod.IZMENI);
    }
    
        public void otvoriPrikazKategorijaFormu() {
        prikazKategorijeController = new PrikazKategorijeController(new PrikazKategorijeForma());
        prikazKategorijeController.otvoriFormu();
    }

        public void otvoriDodajKategorijeFormu() {
        dodajKategorijuController = new DodajKategorijuController(new DodajKategorijuForma());
        dodajKategorijuController.otvoriFormu(FormaMod.DODAJ);    }
        
        
//    public void otvoriIzmeniKategorijuFormu() {
//        dodajKategorijuController = new DodajKategorijuController(new DodajKategorijuForma());
//        dodajKategorijuController.otvoriFormu(FormaMod.IZMENI);
//    }
    
    public void otvoriPrikazPolaznikaFormu() {
        prikazPolaznikaController = new PrikazPolaznikaController(new PrikazPolaznikaForma());
        prikazPolaznikaController.otvoriFormu();
    }
    
    public void otvoriIzmeniPolaznikaFormu() {
        dodajPolaznikaController = new DodajPolaznikaController(new DodajPolaznikaForma());
        dodajPolaznikaController.otvoriFormu(FormaMod.IZMENI);    }
    
    
    
    public void dodajParam(String s, Object o){
       parametri.put(s, o);
   }
   
   public Object vratiParam(String s){
       return parametri.get(s);
   }
   
    public Instruktor getUlogovani() {
        return ulogovani;
    }

    public void setUlogovani(Instruktor ulogovani) {
        this.ulogovani = ulogovani;
    }

    public void osveziFormuInstruktor() {
        prikazInstruktoraController.osveziFormu();
    }
    
    public void osveziFormuFigura() {
        prikazFiguraController.osveziFormu();    
    }
    
    public void osveziFormuKategorija() {
        prikazKategorijeController.osveziFormu();    
    }
    
    public void osveziFormuPolaznik() {
        prikazPolaznikaController.osveziFormu();
    }

    public void otvoriKreirajEvidencijuRadioniceForma() {
        kreirajEvidencijuRadioniceController = new KreirajEvidencijuRadioniceController(new KreiranjeEvidencijeRadioniceForma());
        kreirajEvidencijuRadioniceController.otvoriFormu();
    }

    public void otvoriDodajStavkuFormu(KreiranjeEvidencijeRadioniceForma kef) {
        dodajStavkuController = new DodajStavkuController(new DodajStavkuForma(kef, true));
        dodajStavkuController.otvoriFormu();
    }

    public void otvoriKreiranjeEvidencijeRadioniceForma() {
        kreirajEvidencijuRadioniceController = new KreirajEvidencijuRadioniceController(new KreiranjeEvidencijeRadioniceForma());
        kreirajEvidencijuRadioniceController.otvoriFormu();
    }

    



























    
    
}

