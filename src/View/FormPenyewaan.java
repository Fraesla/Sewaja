/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Server.Koneksi;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
import java.awt.event.KeyEvent;
import static java.lang.Boolean.TRUE;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
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
public class FormPenyewaan extends javax.swing.JFrame {

    /**
     * Creates new form FormPenyewaan
     */
    boolean x;
    Connection con;
    ResultSet rs= null;
    PreparedStatement pst=null;
    Controller.penyewaan control;
    public FormPenyewaan() {
        initComponents();
        cbxLapangan.removeAllItems();
        cbxPelanggan.removeAllItems();
        Koneksi server = new Koneksi();
        con=server.getConnection();
        control=new Controller.penyewaan(this);
        tableSewa();
        tableLapangan();
        isiPelanggan();
        unshowed();
    }
    public JTextField getWaktuAkhir() {
        return WaktuAkhir;
    }

    public JTextField getWaktuAwal() {
        return WaktuAwal;
    }

    public JTextField getJamakhir() {
        return jamakhir;
    }

    public JTextField getJamawal() {
        return jamawal;
    }

    public JTextField getMenitakhir() {
        return menitakhir;
    }

    public JTextField getMenitawal() {
        return menitawal;
    }

    public JComboBox<String> getCbxLapangan() {
        return cbxLapangan;
    }

    public JComboBox<String> getCbxPelanggan() {
        return cbxPelanggan;
    }

    public JTable getTableLapangan() {
        return tableLapangan;
    }

    public JTable getTableSewa() {
        return tableSewa;
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
    
    public JTextField getTxtUangMuka() {
        return txtUangMuka;
    }

    public JTextField getTxtKdPemakaian() {
        return txtKdPemakaian;
    }

    public JTextField getTxtSewa() {
        return txtSewa;
    }

    public JLabel getReport() {
        return report;
    }

    public JLabel getA() {
        return a;
    }

    public JLabel getUser() {
        return user;
    }

    public JLabel getKet() {
        return ket;
    }
    
    private void tableLapangan(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Lapangan");
        model.addColumn("Nama Lapangan");
        model.addColumn("Harga Siang");
        model.addColumn("Harga Malam");
        
        try{
            Koneksi k = new Koneksi();
            Connection con = k.getConnection();
            String sql = "Select * from lapangan";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                model.addRow(new Object[] {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4)
                });
                
                Object[] x = new Object[1];
                x[0] = rs.getString(1);
                
                cbxLapangan.addItem(x[0].toString());
            }
            tableLapangan.setModel(model);
        } catch(Exception e){
            System.out.println("Error => "+e);
        }
    }
    
    private void tableCheckLapangan(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Lapangan");
        model.addColumn("Nama Lapangan");
        model.addColumn("Tanggal Main");
        model.addColumn("Jam Awal");
        model.addColumn("Jam Akhir");
        
        try{
            Koneksi k = new Koneksi();
            Connection con = k.getConnection();
            String sql = "Select kdlpg, namalpg, tglmain, jamawal, jamakhir "
                    + "from lapangan join penyewaan using(kdlpg)";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                model.addRow(new Object[] {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5)                    
                });
            }
            tableLapangan.setModel(model);
        } catch(Exception e){
            System.out.println("Error => "+e);
        }
    }
    
    private void tableSewa(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Pemakaian");
        model.addColumn("Kode Lapangan");
        model.addColumn("Kode Pelanggan");
        model.addColumn("Tanggal Main");
        model.addColumn("Bayar Sewa");
        model.addColumn("Jam Akhir");
        model.addColumn("Jam Awal");
        model.addColumn("Uang Muka");
        model.addColumn("Total Sewa");
        
        try{
            Koneksi k = new Koneksi();
            Connection con = k.getConnection();
            String sql = "Select * from penyewaan";
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
            if (rs.last()) {
                kode.setText(rs.getString(1));
            }
            tableSewa.setModel(model);
        } catch(Exception e){
            System.out.println("Error => "+e);
        }
    }
    
    private void isiPelanggan(){
        try{
            Koneksi k = new Koneksi();
            Connection con = k.getConnection();
            String sql = "Select * from pelanggan";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                Object[] x = new Object[1];
                x[0] = rs.getString(1);
                
                cbxPelanggan.addItem(x[0].toString());
            }
        } catch(Exception e){
            System.out.println("Error => "+e);
        }
    }
    private void showed() {
        WaktuAwal.setVisible(true);
        WaktuAkhir.setVisible(true);
        Tanggal.setVisible(true);
        hapus.setVisible(true);
        insert.setText("UPDATE");
        inputsewa.setVisible(true);
    }
    
    private void unshowed() {
        WaktuAwal.setVisible(false);
        WaktuAkhir.setVisible(false);
        Tanggal.setVisible(false);
        hapus.setVisible(false);
        insert.setText("INSERT");
        inputsewa.setVisible(false);
        jLabel15.setText("Form Penyewaan");
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
        jLabel4 = new javax.swing.JLabel();
        ket = new javax.swing.JLabel();
        clear = new javax.swing.JButton();
        menitawal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        WaktuAwal = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableLapangan = new javax.swing.JTable();
        cbxPelanggan = new javax.swing.JComboBox<String>();
        jLabel6 = new javax.swing.JLabel();
        txtKdPemakaian = new javax.swing.JTextField();
        cbxLapangan = new javax.swing.JComboBox<String>();
        txtSewa = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        WaktuAkhir = new javax.swing.JTextField();
        Bulan = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jamawal = new javax.swing.JTextField();
        titik1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jamakhir = new javax.swing.JTextField();
        inputsewa = new javax.swing.JPanel();
        sw = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        titik2 = new javax.swing.JLabel();
        hapus = new javax.swing.JButton();
        Hari = new javax.swing.JSpinner();
        menitakhir = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Tahun = new com.toedter.calendar.JYearChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSewa = new javax.swing.JTable();
        insert = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        Tanggal = new com.toedter.calendar.JDateChooser();
        txtUangMuka = new javax.swing.JTextField();
        kode = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        ceklpg = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        a = new javax.swing.JLabel();
        user = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1152, 688));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel2.setText("PENYEWAAN");
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
        penyewaan.setForeground(new java.awt.Color(255, 0, 0));
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

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Status :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(360, 20, 80, 20);

        ket.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(ket);
        ket.setBounds(430, 20, 80, 20);

        clear.setText("CLEAR");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        getContentPane().add(clear);
        clear.setBounds(650, 560, 80, 30);
        getContentPane().add(menitawal);
        menitawal.setBounds(460, 400, 30, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Daftar Penyewaan Lapangan");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(800, 110, 180, 17);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tanggal Main");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(400, 320, 79, 17);

        WaktuAwal.setEditable(false);
        getContentPane().add(WaktuAwal);
        WaktuAwal.setBounds(500, 400, 110, 30);

        tableLapangan.setModel(new javax.swing.table.DefaultTableModel(
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
        tableLapangan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableLapanganMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableLapangan);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(670, 390, 450, 91);

        cbxPelanggan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih" }));
        getContentPane().add(cbxPelanggan);
        cbxPelanggan.setBounds(400, 280, 203, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Kode Pelanggan");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(400, 260, 98, 20);

        txtKdPemakaian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKdPemakaianKeyPressed(evt);
            }
        });
        getContentPane().add(txtKdPemakaian);
        txtKdPemakaian.setBounds(400, 160, 203, 30);

        cbxLapangan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih" }));
        getContentPane().add(cbxLapangan);
        cbxLapangan.setBounds(400, 220, 203, 30);

        txtSewa.setEditable(false);
        getContentPane().add(txtSewa);
        txtSewa.setBounds(480, 550, 130, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Bayar Sewa");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(400, 550, 71, 30);

        WaktuAkhir.setEditable(false);
        getContentPane().add(WaktuAkhir);
        WaktuAkhir.setBounds(500, 460, 110, 30);

        Bulan.setModel(new javax.swing.SpinnerListModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
        getContentPane().add(Bulan);
        Bulan.setBounds(450, 340, 50, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Kode Pemakaian");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(400, 140, 100, 17);
        getContentPane().add(jamawal);
        jamawal.setBounds(410, 400, 30, 30);

        titik1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        titik1.setText(":");
        getContentPane().add(titik1);
        titik1.setBounds(450, 410, 10, 14);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Daftar Lapangan");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(830, 370, 210, 17);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Jam Awal");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(400, 380, 56, 17);
        getContentPane().add(jamakhir);
        jamakhir.setBounds(410, 460, 30, 30);

        inputsewa.setBackground(new java.awt.Color(255, 255, 255));
        inputsewa.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        inputsewa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputsewaMouseClicked(evt);
            }
        });

        sw.setText("Input Penyewaan");

        javax.swing.GroupLayout inputsewaLayout = new javax.swing.GroupLayout(inputsewa);
        inputsewa.setLayout(inputsewaLayout);
        inputsewaLayout.setHorizontalGroup(
            inputsewaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputsewaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sw)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        inputsewaLayout.setVerticalGroup(
            inputsewaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputsewaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sw)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(inputsewa);
        inputsewa.setBounds(890, 70, 110, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Jam Akhir");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(400, 440, 59, 17);

        titik2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        titik2.setText(":");
        getContentPane().add(titik2);
        titik2.setBounds(450, 470, 10, 14);

        hapus.setText("DELETE");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });
        getContentPane().add(hapus);
        hapus.setBounds(650, 530, 80, 30);

        Hari.setModel(new javax.swing.SpinnerListModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
        getContentPane().add(Hari);
        Hari.setBounds(400, 340, 50, 30);
        getContentPane().add(menitakhir);
        menitakhir.setBounds(460, 460, 30, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Uang Muka");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(400, 490, 68, 17);
        getContentPane().add(Tahun);
        Tahun.setBounds(500, 340, 60, 30);

        tableSewa.setModel(new javax.swing.table.DefaultTableModel(
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
        tableSewa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSewaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableSewa);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(650, 130, 470, 197);

        insert.setText("INSERT");
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });
        getContentPane().add(insert);
        insert.setBounds(650, 490, 80, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Kode Lapangan");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(400, 200, 95, 17);

        Tanggal.setEnabled(false);
        getContentPane().add(Tanggal);
        Tanggal.setBounds(580, 340, 130, 30);

        txtUangMuka.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtUangMukaPropertyChange(evt);
            }
        });
        txtUangMuka.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUangMukaKeyPressed(evt);
            }
        });
        getContentPane().add(txtUangMuka);
        txtUangMuka.setBounds(400, 510, 210, 30);
        getContentPane().add(kode);
        kode.setBounds(1070, 500, 50, 20);

        jLabel24.setText("Kode Pemakaian Terakhir :");
        getContentPane().add(jLabel24);
        jLabel24.setBounds(920, 500, 150, 20);

        ceklpg.setBackground(new java.awt.Color(255, 255, 255));
        ceklpg.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        ceklpg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ceklpgMouseClicked(evt);
            }
        });

        jLabel25.setText("Check Lapangan");

        javax.swing.GroupLayout ceklpgLayout = new javax.swing.GroupLayout(ceklpg);
        ceklpg.setLayout(ceklpgLayout);
        ceklpgLayout.setHorizontalGroup(
            ceklpgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ceklpgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        ceklpgLayout.setVerticalGroup(
            ceklpgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ceklpgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(ceklpg);
        ceklpg.setBounds(1010, 70, 110, 30);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(jLabel15);
        jLabel15.setBounds(390, 80, 240, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Pelanggan (1).png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1240, 648);

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
        new FormReport().setVisible(true);
        dispose();
    }//GEN-LAST:event_reportMouseClicked

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        new FormAwal().setVisible(true);
        dispose();
    }//GEN-LAST:event_logoutMouseClicked

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        control.clear();
    }//GEN-LAST:event_clearActionPerformed

    private void txtKdPemakaianKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKdPemakaianKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            control.getSewa();
            showed();
        }
    }//GEN-LAST:event_txtKdPemakaianKeyPressed

    private void inputsewaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputsewaMouseClicked
        unshowed();
        control.clear();
    }//GEN-LAST:event_inputsewaMouseClicked

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        control.delete();
        tableSewa();
        unshowed();
    }//GEN-LAST:event_hapusActionPerformed

    private void tableSewaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSewaMouseClicked
        try {
            control.onMouseClickTablePenyewaan();
            showed();
            tableSewa.clearSelection();
        }catch(SQLException ex){
            Logger.getLogger(FormPenyewaan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tableSewaMouseClicked

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        if (insert.getText().equals("INSERT")) {
            try {
                control.insert();
            } catch (SQLException ex) {
                Logger.getLogger(FormPenyewaan.class.getName()).log(Level.SEVERE, null, ex);
            }
            tableSewa();
        } else{
            try {
                control.update();
            } catch (SQLException ex) {
                Logger.getLogger(FormPenyewaan.class.getName()).log(Level.SEVERE, null, ex);
            }
            unshowed();
            tableSewa();
        }
    }//GEN-LAST:event_insertActionPerformed

    private void txtUangMukaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtUangMukaPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUangMukaPropertyChange

    private void txtUangMukaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUangMukaKeyPressed
        String kode = cbxLapangan.getSelectedItem().toString();
        int selisih = 0, hargasiang = 0, hargamalam = 0;

        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            try{
                String sql = "Select *from lapangan where kdlpg = '"+kode+"'";
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql);

                while(rs.next()){
                    hargasiang = rs.getInt(3);
                    hargamalam = rs.getInt(4);
                }
            } catch(Exception e){
                System.out.println("Error => "+e);
            }
            if (Objects.equals(Integer.valueOf(menitawal.getText()), Integer.valueOf(menitakhir.getText()))) {
                selisih = Integer.valueOf(jamakhir.getText()) - Integer.valueOf(jamawal.getText());
            }
            int d = Integer.valueOf(txtUangMuka.getText());
            int sewa = 0;
            if (Integer.valueOf(jamawal.getText()) >= 8 && Integer.valueOf(jamawal.getText()) <= 16){
                sewa = (selisih*hargasiang)-d;
            } else if (Integer.valueOf(jamawal.getText()) >= 17 && Integer.valueOf(jamawal.getText()) <= 23){
                sewa = (selisih*hargamalam)-d;
            }
            txtSewa.setText(String.valueOf(sewa));
        }
    }//GEN-LAST:event_txtUangMukaKeyPressed

    private void ceklpgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ceklpgMouseClicked
        if(jLabel25.getText().equalsIgnoreCase("Back")){
            unshowed();
            tableLapangan();
            jLabel25.setText("Check Lapangan");
            jLabel10.setText("Daftar Lapangan");
        }
        else
        {
            unshowed();
            tableCheckLapangan();
            jLabel25.setText("Back");
            jLabel10.setText("Daftar Lapangan yang digunakan");
        }
        
    }//GEN-LAST:event_ceklpgMouseClicked

    private void tableLapanganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableLapanganMouseClicked
        tableLapangan.clearSelection();
    }//GEN-LAST:event_tableLapanganMouseClicked

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
            java.util.logging.Logger.getLogger(FormPenyewaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPenyewaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPenyewaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPenyewaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private com.toedter.calendar.JYearChooser Tahun;
    private com.toedter.calendar.JDateChooser Tanggal;
    private javax.swing.JTextField WaktuAkhir;
    private javax.swing.JTextField WaktuAwal;
    private javax.swing.JLabel a;
    private javax.swing.JComboBox<String> cbxLapangan;
    private javax.swing.JComboBox<String> cbxPelanggan;
    private javax.swing.JPanel ceklpg;
    private javax.swing.JButton clear;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel home;
    private javax.swing.JPanel inputsewa;
    private javax.swing.JButton insert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jamakhir;
    private javax.swing.JTextField jamawal;
    private javax.swing.JLabel ket;
    private javax.swing.JLabel kode;
    private javax.swing.JLabel logout;
    private javax.swing.JTextField menitakhir;
    private javax.swing.JTextField menitawal;
    private javax.swing.JLabel pelanggan;
    private javax.swing.JLabel pembayaran;
    private javax.swing.JLabel pemesanan;
    private javax.swing.JLabel penyewaan;
    private javax.swing.JLabel report;
    private javax.swing.JLabel sw;
    private javax.swing.JTable tableLapangan;
    private javax.swing.JTable tableSewa;
    private javax.swing.JLabel titik1;
    private javax.swing.JLabel titik2;
    private javax.swing.JTextField txtKdPemakaian;
    private javax.swing.JTextField txtSewa;
    private javax.swing.JTextField txtUangMuka;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables

}
