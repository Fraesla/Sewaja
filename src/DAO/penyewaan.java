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
public class penyewaan {
    
    Connection con;
    
    public penyewaan(){
        Koneksi k = new Koneksi();
        con = k.getConnection();
    }
    public Model.penyewaan getSewa(String kodeCari) throws SQLException {
        String sql = "select *from penyewaan where kdpem = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kodeCari);
        Model.penyewaan sewa = null;
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            sewa = new Model.penyewaan();
            sewa.setKdpem(rs.getString(1));
            sewa.setKdplg(rs.getString(2));
            sewa.setKdlpg(rs.getString(3));
            sewa.setTglmain(rs.getString(4));
            sewa.setBayasewa(rs.getInt(5));
            sewa.setJamakhir(rs.getString(6));
            sewa.setJamawal(rs.getString(7));
            sewa.setUangmuka(rs.getInt(9));
        }
        return sewa;
    }
    
    public void insert(Model.penyewaan sewa) throws SQLException {
        String sql = "insert into penyewaan values (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, sewa.getKdpem());
        ps.setString(2, sewa.getKdplg());
        ps.setString(3, sewa.getKdlpg());
        ps.setString(4, sewa.getTglmain());
        ps.setInt(5, sewa.getBayasewa());
        ps.setString(6, sewa.getJamakhir());
        ps.setString(7, sewa.getJamawal());
        ps.setInt(8, sewa.getTotalsewa());
        ps.setInt(9, sewa.getUangmuka());
        ps.setInt(10, sewa.getPemasukkan());
        ps.executeUpdate();
    }
    
    public void update(Model.penyewaan sewa) throws SQLException {
        String sql = "update penyewaan set kdplg= ?, kdlpg = ?, tglmain = ?,"
                + " bayarsewa = ?, jamakhir = ?, jamawal = ?, totalsewa = ?,"
                + " uangmuka = ?, pemasukan = ? where kdpem = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, sewa.getKdplg());
        ps.setString(2, sewa.getKdlpg());
        ps.setString(3, sewa.getTglmain());
        ps.setInt(4, sewa.getBayasewa());
        ps.setString(5, sewa.getJamakhir());
        ps.setString(6, sewa.getJamawal());
        ps.setInt(7, sewa.getTotalsewa());
        ps.setInt(8, sewa.getUangmuka());
        ps.setInt(9, sewa.getPemasukkan());
        ps.setString(10, sewa.getKdpem());
        ps.executeUpdate();
    }
    
    public void delete(String kode) throws SQLException {
        String sql = "delete from penyewaan where kdpem = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode);
        ps.executeUpdate();
    }
}
