/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author gtama
 */
public class IS implements ApstraktniDomenskiObjekat{
    
    private Date datumIzdavanja;
    private Instruktor instruktor;
    private Sertifikat sertifikat;

    public IS() {
    }

    public IS(Date datumIzdavanja, Instruktor instruktor, Sertifikat sertifikat) {
        this.datumIzdavanja = datumIzdavanja;
        this.instruktor = instruktor;
        this.sertifikat = sertifikat;
    }

    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(Date datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public Instruktor getInstruktor() {
        return instruktor;
    }

    public void setInstruktor(Instruktor instruktor) {
        this.instruktor = instruktor;
    }

    public Sertifikat getSertifikat() {
        return sertifikat;
    }

    public void setSertifikat(Sertifikat sertifikat) {
        this.sertifikat = sertifikat;
    }

    @Override
    public String toString() {
        return "IS{" + "datumIzdavanja=" + datumIzdavanja + ", instruktor=" + instruktor + ", sertifikat=" + sertifikat + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final IS other = (IS) obj;
        if (!Objects.equals(this.datumIzdavanja, other.datumIzdavanja)) {
            return false;
        }
        if (!Objects.equals(this.instruktor, other.instruktor)) {
            return false;
        }
        return Objects.equals(this.sertifikat, other.sertifikat);
    }

    @Override
    public String vratiNazivTabele() {
        return "is";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "datumIzdavanja,instruktor,sertifikat";     }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+datumIzdavanja+"',"+instruktor.getInstruktorID()+","+sertifikat.getSertifikatID();    }

    @Override
    public String vratiPrimarniKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "datumIzdavanja='"+datumIzdavanja+"',instruktor="+instruktor.getInstruktorID()+",sertifikat="+sertifikat.getSertifikatID();    }
    
    
    
}
