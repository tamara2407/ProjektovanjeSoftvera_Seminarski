/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author gtama
 */
public class EvidencijaRadionice implements ApstraktniDomenskiObjekat{
    
    private int evidencijaRadioniceID;
    private double cena;
    private Date datum;
    private Instruktor instruktor;
    private Polaznik polaznik;
    private List<StavkaEvidencijeRadionice> stavke = new ArrayList<>();

    public EvidencijaRadionice() {
    }

    public EvidencijaRadionice(int evidencijaRadioniceID, double cena, Date datum, Instruktor instruktor, Polaznik polaznik, List<StavkaEvidencijeRadionice> stavke) {
        this.evidencijaRadioniceID = evidencijaRadioniceID;
        this.cena = cena;
        this.datum = datum;
        this.instruktor = instruktor;
        this.polaznik = polaznik;
        this.stavke = stavke;
    }

    public int getEvidencijaRadioniceID() {
        return evidencijaRadioniceID;
    }

    public void setEvidencijaRadioniceID(int evidencijaRadioniceID) {
        this.evidencijaRadioniceID = evidencijaRadioniceID;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Instruktor getInstruktor() {
        return instruktor;
    }

    public void setInstruktor(Instruktor instruktor) {
        this.instruktor = instruktor;
    }

    public Polaznik getPolaznik() {
        return polaznik;
    }

    public void setPolaznik(Polaznik polaznik) {
        this.polaznik = polaznik;
    }

    public List<StavkaEvidencijeRadionice> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaEvidencijeRadionice> stavke) {
        this.stavke = stavke;
    }

    @Override
    public String toString() {
        return "EvidencijaRadionice{" + "evidencijaRadioniceID=" + evidencijaRadioniceID + ", cena=" + cena + ", datum=" + datum + ", instruktor=" + instruktor + ", polaznik=" + polaznik + ", stavke=" + stavke + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final EvidencijaRadionice other = (EvidencijaRadionice) obj;
        return this.evidencijaRadioniceID == other.evidencijaRadioniceID;
    }

    @Override
    public String vratiNazivTabele() {
        return "evidencijaradionice";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {

            int polaznikID = rs.getInt("polaznik.polaznikID");
            String imePolaznik = rs.getString("polaznik.ime");
            String prezimePolaznik = rs.getString("polaznik.prezime");
            String emailPolaznik = rs.getString("polaznik.email");

            Kategorija kategorija = new Kategorija(rs.getInt("kategorija.kategorijaID"), rs.getString("kategorija.naziv"));

            Polaznik p = new Polaznik(polaznikID, imePolaznik, prezimePolaznik, emailPolaznik, kategorija);

            int instruktorID = rs.getInt("instruktor.instruktorID");
            String imeInstruktor = rs.getString("instruktor.ime");
            String prezimeInstruktor = rs.getString("instruktor.prezime");
            String emailInstruktor = rs.getString("instruktor.email");
            String korisnickoIme = rs.getString("instruktor.korisnickoIme");
            String lozinka = rs.getString("instruktor.lozinka");

            Instruktor i = new Instruktor(instruktorID, imeInstruktor, prezimeInstruktor,emailInstruktor ,korisnickoIme, lozinka);

            java.sql.Date sqlDate = rs.getDate("datum");
            java.util.Date utilDate = new java.util.Date(sqlDate.getTime());

            EvidencijaRadionice evidencijaRadionice = new EvidencijaRadionice(rs.getInt("evidencijaRadioniceID"), rs.getDouble("cena"), utilDate, i, p, stavke);
            lista.add(evidencijaRadionice);

        }

        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "cena,datum,instruktor,polaznik"; 
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        java.sql.Date sqlDate = new java.sql.Date(datum.getTime());
        return cena+",'"+sqlDate+"',"+instruktor.getInstruktorID()+","+polaznik.getPolaznikID(); 
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "evidencijaradionice.evidencijaRadioniceID="+evidencijaRadioniceID;    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "cena="+cena+",datum='"+datum+"',instruktor="+instruktor.getInstruktorID()+",polaznik="+polaznik.getPolaznikID();
    }
    
    
    
}
