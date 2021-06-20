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
public class pemesanan {
    Connection con;
    public pemesanan() {
        Koneksi server = new Koneksi();
        con=server.getConnection();
    }
    public void createPesan(Model.pemesanan pemesanan) throws SQLException
    {
        String sql="INSERT INTO pemesanan VALUE(?,?,?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, pemesanan.getIdNota());
        ps.setString(2, pemesanan.getKdPlg());
        ps.setString(3, pemesanan.getTglpesan());
        ps.setInt(4, pemesanan.getTotalPesan());
        ps.executeUpdate();
    }
    public void createPesanan(Model.pemesanan pesanan) throws SQLException {
        String sql = "insert into pesanan values (?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, pesanan.getIdNota());
        ps.setString(2, pesanan.getKdBrg());
        ps.setInt(3, pesanan.getJumlah());
        ps.setInt(4, pesanan.getTotalharga());
        ps.executeUpdate();
    }
    public void createBarang(Model.pemesanan barang) throws SQLException {
        String sql = "insert into barang values (?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, barang.getKdBrg());
        ps.setString(2, barang.getNamaBrg());
        ps.setInt(3, barang.getHargaBrg());
        ps.executeUpdate();
    }
    public void updatePesan(Model.pemesanan pemesanan) throws SQLException
    {
        String sql="UPDATE pemesanan SET kdplg=?, tglpesan=?, subtotalmesan=? "
                + "WHERE idnota=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(4, pemesanan.getIdNota());
        ps.setString(1, pemesanan.getKdPlg());
        ps.setString(2, pemesanan.getTglpesan());
        ps.setInt(3, pemesanan.getTotalPesan());;
        ps.executeUpdate();
    }
    public void updatePesanan(Model.pemesanan pesanan) throws SQLException {
        String sql = "update pesanan set jumlah = ?, totalharga = ? where idNota = ? && kdBrg = ? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, pesanan.getJumlah());
        ps.setInt(2, pesanan.getTotalharga());
        ps.setString(3, pesanan.getIdNota());
        ps.setString(4, pesanan.getKdBrg());
        ps.executeUpdate();
    }
    public void update(Model.pemesanan barang) throws SQLException {
        String sql = "update barang set nama = ?, harga = ? where kdBrg = ? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, barang.getNamaBrg());
        ps.setInt(2, barang.getHargaBrg());
        ps.setString(3, barang.getKdBrg());
        ps.executeUpdate();
    }
    public void deletePesan(String idnota) throws SQLException
    {
        String sql="DELETE FROM pemesanan WHERE idnota=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, idnota);
        ps.executeUpdate();
    }
    public void deletePesanan(String kodenota, String kodembrg) throws SQLException {
        String sql = "delete from pesanan where idNota = ? && kdBrg = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kodenota);
        ps.setString(2, kodembrg);
        ps.executeUpdate();
    }
    public void deleteBarang(String kode) throws SQLException {
        String sql = "delete from barang where KdBrg = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode);
        ps.executeUpdate();
    }
    public Model.pemesanan getPemesanan(String idnota) throws SQLException
    {
        String sql="SELECT * FROM pemesanan WHERE idnota=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, idnota);
        Model.pemesanan pemesanan=null;
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
            pemesanan = new Model.pemesanan();
            pemesanan.setIdNota(rs.getString(1));
            pemesanan.setKdPlg(rs.getString(2));
            pemesanan.setTglpesan(rs.getString(3));
            pemesanan.setTotalPesan(rs.getInt(4));
        }
        return pemesanan;
    }
     public Model.pemesanan getPesanan(String kodeCari, String kode) throws SQLException {
        String sql = "select *from pesanan where idNota = ? && kdBrg = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kodeCari);
        ps.setString(2, kode);
        Model.pemesanan pesanan = null;
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            pesanan = new Model.pemesanan();
            pesanan.setIdNota(rs.getString(1));
            pesanan.setKdBrg(rs.getString(2));
            pesanan.setJumlah(rs.getInt(3));
            pesanan.setTotalharga(rs.getInt(4));
        }
        return pesanan;
    }
     public Model.pemesanan getBarang(String kodeCari) throws SQLException {
        String sql = "select *from barang where kdBrg = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kodeCari);
        Model.pemesanan barang = null;
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            barang = new Model.pemesanan();
            barang.setKdBrg(rs.getString(1));
            barang.setNamaBrg(rs.getString(2));
            barang.setHargaBrg(rs.getInt(3));
        }
        return barang;
    }
}
