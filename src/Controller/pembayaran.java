/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Server.Koneksi;
import View.FormPembayaran;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

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
    
    private int uang() throws SQLException{
        int uang = 0;
        String sql = "Select *from pembayaran";
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
            
        if(rs.last()){
            uang = rs.getInt(5);
        }        
        return uang;
    }
    
    public void insert() throws SQLException
    {
        model=new Model.pembayaran();
        model.setIdtrans(view.getTxtIdTrans().getText());
        model.setIdnota(view.getCbxPemesanan().getSelectedItem().toString());
        model.setKdpem(view.getCbxPenyewaan().getSelectedItem().toString());
        model.setTotal(Integer.valueOf(view.getIntTotal().getText()));
        model.setMasukkan(uang()+Integer.valueOf(view.getIntTotal().getText()));
        
        try{
            database.create(model);
            javax.swing.JOptionPane.showMessageDialog(null, "Insert Berhasil");
        }
        catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Error"+ex.getMessage());
        }
    }
    
    public void update() throws SQLException{
        model=new Model.pembayaran();
        model.setIdtrans(view.getTxtIdTrans().getText());
        model.setIdnota(view.getCbxPemesanan().getSelectedItem().toString());
        model.setKdpem(view.getCbxPenyewaan().getSelectedItem().toString());
        model.setTotal(Integer.valueOf(view.getIntTotal().getText()));
        model.setMasukkan(uang()+Integer.valueOf(view.getIntTotal().getText()));
        try {
            database.update(model);
            JOptionPane.showMessageDialog(null, "Entry OK");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error");
        }
        this.clear();
    }
    
    public void delete(){
        String Id = view.getTxtIdTrans().getText();
        try {
            database.delete(Id);
            JOptionPane.showMessageDialog(null, "Delete OK");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error");
        }
        this.clear();
    }
    
    public void clear() 
    {
        view.getTxtIdTrans().setText("");
        view.getCbxPemesanan().setSelectedIndex(0);
        view.getCbxPenyewaan().setSelectedIndex(0);
        view.getIntTotal().setText("");
        view.getTxtSubTotalPesan().setText("");
        view.getTxtSubTotalSewa().setText("");
    }
    
    public void getBayar(){
        String kodeCari=(String) view.getTxtIdTrans().getText();
        try{
            model = new Model.pembayaran();
            model = database.getBayar(kodeCari);
            
            if(model != null){
                view.getCbxPemesanan().setSelectedItem(model.getIdnota());
                view.getCbxPenyewaan().setSelectedItem(model.getKdpem());
                view.getIntTotal().setText(String.valueOf(model.getTotal()));
            }
            else{
                JOptionPane.showMessageDialog(view, "Data Tidak ditemukan");
            }
        }
        catch(SQLException | HeadlessException e){
        }
    }
    
    public void onMouseClickTableBayar() throws SQLException{
        String kode = view.getTableBayar().getValueAt(view.getTableBayar().getSelectedRow(), 0).toString();
        try{
            model = new Model.pembayaran();
            model = database.getBayar(kode);
            view.getTxtIdTrans().setText(model.getIdtrans());
            view.getCbxPemesanan().setSelectedItem(model.getIdnota());
            view.getCbxPenyewaan().setSelectedItem(model.getKdpem());
            view.getIntTotal().setText(String.valueOf(model.getTotal()));
        }catch(SQLException e){
            Logger.getLogger(pembayaran.class.getName()).log(Level.SEVERE, "Eror");
        }
    }
    
    public void previewReportBulanBayar(String bulan, String tahun){
        try {
            HashMap parameter = new HashMap();
            parameter.put("pbulan", bulan);
            parameter.put("ptahun", tahun);
            JasperPrint jasperPrint = null;
            jasperPrint = JasperFillManager.fillReport("src/Report/Bayar/PerBulanBayar.jasper", parameter, con);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(pembayaran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void previewReportTahunBayar(String tahun){
        try {
            HashMap parameter = new HashMap();
            parameter.put("ptahun", tahun);
            JasperPrint jasperPrint = null;
            jasperPrint = JasperFillManager.fillReport("src/Report/Bayar/PerTahunBayar.jasper", parameter, con);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(pembayaran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
