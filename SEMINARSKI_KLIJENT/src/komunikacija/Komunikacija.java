/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import domen.EvidencijaRadionice;
import domen.Figura;
import domen.Instruktor;
import domen.Kategorija;
import domen.Polaznik;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gtama
 */
public class Komunikacija {
    
    private Socket soket;
    private Posiljalac posiljalac;
    private Primalac primalac;
    private static Komunikacija instance;
    
    private Komunikacija(){
    }
    
    public static Komunikacija getInstance(){
        if(instance==null){
            instance = new Komunikacija();
        }
        
        return instance;
    }
    
    public void konekcija(){
        try {
            soket = new Socket("localhost",9000);
            posiljalac = new Posiljalac(soket);
            primalac = new Primalac(soket);
        } catch (IOException ex) {
            System.out.println("SERVER NIJE POVEZAN");
        }
    }
    
    public Instruktor login(String ki, String pass) {
        Instruktor i = new Instruktor();
        i.setLozinka(pass);
        i.setKorisnickoIme(ki);
        Zahtev zahtev = new Zahtev(Operacija.LOGIN,i);
        posiljalac.posalji(zahtev);
        
        Odgovor odg = (Odgovor) primalac.primi();
        
        i = (Instruktor) odg.getOdgovor();
        
        return i;
    }

    public List<Instruktor> ucitajInstruktore() {
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_INSTRUKTORE,null);
        List<Instruktor> instruktori = new ArrayList<>();
        posiljalac.posalji(zahtev);
        Odgovor odg = (Odgovor) primalac.primi();
        instruktori = (List<Instruktor>) odg.getOdgovor();
        return instruktori;
    }

    public void obrisiInstruktora(Instruktor i) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.OBRISI_INSTRUKTORA,i);
        posiljalac.posalji(zahtev);
        
        Odgovor odg = (Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            System.out.println("USPESNO");
        }else{
            System.out.println("GRESKA");
            ((Exception)odg.getOdgovor()).printStackTrace();
            throw new Exception("GRESKA");
        }
        
    }

    public void dodajInstruktora(Instruktor i) throws Exception {
        
        Zahtev zahtev = new Zahtev(Operacija.DODAJ_INSTRUKTORA, i);
        posiljalac.posalji(zahtev);
        Odgovor odgovor = (Odgovor) primalac.primi();
        if(odgovor.getOdgovor()==null){
            System.out.println("USPEH");
        }else{
            Exception e = (Exception) odgovor.getOdgovor();
            throw e;
        }
    }

    public void azurirajInstruktora(Instruktor i) {
        Zahtev zahtev = new Zahtev(Operacija.AZURIRAJ_INSTRUKTORA, i);
        posiljalac.posalji(zahtev);
        Odgovor odgovor = (Odgovor) primalac.primi();
        if(odgovor.getOdgovor()==null){
            System.out.println("USPEH");
            cordinator.Cordinator.getInstance().osveziFormuInstruktor();
        }else{
            System.out.println("GRESKA");
        }
    }

    public List<EvidencijaRadionice> ucitajEvidencijeRadionica() {
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_EVIDENCIJE_RADIONICA,null);
        List<EvidencijaRadionice> evidencijeRadionica = new ArrayList<>();
        posiljalac.posalji(zahtev);
        Odgovor odg = (Odgovor) primalac.primi();
        evidencijeRadionica = (List<EvidencijaRadionice>) odg.getOdgovor();
        return evidencijeRadionica;
        
    }

    public void dodajPolaznika(Polaznik p) throws Exception{
        Zahtev zahtev = new Zahtev(Operacija.DODAJ_POLAZNIKA, p);
        posiljalac.posalji(zahtev);
        Odgovor odgovor = (Odgovor) primalac.primi();
        if(odgovor.getOdgovor()==null){
            System.out.println("USPEŠNO");
        }else{
            Exception e = (Exception) odgovor.getOdgovor();
            throw e;
        }
    }


    public void dodajFiguru(Figura f) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.DODAJ_FIGURU, f);
        posiljalac.posalji(zahtev);
        Odgovor odgovor = (Odgovor) primalac.primi();
        if(odgovor.getOdgovor()==null){
            System.out.println("USPEŠNO");
        }else{
            Exception e = (Exception) odgovor.getOdgovor();
            throw e;
        }
    }

    public void obrisiFiguru(Figura f) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.OBRISI_FIGURU,f);
        posiljalac.posalji(zahtev);
        
        Odgovor odg = (Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            System.out.println("USPESNO");
        }else{
            Exception e = (Exception) odg.getOdgovor();
            throw e;
        }
    }

    public List<Figura> ucitajFigure() {
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_FIGURE,null);
        List<Figura> figure = new ArrayList<>();
        posiljalac.posalji(zahtev);
        Odgovor odg = (Odgovor) primalac.primi();
        figure = (List<Figura>) odg.getOdgovor();
        return figure;
    }

    public void azurirajFiguru(Figura f) {
        Zahtev zahtev = new Zahtev(Operacija.AZURIRAJ_FIGURU, f);
        posiljalac.posalji(zahtev);
        Odgovor odgovor = (Odgovor) primalac.primi();
        if(odgovor.getOdgovor()==null){
            System.out.println("USPEŠNO");
            cordinator.Cordinator.getInstance().osveziFormuFigura();
        }else{
            System.out.println("GREŠKA: " + odgovor.getOdgovor().toString());
            System.out.println("GREŠKA");
        }
    }

    public List<Kategorija> ucitajKategorije() {
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_KATEGORIJE,null);
        List<Kategorija> kategorije = new ArrayList<>();
        posiljalac.posalji(zahtev);
        Odgovor odg = (Odgovor) primalac.primi();
        kategorije = (List<Kategorija>) odg.getOdgovor();
        return kategorije;
    }

//    public void obrisiKategoriju(Kategorija k) throws Exception {
//        
//        Zahtev zahtev = new Zahtev(Operacija.OBRISI_KATEGORIJU,k);
//        posiljalac.posalji(zahtev);
//        
//        Odgovor odg = (Odgovor) primalac.primi();
//        if(odg.getOdgovor()==null){
//            System.out.println("USPESNO");
//        }else{
//            System.out.println("GRESKA");
//            ((Exception)odg.getOdgovor()).printStackTrace();
//            throw new Exception("GRESKA");
//        }
//    }

    public void dodajKategoriju(Kategorija k) {
        Zahtev zahtev = new Zahtev(Operacija.DODAJ_KATEGORIJU, k);
        posiljalac.posalji(zahtev);
        Odgovor odgovor = (Odgovor) primalac.primi();
        if(odgovor.getOdgovor()==null){
            System.out.println("USPEH");
        }else{
            System.out.println("GRESKA");
        }    }

//    public void azurirajKategoriju(Kategorija k) {
//        Zahtev zahtev = new Zahtev(Operacija.AZURIRAJ_KATEGORIJU, k);
//        posiljalac.posalji(zahtev);
//        Odgovor odgovor = (Odgovor) primalac.primi();
//        if(odgovor.getOdgovor()==null){
//            System.out.println("USPEH");
//            cordinator.Cordinator.getInstance().osveziFormuKategorija();
//        }else{
//            System.out.println("GRESKA");
//        }
//    }

    public void obrisiPolaznika(Polaznik p) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.OBRISI_POLAZNIKA,p);
        posiljalac.posalji(zahtev);
        
        Odgovor odg = (Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            System.out.println("USPEŠNO");
        }else{
            Exception e = (Exception) odg.getOdgovor();
            throw e;
        }
    }

    public List<Polaznik> ucitajPolaznike() {
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_POLAZNIKE,null);
        List<Polaznik> polaznici = new ArrayList<>();
        posiljalac.posalji(zahtev);
        Odgovor odg = (Odgovor) primalac.primi();
        polaznici = (List<Polaznik>) odg.getOdgovor();
        return polaznici;
    }

    public void azurirajPolaznika(Polaznik p) {
        Zahtev zahtev = new Zahtev(Operacija.AZURIRAJ_POLAZNIKA, p);
        posiljalac.posalji(zahtev);
        Odgovor odgovor = (Odgovor) primalac.primi();
        if(odgovor.getOdgovor()==null){
            System.out.println("USPEŠNO");
            cordinator.Cordinator.getInstance().osveziFormuPolaznik();
        }else{
            System.out.println("GREŠKA");
        }
        
    }



    
}
