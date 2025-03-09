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
public class Sertifikat implements ApstraktniDomenskiObjekat{
    
    private int sertifikatID;
    private String naziv;
    private String plesnaSkola;

    public Sertifikat() {
    }

    public Sertifikat(int sertifikatID, String naziv, String plesnaSkola) {
        this.sertifikatID = sertifikatID;
        this.naziv = naziv;
        this.plesnaSkola = plesnaSkola;
    }

    public int getSertifikatID() {
        return sertifikatID;
    }

    public void setSertifikatID(int sertifikatID) {
        this.sertifikatID = sertifikatID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getPlesnaSkola() {
        return plesnaSkola;
    }

    public void setPlesnaSkola(String plesnaSkola) {
        this.plesnaSkola = plesnaSkola;
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
        final Sertifikat other = (Sertifikat) obj;
        return this.sertifikatID == other.sertifikatID;
    }

    @Override
    public String vratiNazivTabele() {
        return "sertifikat";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int sertifikatID = rs.getInt("sertifikat.sertifikatID");
            String naziv = rs.getString("sertifikat.naziv");
            String plesnaSkola = rs.getString("sertifikat.plesnaSkola");
            
            Sertifikat s = new Sertifikat(sertifikatID, naziv, plesnaSkola);
            lista.add(s);
        }
        
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "naziv,plesnaSkola";     }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+naziv+"','"+plesnaSkola+"'";    }

    @Override
    public String vratiPrimarniKljuc() {
        return "sertifikat.sertifikatID="+sertifikatID;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "naziv='"+naziv+"',plesnaSkola='"+plesnaSkola+"'";
    }
    
    
    
}
