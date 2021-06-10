/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Server.Koneksi;
import View.FormPenyewaan;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
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
public class penyewaan {
    FormPenyewaan view;
    Model.penyewaan model;
    DAO.penyewaan data;
    Connection con;
    Koneksi k;
    
    public penyewaan(FormPenyewaan view){
        this.view = view;
        data = new DAO.penyewaan();
        k = new Koneksi();
        con = k.getConnection();
    }
    
    private int uang() throws SQLException{
        int uang = 0;
        String sql = "Select *from penyewaan";
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
            
        if(rs.last()){
            uang = rs.getInt(10);
        }        
        return uang;
    }
    
    public void insert() throws SQLException{
        model = new Model.penyewaan();
        model.setKdpem(view.getTxtKdPemakaian().getText());
        model.setKdlpg((String) view.getCbxLapangan().getSelectedItem());
        model.setKdplg((String) view.getCbxPelanggan().getSelectedItem());
        model.setTglmain(String.valueOf(view.getTahun().getValue()+"-"+view.getBulan().getValue()+"-"+view.getHari().getValue()));
        model.setBayasewa(Integer.valueOf(view.getTxtSewa().getText()));
        model.setJamakhir(view.getJamakhir().getText()+":"+view.getMenitakhir().getText());
        model.setJamawal(view.getJamawal().getText()+":"+view.getMenitawal().getText());
        model.setTotalsewa(Integer.valueOf(view.getTxtSewa().getText())+Integer.valueOf(view.getTxtUangMuka().getText()));
        model.setUangmuka(Integer.valueOf(view.getTxtUangMuka().getText()));
        model.setPemasukkan(uang()+Integer.valueOf(view.getTxtSewa().getText())+Integer.valueOf(view.getTxtUangMuka().getText()));
        try {
            data.insert(model);
            JOptionPane.showMessageDialog(null, "Entry OK");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error : "+ex);
        }
        this.clear();
    }
    
    public void update() throws SQLException{
        model = new Model.penyewaan();
        model.setKdpem(view.getTxtKdPemakaian().getText());
        model.setKdlpg((String) view.getCbxLapangan().getSelectedItem());
        model.setKdplg((String) view.getCbxPelanggan().getSelectedItem());
        model.setTglmain(String.valueOf(view.getTahun().getValue()+"-"+view.getBulan().getValue()+"-"+view.getHari().getValue()));
        model.setBayasewa(Integer.valueOf(view.getTxtSewa().getText()));
        model.setJamakhir(view.getJamakhir().getText()+":"+view.getMenitakhir().getText());
        model.setJamawal(view.getJamawal().getText()+":"+view.getMenitawal().getText());
        model.setTotalsewa(Integer.valueOf(view.getTxtSewa().getText())+Integer.valueOf(view.getTxtUangMuka().getText()));
        model.setUangmuka(Integer.valueOf(view.getTxtUangMuka().getText()));
        model.setPemasukkan(uang()+Integer.valueOf(view.getTxtSewa().getText())+Integer.valueOf(view.getTxtUangMuka().getText()));
        try {
            data.update(model);
            JOptionPane.showMessageDialog(null, "Entry OK");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : "+ex);
        }
        this.clear();
    }
    
    public void delete(){
        String Id = view.getTxtKdPemakaian().getText();
        try {
            data.delete(Id);
            JOptionPane.showMessageDialog(null, "Delete OK");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error");
        }
        this.clear();
    }
    
    public void clear(){
        view.getTxtKdPemakaian().setText("");
        view.getCbxLapangan().setSelectedIndex(0);
        view.getCbxPelanggan().setSelectedIndex(0);
        view.getTanggal().setDateFormatString("");
        view.getTxtUangMuka().setText("");
        view.getTxtSewa().setText("");
        view.getJamawal().setText("");
        view.getJamakhir().setText("");
        view.getMenitawal().setText("");
        view.getMenitakhir().setText("");
    }
    
    public void getSewa(){
        String kodeCari=view.getTxtKdPemakaian().getText();
        try{
            model = new Model.penyewaan();
            model = data.getSewa(kodeCari);
            
            if(model != null){
                view.getCbxLapangan().setSelectedItem(model.getKdlpg());
                view.getCbxPelanggan().setSelectedItem(model.getKdplg());
                view.getTanggal().setDate(Date.valueOf(model.getTglmain()));
                view.getWaktuAwal().setText(model.getJamawal());
                view.getWaktuAkhir().setText(model.getJamakhir());
                view.getTxtUangMuka().setText(String.valueOf(model.getUangmuka()));
                view.getTxtSewa().setText(String.valueOf(model.getBayasewa()));
            }
            else{
                JOptionPane.showMessageDialog(view, "Data Tidak ditemukan");
            }
        }
        catch(SQLException | HeadlessException e){
        }
    }
    
    public void onMouseClickTablePenyewaan() throws SQLException{
        String kode = view.getTableSewa().getValueAt(view.getTableSewa().getSelectedRow(), 0).toString();
        try{
            model = new Model.penyewaan();
            model = data.getSewa(kode);
            view.getTxtKdPemakaian().setText(model.getKdpem());
            view.getCbxLapangan().setSelectedItem(model.getKdlpg());
            view.getCbxPelanggan().setSelectedItem(model.getKdplg());
            view.getTanggal().setDate(Date.valueOf(model.getTglmain()));
            view.getWaktuAwal().setText(model.getJamawal());
            view.getWaktuAkhir().setText(model.getJamakhir());
            view.getTxtUangMuka().setText(String.valueOf(model.getUangmuka()));
            view.getTxtSewa().setText(String.valueOf(model.getBayasewa()));
        }catch(SQLException e){
            Logger.getLogger(Controller.penyewaan.class.getName()).log(Level.SEVERE, "Eror");
        }
    }
    
    public void ReportBulanSewa(String bulan, String tahun){
        try {
            HashMap parameter = new HashMap();
            parameter.put("pbulan", bulan);
            parameter.put("ptahun", tahun);
            JasperPrint jasperPrint = null;
            jasperPrint = JasperFillManager.fillReport("src/Report/Sewa/PerBulanSewa.jasper", parameter, con);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(Controller.penyewaan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ReportTahunSewa(String tahun){
        try {
            HashMap parameter = new HashMap();
            parameter.put("ptahun", tahun);
            JasperPrint jasperPrint = null;
            jasperPrint = JasperFillManager.fillReport("src/Report/Sewa/PerTahunSewa.jasper", parameter, con);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(Controller.penyewaan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
