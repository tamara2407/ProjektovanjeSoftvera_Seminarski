/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.EvidencijaRadionice;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gtama
 */
public class ModelTabeleEvidencijaRadionice extends AbstractTableModel {
    
    
    List<EvidencijaRadionice> lista;
    String[] kolone = {"id","datum","instruktor","polaznik"};

        public ModelTabeleEvidencijaRadionice(List<EvidencijaRadionice> lista) {
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
                return e.getDatum();
            case 2:
                return e.getInstruktor().getIme()+ " " + e.getInstruktor().getPrezime();
            case 3:
                return e.getPolaznik().getIme()+" "+e.getPolaznik().getPrezime();
            default:
                return "NA";
        }
    }

    public List<EvidencijaRadionice> getLista() {
        return lista;
    }

    public void setLista(List<EvidencijaRadionice> lista) {
        this.lista = lista;
    }


               
    
}
