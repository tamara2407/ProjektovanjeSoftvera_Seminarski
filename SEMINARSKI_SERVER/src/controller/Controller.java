/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.EvidencijaRadionice;
import domen.Figura;
import domen.Instruktor;
import domen.Kategorija;
import domen.Polaznik;
import java.util.List;
import operacije.evidencijaRadionice.KreirajEvidencijuRadioniceSO;
import operacije.evidencijaRadionice.UcitajEvidencijeRadionicaSO;
import operacije.figura.AzurirajFiguruSO;
import operacije.figura.KreirajFiguruSO;
import operacije.figura.ObrisiFiguruSO;
import operacije.figura.UcitajFigureSO;
import operacije.instruktori.AzurirajInstruktoraSO;
import operacije.instruktori.KreirajInstruktoraSO;
import operacije.instruktori.UcitajInstruktoreSO;
import operacije.instruktori.ObrisiInstruktoraSO;
import operacije.kategorija.AzurirajKategorijuSO;
import operacije.kategorija.ObrisiKategorijuSO;
import operacije.kategorija.UcitajKategorijeSO;
import operacije.kategorija.KreirajKategorijuSO;
import operacije.login.LoginOperacija;
import operacije.polaznik.IzmeniPolaznikaSO;
import operacije.polaznik.KreirajPolaznikaSO;
import operacije.polaznik.ObrisiPolaznikaSO;
import operacije.polaznik.UcitajPolaznikeSO;

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

    public void dodajInstruktora(Instruktor instruktor) throws Exception {
        KreirajInstruktoraSO operacija = new KreirajInstruktoraSO();
        operacija.izvrsi(instruktor, null);
    }

    public void azurirajInstruktora(Instruktor instruktor) throws Exception {
        AzurirajInstruktoraSO operacija = new AzurirajInstruktoraSO();
        operacija.izvrsi(instruktor, null);
    }

    public List<EvidencijaRadionice> ucitajEvidencijeRadionica() throws Exception {
        UcitajEvidencijeRadionicaSO operacija =new UcitajEvidencijeRadionicaSO();
        operacija.izvrsi(null, null);
        System.out.println("KLASA CONTROLLER: "+operacija.getEvidencije());
        return operacija.getEvidencije();       
    }

    public void dodajPolaznika(Polaznik polaznik) throws Exception {
        KreirajPolaznikaSO operacija = new KreirajPolaznikaSO();
        operacija.izvrsi(polaznik, null);
    }

    public void dodajFiguru(Figura figura) throws Exception {
        KreirajFiguruSO operacija = new KreirajFiguruSO();
        operacija.izvrsi(figura, null);    
    }

    public void obrisiFiguru(Figura Ofigura) throws Exception {
        ObrisiFiguruSO operacija =new ObrisiFiguruSO();
        operacija.izvrsi(Ofigura, null);
    }

    public List<Figura> ucitajFigure() throws Exception {
        UcitajFigureSO operacija =new UcitajFigureSO();
        operacija.izvrsi(null, null);
        System.out.println("KLASA CONTROLLER: "+operacija.getFigure());
        return operacija.getFigure();
    }

    public void azurirajFiguru(Figura aFigura) throws Exception {
        AzurirajFiguruSO operacija = new AzurirajFiguruSO();
        operacija.izvrsi(aFigura, null);
    }

    public List<Kategorija> ucitajKategorije() throws Exception {
        UcitajKategorijeSO operacija =new UcitajKategorijeSO();
        operacija.izvrsi(null, null);
        System.out.println("KLASA CONTROLLER: "+operacija.getKategorije());
        return operacija.getKategorije();
    }

    public void obrisiKategoriju(Kategorija kategorija) throws Exception {
        ObrisiKategorijuSO operacija =new ObrisiKategorijuSO();
        operacija.izvrsi(kategorija, null);
    }

    public void dodajKategorija(Kategorija kategorija) throws Exception {
        KreirajKategorijuSO operacija = new KreirajKategorijuSO();
        operacija.izvrsi(kategorija, null);
    }

    public void azurirajKategoriju(Kategorija Akategorija) throws Exception {
        AzurirajKategorijuSO operacija = new AzurirajKategorijuSO();
        operacija.izvrsi(Akategorija, null);    
    }

    public void obrisiPolaznika(Polaznik oPolaznik) throws Exception {
        ObrisiPolaznikaSO operacija =new ObrisiPolaznikaSO();
        operacija.izvrsi(oPolaznik, null);    
    }

    public List<Polaznik> ucitajPolaznike() throws Exception {
        UcitajPolaznikeSO operacija =new UcitajPolaznikeSO();
        operacija.izvrsi(null, null);
        System.out.println("KLASA CONTROLLER: "+operacija.getPolaznike());
        return operacija.getPolaznike();
    }

    public void azurirajPolaznika(Polaznik aPolaznik) throws Exception {
        IzmeniPolaznikaSO operacija = new IzmeniPolaznikaSO();
        operacija.izvrsi(aPolaznik, null);    
    }

    public void dodajEvidencijuRadionice(EvidencijaRadionice evidencija) throws Exception {
        KreirajEvidencijuRadioniceSO operacija = new KreirajEvidencijuRadioniceSO();
        operacija.izvrsi(evidencija, null);
    }
    
}
