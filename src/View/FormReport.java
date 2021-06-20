/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Server.Koneksi;
import java.awt.Color;
import java.awt.Toolkit;
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
        sewa.setForeground(Color.black);
        pesan.setForeground(Color.black);
        bayar.setForeground(Color.black);
        bulan.setVisible(false);
        tahun.setVisible(false);
        print.setVisible(false);
        back.setVisible(false);
        icon();
    }
    private void icon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
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
        Tahun = JOptionPane.showInputDialog(this, "Masukkan Tahun \n Contoh : 2021", 
                "Laporan Penyewaan Per-Tahun", JOptionPane.QUESTION_MESSAGE);
        
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
        Tahun = JOptionPane.showInputDialog(this, "Masukkan Tahun \n Contoh : 2021", 
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
                "Laporan Pembayaran Per-Bulan", JOptionPane.QUESTION_MESSAGE);
        Tahun = JOptionPane.showInputDialog(this, "Masukkan Tahun \n Contoh : 2021", 
                "Laporan Pembayaran Per-Tahun", JOptionPane.QUESTION_MESSAGE);
        
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
        Tahun = JOptionPane.showInputDialog(this, "Masukkan Tahun \n Contoh : 2021", 
                "Laporan Pembayaran Per-Tahun", JOptionPane.QUESTION_MESSAGE);
        
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
                "Laporan Pemesanan Per-Bulan", JOptionPane.QUESTION_MESSAGE);
        Tahun = JOptionPane.showInputDialog(this, "Masukkan Tahun \n Contoh : 2021", 
                "Laporan Pemesanan Per-Tahun", JOptionPane.QUESTION_MESSAGE);
        
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
                        "WHERE month(tglpesan) = '"+Bulan+"' and year(tglpesan) = '"+Tahun+"'";
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
        Tahun = JOptionPane.showInputDialog(this, "Masukkan Tahun \n Contoh : 2021", 
                "Laporan Pemesanan Per-Tahun", JOptionPane.QUESTION_MESSAGE);
        
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
                        "WHERE year(tglpesan) = '"+Tahun+"'";
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
        sewa = new javax.swing.JLabel();
        bayar = new javax.swing.JLabel();
        pesan = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        ket = new javax.swing.JLabel();
        bulan = new javax.swing.JButton();
        tahun = new javax.swing.JButton();
        print = new javax.swing.JButton();
        back = new javax.swing.JButton();
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

        sewa.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        sewa.setText("1. Penyewaan");
        sewa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sewaMouseClicked(evt);
            }
        });
        getContentPane().add(sewa);
        sewa.setBounds(400, 170, 170, 50);

        bayar.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        bayar.setText("3. Pembayaran");
        bayar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bayarMouseClicked(evt);
            }
        });
        getContentPane().add(bayar);
        bayar.setBounds(400, 250, 170, 50);

        pesan.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        pesan.setText("2. Pemesanan");
        pesan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pesanMouseClicked(evt);
            }
        });
        getContentPane().add(pesan);
        pesan.setBounds(400, 210, 170, 50);

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

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Status :");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(380, 20, 80, 20);

        ket.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(ket);
        ket.setBounds(450, 20, 80, 20);

        bulan.setBackground(new java.awt.Color(153, 153, 0));
        bulan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bulan.setForeground(new java.awt.Color(255, 255, 255));
        bulan.setText("Bulan");
        bulan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bulanActionPerformed(evt);
            }
        });
        getContentPane().add(bulan);
        bulan.setBounds(820, 200, 90, 40);

        tahun.setBackground(new java.awt.Color(153, 0, 0));
        tahun.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tahun.setForeground(new java.awt.Color(255, 255, 255));
        tahun.setText("Tahun");
        tahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tahunActionPerformed(evt);
            }
        });
        getContentPane().add(tahun);
        tahun.setBounds(930, 200, 90, 40);

        print.setBackground(new java.awt.Color(102, 170, 246));
        print.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        print.setForeground(new java.awt.Color(255, 255, 255));
        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        getContentPane().add(print);
        print.setBounds(820, 250, 90, 40);

        back.setBackground(new java.awt.Color(0, 0, 0));
        back.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(930, 250, 90, 40);

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
            utama.getUser1().setText(user.getText());
            utama.getUser().setEnabled(false);
        } else{
            utama.getKet().setText("Admin");
            utama.getA().setText(a.getText());
            utama.getUser().setText(user.getText());
            utama.getUser1().setText(user.getText());
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
            member.getA().setText(a.getText());
            member.getUser().setText(user.getText());
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
            sewa.getA().setText(a.getText());
            sewa.getUser().setText(user.getText());
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
            pesan.getA().setText(a.getText());
            pesan.getUser().setText(user.getText());
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
            bayar.getA().setText(a.getText());
            bayar.getUser().setText(user.getText());
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
        if(sewa.getForeground().equals(Color.red)){
            tableSewaBulan();
            bt = 1;
        }
        else if(pesan.getForeground().equals(Color.red)){
            tablePesanBulan();
            bt = 1;
        }
        else if(bayar.getForeground().equals(Color.red)){
            tableBayarBulan();
            bt = 1;
        }
        else{
            JOptionPane.showMessageDialog(this, "Pilih Report nya dulu");
            bt = 0;
        }
    }//GEN-LAST:event_bulanActionPerformed

    private void tahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tahunActionPerformed
        if(sewa.getForeground().equals(Color.red)){
            tableSewaTahun();
            bt = 2;
        }
        else if(pesan.getForeground().equals(Color.red)){
            tablePesanTahun();
            bt = 2;
        }
        else if(bayar.getForeground().equals(Color.red)){
            tableBayarTahun();
            bt = 2;
        }
        else{
            JOptionPane.showMessageDialog(this, "Pilih Report nya dulu");
            bt = 0;
        }
    }//GEN-LAST:event_tahunActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        int x = JOptionPane.showConfirmDialog(this, "Yakin Ingin Mencetak?", "Cetak Report", JOptionPane.OK_CANCEL_OPTION);
        if (x == 0) {
            switch (bt) {
                case 1:
                    if(sewa.getForeground().equals(Color.red)){
                        sewaController.ReportBulanSewa(Bulan, Tahun);
                    }
                    else if(pesan.getForeground().equals(Color.red)){
                        pesanController.ReportBulanPesan(Bulan, Tahun);
                    }
                    else if(bayar.getForeground().equals(Color.red)){
                        bayarController.previewReportBulanBayar(Bulan, Tahun);
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "Pilih Report nya dulu");
                    }   
                    break;
                case 2:
                    if(sewa.getForeground().equals(Color.red)){
                        sewaController.ReportTahunSewa(Tahun);
                    }
                    else if(pesan.getForeground().equals(Color.red)){
                        pesanController.ReportTahunPesan(Tahun);
                    }
                    else if(bayar.getForeground().equals(Color.red)){
                        bayarController.previewReportTahunBayar(Tahun);
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "Pilih Report nya dulu");
                    }   
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Pilih Periode Report nya dulu");
                    break;
            }
        }
    }//GEN-LAST:event_printActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        sewa.setForeground(Color.black);
        pesan.setForeground(Color.black);
        bayar.setForeground(Color.black);
        bulan.setVisible(false);
        tahun.setVisible(false);
        print.setVisible(false);
        back.setVisible(false);
        table.setModel(new DefaultTableModel(null,new String[]{}));
    }//GEN-LAST:event_backActionPerformed

    private void sewaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sewaMouseClicked
        sewa.setForeground(Color.red);
        pesan.setForeground(Color.black);
        bayar.setForeground(Color.black);
        bulan.setVisible(true);
        tahun.setVisible(true);
        print.setVisible(true);
        back.setVisible(true);
        table.setModel(new DefaultTableModel(null,new String[]{}));
    }//GEN-LAST:event_sewaMouseClicked

    private void pesanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pesanMouseClicked
        sewa.setForeground(Color.black);
        pesan.setForeground(Color.red);
        bayar.setForeground(Color.black);
        bulan.setVisible(true);
        tahun.setVisible(true);
        print.setVisible(true);
        back.setVisible(true);
        table.setModel(new DefaultTableModel(null,new String[]{}));
    }//GEN-LAST:event_pesanMouseClicked

    private void bayarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bayarMouseClicked
        sewa.setForeground(Color.black);
        pesan.setForeground(Color.black);
        bayar.setForeground(Color.red);
        bulan.setVisible(true);
        tahun.setVisible(true);
        print.setVisible(true);
        back.setVisible(true);
        table.setModel(new DefaultTableModel(null,new String[]{}));
    }//GEN-LAST:event_bayarMouseClicked

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
    private javax.swing.JButton back;
    private javax.swing.JLabel bayar;
    private javax.swing.JButton bulan;
    private javax.swing.JLabel home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel ket;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel pelanggan;
    private javax.swing.JLabel pembayaran;
    private javax.swing.JLabel pemesanan;
    private javax.swing.JLabel penyewaan;
    private javax.swing.JLabel pesan;
    private javax.swing.JButton print;
    private javax.swing.JLabel report;
    private javax.swing.JLabel sewa;
    private javax.swing.JTable table;
    private javax.swing.JButton tahun;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
