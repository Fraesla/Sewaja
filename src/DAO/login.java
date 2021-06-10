/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Fraesla
 */
public class login {
    Connection con;
    public login(){
        Server.Koneksi k = new Server.Koneksi();
        con = k.getConnection();
    }
    public Model.login getAkun(String kodeCari, String pass) throws SQLException {
        String sql = "select * from login where username = ? and password = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kodeCari);
        ps.setString(2, pass);
        Model.login akun = null;
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            akun = new Model.login();
            akun.setUser(rs.getString(1));
            akun.setPass(rs.getString(2));
            akun.setStatus(rs.getString(3));
        }
        return akun;
    }
    public void insert(Model.login akun) throws SQLException {
        String sql = "INSERT INTO login VALUE(?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, akun.getUser());
        ps.setString(2, akun.getPass());
        ps.setString(3, akun.getStatus());
        ps.executeUpdate();
    }
    
    public void update(Model.login akun) throws SQLException {
        String sql = "update login set password = ? where username = ? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, akun.getPass());
        ps.setString(2, akun.getUser());
        ps.executeUpdate();
    }
}
