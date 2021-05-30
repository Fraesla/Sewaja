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
public class pembayaran {
    String Idtrans;
    String Idnota;
    String kdpem;
    int total;

    public String getIdtrans() {
        return Idtrans;
    }

    public void setIdtrans(String Idtrans) {
        this.Idtrans = Idtrans;
    }

    public String getIdnota() {
        return Idnota;
    }

    public void setIdnota(String Idnota) {
        this.Idnota = Idnota;
    }

    public String getKdpem() {
        return kdpem;
    }

    public void setKdpem(String kdpem) {
        this.kdpem = kdpem;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
}
