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
public class StavkaEvidencijeRadionice implements ApstraktniDomenskiObjekat {
    
    private int rb;
    private EvidencijaRadionice evidencijaRadionice;
    private int brojCasova;
    private Figura figura;
    private double cenaFigure;
    private double cenaStavke;
    
    private StatusStavke status;

    public StavkaEvidencijeRadionice() {
    }

    public StavkaEvidencijeRadionice(int rb, EvidencijaRadionice evidencijaRadionice, int brojCasova, Figura figura, double cenaFigure, double cenaStavke) {
        this.rb = rb;
        this.evidencijaRadionice = evidencijaRadionice;
        this.brojCasova = brojCasova;
        this.figura = figura;
        this.cenaFigure = cenaFigure;
        this.cenaStavke = cenaStavke;
        
        this.status = StatusStavke.NEIZMENJENA;
    }


    

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public EvidencijaRadionice getEvidencijaRadionice() {
        return evidencijaRadionice;
    }

    public void setEvidencijaRadionice(EvidencijaRadionice evidencijaRadionice) {
        this.evidencijaRadionice = evidencijaRadionice;
    }

    public double getCenaFigure() {
        return cenaFigure;
    }

    public void setCenaFigure(double cenaFigure) {
        this.cenaFigure = cenaFigure;
    }

    public double getCenaStavke() {
        return cenaStavke;
    }

    public void setCenaStavke(double cenaStavke) {
        this.cenaStavke = cenaStavke;
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
    
    
    public StatusStavke getStatus() {
        return status;
    }

    public void setStatus(StatusStavke status) {
        this.status = status;
    }
    
    
    

    @Override
    public String toString() {
        return "StavkaEvidencijeRadionice{" + "rb=" + rb + ", evidencijaRadionice=" + evidencijaRadionice + ", brojCasova=" + brojCasova + ", figura=" + figura + ", cenaFigure=" + cenaFigure + ", cenaStavke=" + cenaStavke + '}';
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
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Figura f = new Figura(rs.getInt("figuraID"), rs.getString("naziv"), rs.getString("tezina"), rs.getDouble("cena"));
            StavkaEvidencijeRadionice stavkaEvidencijeRadionice = new StavkaEvidencijeRadionice(rs.getInt("rb"), evidencijaRadionice,rs.getInt("brojCasova"),  f, rs.getDouble("cenaFigure"), rs.getDouble("cenaStavke"));
            lista.add(stavkaEvidencijeRadionice);
        }

        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "evidencijaRadioniceID,brojCasova,figura,cenaFigure,cenaStavke";     }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return evidencijaRadionice.getEvidencijaRadioniceID()+ "," + brojCasova + ","
                + figura.getFiguraID() + "," + cenaFigure + "," + cenaStavke; 
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "stavkaevidencijeradionice.rb=" + rb + " AND stavkaevidencijeradionice.evidencijaRadioniceID=" + evidencijaRadionice.getEvidencijaRadioniceID();
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
    return "evidencijaRadioniceID=" + evidencijaRadionice.getEvidencijaRadioniceID()+ ",cenaFigure=" + cenaFigure + ",cenaStavke=" + cenaStavke + ",brojCasova=" + brojCasova
                + ",figura=" + figura.getFiguraID();
    }
    
    
    
}
