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
    public penyewaan() {
        Koneksi server = new Koneksi();
        con=server.getConnection();
    }
    public void createPenyewaan(Model.penyewaan penyewaan) throws SQLException
    {
        String sql="INSERT INTO penyewaan VALUE(?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, penyewaan.getKdpem());
        ps.setString(2, penyewaan.getKdplg());
        ps.setString(3, penyewaan.getKdlpg());
        ps.setString(4, penyewaan.getTgl());
        ps.setInt(5, penyewaan.getHarga());
        ps.setInt(6, penyewaan.getJamakhir());
        ps.setInt(7, penyewaan.getJamawal());
        ps.setInt(8, penyewaan.getTotal());
        ps.setInt(9, penyewaan.getUangmuka());
        ps.executeUpdate();
    }
    public void createLapangan(Model.penyewaan lapangan) throws SQLException
    {
        String sql="INSERT INTO lapangan VALUE(?,?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, lapangan.getKdlpg());
        ps.setString(2, lapangan.getNama());
        ps.setInt(3, lapangan.getHarga());
       
        ps.executeUpdate();
    }
    public void updatePenyewaan(Model.penyewaan penyewaan) throws SQLException
    {
        String sql="UPDATE penyewaan SET kdplg=?, kdlpg=?, tglmain=?, bayarsewa=?, "
                + "jamakhir=?, jamawal=?, totalsewa=?, uangmuka=? "
                + "WHERE kdpem=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(9, penyewaan.getKdpem());
        ps.setString(1, penyewaan.getKdplg());
        ps.setString(2, penyewaan.getKdlpg());
        ps.setString(3, penyewaan.getTgl());
        ps.setInt(4, penyewaan.getHarga());
        ps.setInt(5, penyewaan.getJamakhir());
        ps.setInt(6, penyewaan.getJamawal());
        ps.setInt(7, penyewaan.getTotal());
        ps.setInt(8, penyewaan.getUangmuka());
        ps.executeUpdate();
    }
    public void updateLapangan(Model.penyewaan lapangan) throws SQLException
    {
        String sql="UPDATE lapangan SET namalpg=?, harga=? "
                + "WHERE kdlpg=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(3, lapangan.getKdlpg());
        ps.setString(1, lapangan.getNama());
        ps.setInt(2, lapangan.getHarga());
        ps.executeUpdate();
    }
    public void deletePenyewaan(String kode) throws SQLException
    {
        String sql="DELETE FROM penyewaan WHERE kdpem=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, kode);
        ps.executeUpdate();
    }
    public void deleteLapangan(String kode) throws SQLException
    {
        String sql="DELETE FROM lapangan WHERE kdlpg=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, kode);
        ps.executeUpdate();
    }
    public Model.penyewaan getPenyewaan(String kode) throws SQLException
    {
        String sql="SELECT * FROM penyewaan WHERE kdpem=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, kode);
        Model.penyewaan penyewaan=null;
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
            penyewaan = new Model.penyewaan();
            penyewaan.setKdpem(rs.getString(1));
            penyewaan.setKdplg(rs.getString(2));
            penyewaan.setKdlpg(rs.getString(3));
            penyewaan.setTgl(rs.getString(4));
            penyewaan.setHarga(rs.getInt(5));
            penyewaan.setJamakhir(rs.getInt(6));
            penyewaan.setJamawal(rs.getInt(7));
            penyewaan.setTotal(rs.getInt(8));
            penyewaan.setUangmuka(rs.getInt(9));
        }
        return penyewaan;
    }
    public Model.penyewaan getLapangan(String kode) throws SQLException
    {
        String sql="SELECT * FROM lapangan WHERE kdlpg=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, kode);
        Model.penyewaan penyewaan=null;
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
            penyewaan = new Model.penyewaan();
            penyewaan.setKdlpg(rs.getString(1));
            penyewaan.setNama(rs.getString(2));
            penyewaan.setHarga(rs.getInt(3));
        }
        return penyewaan;
    }
}
