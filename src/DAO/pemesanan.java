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
    public void create(Model.pemesanan pemesanan) throws SQLException
    {
        String sql="INSERT INTO pemesanan VALUE(?,?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, pemesanan.getIdNota());
        ps.setString(2, pemesanan.getKdPlg());
        ps.setInt(3, pemesanan.getTotal());
        ps.executeUpdate();
    }
    public void update(Model.pemesanan pemesanan) throws SQLException
    {
        String sql="UPDATE pemesanan SET kdplg=?, subtotalmesan=? "
                + "WHERE idnota=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(3, pemesanan.getIdNota());
        ps.setString(1, pemesanan.getKdPlg());
        ps.setInt(2, pemesanan.getTotal());;
        ps.executeUpdate();
    }
    public void delete(String idnota) throws SQLException
    {
        String sql="DELETE FROM pemesanan WHERE idnota=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, idnota);
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
            pemesanan.setTotal(rs.getInt(3));
        }
        return pemesanan;
    }
}
