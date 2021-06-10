/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Server.Koneksi;
import View.FormPelanggan;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class pelanggan {
    View.FormPelanggan view;
    DAO.pelanggan database;
    Model.pelanggan model;
    Connection con;
    Koneksi server;
    ResultSet rs= null;
    PreparedStatement pst=null;
    public pelanggan(FormPelanggan view) {
        this.view = view;
        database=new DAO.pelanggan();
        server=new Koneksi();
        try{
            con=server.getConnection();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }
    public void insertPelanggan()
    {
        model=new Model.pelanggan();
        model.setKdPlg(view.getTxtKode().getText());
        model.setNama(view.getTxtNama().getText());
        model.setTelp(view.getTxtTelpAlm().getText());
        model.setIdMem(view.getCbxMember().getSelectedItem().toString());
        
        try{
            database.createPelanggan(model);
            javax.swing.JOptionPane.showMessageDialog(null, "Insert Pelanggan Berhasil");
        }
        catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Error"+ex.getMessage());
        }
    }
    public void insertMember()
    {
        model=new Model.pelanggan();
        model.setIdMem(view.getTxtKode().getText());
        model.setNama(view.getTxtNama().getText());
        model.setTelp(view.getTxtIdTelp().getText());
        model.setAlm(view.getTxtTelpAlm().getText());
        
        try{
            database.createMember(model);
            javax.swing.JOptionPane.showMessageDialog(null, "Insert Member Berhasil");
        }
        catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Error"+ex.getMessage());
        }
    }
    public void updatePelanggan()
    {
        model=new Model.pelanggan();
        model.setKdPlg(view.getTxtKode().getText());
        model.setNama(view.getTxtNama().getText());
        model.setTelp(view.getTxtTelpAlm().getText());
        model.setIdMem(view.getCbxMember().getSelectedItem().toString());
        
        try{
            database.updatePelanggan(model);
            javax.swing.JOptionPane.showMessageDialog(view, "Update Pelanggan Berhasil");
            view.getTxtKode().setEnabled(true);
            view.getTxtKode().requestFocus();
            view.getForm1().setVisible(true);
            view.getForm1().setText("Daftar Member ?");
            view.getForm2().setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(pemesanan.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    public void updateMember()
    {
        model=new Model.pelanggan();
        model.setIdMem(view.getTxtKode().getText());
        model.setNama(view.getTxtNama().getText());
        model.setTelp(view.getTxtIdTelp().getText());
        model.setAlm(view.getTxtTelpAlm().getText());
        
        try{
            database.updateMember(model);
            javax.swing.JOptionPane.showMessageDialog(view, "Update Member Berhasil");
            view.getTxtKode().setEnabled(true);
            view.getTxtKode().requestFocus();
            view.getForm1().setVisible(true);
            view.getForm1().setText("Input Pelanggan");
            view.getForm2().setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(pemesanan.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    public void getPelanggan()
    {
        String key=view.getTxtKode().getText();   
        try{
            model=database.getPelanggan(key);
            if(model!=null)
            {
                view.getTxtKode().setText(model.getKdPlg());
                view.getTxtNama().setText(model.getNama());
                view.getCbxMember().setSelectedItem(model.getIdMem());
                view.getTxtTelpAlm().setText(model.getTelp());
            }
            else
                JOptionPane.showMessageDialog(null, "Data Kosong");
        }
        catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,e);
        }
    }
    public void getMember()
    {
        String key=view.getTxtKode().getText();   
        try{
            model=database.getMember(key);
            if(model!=null)
            {
                view.getTxtKode().setText(model.getIdMem());
                view.getTxtNama().setText(model.getNama());
                view.getTxtIdTelp().setText(model.getTelp());
                view.getTxtTelpAlm().setText(model.getAlm());
            }
            else
                JOptionPane.showMessageDialog(null, "Data Kosong");
        }
        catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,e);
        }
    }
    public void deletePelanggan()
    {
        String Kode = view.getTxtKode().getText();
        try{
            database.deletePelanggan(Kode);
            JOptionPane.showMessageDialog(null, "Delete Pelanggan Success");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        this.clear();
    }
    public void deleteMember()
    {
        String ID = view.getTxtKode().getText();
        try{
            database.deleteMember(ID);
            JOptionPane.showMessageDialog(null, "Delete Member Success");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        this.clear();
    }
    public void clear() 
    {
        view.getTxtKode().setText("");
        view.getTxtNama().setText("");
        view.getTxtIdTelp().setText("");
        view.getTxtTelpAlm().setText("");
        view.getCbxMember().setSelectedItem("-");
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
            if (rs.last()) {
                view.getPelanggankd().setText(rs.getString(1));
            }
        }catch (SQLException ex) {
            Logger.getLogger(pelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void MemberTabel()
    {
        try{
            DefaultTableModel model = (DefaultTableModel)view.getTableMember().getModel();
            model.setRowCount(0);
            ResultSet rs = server.getQuery(con,"SELECT * FROM member");
            while(rs.next())
            {
                Object data[]=
                {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4)
                };
                model.addRow(data);
            }
            if (rs.last()) {
                view.getMemberkd().setText(rs.getString(1));
            }
        }catch (SQLException ex) {
            Logger.getLogger(pelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void onMouseClickTablePelanggan()
    {
        DAO.pelanggan sql=new DAO.pelanggan();
        String kode=view.getTablePelanggan().getValueAt(
                view.getTablePelanggan().getSelectedRow(),0).toString();
        String nama=view.getTablePelanggan().getValueAt(
                view.getTablePelanggan().getSelectedRow(),1).toString();
        String idMem=view.getTablePelanggan().getValueAt(
                view.getTablePelanggan().getSelectedRow(),2).toString();
        String telp=view.getTablePelanggan().getValueAt(
                view.getTablePelanggan().getSelectedRow(),3).toString();
        
        try{
            Model.pelanggan model = sql.getPelanggan(kode);
            view.getTxtKode().setText(model.getKdPlg());
            view.getTxtNama().setText(model.getNama());
            view.getCbxMember().setSelectedItem(model.getIdMem());
            view.getTxtTelpAlm().setText(model.getTelp());
        }catch (SQLException ex) {
            Logger.getLogger(pelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    public void onMouseClickTableMember()
    {
        DAO.pelanggan sql=new DAO.pelanggan();
        String Id=view.getTableMember().getValueAt(
                view.getTableMember().getSelectedRow(),0).toString();
        String nama=view.getTableMember().getValueAt(
                view.getTableMember().getSelectedRow(),1).toString();
        String telp=view.getTableMember().getValueAt(
                view.getTableMember().getSelectedRow(),2).toString();
        String alm=view.getTableMember().getValueAt(
                view.getTableMember().getSelectedRow(),3).toString();
    
        try{
            Model.pelanggan model = sql.getMember(Id);
            view.getTxtKode().setText(model.getIdMem());
            view.getTxtNama().setText(model.getNama());
            view.getTxtIdTelp().setText(model.getTelp());
            view.getTxtTelpAlm().setText(model.getAlm());
        }catch (SQLException ex) {
            Logger.getLogger(pelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

}
