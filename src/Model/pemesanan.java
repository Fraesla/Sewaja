/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Fraesla
 */
public class pemesanan {
    public String IdNota;
    public String KdPlg;
    public String KdBrg;
    public String namaBrg;
    public int jumlah;
    public int hargaBrg;
    public int totalharga;
    public int totalPesan;

    public String getIdNota() {
        return IdNota;
    }

    public void setIdNota(String IdNota) {
        this.IdNota = IdNota;
    }

    public String getKdPlg() {
        return KdPlg;
    }

    public void setKdPlg(String KdPlg) {
        this.KdPlg = KdPlg;
    }

    public Integer getTotalPesan() {
        return totalPesan;
    }

    public void setTotalPesan(Integer totalPesan) {
        this.totalPesan = totalPesan;
    }

    public String getKdBrg() {
        return KdBrg;
    }

    public void setKdBrg(String KdBrg) {
        this.KdBrg = KdBrg;
    }

    public String getNamaBrg() {
        return namaBrg;
    }

    public void setNamaBrg(String namaBrg) {
        this.namaBrg = namaBrg;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getHargaBrg() {
        return hargaBrg;
    }

    public void setHargaBrg(int hargaBrg) {
        this.hargaBrg = hargaBrg;
    }

    public int getTotalharga() {
        return totalharga;
    }

    public void setTotalharga(int totalharga) {
        this.totalharga = totalharga;
    }

    public void setTotalPesan(int totalPesan) {
        this.totalPesan = totalPesan;
    }

    
    
}
