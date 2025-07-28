/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.evidencijaRadionice;

import domen.EvidencijaRadionice;
import domen.StavkaEvidencijeRadionice;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author gtama
 */
public class KreirajEvidencijuRadioniceSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {

        if (param == null || !(param instanceof EvidencijaRadionice)) {
            throw new Exception("Sistem ne moze da kreira evidenciju radionice");
        }

    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {

        EvidencijaRadionice evidencija = (EvidencijaRadionice) param;
        PreparedStatement ps = broker.add(param);
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        int id = rs.getInt(1);
        evidencija.setEvidencijaRadioniceID(id);
        
        for (StavkaEvidencijeRadionice se : evidencija.getStavke()) {
            se.setEvidencijaRadionice(evidencija);
            broker.add(se);
        }
        




    }
    
}
