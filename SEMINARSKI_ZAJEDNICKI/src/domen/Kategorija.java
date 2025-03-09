/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gtama
 */
public class Kategorija implements ApstraktniDomenskiObjekat{
    
    private int kategorijaID;
    private String naziv;

    public Kategorija() {
    }

    public Kategorija(int kategorijaID, String naziv) {
        this.kategorijaID = kategorijaID;
        this.naziv = naziv;
    }

    public int getKategorijaID() {
        return kategorijaID;
    }

    public void setKategorijaID(int kategorijaID) {
        this.kategorijaID = kategorijaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return naziv;
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
        final Kategorija other = (Kategorija) obj;
        return this.kategorijaID == other.kategorijaID;
    }

    @Override
    public String vratiNazivTabele() {
        return "kategorija";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int kategorijaID = rs.getInt("kategorija.kategorijaID");
            String naziv = rs.getString("kategorija.naziv");
            
            Kategorija k = new Kategorija(kategorijaID, naziv);
            lista.add(k);
        }
        
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "naziv";     }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+naziv+"'";    }

    @Override
    public String vratiPrimarniKljuc() {
        return "kategorija.kategorijaID="+kategorijaID;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "naziv='"+naziv+"'";
    }
    
    
}
