/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.stavkeevidencijeradionice;

import domen.StavkaEvidencijeRadionice;
import java.util.List;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author gtama
 */
public class UcitajStavkeSO extends ApstraktnaGenerickaOperacija {

    private List<StavkaEvidencijeRadionice> stavke;

    @Override
    protected void preduslovi(Object param) throws Exception {

    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        int id = Integer.parseInt(kljuc);
        String uslov = " JOIN figura ON stavkaevidencijeradionice.figura = figura.figuraID WHERE evidencijaradioniceID=" + id;
        stavke = broker.getAll(new StavkaEvidencijeRadionice(), uslov);
    }

    public List<StavkaEvidencijeRadionice> getStavke() {
        return stavke;
    }
    
}
