/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
    String kdpem;
    String kdplg;
    String kdlpg;
    String nama;
    String tgl;
    Integer harga;
    Integer jamakhir;
    Integer jamawal;
    Integer total;
    Integer uangmuka;

    public String getKdpem() {
        return kdpem;
    }

    public void setKdpem(String kdpem) {
        this.kdpem = kdpem;
    }

    public String getKdplg() {
        return kdplg;
    }

    public void setKdplg(String kdplg) {
        this.kdplg = kdplg;
    }

    public String getKdlpg() {
        return kdlpg;
    }

    public void setKdlpg(String kdlpg) {
        this.kdlpg = kdlpg;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public Integer getJamakhir() {
        return jamakhir;
    }

    public void setJamakhir(Integer jamakhir) {
        this.jamakhir = jamakhir;
    }

    public Integer getJamawal() {
        return jamawal;
    }

    public void setJamawal(Integer jamawal) {
        this.jamawal = jamawal;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getUangmuka() {
        return uangmuka;
    }

    public void setUangmuka(Integer uangmuka) {
        this.uangmuka = uangmuka;
    }
    
    
}
