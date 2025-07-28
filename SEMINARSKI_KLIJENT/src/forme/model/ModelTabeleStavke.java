/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.StatusStavke;
import domen.StavkaEvidencijeRadionice;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tacaaa
 */
public class ModelTabeleStavke extends AbstractTableModel {

    List<StavkaEvidencijeRadionice> lista = new ArrayList<>();
    String[] kolone = {"figura", "cena figure", "broj casova", "cena stavke"};

    public ModelTabeleStavke(List<StavkaEvidencijeRadionice> lista) {
        //this.lista = lista;
        this.lista = (lista != null) ? lista : new ArrayList<>();
    }

    public List<StavkaEvidencijeRadionice> getAktivneStavke() {
        List<StavkaEvidencijeRadionice> aktivne = new ArrayList<>();
        for (StavkaEvidencijeRadionice se : lista) {
            if (se.getStatus()!= StatusStavke.OBRISANA) {
                aktivne.add(se);
            }
        }
        return aktivne;
    }

    @Override
    public int getRowCount() {
        
        return getAktivneStavke().size();

    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaEvidencijeRadionice se = getAktivneStavke().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return se.getFigura().getNaziv();
            case 1:
                return se.getCenaFigure();
            case 2:
                return se.getBrojCasova();
            case 3:
                return se.getCenaStavke();
            default:
                return "NA";
        }
    }

    public List<StavkaEvidencijeRadionice> getLista() {
        return lista;
    }

    public void obrisiStavku(StavkaEvidencijeRadionice se) {
       se.setStatus(StatusStavke.OBRISANA);
        fireTableDataChanged();
    }

    public void dodaj(StavkaEvidencijeRadionice se) {
        lista.add(se);
        fireTableDataChanged();
    }

    //ovde
    public void izmeniBrojCasova(int rowIndex, int noviBrojCasova) {
        StavkaEvidencijeRadionice se = getAktivneStavke().get(rowIndex);
        se.setBrojCasova(noviBrojCasova);
        se.setCenaStavke(noviBrojCasova * se.getCenaFigure());

        fireTableRowsUpdated(rowIndex, rowIndex);
    }
}
