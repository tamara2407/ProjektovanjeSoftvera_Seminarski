/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import cordinator.Cordinator;
import domen.Instruktor;
import forme.LoginForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author gtama
 */
public class LoginController {
    
    private final LoginForma lf;

    public LoginController(LoginForma lf) {
        this.lf = lf;
        addActionListeners();
    }
    
    private void addActionListeners(){
    
        lf.loginAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prijava(e);
            }

            private void prijava(ActionEvent e) {
                
                String ki = lf.getjTextFieldUsername().getText().trim();
                String pass = String.valueOf(lf.getjPasswordFieldPassword().getPassword());
                
                komunikacija.Komunikacija.getInstance().konekcija();
                Instruktor ulogovani = komunikacija.Komunikacija.getInstance().login(ki, pass);
                
                if(ulogovani==null){
                    JOptionPane.showMessageDialog(lf,"Korisničko ime i šifra nisu ispravni","GREŠKA", JOptionPane.ERROR_MESSAGE);

                }else{
                    Cordinator.getInstance().setUlogovani(ulogovani);
                    JOptionPane.showMessageDialog(lf,"Korisničko ime i šifra su ispravni","USPEH", JOptionPane.INFORMATION_MESSAGE);
                    Cordinator.getInstance().otvoriGlavnuFormu();
                    lf.dispose();
                }
                
            }
        });
        
    }

    public void otvoriFormu() {
        lf.setVisible(true);
    }
    
    
    
}
