/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import java.text.SimpleDateFormat;

import domen.EvidencijaRadionice;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gtama
 */
public class ModelTabeleEvidencijeRadionice extends AbstractTableModel {

    List<EvidencijaRadionice> lista = new ArrayList<>();
    String[] kolone = {"id", "datum kreiranja", "instruktor", "polaznik", "ukupnaCena"};

    public ModelTabeleEvidencijeRadionice(List<EvidencijaRadionice> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();

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
        EvidencijaRadionice e = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return e.getEvidencijaRadioniceID();
            case 1:
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
                return sdf.format(e.getDatum());
            case 2:
                return e.getInstruktor().getIme()+" "+e.getInstruktor().getPrezime();

            case 3:
                return e.getPolaznik().getIme()+" "+e.getPolaznik().getPrezime();
            case 4:
                return e.getCena();

            default:
                return "NA";
        }
    }

    public List<EvidencijaRadionice> getLista() {
        return lista;
    }


    public void pretrazi(String ime, String prezime) {
        List<EvidencijaRadionice> filteredList = lista.stream()
                .filter(e -> (ime == null || ime.isEmpty() || e.getPolaznik().getIme().toLowerCase().contains(ime.toLowerCase())))
                .filter(e -> (prezime == null || prezime.isEmpty() || e.getPolaznik().getIme().toLowerCase().contains(prezime.toLowerCase())))
                .collect(Collectors.toList());
        
        this.lista = filteredList;
        fireTableDataChanged();
    }
    
}
