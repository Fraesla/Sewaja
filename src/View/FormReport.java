/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Server.Koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class FormReport extends javax.swing.JFrame {
    Controller.pembayaran bayarController;
    Controller.penyewaan sewaController;
    Controller.pemesanan pesanController;
    FormPenyewaan viewSewa;
    FormPemesanan viewPesan;
    FormPembayaran viewBayar;
    int bt=0;
    String Bulan,Tahun;

    /**
     * Creates new form FormReport
     */
    public FormReport() {
        initComponents();
        sewaController = new Controller.penyewaan(viewSewa);
        bayarController = new Controller.pembayaran(viewBayar);
        pesanController = new Controller.pemesanan(viewPesan);
        ket.setText("Admin");
    }

    public JLabel getA() {
        return a;
    }

    public JLabel getKet() {
        return ket;
    }

    public JLabel getUser() {
        return user;
    }
    
    private void tableSewaBulan(){
        Bulan = JOptionPane.showInputDialog(this, "Masukkan Bulan \n Contoh : 01", 
                "Laporan Penyewaan Per-Bulan", JOptionPane.QUESTION_MESSAGE);
        Tahun = JOptionPane.showInputDialog(this, "Masukkan Tahun \n Contoh : 2014", 
                "Laporan Penyewaan Per-Bulan", JOptionPane.QUESTION_MESSAGE);
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Pemakaian");
        model.addColumn("Kode Pelanggan");
        model.addColumn("Nama Pelanggan");
        model.addColumn("Kode Lapangan");
        model.addColumn("Tanggal Main");
        model.addColumn("Jam Awal");
        model.addColumn("Jam Akhir");
        model.addColumn("Total Sewa");
        model.addColumn("Pemasukkan");
        
        try{
            Koneksi k = new Koneksi();
            Connection con = k.getConnection();
            String sql = "SELECT penyewaan.`kdpem`, penyewaan.`kdplg`, " +
                        "pelanggan.`namaplg`, penyewaan.`kdlpg`, penyewaan.`tglmain`, " +
                        "penyewaan.`jamawal`, penyewaan.`jamakhir`, penyewaan.`totalsewa`, " +
                        "penyewaan.`pemasukan` FROM `pelanggan` pelanggan INNER JOIN `penyewaan` penyewaan "+ 
                        "ON pelanggan.`kodeplg` = penyewaan.`kdplg` " +
                        "WHERE month(tglmain) = '"+Bulan+"' and year(tglmain) = '"+Tahun+"'";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                model.addRow(new Object[] {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9)
                });
            }
            table.setModel(model);
        } catch(Exception e){
        }
    }
    
    private void tableSewaTahun(){
        Tahun = JOptionPane.showInputDialog(this, "Masukkan Tahun \n Contoh : 2014", 
                "Laporan Penyewaan Per-Bulan", JOptionPane.QUESTION_MESSAGE);
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Pemakaian");
        model.addColumn("Kode Pelanggan");
        model.addColumn("Nama Pelanggan");
        model.addColumn("Kode Lapangan");
        model.addColumn("Tanggal Main");
        model.addColumn("Jam Awal");
        model.addColumn("Jam Akhir");
        model.addColumn("Total Sewa");
        model.addColumn("Pemasukkan");
        
        try{
            Koneksi k = new Koneksi();
            Connection con = k.getConnection();
            String sql = "SELECT penyewaan.`kdpem`, penyewaan.`kdplg`, " +
                        "pelanggan.`namaplg`, penyewaan.`kdlpg`, penyewaan.`tglmain`, " +
                        "penyewaan.`jamawal`, penyewaan.`jamakhir`, penyewaan.`totalsewa`, " +
                        "penyewaan.`pemasukan` FROM `pelanggan` pelanggan INNER JOIN `penyewaan` penyewaan "+ 
                        "ON pelanggan.`kodeplg` = penyewaan.`kdplg` " +
                        "WHERE year(tglmain) = '"+Tahun+"'";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                model.addRow(new Object[] {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9)
                });
            }
            table.setModel(model);
        } catch(Exception e){
        }
    }
    
    private void tableBayarBulan(){
        Bulan = JOptionPane.showInputDialog(this, "Masukkan Bulan \n Contoh : 01", 
                "Laporan Penyewaan Per-Bulan", JOptionPane.QUESTION_MESSAGE);
        Tahun = JOptionPane.showInputDialog(this, "Masukkan Tahun \n Contoh : 2014", 
                "Laporan Penyewaan Per-Bulan", JOptionPane.QUESTION_MESSAGE);
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Transaksi");
        model.addColumn("Kode Pemakaian");
        model.addColumn("SubTotal Sewa");
        model.addColumn("ID Nota");
        model.addColumn("SubTotal Pesan");
        model.addColumn("Total Bayar");
        model.addColumn("Pemasukkan");
        
        try{
            Koneksi k = new Koneksi();
            Connection con = k.getConnection();
            String sql = "SELECT pembayaran.`idtrans`, pembayaran.`kdpem`, " +
                        "penyewaan.`totalsewa`, pembayaran.`idnota`, pemesanan.`subtotalmesan`, " +
                        "pembayaran.`total`, pembayaran.`masukkan` FROM `pemesanan` pemesanan INNER JOIN " +
                        "`pembayaran` pembayaran ON pemesanan.`idnota` = pembayaran.`idnota` INNER JOIN " +
                        "`penyewaan` penyewaan ON pembayaran.`kdpem` = penyewaan.`kdpem`" +
                        "WHERE month(tglmain) = '"+Bulan+"' and year(tglmain) = '"+Tahun+"'";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                model.addRow(new Object[] {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7)
                });
            }
            table.setModel(model);
        } catch(Exception e){
        }
    }
    
    private void tableBayarTahun(){
        Tahun = JOptionPane.showInputDialog(this, "Masukkan Tahun \n Contoh : 2014", 
                "Laporan Penyewaan Per-Bulan", JOptionPane.QUESTION_MESSAGE);
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Transaksi");
        model.addColumn("Kode Pemakaian");
        model.addColumn("SubTotal Sewa");
        model.addColumn("ID Nota");
        model.addColumn("SubTotal Pesan");
        model.addColumn("Total Bayar");
        model.addColumn("Pemasukkan");
        
        try{
            Koneksi k = new Koneksi();
            Connection con = k.getConnection();
            String sql = "SELECT pembayaran.`idtrans`, pembayaran.`kdpem`, " +
                        "penyewaan.`totalsewa`, pembayaran.`idnota`, pemesanan.`subtotalmesan`, " +
                        "pembayaran.`total`, pembayaran.`masukkan` FROM `pemesanan` pemesanan INNER JOIN " +
                        "`pembayaran` pembayaran ON pemesanan.`idnota` = pembayaran.`idnota` INNER JOIN " +
                        "`penyewaan` penyewaan ON pembayaran.`kdpem` = penyewaan.`kdpem`" +
                        "WHERE year(tglmain) = '"+Tahun+"'";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                model.addRow(new Object[] {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7)
                });
            }
            table.setModel(model);
        } catch(Exception e){
        }
    }
    
    private void tablePesanBulan(){
        Bulan = JOptionPane.showInputDialog(this, "Masukkan Bulan \n Contoh : 01", 
                "Laporan Penyewaan Per-Bulan", JOptionPane.QUESTION_MESSAGE);
        Tahun = JOptionPane.showInputDialog(this, "Masukkan Tahun \n Contoh : 2014", 
                "Laporan Penyewaan Per-Bulan", JOptionPane.QUESTION_MESSAGE);
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Nota");
        model.addColumn("Kode Pelanggan");
        model.addColumn("Nama Pelanggan");
        model.addColumn("ID Menu/Barang");
        model.addColumn("Nama Menu/Barang");
        model.addColumn("Jumlah");
        model.addColumn("Total Harga");
        model.addColumn("Sub Total Pesan");
        
        try{
            Koneksi k = new Koneksi();
            Connection con = k.getConnection();
            String sql = "SELECT pesanan.`idNota`, pelanggan.`kodeplg`, " +
                        "pelanggan.`namaplg`, pesanan.`kdBrg`, barang.`nama`, " +
                        "pesanan.`jumlah`, pesanan.`totalharga`, pemesanan.`subtotalmesan` " +
                        "FROM `pelanggan` pelanggan INNER JOIN `pemesanan` pemesanan ON " + 
                        "pelanggan.`kodeplg` = pemesanan.`kdplg`\n" +
                        "INNER JOIN `pesanan` pesanan ON pemesanan.`idnota` = pesanan.`idNota`\n" +
                        "INNER JOIN `barang` barang ON pesanan.`kdBrg` = barang.`kdBrg`\n" +
                        "INNER JOIN `penyewaan` penyewaan ON pelanggan.`kodeplg` = penyewaan.`kdplg` " +
                        "WHERE month(tglmain) = '"+Bulan+"' and year(tglmain) = '"+Tahun+"'";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                model.addRow(new Object[] {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8)
                });
            }
            table.setModel(model);
        } catch(Exception e){
        }
    }
    
    private void tablePesanTahun(){
        Tahun = JOptionPane.showInputDialog(this, "Masukkan Tahun \n Contoh : 2014", 
                "Laporan Penyewaan Per-Bulan", JOptionPane.QUESTION_MESSAGE);
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Nota");
        model.addColumn("Kode Pelanggan");
        model.addColumn("Nama Pelanggan");
        model.addColumn("ID Menu/Barang");
        model.addColumn("Nama Menu/Barang");
        model.addColumn("Jumlah");
        model.addColumn("Total Harga");
        model.addColumn("Sub Total Pesan");
        
        try{
            Koneksi k = new Koneksi();
            Connection con = k.getConnection();
            String sql = "SELECT pesanan.`idNota`, pelanggan.`kodeplg`, " +
                        "pelanggan.`namaplg`, pesanan.`kdBrg`, barang.`nama`, " +
                        "pesanan.`jumlah`, pesanan.`totalharga`, pemesanan.`subtotalmesan` " +
                        "FROM `pelanggan` pelanggan INNER JOIN `pemesanan` pemesanan ON " + 
                        "pelanggan.`kodeplg` = pemesanan.`kdplg`\n" +
                        "INNER JOIN `pesanan` pesanan ON pemesanan.`idnota` = pesanan.`idNota`\n" +
                        "INNER JOIN `barang` barang ON pesanan.`kdBrg` = barang.`kdBrg`\n" +
                        "INNER JOIN `penyewaan` penyewaan ON pelanggan.`kodeplg` = penyewaan.`kdplg` " +
                        "WHERE year(tglmain) = '"+Tahun+"'";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                model.addRow(new Object[] {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8)
                });
            }
            table.setModel(model);
        } catch(Exception e){
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        home = new javax.swing.JLabel();
        pelanggan = new javax.swing.JLabel();
        penyewaan = new javax.swing.JLabel();
        pemesanan = new javax.swing.JLabel();
        pembayaran = new javax.swing.JLabel();
        report = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        javax.swing.JLabel jLabel11 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        txtPilihan = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        ket = new javax.swing.JLabel();
        bulan = new javax.swing.JButton();
        tahun = new javax.swing.JButton();
        print = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        a = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel1.setText("REPORT");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 120, 170, 44);

        jLabel13.setText("-----------------------------------------");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(20, 160, 170, 14);

        home.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        home.setText("Home");
        home.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });
        getContentPane().add(home);
        home.setBounds(20, 180, 70, 29);

        pelanggan.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        pelanggan.setText("Pelanggan");
        pelanggan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pelangganMouseClicked(evt);
            }
        });
        getContentPane().add(pelanggan);
        pelanggan.setBounds(20, 220, 109, 29);

        penyewaan.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        penyewaan.setText("Penyewaan");
        penyewaan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                penyewaanMouseClicked(evt);
            }
        });
        getContentPane().add(penyewaan);
        penyewaan.setBounds(20, 270, 121, 29);

        pemesanan.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        pemesanan.setText("Pemesanan");
        pemesanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pemesananMouseClicked(evt);
            }
        });
        getContentPane().add(pemesanan);
        pemesanan.setBounds(20, 320, 132, 29);

        pembayaran.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        pembayaran.setText("Pembayaran");
        pembayaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pembayaranMouseClicked(evt);
            }
        });
        getContentPane().add(pembayaran);
        pembayaran.setBounds(20, 370, 132, 29);

        report.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        report.setForeground(new java.awt.Color(255, 0, 0));
        report.setText("Report");
        report.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportMouseClicked(evt);
            }
        });
        getContentPane().add(report);
        report.setBounds(20, 410, 71, 29);

        logout.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        logout.setText("Keluar");
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });
        getContentPane().add(logout);
        logout.setBounds(20, 460, 67, 29);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setText("Pilih Report Yang Mau dicetak");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(400, 100, 340, 60);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel23.setText("1. Penyewaan");
        getContentPane().add(jLabel23);
        jLabel23.setBounds(400, 170, 170, 50);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel24.setText("3. Pembayaran");
        getContentPane().add(jLabel24);
        jLabel24.setBounds(400, 250, 170, 50);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel25.setText("2. Pemesanan");
        getContentPane().add(jLabel25);
        jLabel25.setBounds(400, 210, 170, 50);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(390, 350, 740, 180);

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setText("Pilihan Report :");
        getContentPane().add(jLabel26);
        jLabel26.setBounds(820, 170, 140, 30);
        getContentPane().add(txtPilihan);
        txtPilihan.setBounds(950, 170, 70, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Status :");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(380, 20, 80, 20);

        ket.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(ket);
        ket.setBounds(450, 20, 80, 20);

        bulan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bulan.setText("Bulan");
        bulan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bulanActionPerformed(evt);
            }
        });
        getContentPane().add(bulan);
        bulan.setBounds(820, 220, 90, 40);

        tahun.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tahun.setText("Tahun");
        tahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tahunActionPerformed(evt);
            }
        });
        getContentPane().add(tahun);
        tahun.setBounds(930, 220, 90, 40);

        print.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        getContentPane().add(print);
        print.setBounds(870, 270, 90, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(390, 60, 240, 40);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Pelanggan (1).png"))); // NOI18N
        getContentPane().add(jLabel12);
        jLabel12.setBounds(0, 0, 1150, 600);

        user.setText("jLabel2");
        getContentPane().add(user);
        user.setBounds(0, 0, 34, 14);

        a.setText("jLabel2");
        getContentPane().add(a);
        a.setBounds(20, 70, 34, 14);

        setSize(new java.awt.Dimension(1166, 599));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        FormUtama utama = new FormUtama();
        if (a.getText().equals("operator")) {
            utama.getReport().setVisible(false);
            utama.getA().setText(a.getText());
            utama.getKet().setText("Operator");
            utama.getjLabel4().setText("Edit Akun");
            utama.getUser().setText(user.getText());
            utama.getUser().setEnabled(false);
        } else{
            utama.getKet().setText("Admin");
        }
        utama.setVisible(true);
        dispose();
    }//GEN-LAST:event_homeMouseClicked

    private void pelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pelangganMouseClicked
        FormPelanggan member = new FormPelanggan();
        if (a.getText().equals("operator")) {
            member.getReport().setVisible(false);
            member.getKet().setText("Operator");
            member.getA().setText(a.getText());
            member.getUser().setText(user.getText());
        }
        else{
            member.getKet().setText("Admin");
        }
        member.setVisible(true);
        dispose();
    }//GEN-LAST:event_pelangganMouseClicked

    private void penyewaanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_penyewaanMouseClicked
        FormPenyewaan sewa = new FormPenyewaan();
        if (a.getText().equals("operator")) {
            sewa.getReport().setVisible(false);
            sewa.getKet().setText("Operator");
            sewa.getA().setText(a.getText());
            sewa.getUser().setText(user.getText());
        }
        else{
            sewa.getKet().setText("Admin");
        }
        sewa.setVisible(true);
        dispose();
    }//GEN-LAST:event_penyewaanMouseClicked

    private void pemesananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pemesananMouseClicked
        FormPemesanan pesan = new FormPemesanan();
        if (a.getText().equals("operator")) {
            pesan.getReport().setVisible(false);
            pesan.getKet().setText("Operator");
            pesan.getA().setText(a.getText());
            pesan.getUser().setText(user.getText());
        }
        else{
            pesan.getKet().setText("Admin");
        }
        pesan.setVisible(true);
        dispose();
    }//GEN-LAST:event_pemesananMouseClicked

    private void pembayaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pembayaranMouseClicked
        FormPembayaran bayar = new FormPembayaran();
        if (a.getText().equals("operator")) {
            bayar.getReport().setVisible(false);
            bayar.getKet().setText("Operator");
            bayar.getA().setText(a.getText());
            bayar.getUser().setText(user.getText());
        }
        else{
            bayar.getKet().setText("Admin");
        }
        bayar.setVisible(true);
        dispose();
    }//GEN-LAST:event_pembayaranMouseClicked

    private void reportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_reportMouseClicked

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        new FormLogin().setVisible(true);
        dispose();
    }//GEN-LAST:event_logoutMouseClicked

    private void bulanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bulanActionPerformed
        switch(txtPilihan.getText()){
            case "1":
                tableSewaBulan();
                bt = 1;
                break;
            case "2":
                tablePesanBulan();
                bt = 1;
                break;
            case "3":
                tableBayarBulan();
                bt = 1;
                break;
            default:
                JOptionPane.showMessageDialog(this, "Pilih Report nya dulu");
                bt = 0;
                break;
        }
    }//GEN-LAST:event_bulanActionPerformed

    private void tahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tahunActionPerformed
        switch(txtPilihan.getText()){
            case "1":
                tableSewaTahun();
                bt = 2;
                break;
            case "2":
                tablePesanTahun();
                bt = 2;
                break;
            case "3":
                tableBayarTahun();
                bt = 2;
                break;
            default:
                JOptionPane.showMessageDialog(this, "Pilih Report nya dulu");
                bt = 0;
                break;
        }
    }//GEN-LAST:event_tahunActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        int x = JOptionPane.showConfirmDialog(this, "Yakin Ingin Mencetak?", "Cetak Report", JOptionPane.OK_CANCEL_OPTION);
        if (x == 0) {
            switch (bt) {
                case 1:
                    switch(txtPilihan.getText()){
                        case "1":
                            sewaController.ReportBulanSewa(Bulan, Tahun);
                            break;
                        case "2":
                            pesanController.ReportBulanPesan(Bulan, Tahun);
                            break;
                        case "3":
                            bayarController.previewReportBulanBayar(Bulan, Tahun);
                            break;
                        default:
                            JOptionPane.showMessageDialog(this, "Pilih Periode Report nya dulu");
                            break;
                    }   
                    break;
                case 2:
                    switch(txtPilihan.getText()){
                        case "1":
                            sewaController.ReportTahunSewa(Tahun);
                            break;
                        case "2":
                            pesanController.ReportTahunPesan(Tahun);
                            break;
                        case "3":
                            bayarController.previewReportTahunBayar(Tahun);
                        break;
                        default:
                            JOptionPane.showMessageDialog(this, "Pilih Periode Report nya dulu");
                            break;
                    }   
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Pilih Periode Report nya dulu");
                    break;
            }
        }
    }//GEN-LAST:event_printActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FormAwal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel a;
    private javax.swing.JButton bulan;
    private javax.swing.JLabel home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel ket;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel pelanggan;
    private javax.swing.JLabel pembayaran;
    private javax.swing.JLabel pemesanan;
    private javax.swing.JLabel penyewaan;
    private javax.swing.JButton print;
    private javax.swing.JLabel report;
    private javax.swing.JTable table;
    private javax.swing.JButton tahun;
    private javax.swing.JTextField txtPilihan;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
