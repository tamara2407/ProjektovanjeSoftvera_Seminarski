/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import domen.EvidencijaRadionice;
import domen.Figura;
import domen.Instruktor;
import domen.Kategorija;
import domen.Polaznik;
import domen.StavkaEvidencijeRadionice;
import exception.FiguraNeMozeDaSeObriseException;
import exception.FiguraVecPostojiException;
import exception.InstruktorVecPostojiException;
import exception.KategorijaVecPostojiException;
import exception.PolaznikNeMozeDaSeObriseException;
import exception.PolaznikVecPostojiException;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.login.LoginException;
import komunikacija.Odgovor;
import komunikacija.Posiljalac;
import komunikacija.Primalac;
import komunikacija.Zahtev;

/**
 *
 * @author gtama
 */
public class ObradaKlijentskihZahteva extends Thread {
    
    Socket socket;
    Posiljalac posiljalac;
    Primalac primalac;
    boolean kraj = false;

    public ObradaKlijentskihZahteva(Socket socket) {
        this.socket = socket;
        posiljalac = new Posiljalac(socket);
        primalac = new Primalac(socket);
    }
    
    

    @Override
    public void run() {
        while(!kraj){
            try {
                Zahtev zahtev = (Zahtev) primalac.primi();
                Odgovor odgovor = new Odgovor();
                switch(zahtev.getOperacija()){
                    
                    case LOGIN:
                        
                        Instruktor i = (Instruktor) zahtev.getParametar();
                            i= controller.Controller.getInstance().login(i);
                            odgovor.setOdgovor(i);
//                        try {
//
//                        } catch (LoginException ivp) {
//
//                            odgovor.setOdgovor(ivp);
//
//                        } catch (Exception excp) {
//
//                            odgovor.setOdgovor(excp);
//                        }

                        break;
                        
                    case UCITAJ_INSTRUKTORE:
                        List<Instruktor> instruktori = controller.Controller.getInstance().ucitajInstruktore();  
                        odgovor.setOdgovor(instruktori);
                        break;
                        
                    case OBRISI_INSTRUKTORA:
                        try{
                        Instruktor instruktor = (Instruktor) zahtev.getParametar();
                        controller.Controller.getInstance().obrisiInstruktora(instruktor);
                        odgovor.setOdgovor(null);
                        }catch(Exception e){
                           odgovor.setOdgovor(e);
                        }
                        break;
                        
                    case DODAJ_INSTRUKTORA:
                        Instruktor instruktor = (Instruktor) zahtev.getParametar();
                        try {
                            controller.Controller.getInstance().dodajInstruktora(instruktor);
                            odgovor.setOdgovor(null);
                        } catch (InstruktorVecPostojiException ivp) {

                            odgovor.setOdgovor(ivp);

                        } catch (Exception excp) {

                            odgovor.setOdgovor(excp);
                        }

                        break;
                        
                    case AZURIRAJ_INSTRUKTORA:
                        Instruktor Ainstruktor = (Instruktor) zahtev.getParametar();
                        controller.Controller.getInstance().azurirajInstruktora(Ainstruktor);
                        odgovor.setOdgovor(null);
                        break;
                        
                    case UCITAJ_EVIDENCIJE_RADIONICA:
                        List<EvidencijaRadionice> evidencijeRadionica = controller.Controller.getInstance().ucitajEvidencijeRadionica();  
                        System.out.println("KLASA OKZ: "+evidencijeRadionica);
                        odgovor.setOdgovor(evidencijeRadionica);
                        break;
                        
                    case DODAJ_FIGURU:
                        Figura figura = (Figura) zahtev.getParametar();
                        try {
                            controller.Controller.getInstance().dodajFiguru(figura);
                            odgovor.setOdgovor(null);
                        } catch (FiguraVecPostojiException fvp) {

                            odgovor.setOdgovor(fvp);

                        } catch (Exception excp) {

                            odgovor.setOdgovor(excp);
                        }

                        break;
                        
                    case OBRISI_FIGURU:
                        
                        Figura Ofigura = (Figura) zahtev.getParametar();
                        try {
                            controller.Controller.getInstance().obrisiFiguru(Ofigura);
                            odgovor.setOdgovor(null);
                        } catch (FiguraNeMozeDaSeObriseException exc) {

                            odgovor.setOdgovor(exc);
                        } catch (Exception ex) {

                            odgovor.setOdgovor(ex);
                        }
                        break;
                        
                    case UCITAJ_FIGURE:
                        List<Figura> figure = controller.Controller.getInstance().ucitajFigure();  
                        odgovor.setOdgovor(figure);
                        break;
                        
                    case AZURIRAJ_FIGURU:
                        Figura aFigura = (Figura) zahtev.getParametar();
                        controller.Controller.getInstance().azurirajFiguru(aFigura);
                        odgovor.setOdgovor(null);
                        break;
                        
                    case UCITAJ_KATEGORIJE:
                        List<Kategorija> kategorije = controller.Controller.getInstance().ucitajKategorije();  
                        odgovor.setOdgovor(kategorije);
                        break;
                        
                    case OBRISI_KATEGORIJU:
                        try{
                        Kategorija kategorija = (Kategorija) zahtev.getParametar();
                        controller.Controller.getInstance().obrisiKategoriju(kategorija);
                        odgovor.setOdgovor(null);
                        }catch(Exception e){
                           odgovor.setOdgovor(e);
                        }
                        break;
                        
                    case DODAJ_KATEGORIJU:
                        Kategorija k = (Kategorija) zahtev.getParametar();
                        try {
                            controller.Controller.getInstance().dodajKategorija(k);
                            odgovor.setOdgovor(null);
                        } catch (KategorijaVecPostojiException kvp) {

                            odgovor.setOdgovor(kvp);

                        } catch (Exception excp) {

                            odgovor.setOdgovor(excp);
                        }

                        break;
                        
                    case AZURIRAJ_KATEGORIJU:
                        Kategorija Akategorija = (Kategorija) zahtev.getParametar();
                        controller.Controller.getInstance().azurirajKategoriju(Akategorija);
                        odgovor.setOdgovor(null);
                        break;
                        
                    case OBRISI_POLAZNIKA:
                        
                        Polaznik oPolaznik = (Polaznik) zahtev.getParametar();
                        
                        try {
                            controller.Controller.getInstance().obrisiPolaznika(oPolaznik);
                            odgovor.setOdgovor(null);
                        } catch (PolaznikNeMozeDaSeObriseException exc) {

                            odgovor.setOdgovor(exc);
                        } catch (Exception ex) {

                            odgovor.setOdgovor(ex);
                        }
                        break;
                        
                    case UCITAJ_POLAZNIKE:
                        List<Polaznik> polaznici = controller.Controller.getInstance().ucitajPolaznike();  
                        odgovor.setOdgovor(polaznici);
                        break;
                        
                    case DODAJ_POLAZNIKA:
                        Polaznik Polaznik = (Polaznik) zahtev.getParametar();
                        try {
                            controller.Controller.getInstance().dodajPolaznika(Polaznik);
                            odgovor.setOdgovor(null);

                        } catch (PolaznikVecPostojiException pvp) {

                            odgovor.setOdgovor(pvp);

                        } catch (Exception excp) {

                            odgovor.setOdgovor(excp);
                        }
                        break;
                        
                    case AZURIRAJ_POLAZNIKA:
                        Polaznik aPolaznik = (Polaznik) zahtev.getParametar();
                        controller.Controller.getInstance().azurirajPolaznika(aPolaznik);
                        odgovor.setOdgovor(null);
                        break;
                        
                    case DODAJ_EVIDENCIJU_RADIONICE:
                        EvidencijaRadionice evidencija = (EvidencijaRadionice) zahtev.getParametar();
                        controller.Controller.getInstance().dodajEvidencijuRadionice(evidencija);
                        odgovor.setOdgovor(null);
                        break;
                    case UCITAJ_EVIDENCIJE_ZAPOSLENI:
                        Instruktor in = (Instruktor) zahtev.getParametar();
                        List<EvidencijaRadionice> evidencijeZaposlenog = controller.Controller.getInstance().ucitajEvidencijeRadionica(in);
                        odgovor.setOdgovor(evidencijeZaposlenog);
                        break;
                    case UCITAJ_STAVKE:
                        int id = (int) zahtev.getParametar();
                        List<StavkaEvidencijeRadionice> stavke = controller.Controller.getInstance().ucitajStavkeZaEvidencijuRadionice(id);
                        odgovor.setOdgovor(stavke);
                        break;
                    case IZMENI_EVIDENCIJU_RADIONICE:
                        EvidencijaRadionice er = (EvidencijaRadionice) zahtev.getParametar();
                        controller.Controller.getInstance().izmeniEvidencijuRadionice(er);
                        odgovor.setOdgovor(null);
                        break;
                        
                    default: System.out.println("GRESKA, TA OPERACIJA NE POSTOJI");
                    
                }
                
                posiljalac.posalji(odgovor);
            } catch (Exception ex) {
                Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void prekini(){
        kraj = true;
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
        interrupt();
    }
    
    
    
    
}
