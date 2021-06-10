/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Server.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        String sql="INSERT INTO pembayaran VALUE(?,?,?,?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, pembayaran.getIdtrans());
        ps.setString(2, pembayaran.getIdnota());
        ps.setString(3, pembayaran.getKdpem());
        ps.setInt(4, pembayaran.getTotal());
        ps.setInt(5, pembayaran.getMasukkan());
        ps.executeUpdate();
    }
    public void update(Model.pembayaran bayar) throws SQLException {
        String sql = "update pembayaran set kdpem = ?, idnota = ?, total = ?, "
                + "masukkan = ? where idtrans = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, bayar.getKdpem());
        ps.setString(2, bayar.getIdnota());
        ps.setInt(3, bayar.getTotal());
        ps.setInt(4, bayar.getMasukkan());
        ps.setString(5, bayar.getIdtrans());
        ps.executeUpdate();
    }
    
    public void delete(String kode) throws SQLException {
        String sql = "delete from pembayaran where idtrans = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode);
        ps.executeUpdate();
    }
    
    public Model.pembayaran getBayar(String kodeCari) throws SQLException {
        String sql = "select *from pembayaran where idtrans= ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kodeCari);
        Model.pembayaran bayar = null;
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            bayar = new Model.pembayaran();
            bayar.setIdtrans(rs.getString(1));
            bayar.setKdpem(rs.getString(2));
            bayar.setIdnota(rs.getString(3));
            bayar.setTotal(rs.getInt(4));
            bayar.setMasukkan(rs.getInt(5));
        }
        return bayar;
    }
}
