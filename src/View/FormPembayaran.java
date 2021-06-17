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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class FormPembayaran extends javax.swing.JFrame {

    /**
     * Creates new form FormPembayaran
     */
    Connection con;
    ResultSet rs= null;
    PreparedStatement pst=null;
    Controller.pembayaran control;
    DAO.pemesanan dataPesan;
    Model.pemesanan pesan;
    DAO.penyewaan dataSewa;
    Model.penyewaan sewa;
    public FormPembayaran() {
        initComponents();
        cbxPemesanan.removeAllItems();
        cbxPenyewaan.removeAllItems();
        tableBayar();
        tablePesan();
        tableSewa();
        Koneksi server = new Koneksi();
        con=server.getConnection();
        control=new Controller.pembayaran(this);
        control.clear();
        dataPesan = new DAO.pemesanan();
        dataSewa = new DAO.penyewaan();
        delete.setVisible(false);
        jLabel16.setText("Form Pembayaran");
        insert.setForeground(Color.white);
        insert.setBackground(Color.green);
        icon();
    }
    private void icon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
    }
    private void tablePesan(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id Nota");
        model.addColumn("Kode Pelanggan");
        model.addColumn("Sub Total Pesan");
        
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
                    rs.getString(3)
                });
                
                Object[] x = new Object[1];
                x[0] = rs.getString(1);
                
                cbxPemesanan.addItem(x[0].toString());
            }
            tablePesan.setModel(model);
        } catch(Exception e){
            System.out.println("Error => "+e);
        }
    }
    
    private void tableSewa(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Pemakaian");
        model.addColumn("Kode Pelanggan");
        model.addColumn("Sub Total Sewa");
        
        try{
            Koneksi k = new Koneksi();
            Connection con = k.getConnection();
            String sql = "Select *from penyewaan";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                model.addRow(new Object[] {
                    rs.getString(1),
                    rs.getString(3),
                    rs.getString(8)
                });
                
                Object[] x = new Object[1];
                x[0] = rs.getString(1);
                
                cbxPenyewaan.addItem((String) x[0]);
            }
            tableSewa.setModel(model);
        } catch(Exception e){
            System.out.println("Error => "+e);
        }
    }
    
    private void tableBayar(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id Transaksi");
        model.addColumn("Id Nota");
        model.addColumn("Kode Pemakaian");
        model.addColumn("Total Bayar");
        
        try{
            Koneksi k = new Koneksi();
            Connection con = k.getConnection();
            String sql = "Select *from pembayaran";
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
            if (rs.last()) {
                idtrans.setText(rs.getString(1));
            }
            tableBayar.setModel(model);
        } catch(Exception e){
            System.out.println("Error => "+e);
        }
    }
    
    public JComboBox<String> getCbxPemesanan() {
        return cbxPemesanan;
    }

    public JComboBox<String> getCbxPenyewaan() {
        return cbxPenyewaan;
    }

    public JTable getTableBayar() {
        return tableBayar;
    }

    public JTable getTablePesan() {
        return tablePesan;
    }

    public JTable getTableSewa() {
        return tableSewa;
    }

    public JTextField getTxtIdTrans() {
        return txtIdTrans;
    }

    public JTextField getTxtSubTotalPesan() {
        return txtSubTotalPesan;
    }

    public JTextField getTxtSubTotalSewa() {
        return txtSubTotalSewa;
    }

    public JTextField getIntTotal() {
        return IntTotal;
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
        jLabel10 = new javax.swing.JLabel();
        ket = new javax.swing.JLabel();
        delete = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        insert = new javax.swing.JButton();
        IntTotal = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableBayar = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        idtrans = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableSewa = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePesan = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtSubTotalPesan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbxPemesanan = new javax.swing.JComboBox<String>();
        jLabel4 = new javax.swing.JLabel();
        txtSubTotalSewa = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cbxPenyewaan = new javax.swing.JComboBox<String>();
        jLabel9 = new javax.swing.JLabel();
        txtIdTrans = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        a = new javax.swing.JLabel();
        user = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1152, 688));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel2.setText("PEMBAYARAN");
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
        pembayaran.setForeground(new java.awt.Color(255, 0, 0));
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

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Status :");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(380, 20, 80, 20);

        ket.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(ket);
        ket.setBounds(450, 20, 80, 20);

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
        delete.setBounds(450, 500, 90, 25);

        hapus.setBackground(new java.awt.Color(0, 0, 0));
        hapus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        hapus.setForeground(new java.awt.Color(255, 255, 255));
        hapus.setText("CLEAR");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });
        getContentPane().add(hapus);
        hapus.setBounds(500, 470, 80, 25);

        insert.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        insert.setText("INSERT");
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });
        getContentPane().add(insert);
        insert.setBounds(410, 470, 90, 25);
        getContentPane().add(IntTotal);
        IntTotal.setBounds(420, 400, 160, 30);

        tableBayar.setModel(new javax.swing.table.DefaultTableModel(
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
        tableBayar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableBayarMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableBayar);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(620, 450, 494, 151);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Daftar Pembayaran");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(800, 420, 130, 17);

        jLabel12.setText("ID Transaksi Terakhir :");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(920, 610, 140, 20);
        getContentPane().add(idtrans);
        idtrans.setBounds(1060, 610, 50, 20);

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
        jScrollPane2.setViewportView(tableSewa);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(620, 270, 490, 129);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Daftar Penyewaan");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(810, 240, 112, 17);

        tablePesan.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePesan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePesanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePesan);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(630, 90, 490, 129);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Daftar Pemesanan");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(820, 60, 112, 17);

        txtSubTotalPesan.setEditable(false);
        getContentPane().add(txtSubTotalPesan);
        txtSubTotalPesan.setBounds(420, 350, 160, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Total Bayar");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(420, 380, 69, 17);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Sub Total Pesan");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(420, 320, 98, 17);

        cbxPemesanan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxPemesananItemStateChanged(evt);
            }
        });
        cbxPemesanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxPemesananMouseClicked(evt);
            }
        });
        getContentPane().add(cbxPemesanan);
        cbxPemesanan.setBounds(420, 290, 160, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("ID Nota");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(420, 270, 47, 17);

        txtSubTotalSewa.setEditable(false);
        getContentPane().add(txtSubTotalSewa);
        txtSubTotalSewa.setBounds(420, 240, 160, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Sub Total Sewa");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(420, 220, 94, 17);

        cbxPenyewaan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxPenyewaanMouseClicked(evt);
            }
        });
        cbxPenyewaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPenyewaanActionPerformed(evt);
            }
        });
        getContentPane().add(cbxPenyewaan);
        cbxPenyewaan.setBounds(420, 190, 160, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Kode Pemakaian");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(420, 170, 100, 17);
        getContentPane().add(txtIdTrans);
        txtIdTrans.setBounds(420, 140, 160, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("ID Transaksi");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(420, 120, 74, 17);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(jLabel16);
        jLabel16.setBounds(390, 70, 240, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Pelanggan (1).png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1152, 648);

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
      
    }//GEN-LAST:event_pembayaranMouseClicked

    private void reportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportMouseClicked
        FormReport report = new FormReport();  
        report.getA().setText(a.getText());
        report.getUser().setText(user.getText());
        report.setVisible(true);
        dispose();
    }//GEN-LAST:event_reportMouseClicked

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
       new FormAwal().setVisible(true);
       dispose();
    }//GEN-LAST:event_logoutMouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int z = JOptionPane.showConfirmDialog(this, "Yakin Data mau Di Hapus?", "Delete Data", JOptionPane.OK_CANCEL_OPTION);
        if(z == 0){
            control.delete();
            insert.setText("INSERT");
            insert.setForeground(Color.white);
            insert.setBackground(Color.green);
            delete.setVisible(false);
            tableBayar();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Data tidak jadi dihapus");
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        if (insert.getText().equals("INSERT")) {
            try {
                control.insert();
            }catch(SQLException ex) {
                Logger.getLogger(FormPembayaran.class.getName()).log(Level.SEVERE, null, ex);
            }
            tableBayar();
        } else{
            try {
                control.update();
                insert.setText("INSERT");
                insert.setForeground(Color.white);
                insert.setBackground(Color.green);
                delete.setVisible(false);
                txtIdTrans.setEnabled(true);
            } catch (SQLException ex) {
                Logger.getLogger(FormPembayaran.class.getName()).log(Level.SEVERE, null, ex);
            }
            tableBayar();
            delete.setVisible(false);
        }
    }//GEN-LAST:event_insertActionPerformed

    private void tableBayarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBayarMouseClicked
        try {
            control.onMouseClickTableBayar();
            insert.setText("UPDATE");
            insert.setForeground(Color.white);
            insert.setBackground(Color.orange);
            tableBayar.clearSelection();
            delete.setVisible(true);
            txtIdTrans.setEnabled(false);
        } catch (SQLException ex) {
            Logger.getLogger(FormPembayaran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tableBayarMouseClicked

    private void cbxPemesananItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxPemesananItemStateChanged

    }//GEN-LAST:event_cbxPemesananItemStateChanged

    private void cbxPemesananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxPemesananMouseClicked
        String id = cbxPemesanan.getSelectedItem().toString();
        try {
            pesan = new Model.pemesanan();
            pesan = dataPesan.getPemesanan(id);

            txtSubTotalPesan.setText(String.valueOf(pesan.totalPesan));
        }catch(SQLException ex){
            Logger.getLogger(FormPembayaran.class.getName()).log(Level.SEVERE, null, ex);
        }

        int a = Integer.valueOf(txtSubTotalPesan.getText());
        int b = Integer.valueOf(txtSubTotalSewa.getText());
        int total = a + b;
        IntTotal.setText(String.valueOf(total));
    }//GEN-LAST:event_cbxPemesananMouseClicked

    private void cbxPenyewaanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxPenyewaanMouseClicked
        String id = cbxPenyewaan.getSelectedItem().toString();
        try {
            sewa = new Model.penyewaan();
            sewa = dataSewa.getSewa(id);

            txtSubTotalSewa.setText(String.valueOf(sewa.bayasewa));
        }catch(SQLException ex) {
            Logger.getLogger(FormPembayaran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbxPenyewaanMouseClicked

    private void cbxPenyewaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPenyewaanActionPerformed

    }//GEN-LAST:event_cbxPenyewaanActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
       control.clear();
       delete.setVisible(false);
       insert.setText("INSERT");
       insert.setForeground(Color.white);
       insert.setBackground(Color.green);
    }//GEN-LAST:event_hapusActionPerformed

    private void tablePesanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePesanMouseClicked
        tablePesan.clearSelection();
    }//GEN-LAST:event_tablePesanMouseClicked

    private void tableSewaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSewaMouseClicked
       tableSewa.clearSelection();
    }//GEN-LAST:event_tableSewaMouseClicked

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
            java.util.logging.Logger.getLogger(FormPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JTextField IntTotal;
    private javax.swing.JLabel a;
    private javax.swing.JComboBox<String> cbxPemesanan;
    private javax.swing.JComboBox<String> cbxPenyewaan;
    private javax.swing.JButton delete;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel home;
    private javax.swing.JLabel idtrans;
    private javax.swing.JButton insert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel ket;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel pelanggan;
    private javax.swing.JLabel pembayaran;
    private javax.swing.JLabel pemesanan;
    private javax.swing.JLabel penyewaan;
    private javax.swing.JLabel report;
    private javax.swing.JTable tableBayar;
    private javax.swing.JTable tablePesan;
    private javax.swing.JTable tableSewa;
    private javax.swing.JTextField txtIdTrans;
    private javax.swing.JTextField txtSubTotalPesan;
    private javax.swing.JTextField txtSubTotalSewa;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
