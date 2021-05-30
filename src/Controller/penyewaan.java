/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Server.Koneksi;
import View.FormPenyewaan;
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
public class penyewaan {
    View.FormPenyewaan view;
    DAO.penyewaan database;
    Model.penyewaan model;
    Connection con;
    Koneksi server;
    
    public penyewaan(FormPenyewaan view)
    {
        this.view = view;
        database=new DAO.penyewaan();
        server=new Koneksi();
        try{
            con=server.getConnection();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }
    public void insertPenyewaan()
    {
        model=new Model.penyewaan();
        model.setKdpem(view.getTxtKode().getText());
        model.setKdplg(view.getCbxPelanggan().getSelectedItem().toString());
        model.setKdlpg(view.getCbxLapangan().getSelectedItem().toString());
        model.setTgl(view.getTxtTglNama().getText());
        model.setHarga(Integer.parseInt(view.getIntHarga().getText()));
        model.setJamakhir(Integer.parseInt(view.getIntJahir().getText()));
        model.setJamawal(Integer.parseInt(view.getIntJawal().getText()));
        model.setTotal(Integer.parseInt(view.getIntTotal().getText()));
        model.setUangmuka(Integer.parseInt(view.getIntUang().getText()));
        try{
            database.createPenyewaan(model);
            javax.swing.JOptionPane.showMessageDialog(null, "Insert Penyewaan Berhasil");
        }
        catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Error"+ex.getMessage());
        }
    }
    public void insertLapangan()
    {
        model=new Model.penyewaan();
        model.setKdlpg(view.getTxtKode().getText());
        model.setNama(view.getTxtTglNama().getText());
        model.setHarga(Integer.parseInt(view.getIntHarga().getText()));
        try{
            database.createLapangan(model);
            javax.swing.JOptionPane.showMessageDialog(null, "Insert Lapangan Berhasil");
        }
        catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Error"+ex.getMessage());
        }
    }
    public void updatePenyewaan()
    {
        model=new Model.penyewaan();
        model.setKdpem(view.getTxtKode().getText());
        model.setKdplg(view.getCbxPelanggan().getSelectedItem().toString());
        model.setKdlpg(view.getCbxLapangan().getSelectedItem().toString());
        model.setTgl(view.getTxtTglNama().getText());
        model.setHarga(Integer.parseInt(view.getIntHarga().getText()));
        model.setJamakhir(Integer.parseInt(view.getIntJahir().getText()));
        model.setJamawal(Integer.parseInt(view.getIntJawal().getText()));
        model.setTotal(Integer.parseInt(view.getIntTotal().getText()));
        model.setUangmuka(Integer.parseInt(view.getIntUang().getText()));
        
        try{
            database.updatePenyewaan(model);
            javax.swing.JOptionPane.showMessageDialog(view, "Update Penyewaan Berhasil");
        } catch (SQLException ex) {
            Logger.getLogger(penyewaan.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    public void updateLapangan()
    {
        model=new Model.penyewaan();
        model.setKdlpg(view.getTxtKode().getText());
        model.setNama(view.getTxtTglNama().getText());
        model.setHarga(Integer.parseInt(view.getIntHarga().getText()));
        try{
            database.updateLapangan(model);
            javax.swing.JOptionPane.showMessageDialog(view, "Update Lapangan Berhasil");
        } catch (SQLException ex) {
            Logger.getLogger(penyewaan.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    public void deletePenyewaan()
    {
        String kode = view.getTxtKode().getText();
        try{
            database.deletePenyewaan(kode);
            JOptionPane.showMessageDialog(null, "Delete Penyewaan Success");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        this.clear();
    }
    public void deleteLapangan()
    {
        String kode = view.getTxtKode().getText();
        try{
            database.deleteLapangan(kode);
            JOptionPane.showMessageDialog(null, "Delete Lapangan Success");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        this.clear();
    }
    public void getPenyewaan()
    {
        String key=view.getTxtKode().getText();   
        try{
            model=database.getPenyewaan(key);
            if(model!=null)
            {
                model.setKdpem(view.getTxtKode().getText());
                model.setKdplg(view.getCbxPelanggan().getSelectedItem().toString());
                model.setKdlpg(view.getCbxLapangan().getSelectedItem().toString());
                model.setTgl(view.getTxtTglNama().getText());
                model.setHarga(Integer.parseInt(view.getIntHarga().getText()));
                model.setJamakhir(Integer.parseInt(view.getIntJahir().getText()));
                model.setJamawal(Integer.parseInt(view.getIntJawal().getText()));
                model.setTotal(Integer.parseInt(view.getIntTotal().getText()));
                model.setUangmuka(Integer.parseInt(view.getIntUang().getText()));
            }
            else
                JOptionPane.showMessageDialog(null, "Data Kosong");
        }
        catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,e);
        }
    }
    public void getLapangan()
    {
        String key=view.getTxtKode().getText();   
        try{
            model=database.getPenyewaan(key);
            if(model!=null)
            {
                model.setKdlpg(view.getTxtKode().getText());
                model.setNama(view.getTxtTglNama().getText());
                model.setHarga(Integer.parseInt(view.getIntHarga().getText()));
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
        view.getTxtKode().setText("");
        view.getTxtTglNama().setText("");
        view.getCbxPelanggan().setSelectedItem("-----");
        view.getCbxLapangan().setSelectedItem("-----");
        view.getIntHarga().setText("");
        view.getIntJahir().setText("");
        view.getIntJawal().setText("");
        view.getIntTotal().setText("");
        view.getIntUang().setText("");
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
    public void LapanganTabel()
    {
        try{
            DefaultTableModel model = (DefaultTableModel)view.getTableLapangan().getModel();
            model.setRowCount(0);
            ResultSet rs = server.getQuery(con,"SELECT * FROM lapangan");
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
            Logger.getLogger(Controller.penyewaan.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Controller.penyewaan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void onMouseClickTablePenyewaan()
    {
        DAO.penyewaan sql=new DAO.penyewaan();
        String kodepem=view.getTablePenyewaan().getValueAt(
                view.getTablePenyewaan().getSelectedRow(),0).toString();
        String kodeplg=view.getTablePenyewaan().getValueAt(
                view.getTablePenyewaan().getSelectedRow(),1).toString();
        String kodelpg=view.getTablePenyewaan().getValueAt(
                view.getTablePenyewaan().getSelectedRow(),2).toString();
        String tgl=view.getTablePenyewaan().getValueAt(
                view.getTablePenyewaan().getSelectedRow(),3).toString();
        int harga=Integer.parseInt(view.getTablePenyewaan().getValueAt(
                view.getTablePenyewaan().getSelectedRow(),4).toString());
        int jahar=Integer.parseInt(view.getTablePenyewaan().getValueAt(
                view.getTablePenyewaan().getSelectedRow(),5).toString());
        int jawal=Integer.parseInt(view.getTablePenyewaan().getValueAt(
                view.getTablePenyewaan().getSelectedRow(),6).toString());
        int total=Integer.parseInt(view.getTablePenyewaan().getValueAt(
                view.getTablePenyewaan().getSelectedRow(),7).toString());
        int uang=Integer.parseInt(view.getTablePenyewaan().getValueAt(
                view.getTablePenyewaan().getSelectedRow(),8).toString());
        
        try{
            Model.penyewaan model = sql.getPenyewaan(kodepem);
            view.getTxtKode().setText(model.getKdpem());
            view.getCbxPelanggan().setSelectedItem(model.getKdplg());
            view.getCbxLapangan().setSelectedItem(model.getKdlpg());
            view.getTxtTglNama().setText(model.getTgl());
            view.getIntHarga().setText(Integer.toString(model.getHarga()));
            view.getIntJahir().setText(Integer.toString(model.getJamakhir()));
            view.getIntJawal().setText(Integer.toString(model.getJamawal()));
            view.getIntTotal().setText(Integer.toString(model.getTotal()));
            view.getIntUang().setText(Integer.toString(model.getUangmuka()));
        }catch (SQLException ex) {
            Logger.getLogger(penyewaan.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    public void onMouseClickTableLapangan()
    {
        DAO.penyewaan sql=new DAO.penyewaan();
        String kodelpg=view.getTableLapangan().getValueAt(
                view.getTableLapangan().getSelectedRow(),0).toString();
        String nama=view.getTableLapangan().getValueAt(
                view.getTableLapangan().getSelectedRow(),1).toString();
        int harga=Integer.parseInt(view.getTableLapangan().getValueAt(
                view.getTableLapangan().getSelectedRow(),2).toString());
        
        try{
            Model.penyewaan model = sql.getLapangan(kodelpg);
            view.getTxtKode().setText(model.getKdlpg());
            view.getTxtTglNama().setText(model.getNama());
            view.getIntHarga().setText(Integer.toString(model.getHarga()));
        }catch (SQLException ex) {
            Logger.getLogger(penyewaan.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
}
