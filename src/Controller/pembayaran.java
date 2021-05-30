/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Server.Koneksi;
import View.FormPembayaran;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fraesla
 */
public class pembayaran {
    View.FormPembayaran view;
    DAO.pembayaran database;
    Model.pembayaran model;
    Connection con;
    Koneksi server;
    public pembayaran(FormPembayaran view)
    {
        this.view = view;
        database=new DAO.pembayaran();
        server=new Koneksi();
        try{
            con=server.getConnection();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }
    public void insert()
    {
        model=new Model.pembayaran();
        model.setIdtrans(view.getTxtIdtran().getText());
        model.setIdnota(view.getCbxPemesanan().getSelectedItem().toString());
        model.setKdpem(view.getCbxPenyewaan().getSelectedItem().toString());
        model.setTotal(Integer.parseInt(view.getIntTotal().getText()));
        
        try{
            database.create(model);
            javax.swing.JOptionPane.showMessageDialog(null, "Insert Berhasil");
        }
        catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Error"+ex.getMessage());
        }
    }
    public void clear() 
    {
        view.getTxtIdtran().setText("");
        view.getIntTotal().setText("");
        view.getCbxPemesanan().setSelectedItem("-----");
        view.getCbxPenyewaan().setSelectedItem("-----");
    }
    public void PembayaranTabel()
    {
        try{
            DefaultTableModel model = (DefaultTableModel)view.getTablePembayaran().getModel();
            model.setRowCount(0);
            ResultSet rs = server.getQuery(con,"SELECT * FROM pembayaran");
            while(rs.next())
            {
                Object data[]=
                {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4)
                };
                model.addRow(data);
            }
        }catch (SQLException ex) {
            Logger.getLogger(pembayaran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void PemesananTabel()
    {
        try{
            DefaultTableModel model = (DefaultTableModel)view.getTablePemesanan().getModel();
            model.setRowCount(0);
            ResultSet rs = server.getQuery(con,"SELECT * FROM pemesanan");
            while(rs.next())
            {
                Object data[]=
                {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getInt(3)
                };
                model.addRow(data);
            }
        }catch (SQLException ex) {
            Logger.getLogger(pemesanan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void PenyewaanTabel()
    {
        try{
            DefaultTableModel model = (DefaultTableModel)view.getTablePenyewaan().getModel();
            model.setRowCount(0);
            ResultSet rs = server.getQuery(con,"SELECT * FROM penyewaan");
            while(rs.next())
            {
                Object data[]=
                {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getInt(5),
                    rs.getInt(6),
                    rs.getInt(7),
                    rs.getInt(8),
                    rs.getInt(9)
                };
                model.addRow(data);
            }
        }catch (SQLException ex) {
            Logger.getLogger(Controller.penyewaan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
