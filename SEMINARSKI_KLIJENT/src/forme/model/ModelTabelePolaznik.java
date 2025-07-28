/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.Polaznik;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gtama
 */
public class ModelTabelePolaznik extends AbstractTableModel{

    List<Polaznik> lista;
    String[] kolone = {"id","ime","prezime","email","kategorija"};

    public ModelTabelePolaznik(List<Polaznik> lista) {
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
        Polaznik p = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getPolaznikID();
            case 1:
                return p.getIme();
            case 2:
                return p.getPrezime();
            case 3:
                return p.getEmail();
            case 4:
                return p.getKategorija().getNaziv();
            default:
                return "NA";
        }
    }

    public List<Polaznik> getLista() {
        return lista;
    }

    public void pretrazi(String ime, String prezime) {
        List<Polaznik> filteredList = lista.stream()
            .filter(p -> (ime == null || ime.isEmpty() || p.getIme().toLowerCase().contains(ime.toLowerCase())))
            .filter(p -> (prezime == null || prezime.isEmpty() || p.getPrezime().toLowerCase().contains(prezime.toLowerCase())))
            .collect(Collectors.toList());
        this.lista = filteredList;
        fireTableDataChanged();
               
    }

    public void pretrazi(String imePrezime) {
        List<Polaznik> filteredList = lista.stream()
                .filter(p -> (imePrezime == null || imePrezime.isEmpty() || p.getIme().toLowerCase().contains(imePrezime.toLowerCase()) || p.getPrezime().toLowerCase().contains(imePrezime.toLowerCase())))
                .collect(Collectors.toList());

        this.lista = filteredList;
        fireTableDataChanged();
    
    }
    
}
