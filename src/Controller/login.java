/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.FormLogin;
import View.FormUtama;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Fraesla
 */
public class login {
    FormLogin login;
    Model.login model;
    DAO.login data;
    FormUtama home;
    Connection con;
    Server.Koneksi k;
    
    public login (FormLogin login, FormUtama home){
        this.login = login;
        this.home = home;
        data = new DAO.login();
        k = new Server.Koneksi();
        con = k.getConnection();
    }
    public void getAkun(){
        String user = login.getTxtUser().getText();
        String pass = login.getTxtpass().getText();
        try {
            model = new Model.login();
            model = data.getAkun(user, pass);
            if (model != null) {
                FormUtama views = new FormUtama();
                if (model.getStatus().equals("operator")) {
                    views.getReport().setVisible(false);
                    views.getKet().setText("Operator");
                    views.getUser1().setText(model.getUser());
                    views.getjEdit().setVisible(false);
                    views.getjInsert().setBackground(Color.orange);
                    views.getjLabel4().setText("Edit Akun");
                    views.getjLabel4().setForeground(Color.white);
                } else{
                    views.getUser1().setText(model.getUser());
                    views.getKet().setText("Admin");
                    views.getjEdit().setVisible(true);
                    views.getjLabel4().setText("Tambah Akun");
                    views.getjLabel5().setText("Edit Akun");
                }
                views.getA().setText(model.getStatus());
                views.setVisible(true);
                login.dispose();
            } else{
                JOptionPane.showMessageDialog(null, "Username atau Password Salah");
                this.clear();
                login.getTxtUser().requestFocus();
            }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error : "+e);
        }
    }
    public void insert(){
        model = new Model.login();
        model.setUser(home.getUser().getText());
        model.setPass(home.getPass().getText());
        model.setStatus(home.getStatus().getSelectedItem().toString());
        try {
            data.insert(model);
            JOptionPane.showMessageDialog(null, "Entry Akun OK");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : "+ex);
        }
    }
    
    public void update(){
        String user = home.getUser().getText();
        String pass = home.getPass().getText();
        try {
            model = new Model.login();
            model = data.getAkun(user, pass);
            if (model != null) {
                String passnew = home.getPassnew().getText();
                String passkon = home.getPasskon().getText();
                if (passnew.equals(passkon)) {
                    model = new Model.login();
                    model.setUser(user);
                    model.setPass(passnew);
                    data.update(model);
                    JOptionPane.showMessageDialog(home, "Update Akun OK");
                } else{
                    JOptionPane.showMessageDialog(home, "Password baru tidak sama");
                }
            } else{
                JOptionPane.showMessageDialog(null, "Password Lama Salah");
                home.getUser().setText("");
                home.getPass().setText("");
                home.getPassnew().setText("");
                home.getPasskon().setText("");
                home.getUser().requestFocus();
            }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error : "+e);
        }
    }
    public void clear(){
        login.getTxtUser().setText("");
        login.getTxtpass().setText("");
    }
    
    public void cek(){
        String user = home.getUser().getText();
        String pass = home.getPass().getText();
        try {
            model = new Model.login();
            model = data.getAkun(user, pass);
            if (model != null) {
                home.getPassnew().requestFocus();
            } else{
                JOptionPane.showMessageDialog(null, "Username atau Password Salah");
                home.getUser().setText("");
                home.getPass().setText("");
                home.getUser().requestFocus();
            }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error : "+e);
        }
    }
}
