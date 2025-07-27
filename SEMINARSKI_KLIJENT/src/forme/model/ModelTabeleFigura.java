/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.Figura;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gtama
 */
public class ModelTabeleFigura extends AbstractTableModel{

    List<Figura> lista;
    String[] kolone = {"id","naziv","tezina","cena"};

    public ModelTabeleFigura(List<Figura> lista) {
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
        Figura f = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return f.getFiguraID();
            case 1:
                return f.getNaziv();
            case 2:
                return f.getTezina();
            case 3:
                return f.getCena();
            default:
                return "NA";
        }
    }

    public List<Figura> getLista() {
        return lista;
    }


    public void pretrazi(String naziv) {
            List<Figura> filteredList = lista.stream()
            .filter(f -> (naziv == null || naziv.isEmpty() || f.getNaziv().toLowerCase().contains(naziv.toLowerCase())))
            .collect(Collectors.toList());
        this.lista = filteredList;
        fireTableDataChanged();    
    }   
}
