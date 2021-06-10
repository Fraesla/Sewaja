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
public class pelanggan {
    Connection con;
    public pelanggan() {
        Koneksi server = new Koneksi();
        con=server.getConnection();
    }
    public void createPelanggan(Model.pelanggan pelanggan) throws SQLException
    {
        String sql="INSERT INTO pelanggan VALUE(?,?,?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, pelanggan.getKdPlg());
        ps.setString(2, pelanggan.getNama());
        ps.setString(3, pelanggan.getTelp());
        ps.setString(4, pelanggan.getIdMem());
        ps.executeUpdate();
    }
    public void createMember(Model.pelanggan pelanggan) throws SQLException
    {
        String sql="INSERT INTO member VALUE(?,?,?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, pelanggan.getIdMem());
        ps.setString(2, pelanggan.getNama());
        ps.setString(3, pelanggan.getTelp());
        ps.setString(4, pelanggan.getAlm());
        ps.executeUpdate();
    }
    public void updatePelanggan(Model.pelanggan pelanggan) throws SQLException
    {
        String sql="UPDATE pelanggan SET namaplg=?, telp=?, idMem=? "
                + "WHERE kodeplg=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(4, pelanggan.getKdPlg());
        ps.setString(1, pelanggan.getNama());
        ps.setString(2, pelanggan.getTelp());
        ps.setString(3, pelanggan.getIdMem());
        ps.executeUpdate();
    }
    public void updateMember(Model.pelanggan pelanggan) throws SQLException
    {
        String sql="UPDATE member SET namaMem=?, telp=?, alm=? "
                + "WHERE idMem=?";
        PreparedStatement ps=con.prepareStatement(sql);
       ps.setString(4, pelanggan.getIdMem());
        ps.setString(1, pelanggan.getNama());
        ps.setString(2, pelanggan.getTelp());
        ps.setString(3, pelanggan.getAlm());
        ps.executeUpdate();
    }
    public void deletePelanggan(String kodeplg) throws SQLException
    {
        String sql="DELETE FROM pelanggan WHERE kodeplg=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, kodeplg);
        ps.executeUpdate();
    }
    public void deleteMember(String idMem) throws SQLException
    {
        String sql="DELETE FROM member WHERE idMem=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, idMem);
        ps.executeUpdate();
    }
    public Model.pelanggan getPelanggan(String kodeplg) throws SQLException
    {
        String sql="SELECT * FROM pelanggan WHERE kodeplg=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, kodeplg);
        Model.pelanggan pelanggan=null;
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
            pelanggan = new Model.pelanggan();
            pelanggan.setKdPlg(rs.getString(1));
            pelanggan.setNama(rs.getString(2));
            pelanggan.setTelp(rs.getString(3));
            pelanggan.setIdMem(rs.getString(4));
        }
        return pelanggan;
    }
    public Model.pelanggan getMember(String idMem) throws SQLException
    {
        String sql="SELECT * FROM member WHERE idMem=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, idMem);
        Model.pelanggan member=null;
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
            member = new Model.pelanggan();
            member.setIdMem(rs.getString(1));
            member.setNama(rs.getString(2));
            member.setTelp(rs.getString(3));
            member.setAlm(rs.getString(4));
        }
        return member;
    }
}
