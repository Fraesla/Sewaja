/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Server.Koneksi;
import View.FormPemesanan;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    public void insertPemesanan()
    {
        model=new Model.pemesanan();
        model.setIdNota(view.getCbxPesanan().getSelectedItem().toString());
        model.setKdPlg(view.getCbxPelanggan().getSelectedItem().toString());
        model.setTotalPesan(Integer.valueOf(view.getTxtSubTotalPesan().getText()));
        
        try{
            database.createPesan(model);
            javax.swing.JOptionPane.showMessageDialog(null, "Insert Pemesanan Berhasil");
        }
        catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Error"+ex.getMessage());
        }
        this.clear();
    }
    
    public void insertPesanan(){
        model = new Model.pemesanan();
        model.setIdNota((String) view.getTxtIdNota().getText());
        model.setKdBrg((String) view.getCbKdMenu().getSelectedItem());
        model.setJumlah(Integer.parseInt(view.getTxtJumlah().getText()));
        model.setTotalharga(Integer.parseInt(view.getTxtSubTotal().getText()));
        try {
            database.createPesanan(model);
            JOptionPane.showMessageDialog(null, "Insert Pesanan Berhasil");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : "+ex);
        }
        this.clear();
    }
    
    public void insertBarang(){
        model = new Model.pemesanan();
        model.setKdBrg((String) view.getTxtIdNota().getText());
        model.setNamaBrg(view.getTxtJumlah().getText());
        model.setHargaBrg(Integer.parseInt(view.getTxtSubTotal().getText()));
        try {
            database.createBarang(model);
            JOptionPane.showMessageDialog(null, "Insert Barang Berhasil");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : "+ex);
        }
        this.clear();
    }
    
    public void updatePemesanan()
    {
        model=new Model.pemesanan();
        model.setIdNota(view.getCbxPesanan().getSelectedItem().toString());
        model.setKdPlg(view.getCbxPelanggan().getSelectedItem().toString());
        model.setTotalPesan(Integer.valueOf(view.getTxtSubTotalPesan().getText()));
        
        try{
            database.updatePesan(model);
            javax.swing.JOptionPane.showMessageDialog(view, "Update Pemesanan Berhasil");
        } catch (SQLException ex) {
            Logger.getLogger(pemesanan.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.clear();
    }
    
    public void updatePesanan(){
        model = new Model.pemesanan();
        model.setIdNota((String) view.getTxtIdNota().getText());
        model.setKdBrg((String) view.getCbKdMenu().getSelectedItem());
        model.setJumlah(Integer.parseInt(view.getTxtJumlah().getText()));
        model.setTotalharga(Integer.parseInt(view.getTxtSubTotal().getText()));
        try {
            database.updatePesanan(model);
            JOptionPane.showMessageDialog(null, "Update OK");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error : "+ex);
        }
        this.clear();
    }
    
    public void updateBarang(){
        model = new Model.pemesanan();
        model.setKdBrg((String) view.getTxtIdNota().getText());
        model.setNamaBrg(view.getTxtJumlah().getText());
        model.setHargaBrg(Integer.parseInt(view.getTxtSubTotal().getText()));
        try {
            database.update(model);
            JOptionPane.showMessageDialog(null, "Update OK");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : "+ex);
        }
        this.clear();
    }
    
    public void deletePemesanan()
    {
        String Id = view.getCbxPesanan().getSelectedItem().toString();
        try{
            database.deletePesan(Id);
            JOptionPane.showMessageDialog(null, "Delete Success");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        this.clear();
    }
    
    public void deletePesanan(){
        String Id = view.getTxtIdNota().getText();
        String kode = view.getCbKdMenu().getSelectedItem().toString();
        try {
            database.deletePesanan(Id, kode);
            JOptionPane.showMessageDialog(null, "Delete OK");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error");
        }
        this.clear();
    }
    
    public void deleteBarang(){
        String kode = view.getTxtIdNota().getText();
        try {
            database.deleteBarang(kode);
            JOptionPane.showMessageDialog(null, "Delete OK");
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : "+ex);
        }
        this.clear();
    }
    
    public void getPemesanan()
    {
        String key=view.getCbxPesanan().getSelectedItem().toString();   
        try{
            model=database.getPemesanan(key);
            if(model!=null)
            {
                view.getCbxPelanggan().setSelectedItem(model.getKdPlg());
                view.getTxtSubTotalPesan().setText(Integer.toString(model.getTotalPesan()));
            }
            else
                JOptionPane.showMessageDialog(null, "Data Kosong");
        }
        catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public void getPesanan(){
        String kodeCari=(String) view.getTxtIdNota().getText();
        String kode=(String) view.getCbKdMenu().getSelectedItem();
        try{
            model = new Model.pemesanan();
            model = database.getPesanan(kodeCari, kode);
            
            if(model != null){
                view.getTxtIdNota().setText(model.getIdNota());
                view.getCbKdMenu().setSelectedItem(model.getKdBrg());
                view.getTxtJumlah().setText(String.valueOf(model.getJumlah()));
                view.getTxtSubTotal().setText(String.valueOf(model.getTotalharga()));
            }
            else{
                JOptionPane.showMessageDialog(view, "Data Tidak ditemukan");
            }
        }
        catch(SQLException | HeadlessException e){
        }
    }
    
    public void getBarang(){
        String kodeCari=(String) view.getTxtIdNota().getText();
        try{
            model = new Model.pemesanan();
            model = database.getBarang(kodeCari);
            
            if(model != null){
                view.getTxtIdNota().setText(model.getKdBrg());
                view.getTxtJumlah().setText(model.getNamaBrg());
                view.getTxtSubTotal().setText(String.valueOf(model.getHargaBrg()));
            }
            else{
                JOptionPane.showMessageDialog(view, "Data Tidak ditemukan");
            }
        }
        catch(SQLException | HeadlessException e){
        }
    }
    
    public void clear() 
    {
        view.getTxtIdNota().setText("");
        view.getCbxPesanan().setSelectedItem(0);
        view.getCbKdMenu().setSelectedItem(0);
        view.getCbxPelanggan().setSelectedItem(0);
        view.getTxtJumlah().setText("");
        view.getTxtSubTotal().setText("");
    }
   
    public void onMouseClickTablePemesanan()throws SQLException
    {
        String kode = view.getTableMenuPesan().getValueAt(view.getTableMenuPesan().getSelectedRow(), 0).toString();
        try{
            model = new Model.pemesanan();
            model = database.getPemesanan(kode);
            view.getCbxPesanan().setSelectedItem(model.getIdNota());
            view.getCbxPelanggan().setSelectedItem(model.getKdPlg());
            view.getTxtSubTotalPesan().setText(String.valueOf(model.getTotalPesan()));
        }catch(SQLException e){
            Logger.getLogger(Controller.pemesanan.class.getName()).log(Level.SEVERE, "Eror");
        }  
    }
    
    public void onMouseClickTablePesanan() throws SQLException{
        String id = view.getTablePesanan().getValueAt(
                view.getTablePesanan().getSelectedRow(), 0).toString();
        String kd = view.getTablePesanan().getValueAt(
                view.getTablePesanan().getSelectedRow(), 1).toString();
        try{
            model = new Model.pemesanan();
            model = database.getPesanan(id, kd);
            view.getTxtIdNota().setText(model.getIdNota());
            view.getCbKdMenu().setSelectedItem(model.getKdBrg());
            view.getTxtJumlah().setText(String.valueOf(model.getJumlah()));
            view.getTxtSubTotal().setText(String.valueOf(model.getTotalharga()));
        }catch(SQLException e){
            Logger.getLogger(Controller.pemesanan.class.getName()).log(Level.SEVERE, "Eror");
        }
    }
    
    public void onMouseClickTableBarang() throws SQLException{
        String kode = view.getTableMenuPesan().getValueAt(view.getTableMenuPesan().getSelectedRow(), 0).toString();
        try{
            model = new Model.pemesanan();
            model = database.getBarang(kode);
            view.getTxtIdNota().setText(model.getKdBrg());
            view.getTxtJumlah().setText(model.getNamaBrg());
            view.getTxtSubTotal().setText(String.valueOf(model.getHargaBrg()));
        }catch(SQLException e){
            Logger.getLogger(Controller.pemesanan.class.getName()).log(Level.SEVERE, "Eror");
        }
    }
    
     public void ReportBulanPesan(String bulan, String tahun){
        try {
            HashMap parameter = new HashMap();
            parameter.put("pbulan", bulan);
            parameter.put("ptahun", tahun);
            JasperPrint jasperPrint = null;
            jasperPrint = JasperFillManager.fillReport("src/Report/Pesan/PerBulanPesan.jasper", parameter, con);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(Controller.pemesanan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ReportTahunPesan(String tahun){
        try {
            HashMap parameter = new HashMap();
            parameter.put("ptahun", tahun);
            JasperPrint jasperPrint = null;
            jasperPrint = JasperFillManager.fillReport("src/Report/Pesan/PerTahunPesan.jasper", parameter, con);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(Controller.pemesanan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
