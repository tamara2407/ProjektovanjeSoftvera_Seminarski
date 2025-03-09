/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import domen.Instruktor;
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
            System.out.println("uspeh");
        }else{
            System.out.println("greska");
            ((Exception)odg.getOdgovor()).printStackTrace();
            throw new Exception("GRESKA");
        }
        
    }

    public void dodajInstruktora(Instruktor i) {
        
    }
    
}
