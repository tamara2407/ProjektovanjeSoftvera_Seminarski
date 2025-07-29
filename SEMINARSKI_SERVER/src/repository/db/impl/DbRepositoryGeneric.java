/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import java.sql.PreparedStatement;
import domen.ApstraktniDomenskiObjekat;
import java.util.ArrayList;
import java.util.List;
import repository.db.DbRepository;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author gtama
 */
import repository.db.DbConnectionFactory;
public class DbRepositoryGeneric implements DbRepository<ApstraktniDomenskiObjekat> {

    @Override
    public List<ApstraktniDomenskiObjekat> getAll(ApstraktniDomenskiObjekat param, String uslov) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        String upit = "SELECT * FROM " + param.vratiNazivTabele();
        if(uslov!=null){
            upit+=uslov; 
        }
        
        System.out.println(upit);
        
        Statement st = DbConnectionFactory.getInstance().getConnection().createStatement();
        ResultSet rs = st.executeQuery(upit);
        lista = param.vratiListu(rs);
        
        
        rs.close();
        st.close();
        return lista;
    }

    @Override
    public PreparedStatement add(ApstraktniDomenskiObjekat param) throws Exception {
        
        String upit = "INSERT INTO " + param.vratiNazivTabele() + " ("
                + param.vratiKoloneZaUbacivanje() + " ) VALUES ( " + param.vratiVrednostiZaUbacivanje() + " )";

        System.out.println(upit);

        PreparedStatement ps = DbConnectionFactory.getInstance().getConnection().prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
        ps.executeUpdate();
        return ps;
    }

    @Override
    public void edit(ApstraktniDomenskiObjekat param) throws Exception {
        
        String upit = "UPDATE "+param.vratiNazivTabele()+" SET "+ param.vratiVrednostiZaIzmenu()+" WHERE " + param.vratiPrimarniKljuc();
        System.out.println(upit);
        Statement st = DbConnectionFactory.getInstance().getConnection().createStatement();
        st.executeUpdate(upit);
        st.close();
    }

    @Override
    public void delete(ApstraktniDomenskiObjekat param) throws Exception {
        String upit = "DELETE FROM "+param.vratiNazivTabele()+" WHERE "+ param.vratiPrimarniKljuc();
        System.out.println(upit);
        Statement st = DbConnectionFactory.getInstance().getConnection().createStatement();
        st.executeUpdate(upit);
        st.close();
    }

    @Override
    public List<ApstraktniDomenskiObjekat> getAll() {
        
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        
        //ODRADI
        
        return lista;
        
    }

    @Override
    public ApstraktniDomenskiObjekat get(ApstraktniDomenskiObjekat param, String uslov) throws Exception {
        
        ApstraktniDomenskiObjekat novi = null;
        String upit = "SELECT * FROM " + param.vratiNazivTabele();
        if(uslov!=null){
            upit+=uslov; 
        }
        
        System.out.println(upit);
        
        Statement st = DbConnectionFactory.getInstance().getConnection().createStatement();
        ResultSet rs = st.executeQuery(upit);
        List<ApstraktniDomenskiObjekat> lista = param.vratiListu(rs);
        if (!lista.isEmpty()) {
            novi = lista.get(0);
        }
        
        
        rs.close();
        st.close();
        return novi;
        
    }
    
}
