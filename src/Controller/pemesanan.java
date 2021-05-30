/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Server.Koneksi;
import View.FormPemesanan;
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
public class pemesanan {
    View.FormPemesanan view;
    DAO.pemesanan database;
    Model.pemesanan model;
    Connection con;
    Koneksi server;
    
    public pemesanan(FormPemesanan view)
    {
        this.view = view;
        database=new DAO.pemesanan();
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
        model=new Model.pemesanan();
        model.setIdNota(view.getTxtIdNota().getText());
        model.setKdPlg(view.getCbxPelanggan().getSelectedItem().toString());
        model.setTotal(Integer.parseInt(view.getTxtTotal().getText()));
        
        try{
            database.create(model);
            javax.swing.JOptionPane.showMessageDialog(null, "Insert Berhasil");
        }
        catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Error"+ex.getMessage());
        }
    }
    public void update()
    {
        model=new Model.pemesanan();
        model.setIdNota(view.getTxtIdNota().getText());
        model.setKdPlg(view.getCbxPelanggan().getSelectedItem().toString());
        model.setTotal(Integer.parseInt(view.getTxtTotal().getText()));
        
        try{
            database.update(model);
            javax.swing.JOptionPane.showMessageDialog(view, "Update Berhasil");
        } catch (SQLException ex) {
            Logger.getLogger(pemesanan.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    public void delete()
    {
        String Id = view.getTxtIdNota().getText();
        try{
            database.delete(Id);
            JOptionPane.showMessageDialog(null, "Delete Success");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        this.clear();
    }
    public void getPemesanan()
    {
        String key=view.getTxtIdNota().getText();   
        try{
            model=database.getPemesanan(key);
            if(model!=null)
            {
                view.getTxtIdNota().setText(model.getIdNota());
                view.getCbxPelanggan().setSelectedItem(model.getKdPlg());
                view.getTxtTotal().setText(Integer.toString(model.getTotal()));
            }
            else
                JOptionPane.showMessageDialog(null, "Data Kosong");
        }
        catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,e);
        }
    }
    public void clear() 
    {
        view.getTxtIdNota().setText("");
        view.getTxtTotal().setText("");
        view.getCbxPelanggan().setSelectedItem("-----");
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
    public void PelangganTabel()
    {
        try{
            DefaultTableModel model = (DefaultTableModel)view.getTablePelanggan().getModel();
            model.setRowCount(0);
            ResultSet rs = server.getQuery(con,"SELECT * FROM pelanggan");
            while(rs.next())
            {
                Object data[]=
                {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(4),
                    rs.getString(3)
                };
                model.addRow(data);
            }
        }catch (SQLException ex) {
            Logger.getLogger(pelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void onMouseClickTablePemesanan()
    {
        DAO.pemesanan sql=new DAO.pemesanan();
        String id=view.getTablePemesanan().getValueAt(
                view.getTablePemesanan().getSelectedRow(),0).toString();
        String kode=view.getTablePemesanan().getValueAt(
                view.getTablePemesanan().getSelectedRow(),1).toString();
        int total=Integer.parseInt(view.getTablePemesanan().getValueAt(
                view.getTablePemesanan().getSelectedRow(),2).toString());
        
        try{
            Model.pemesanan model = sql.getPemesanan(id);
            view.getTxtIdNota().setText(model.getIdNota());
            view.getCbxPelanggan().setSelectedItem(model.getKdPlg());
            view.getTxtTotal().setText(Integer.toString(model.getTotal()));
        }catch (SQLException ex) {
            Logger.getLogger(pelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
}
