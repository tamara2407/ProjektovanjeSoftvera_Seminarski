/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.EvidencijaRadionice;
import domen.Figura;
import domen.StavkaEvidencijeRadionice;
import forme.DodajStavkuForma;
import forme.model.ModelTabeleFigura;
import forme.model.ModelTabeleStavke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gtama
 */
public class DodajStavkuController {
    
    private final DodajStavkuForma dsf;

    public DodajStavkuController(DodajStavkuForma dsf) {
        this.dsf = dsf;
        addActionListeners();
    }

    public void otvoriFormu() {
        pripremiFormu();
        dsf.setVisible(true);
    }

    private void addActionListeners() {
        StavkaEvidencijeRadionice se = new StavkaEvidencijeRadionice();
        dsf.pretraziAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String naziv = dsf.getjTextFieldNaziv().getText().trim();

                ModelTabeleFigura mtf = (ModelTabeleFigura) dsf.getjTableFigure().getModel();
                mtf.pretrazi(naziv);
                if (mtf.getLista().isEmpty()) {
                    JOptionPane.showMessageDialog(dsf, "Sistem ne može da nađe figure po zadatom kriterijumu", "NEUSPEŠNO", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(dsf, "Sistem je našao figure po zadatom kriterijumu", "USPEŠNO", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        });
        dsf.resetujAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pripremiFormu();
                dsf.getjTextFieldNaziv().setText("");

            }

        });
        
        dsf.izaberiAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Figura figura;
                int brojCasova;

                int red = dsf.getjTableFigure().getSelectedRow();

                if (red == -1) {
                    JOptionPane.showMessageDialog(dsf, "Morate selektovati figuru", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    ModelTabeleFigura mtf = (ModelTabeleFigura) dsf.getjTableFigure().getModel();
                    figura = mtf.getLista().get(red);

                }

                double cenaFigure = figura.getCena();
              

                try {
                    brojCasova = Integer.parseInt(dsf.getjTextFieldBrojCasova().getText().trim());

                } catch (NumberFormatException exc) {
                    JOptionPane.showMessageDialog(dsf, "Broj časova nije ispravno unet", "NEUSPEŠNO", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (brojCasova < 0) {
                    JOptionPane.showMessageDialog(dsf, "Broj časova ne može biti negativan", "NEUSPEŠNO", JOptionPane.ERROR_MESSAGE);
                    return;

                }
                if (brojCasova == 0) {
                    JOptionPane.showMessageDialog(dsf, "Broj časova ne može biti nula", "NEUSPEŠNO", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                

                double cenaStavke = cenaFigure * brojCasova;
                
                dsf.getjLabelUkupnaCena().setText(cenaStavke+"");
                se.setCenaStavke(cenaStavke);
                se.setFigura(figura);
                se.setCenaFigure(cenaFigure);
                se.setBrojCasova(brojCasova);
            }
        });
        
         dsf.dodajAddActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(se.getCenaStavke() == 0){
                    JOptionPane.showMessageDialog(dsf, "Da biste dodali stavku potrebno je da dodate sve potrebne podatke", "NEUSPEŠNO", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                if(dsf.getParent() != null){
                    
                    EvidencijaRadionice evidencija = dsf.getParent().getEvidencijaRadionice();
                    se.setEvidencijaRadionice(evidencija);
                    
                    ModelTabeleStavke mts = (ModelTabeleStavke) dsf.getParent().getjTableStavke().getModel();
                    List<StavkaEvidencijeRadionice> stavke = mts.getLista();
                    for (StavkaEvidencijeRadionice s : stavke) {
                        if(s.getFigura().equals(se.getFigura())){
                            int novibrojCasova = s.getBrojCasova()+se.getBrojCasova();
                            mts.obrisiStavku(s);
                            s.setBrojCasova(novibrojCasova);
                            s.setCenaStavke(se.getCenaFigure()*novibrojCasova);
                            mts.dodaj(s);
                            cordinator.Cordinator.getInstance().kreirajEvidencijuRadioniceController.pripremiFormuStavki();
                            
                            JOptionPane.showMessageDialog(dsf, "Stavka je uspešno dodata u evidenciju radionice", "USPEŠNO", JOptionPane.INFORMATION_MESSAGE);
                            dsf.dispose();
                            return;
                        }
                    }
                    
                    dsf.getParent().getEvidencijaRadionice().getStavke().add(se);
                }
                else{
                    cordinator.Cordinator.getInstance().dodajParam("stavka", se);
                }
                JOptionPane.showMessageDialog(dsf, "Stavka je uspešno dodata u evidenciju radionice", "USPEŠNO", JOptionPane.INFORMATION_MESSAGE);
                dsf.dispose();
            }
            
        });
        
        
        
        
        
        
        
        
        
        

    }

    public void pripremiFormu() {
        List<Figura> figure = komunikacija.Komunikacija.getInstance().ucitajFigure();
        ModelTabeleFigura mtf = new ModelTabeleFigura(figure);
        dsf.getjTableFigure().setModel(mtf);
    }

    public void osveziFormu() {
        pripremiFormu();
    }
    
}
