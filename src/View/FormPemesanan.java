/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Server.Koneksi;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class FormPemesanan extends javax.swing.JFrame {

    /**
     * Creates new form FormPemesanan
     */
    Connection con;
    ResultSet rs= null;
    PreparedStatement pst=null;
    Controller.pemesanan control;
    int x;
    boolean y;
    public FormPemesanan() {
        initComponents();
        awal();
        tableDetail();
        tableMenu();
        Koneksi server = new Koneksi();
        con=server.getConnection();
        control=new Controller.pemesanan(this);
        control.clear();
        icon();
    }
    private void icon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
    }


    public JComboBox<String> getCbxPesan() {
        return cbxPesan;
    }
    
    public JSpinner getBulan() {
        return Bulan;
    }

    public JSpinner getHari() {
        return Hari;
    }

    public JDateChooser getTanggal() {
        return Tanggal;
    }

    public JYearChooser getTahun() {
        return Tahun;
    }

    public JTextField getTgl() {
        return tgl;
    }
    

    public JComboBox<String> getCbxPelanggan() {
        return cbxPelanggan;
    }

    public JTable getTableMenuPesan() {
        return tableMenuPesan;
    }

    public JTable getTablePesanan() {
        return tablePesanan;
    }

    public JTextField getTxtIdNota() {
        return txtIdNota;
    }

    public JTextField getTxtJumlah() {
        return txtJumlah;
    }

    public JTextField getTxtSubTotal() {
        return txtSubTotal;
    }

    public JComboBox<String> getCbxPesanan() {
        return cbxPesanan;
    }

    public JTextField getTxtSubTotalPesan() {
        return txtSubTotalPesan;
    }
    
    public JLabel getTambahbrg() {
        return tambahbrg;
    }
    
    public JLabel getA() {
        return a;
    }

    public JLabel getKet() {
        return ket;
    }

    public JLabel getReport() {
        return report;
    }

    public JLabel getUser() {
        return user;
    }
    
    private void awal(){
        cbxPesanan.setVisible(false);
        cbxPelanggan.setVisible(false);
        txtSubTotalPesan.setVisible(false);
        Id.setVisible(false);
        kode.setVisible(false);
        subtotal.setVisible(false);
        pesan.setVisible(false);
        delete.setVisible(false);
        
    
        idd.setVisible(true);
        idd.setText("Id Nota");
        kdm.setVisible(true);
        j.setVisible(true);
        j.setText("Jumlah");
        t.setVisible(true);
        t.setText("SubTotal");
        jLabel1.setText("PEMESANAN");
        txtIdNota.setVisible(true);
        cbxPesan.setVisible(true);
        txtJumlah.setVisible(true);
        txtSubTotal.setVisible(true);
        txtSubTotal.setEnabled(false);
        change.setVisible(true);
        change.setText("Total Pemesanan");
        pesan.setVisible(false);
        brg.setVisible(false);
        nonota.setVisible(true);
        jLabel3.setText("Id Nonota Terakhir :");
        tambahbrg.setVisible(true);
        jLabel15.setText("Form Pesanan");
        submit.setText("INSERT");
        jLabel5.setVisible(false);
        Tanggal.setVisible(false);
        tgl.setVisible(false);
        Hari.setVisible(false);
        Bulan.setVisible(false);
        Tahun.setVisible(false);
        submit.setForeground(Color.white);
        submit.setBackground(Color.green);
        x=1;
    }
    
    private void akhir(){
        idd.setVisible(false);
        kdm.setVisible(false);
        j.setVisible(false);
        t.setVisible(false);
        txtIdNota.setVisible(false);
        cbxPesan.setVisible(false);
        txtJumlah.setVisible(false);
        txtSubTotal.setVisible(false);
        change.setVisible(false);
        delete.setVisible(false);
        
        cbxPesanan.setVisible(true);
        cbxPelanggan.setVisible(true);
        txtSubTotalPesan.setVisible(true);
        Id.setVisible(true);
        kode.setVisible(true);
        subtotal.setVisible(true);
        change.setVisible(true);
        change.setText("Mau memesan?");
        pesan.setVisible(false);
        brg.setVisible(false);
        nonota.setVisible(true);
        jLabel3.setText("Id Nonota Terakhir:");
        tambahbrg.setVisible(true);
        jLabel15.setText("Form Pemesanan");
        jLabel5.setVisible(true);
        Tanggal.setVisible(false);
        tgl.setVisible(false);
        Hari.setVisible(true);
        Bulan.setVisible(true);
        Tahun.setVisible(true);
        x=2;
    }
    
    private void tambahbrg(){
        cbxPesanan.setVisible(false);
        cbxPelanggan.setVisible(false);
        txtSubTotalPesan.setVisible(false);
        Id.setVisible(false);
        kode.setVisible(false);
        subtotal.setVisible(false);
        pesan.setVisible(false);
        delete.setVisible(false);
        
    
        idd.setVisible(true);
        idd.setText("Kode Menu/Barang");
        kdm.setVisible(false);
        j.setVisible(true);
        j.setText("Nama");
        t.setVisible(true);
        t.setText("Harga");
        jLabel1.setText("MENU & BARANG");
        txtIdNota.setVisible(true);
        cbxPesan.setVisible(false);
        txtJumlah.setVisible(true);
        txtSubTotal.setVisible(true);
        txtSubTotal.setEnabled(true);
        change.setVisible(true);
        change.setText("Mau Memesan ?");
        pesan.setVisible(true);
        pesan.setText("Total Pemesanan");
        control.clear();
        brg.setVisible(true);
        nonota.setVisible(false);
        jLabel3.setText("Kode Barang Terakhir :");
        jLabel15.setText("Form Barang");
        jLabel5.setVisible(false);
        Tanggal.setVisible(false);
        tgl.setVisible(false);
        Hari.setVisible(false);
        Bulan.setVisible(false);
        Tahun.setVisible(false);
        x=3;
    }
    
    private void isiPelanggan(){
        cbxPelanggan.removeAllItems();
        try{
            Koneksi k = new Koneksi();
            Connection con = k.getConnection();
            String sql = "Select *from pelanggan";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                Object[] x = new Object[1];
                x[0] = rs.getString(1);
                
                cbxPelanggan.addItem(x[0].toString());
            }
        } catch(Exception e){
        }
    }
    
    private void tablePesan(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id Nota");
        model.addColumn("Kode Pelanggan");
        model.addColumn("Tanggal Pesan");
        model.addColumn("SubTotal Pesan");
        
        try{
            Koneksi k = new Koneksi();
            Connection con = k.getConnection();
            String sql = "Select *from pemesanan";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                model.addRow(new Object[] {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4)
                });
            }
            tableMenuPesan.setModel(model);
        } catch(Exception e){
        }
    }
    
    private void tableDetail(){
        cbxPesanan.removeAllItems();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id Nota");
        model.addColumn("Kode Menu/Barang");
        model.addColumn("Jumlah");
        model.addColumn("Total Harga");
        
        try{            
            Koneksi k = new Koneksi();
            Connection con = k.getConnection();
            String sql = "Select *from pesanan";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            Object[] z = new Object[4];
            z[0]="";
            
            while(rs.next()){
                model.addRow(new Object[] {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4)
                });
                
                if (z[0].equals(rs.getString(1))) {
                    z[0]=rs.getString(1);
                }else{
                    cbxPesanan.addItem(rs.getString(1));
                    z[0]=rs.getString(1);
                }                                
            }
            if (rs.last()){
                nonota.setText(rs.getString(1));
            }
            tablePesanan.setModel(model);
        } catch(Exception e){
        }
    }
    
    private void tableMenu(){
        cbxPesan.removeAllItems();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Menu/Barang");
        model.addColumn("Nama");
        model.addColumn("Harga");
        
        try{
            Koneksi k = new Koneksi();
            Connection con = k.getConnection();
            String sql = "Select *from barang";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                model.addRow(new Object[] {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3)
                });
                
                Object[] x = new Object[1];
                x[0] = rs.getString(1);
                
                cbxPesan.addItem(x[0].toString());
            }
            if (rs.last()) {
                brg.setText(rs.getString(1));
            }
            tableMenuPesan.setModel(model);
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

        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        home = new javax.swing.JLabel();
        pelanggan = new javax.swing.JLabel();
        penyewaan = new javax.swing.JLabel();
        pemesanan = new javax.swing.JLabel();
        pembayaran = new javax.swing.JLabel();
        report = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbxPesanan = new javax.swing.JComboBox<String>();
        cbxPelanggan = new javax.swing.JComboBox<String>();
        kode = new javax.swing.JLabel();
        kdm = new javax.swing.JLabel();
        txtIdNota = new javax.swing.JTextField();
        clear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePesanan = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        txtSubTotalPesan = new javax.swing.JTextField();
        subtotal = new javax.swing.JLabel();
        idd = new javax.swing.JLabel();
        pesan = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        txtJumlah = new javax.swing.JTextField();
        judulMenuPesan = new javax.swing.JLabel();
        delete = new javax.swing.JButton();
        j = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        change = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableMenuPesan = new javax.swing.JTable();
        Id = new javax.swing.JLabel();
        t = new javax.swing.JLabel();
        nonota = new javax.swing.JLabel();
        brg = new javax.swing.JLabel();
        tambahbrg = new javax.swing.JLabel();
        ket = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Hari = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        Bulan = new javax.swing.JSpinner();
        Tahun = new com.toedter.calendar.JYearChooser();
        tgl = new javax.swing.JTextField();
        cbxPesan = new javax.swing.JComboBox<String>();
        jLabel1 = new javax.swing.JLabel();
        Tanggal = new com.toedter.calendar.JDateChooser();
        a = new javax.swing.JLabel();
        user = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1152, 688));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel2.setText("PEMESANAN");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 150, 250, 50);

        jLabel13.setText("-----------------------------------------");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(20, 190, 170, 14);

        home.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        home.setText("Home");
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });
        getContentPane().add(home);
        home.setBounds(20, 210, 70, 20);

        pelanggan.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        pelanggan.setText("Pelanggan");
        pelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pelangganMouseClicked(evt);
            }
        });
        getContentPane().add(pelanggan);
        pelanggan.setBounds(20, 250, 130, 30);

        penyewaan.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        penyewaan.setText("Penyewaan");
        penyewaan.setMaximumSize(new java.awt.Dimension(109, 29));
        penyewaan.setMinimumSize(new java.awt.Dimension(109, 29));
        penyewaan.setPreferredSize(new java.awt.Dimension(109, 29));
        penyewaan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                penyewaanMouseClicked(evt);
            }
        });
        getContentPane().add(penyewaan);
        penyewaan.setBounds(20, 290, 140, 30);

        pemesanan.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        pemesanan.setForeground(new java.awt.Color(255, 0, 0));
        pemesanan.setText("Pemesanan");
        pemesanan.setMaximumSize(new java.awt.Dimension(109, 29));
        pemesanan.setMinimumSize(new java.awt.Dimension(109, 29));
        pemesanan.setPreferredSize(new java.awt.Dimension(109, 29));
        pemesanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pemesananMouseClicked(evt);
            }
        });
        getContentPane().add(pemesanan);
        pemesanan.setBounds(20, 330, 130, 30);

        pembayaran.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        pembayaran.setText("Pembayaran");
        pembayaran.setMaximumSize(new java.awt.Dimension(109, 29));
        pembayaran.setMinimumSize(new java.awt.Dimension(109, 29));
        pembayaran.setPreferredSize(new java.awt.Dimension(109, 29));
        pembayaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pembayaranMouseClicked(evt);
            }
        });
        getContentPane().add(pembayaran);
        pembayaran.setBounds(20, 370, 140, 30);

        report.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        report.setText("Report");
        report.setMaximumSize(new java.awt.Dimension(109, 29));
        report.setMinimumSize(new java.awt.Dimension(109, 29));
        report.setPreferredSize(new java.awt.Dimension(109, 29));
        report.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportMouseClicked(evt);
            }
        });
        getContentPane().add(report);
        report.setBounds(20, 410, 80, 30);

        logout.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        logout.setText("Keluar");
        logout.setMaximumSize(new java.awt.Dimension(109, 29));
        logout.setMinimumSize(new java.awt.Dimension(109, 29));
        logout.setPreferredSize(new java.awt.Dimension(109, 29));
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });
        getContentPane().add(logout);
        logout.setBounds(20, 450, 70, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Status :");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(380, 20, 80, 20);

        cbxPesanan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih" }));
        cbxPesanan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxPesananIdNotaChange(evt);
            }
        });
        getContentPane().add(cbxPesanan);
        cbxPesanan.setBounds(380, 170, 160, 30);

        cbxPelanggan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih" }));
        cbxPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPelangganActionPerformed(evt);
            }
        });
        getContentPane().add(cbxPelanggan);
        cbxPelanggan.setBounds(380, 230, 160, 30);

        kode.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        kode.setText("Kode Pelanggan");
        getContentPane().add(kode);
        kode.setBounds(380, 210, 127, 22);

        kdm.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        kdm.setText("Kode Menu / Barang");
        getContentPane().add(kdm);
        kdm.setBounds(380, 210, 163, 22);
        getContentPane().add(txtIdNota);
        txtIdNota.setBounds(380, 170, 160, 30);

        clear.setBackground(new java.awt.Color(0, 0, 0));
        clear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clear.setForeground(new java.awt.Color(255, 255, 255));
        clear.setText("CLEAR");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        getContentPane().add(clear);
        clear.setBounds(390, 440, 90, 30);

        tablePesanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablePesanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePesananMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePesanan);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(650, 140, 460, 129);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Daftar Detail Pemesanan");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(800, 110, 149, 17);

        submit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        submit.setText("INSERT");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        getContentPane().add(submit);
        submit.setBounds(390, 400, 90, 30);

        txtSubTotalPesan.setEditable(false);
        txtSubTotalPesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubTotalPesanActionPerformed(evt);
            }
        });
        getContentPane().add(txtSubTotalPesan);
        txtSubTotalPesan.setBounds(380, 350, 160, 30);

        subtotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        subtotal.setText("SubTotal Pesan");
        getContentPane().add(subtotal);
        subtotal.setBounds(380, 330, 122, 22);

        idd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        idd.setText("ID Nota");
        getContentPane().add(idd);
        idd.setBounds(380, 150, 160, 22);

        pesan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        pesan.setText("Pesan?");
        pesan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pesanMouseClicked(evt);
            }
        });
        getContentPane().add(pesan);
        pesan.setBounds(430, 540, 110, 14);

        txtSubTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubTotalActionPerformed(evt);
            }
        });
        getContentPane().add(txtSubTotal);
        txtSubTotal.setBounds(380, 350, 160, 30);

        txtJumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtJumlahKeyPressed(evt);
            }
        });
        getContentPane().add(txtJumlah);
        txtJumlah.setBounds(380, 290, 160, 30);

        judulMenuPesan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        judulMenuPesan.setText("Daftar Menu & Barang");
        getContentPane().add(judulMenuPesan);
        judulMenuPesan.setBounds(810, 330, 135, 17);

        delete.setBackground(new java.awt.Color(255, 0, 0));
        delete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        getContentPane().add(delete);
        delete.setBounds(500, 420, 90, 30);

        j.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        j.setText("Jumlah");
        getContentPane().add(j);
        j.setBounds(380, 270, 56, 22);

        jLabel3.setText("ID Nota Terakhir :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(920, 550, 130, 20);

        change.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        change.setText("Untuk Siapa?");
        change.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeMouseClicked(evt);
            }
        });
        getContentPane().add(change);
        change.setBounds(430, 490, 120, 20);

        tableMenuPesan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableMenuPesan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMenuPesanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableMenuPesan);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(650, 360, 460, 137);

        Id.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Id.setText("ID Nota");
        getContentPane().add(Id);
        Id.setBounds(380, 150, 62, 22);

        t.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t.setText("SubTotal");
        getContentPane().add(t);
        t.setBounds(380, 330, 70, 22);
        getContentPane().add(nonota);
        nonota.setBounds(1060, 550, 50, 20);
        getContentPane().add(brg);
        brg.setBounds(1060, 550, 50, 20);

        tambahbrg.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tambahbrg.setText("Tambah Menu & Barang");
        tambahbrg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tambahbrgMouseClicked(evt);
            }
        });
        getContentPane().add(tambahbrg);
        tambahbrg.setBounds(940, 500, 170, 30);

        ket.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(ket);
        ket.setBounds(450, 20, 80, 20);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(jLabel15);
        jLabel15.setBounds(390, 80, 240, 40);

        Hari.setModel(new javax.swing.SpinnerListModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
        getContentPane().add(Hari);
        Hari.setBounds(380, 290, 50, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Tanggal Pesan");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(380, 270, 120, 22);

        Bulan.setModel(new javax.swing.SpinnerListModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
        getContentPane().add(Bulan);
        Bulan.setBounds(430, 290, 50, 30);
        getContentPane().add(Tahun);
        Tahun.setBounds(480, 290, 60, 30);

        tgl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tglKeyPressed(evt);
            }
        });
        getContentPane().add(tgl);
        tgl.setBounds(560, 290, 130, 30);

        cbxPesan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih" }));
        getContentPane().add(cbxPesan);
        cbxPesan.setBounds(380, 230, 160, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Pelanggan (1).png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1152, 648);

        Tanggal.setEnabled(false);
        getContentPane().add(Tanggal);
        Tanggal.setBounds(560, 290, 130, 30);

        a.setText("jLabel2");
        getContentPane().add(a);
        a.setBounds(20, 70, 34, 14);

        user.setText("jLabel2");
        getContentPane().add(user);
        user.setBounds(0, 0, 34, 14);

        pack();
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
            utama.getjEdit().setVisible(false);
            utama.getjInsert().setBackground(Color.orange);
            utama.getjLabel4().setForeground(Color.white);
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

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        new FormAwal().setVisible(true);
        dispose();
    }//GEN-LAST:event_logoutMouseClicked

    private void reportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportMouseClicked
        FormReport report = new FormReport();  
        report.getA().setText(a.getText());
        report.getUser().setText(user.getText());
        report.setVisible(true);
        dispose();
    }//GEN-LAST:event_reportMouseClicked

    private void cbxPesananIdNotaChange(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxPesananIdNotaChange
        int z = 0;
        try{
            Koneksi k = new Koneksi();
            Connection con = k.getConnection();
            String sql = "Select *from pesanan where idnota='"+cbxPesanan.getSelectedItem().toString()+"'";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while(rs.next()){
                rs.getString(1);
                rs.getString(2);
                rs.getString(3);
                rs.getString(4);

                z = z+rs.getInt(4);

            }
            txtSubTotalPesan.setText(String.valueOf(z));
        } catch(Exception e){
        }
    }//GEN-LAST:event_cbxPesananIdNotaChange

    private void tablePesananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePesananMouseClicked
        try {
            awal();
            tableMenu();
            control.onMouseClickTablePesanan();
            tablePesanan.clearSelection();
            judulMenuPesan.setText("Daftar Menu & Barang");
            pesan.setVisible(false);
            submit.setForeground(Color.white);
            submit.setBackground(Color.orange);
            submit.setText("UPDATE");
            txtIdNota.setEnabled(false);
            delete.setVisible(true);            
            y = true;
        }catch(SQLException ex) {
            Logger.getLogger(FormPemesanan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tablePesananMouseClicked

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        if (submit.getText().equals("INSERT")) {
            switch (x) {
                case 1:
                    control.insertPesanan();
                    control.clear();
                    tableDetail();
                    awal();
                    break;
                case 2:
                    int z = JOptionPane.showConfirmDialog(this, "Yakin Data sudah Lengkap ?", "Insert Data", JOptionPane.OK_CANCEL_OPTION);
                    if(z == 0){
                        control.insertPemesanan();
                        control.clear();
                        tablePesan();
                        awal();
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "Insert Pemesanan Anda di Cancel");
                    }
                    break;
                case 3:
                    control.insertBarang();
                    control.clear();
                    tableMenu();
                    awal();
                    break;
                default:
                    break;
            }
        } else{
            switch (x) {
                case 1:
                    control.updatePesanan();
                    txtIdNota.setEnabled(true);
                    control.clear();
                    tableDetail();
                    awal();
                    submit.setForeground(Color.white);
                    submit.setBackground(Color.green);
                    submit.setText("INSERT");
                    break;
                case 2:
                    control.updatePemesanan();
                    txtIdNota.setEnabled(true);
                    control.clear();
                    tablePesan();
                    awal();
                    cbxPesanan.setEnabled(true);
                    submit.setForeground(Color.white);
                    submit.setBackground(Color.green);
                    submit.setText("INSERT");
                    break;
                case 3:
                    control.updateBarang();
                    txtIdNota.setEnabled(true);
                    control.clear();
                    tableMenu();
                    awal();
                    submit.setForeground(Color.white);
                    submit.setBackground(Color.green);
                    submit.setText("INSERT");
                    break;
                default:
                    break;
            }
        }
    }//GEN-LAST:event_submitActionPerformed

    private void txtSubTotalPesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubTotalPesanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubTotalPesanActionPerformed

    private void pesanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pesanMouseClicked
        if(pesan.getText().equalsIgnoreCase("Total Pemesanan"))
        {
            akhir();
            isiPelanggan();
            tablePesan();
            judulMenuPesan.setText("Daftar Pemesanan");
            control.clear();
        }
        else{
            awal();
            tableMenu();
            judulMenuPesan.setText("Daftar Menu & Barang");
            control.clear();
        }
        submit.setForeground(Color.white);
        submit.setBackground(Color.green);
        submit.setText("INSERT");
    }//GEN-LAST:event_pesanMouseClicked

    private void txtSubTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubTotalActionPerformed

    private void txtJumlahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahKeyPressed
        int z = 0;
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            int jum = Integer.parseInt(txtJumlah.getText());
            try{
                Koneksi k = new Koneksi();
                Connection con = k.getConnection();
                String sql = "Select * from barang where kdBrg='"
                        +cbxPesan.getSelectedItem().toString()+"'";
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql);

                while(rs.next()){
                    rs.getString(1);
                    rs.getString(2);
                    rs.getString(3);

                    z = rs.getInt(3)*jum;
                }
                txtSubTotal.setText(String.valueOf(z));
            } catch(Exception e){
            }
        }
    }//GEN-LAST:event_txtJumlahKeyPressed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int z = JOptionPane.showConfirmDialog(this, "Yakin Data mau Di Hapus?", "Delete Data", JOptionPane.OK_CANCEL_OPTION);
        if(z == 0){
            if (y == true) {
                txtIdNota.setEnabled(true);
                control.deletePesanan();
                tableDetail();
                awal();
            } else{
                if (judulMenuPesan.getText().equalsIgnoreCase("Daftar Pemesanan")) {
                    txtIdNota.setEnabled(true);
                    control.deletePemesanan();
                    tablePesan();
                    awal();
                } else if (judulMenuPesan.getText().equalsIgnoreCase("Daftar Menu & Barang")){
                    txtIdNota.setEnabled(true);
                    control.deleteBarang();
                    tableMenu();
                    awal();
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Data tidak jadi dihapus");
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void changeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changeMouseClicked
        if(change.getText().equalsIgnoreCase("Total Pemesanan"))
        {
            akhir();
            isiPelanggan();
            tablePesan();
            judulMenuPesan.setText("Daftar Pemesanan");
            control.clear();
            cbxPesanan.setEnabled(true);
        }
        else{
            awal();
            tableMenu();
            judulMenuPesan.setText("Daftar Menu & Barang");
            control.clear();
            cbxPesanan.setEnabled(true);
        }
        submit.setForeground(Color.white);
        submit.setBackground(Color.green);
        submit.setText("INSERT");
    }//GEN-LAST:event_changeMouseClicked

    private void tableMenuPesanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMenuPesanMouseClicked
        if (judulMenuPesan.getText().equalsIgnoreCase("Daftar Pemesanan")) {
            try {
                akhir();
//                Tanggal.setVisible(true);
                tgl.setVisible(true);
                tgl.setEnabled(false);
                control.onMouseClickTablePemesanan();
                tableMenuPesan.clearSelection();
                tambahbrg.setVisible(true);
                pesan.setVisible(false);
                delete.setVisible(true);
                cbxPesanan.setEnabled(false);
                submit.setForeground(Color.white);
                submit.setBackground(Color.orange);
                submit.setText("UPDATE");
                txtIdNota.setEnabled(false);
            } catch (SQLException ex) {
                Logger.getLogger(FormPemesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (judulMenuPesan.getText().equalsIgnoreCase("Daftar Menu & Barang")){
            try {
                tambahbrg();
                control.onMouseClickTableBarang();
                tableMenuPesan.clearSelection();
                tambahbrg.setVisible(false);
                delete.setVisible(true);
                submit.setText("UPDATE");
                submit.setForeground(Color.white);
                submit.setBackground(Color.orange);
            } catch (SQLException ex) {
                Logger.getLogger(FormPemesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        y = false;
    }//GEN-LAST:event_tableMenuPesanMouseClicked

    private void tambahbrgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahbrgMouseClicked
        tambahbrg();
        judulMenuPesan.setText("Daftar Menu & Barang");
        tableMenu();
        tambahbrg.setVisible(false);
        control.clear();
    }//GEN-LAST:event_tambahbrgMouseClicked

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        control.clear();
        submit.setText("INSERT");
        txtIdNota.setEnabled(true);
        cbxPesanan.setEnabled(true);
        tgl.setVisible(false);
        submit.setForeground(Color.white);
        submit.setBackground(Color.green);
        delete.setVisible(false);
        if(x==3){
            tambahbrg.setVisible(false);
            pesan.setVisible(true);
        }
        else{
            tambahbrg.setVisible(true);
            pesan.setVisible(false);
        }
    }//GEN-LAST:event_clearActionPerformed

    private void tglKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tglKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tglKeyPressed

    private void cbxPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPelangganActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormPemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAwal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner Bulan;
    private javax.swing.JSpinner Hari;
    private javax.swing.JLabel Id;
    private com.toedter.calendar.JYearChooser Tahun;
    private com.toedter.calendar.JDateChooser Tanggal;
    private javax.swing.JLabel a;
    private javax.swing.JLabel brg;
    private javax.swing.JComboBox<String> cbxPelanggan;
    private javax.swing.JComboBox<String> cbxPesan;
    private javax.swing.JComboBox<String> cbxPesanan;
    private javax.swing.JLabel change;
    private javax.swing.JButton clear;
    private javax.swing.JButton delete;
    private javax.swing.JLabel home;
    private javax.swing.JLabel idd;
    private javax.swing.JLabel j;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel judulMenuPesan;
    private javax.swing.JLabel kdm;
    private javax.swing.JLabel ket;
    private javax.swing.JLabel kode;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel nonota;
    private javax.swing.JLabel pelanggan;
    private javax.swing.JLabel pembayaran;
    private javax.swing.JLabel pemesanan;
    private javax.swing.JLabel penyewaan;
    private javax.swing.JLabel pesan;
    private javax.swing.JLabel report;
    private javax.swing.JButton submit;
    private javax.swing.JLabel subtotal;
    private javax.swing.JLabel t;
    private javax.swing.JTable tableMenuPesan;
    private javax.swing.JTable tablePesanan;
    private javax.swing.JLabel tambahbrg;
    private javax.swing.JTextField tgl;
    private javax.swing.JTextField txtIdNota;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtSubTotalPesan;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
