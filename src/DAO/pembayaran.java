/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Server.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Fraesla
 */
public class pembayaran {
    Connection con;
    public pembayaran() {
        Koneksi server = new Koneksi();
        con=server.getConnection();
    }
    public void create(Model.pembayaran pembayaran) throws SQLException
    {
        String sql="INSERT INTO pembayaran VALUE(?,?,?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, pembayaran.getIdtrans());
        ps.setString(2, pembayaran.getIdnota());
        ps.setString(3, pembayaran.getKdpem());
        ps.setInt(4, pembayaran.getTotal());
        ps.executeUpdate();
    }
}
