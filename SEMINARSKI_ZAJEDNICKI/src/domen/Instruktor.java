/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author gtama
 */
public class Instruktor implements ApstraktniDomenskiObjekat{
    
    private int instruktorID;
    private String ime;
    private String prezime;
    private String email;
    private String korisnickoIme;
    private String lozinka;

    public Instruktor() {
    }

    public Instruktor(int instruktorID, String ime, String prezime, String email, String korisnickoIme, String lozinka) {
        this.instruktorID = instruktorID;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public int getInstruktorID() {
        return instruktorID;
    }

    public void setInstruktorID(int instruktorID) {
        this.instruktorID = instruktorID;
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

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
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
        final Instruktor other = (Instruktor) obj;
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        return Objects.equals(this.lozinka, other.lozinka);
    }

   
    

    @Override
    public String vratiNazivTabele() {
        return "instruktor";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int instruktorID = rs.getInt("instruktor.instruktorID");
            String ime = rs.getString("instruktor.ime");
            String prezime = rs.getString("instruktor.prezime");
            String email = rs.getString("instruktor.email");
            String korisnickoIme = rs.getString("instruktor.korisnickoIme");
            String lozinka = rs.getString("instruktor.lozinka");
            
            Instruktor i = new Instruktor(instruktorID, ime, prezime, email, korisnickoIme, lozinka);
            lista.add(i);
        }
        
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "ime,prezime,email,korisnickoIme,lozinka";   
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+ime+"','"+prezime+"','"+email+"','"+korisnickoIme+"','"+lozinka+"'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "instruktor.instruktorID="+instruktorID;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "ime='"+ime+"',prezime='"+prezime+"',email='"+email+"',korisnickoIme='"+korisnickoIme+"',lozinka='"+lozinka+"'";
    }
    
    
    
}
