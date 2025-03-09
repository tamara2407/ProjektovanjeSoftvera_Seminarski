/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.Instruktor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gtama
 */
public class ModelTabeleInstruktor extends AbstractTableModel{

    List<Instruktor> lista;
    String[] kolone = {"id","ime","prezime","email"};

    public ModelTabeleInstruktor(List<Instruktor> lista) {
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
        Instruktor i = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return i.getInstruktorID();
            case 1:
                return i.getIme();
            case 2:
                return i.getPrezime();
            case 3:
                return i.getEmail();
            default:
                return "NA";
        }
    }

    public List<Instruktor> getLista() {
        return lista;
    }
    
    
    
}
