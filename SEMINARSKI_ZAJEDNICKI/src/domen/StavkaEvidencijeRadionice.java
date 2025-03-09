/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

/**
 *
 * @author gtama
 */
public class StavkaEvidencijeRadionice implements ApstraktniDomenskiObjekat {
    
    private int rb;
    private double cena;
    private int brojCasova;
    private Figura figura; 

    public StavkaEvidencijeRadionice() {
    }

    public StavkaEvidencijeRadionice(int rb, double cena, int brojCasova, Figura figura) {
        this.rb = rb;
        this.cena = cena;
        this.brojCasova = brojCasova;
        this.figura = figura;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getBrojCasova() {
        return brojCasova;
    }

    public void setBrojCasova(int brojCasova) {
        this.brojCasova = brojCasova;
    }

    public Figura getFigura() {
        return figura;
    }

    public void setFigura(Figura figura) {
        this.figura = figura;
    }

    @Override
    public String toString() {
        return "StavkaEvidencijeRadionice{" + "rb=" + rb + ", cena=" + cena + ", brojCasova=" + brojCasova + ", figura=" + figura + '}';
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
        final StavkaEvidencijeRadionice other = (StavkaEvidencijeRadionice) obj;
        return this.rb == other.rb;
    }

    @Override
    public String vratiNazivTabele() {
        return "stavkaevidencijeradionice";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "rb,evidencijaRadioniceID,brojCasova,figura,cena";     }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        //return rb+","+EvidencijaRadioniceID+","+brojCasova+","+figura.getFiguraID()+","+cena;   
        return "";
    }

    @Override
    public String vratiPrimarniKljuc() {
        //return "stavkaevidencijeradionice.rb="+rb+" AND "+"stavkaevidencijeradionice.evidencijaRadioniceID="+;
        return "";
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        //return "rb="+rb+",evidencijaRadioniceID="+evidencijaRadioniceID+",brojCasova="+brojCasova+",figura="+figura.getFiguraID()+"cena="+cena;
        return "";
    }
    
    
    
}
