/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author gtama
 */
public class Polaznik implements ApstraktniDomenskiObjekat{
    
    private int polaznikID;
    private String ime;
    private String prezime;
    private String email;
    private Kategorija kategorija;

    public Polaznik() {
    }

    public Polaznik(int polaznikID, String ime, String prezime, String email, Kategorija kategorija) {
        this.polaznikID = polaznikID;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.kategorija = kategorija;
    }

    public int getPolaznikID() {
        return polaznikID;
    }

    public void setPolaznikID(int polaznikID) {
        this.polaznikID = polaznikID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Polaznik other = (Polaznik) obj;
        return this.polaznikID == other.polaznikID;
    }

    @Override
    public String vratiNazivTabele() {
        return "polaznik";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "ime,prezime,email,kategorija";     }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+ime+"','"+prezime+"','"+email+"',"+kategorija.getKategorijaID();    }

    @Override
    public String vratiPrimarniKljuc() {
        return "polaznik.polaznikID="+polaznikID;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "ime='"+ime+"',prezime='"+prezime+"',email='"+email+"',kategorija="+kategorija.getKategorijaID();    }
    
    
    
}
