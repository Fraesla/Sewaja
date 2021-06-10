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
    public String kdpem;
    public String kdlpg;
    public String kdplg;
    public String tglmain;
    public String jamawal;
    public String jamakhir;
    public int uangmuka;
    public int bayasewa;
    public int totalsewa;
    public int pemasukkan;

    public String getKdpem() {
        return kdpem;
    }

    public void setKdpem(String kdpem) {
        this.kdpem = kdpem;
    }

    public String getKdlpg() {
        return kdlpg;
    }

    public void setKdlpg(String kdlpg) {
        this.kdlpg = kdlpg;
    }

    public String getKdplg() {
        return kdplg;
    }

    public void setKdplg(String kdplg) {
        this.kdplg = kdplg;
    }

    public String getTglmain() {
        return tglmain;
    }

    public void setTglmain(String tglmain) {
        this.tglmain = tglmain;
    }

    public String getJamawal() {
        return jamawal;
    }

    public void setJamawal(String jamawal) {
        this.jamawal = jamawal;
    }

    public String getJamakhir() {
        return jamakhir;
    }

    public void setJamakhir(String jamakhir) {
        this.jamakhir = jamakhir;
    }

    public int getUangmuka() {
        return uangmuka;
    }

    public void setUangmuka(int uangmuka) {
        this.uangmuka = uangmuka;
    }

    public int getBayasewa() {
        return bayasewa;
    }

    public void setBayasewa(int bayasewa) {
        this.bayasewa = bayasewa;
    }

    public int getTotalsewa() {
        return totalsewa;
    }

    public void setTotalsewa(int totalsewa) {
        this.totalsewa = totalsewa;
    }

    public int getPemasukkan() {
        return pemasukkan;
    }

    public void setPemasukkan(int pemasukkan) {
        this.pemasukkan = pemasukkan;
    }
    
    
}
