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
public class Figura implements ApstraktniDomenskiObjekat{
 
    private int figuraID;
    private String naziv;
    private String tezina;
    private double cena;

    public Figura() {
    }

    public Figura(int figuraID, String naziv, String tezina, double cena) {
        this.figuraID = figuraID;
        this.naziv = naziv;
        this.tezina = tezina;
        this.cena = cena;
    }

    public int getFiguraID() {
        return figuraID;
    }

    public void setFiguraID(int figuraID) {
        this.figuraID = figuraID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTezina() {
        return tezina;
    }

    public void setTezina(String tezina) {
        this.tezina = tezina;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
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
        final Figura other = (Figura) obj;
        return this.figuraID == other.figuraID;
    }

    @Override
    public String vratiNazivTabele() {
        return "figura";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int figuraID = rs.getInt("figura.figuraID");
            String naziv = rs.getString("figura.naziv");
            String tezina = rs.getString("figura.tezina");
            double cena = rs.getDouble("figura.cena");
            
            Figura f = new Figura(figuraID, naziv, tezina, cena);
            lista.add(f);
        }
        
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "naziv,tezina,cena";     }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+naziv+"','"+tezina+"',"+cena;
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "figura.figuraID="+figuraID;    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "naziv='"+naziv+"',tezina='"+tezina+"',cena="+cena;   
    }
    
    
}
