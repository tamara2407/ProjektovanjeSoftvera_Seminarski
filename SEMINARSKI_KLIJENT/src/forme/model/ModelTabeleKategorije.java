/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.Kategorija;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gtama
 */
public class ModelTabeleKategorije extends AbstractTableModel{

    List<Kategorija> lista;
    String[] kolone = {"id","naziv"};

    public ModelTabeleKategorije(List<Kategorija> lista) {
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
        Kategorija k = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return k.getKategorijaID();
            case 1:
                return k.getNaziv();
            default:
                return "NA";
        }
    }

    public List<Kategorija> getLista() {
        return lista;
    }

    public void pretrazi(String naziv) {
            List<Kategorija> filteredList = lista.stream()
            .filter(k -> (naziv == null || naziv.isEmpty() || k.getNaziv().toLowerCase().contains(naziv.toLowerCase())))
            .collect(Collectors.toList());
        this.lista = filteredList;
        fireTableDataChanged();    
    }   
    
}
