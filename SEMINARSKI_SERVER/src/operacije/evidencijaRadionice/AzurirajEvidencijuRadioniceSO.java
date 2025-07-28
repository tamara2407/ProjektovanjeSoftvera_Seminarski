/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.evidencijaRadionice;

import domen.EvidencijaRadionice;
import domen.StavkaEvidencijeRadionice;
import java.util.Date;
import java.util.List;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author gtama
 */
public class AzurirajEvidencijuRadioniceSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof EvidencijaRadionice)) {
            throw new Exception("Sistem ne moze da zapamti evidenciju radionice");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {

        EvidencijaRadionice er = (EvidencijaRadionice) param;

        List<StavkaEvidencijeRadionice> sveStavke = er.getStavke();  

        for (StavkaEvidencijeRadionice se : sveStavke) {
            se.setEvidencijaRadionice(er);

            switch (se.getStatus()) {
                case NOVA:
                    broker.add(se);
                    break;
                case IZMENJENA:
                    broker.edit(se);
                    break;
                case OBRISANA:
                    broker.delete(se);
                    break;
                case NEIZMENJENA:
                    break; 
            }
        }

        er.setDatum(new Date());
        broker.edit(er);

    }
    
}
