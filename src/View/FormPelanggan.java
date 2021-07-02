/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Server.Koneksi;
import java.awt.Color;
import java.awt.Toolkit;
import static java.lang.Boolean.TRUE;
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
public class FormPelanggan extends javax.swing.JFrame {

    /**
     * Creates new form FoemMember
     */
    boolean x;
    boolean y;
    Connection con;
    ResultSet rs= null;
    PreparedStatement pst=null;
    Controller.pelanggan control;
    public FormPelanggan() {
        initComponents();
        Koneksi server = new Koneksi();
        con=server.getConnection();
        change2plg();
        control=new Controller.pelanggan(this);
        tablePelanggan();
        tableMember();
        control.PelangganTabel();
        control.MemberTabel();
        btnDelete.setVisible(false);
        comboBox();
        icon();
    }
    private void icon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
    }
    private void tablePelanggan(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Pelanggan");
        model.addColumn("Nama Pelanggan");
        model.addColumn("Id Member");
        model.addColumn("No. Telp");
        TablePelanggan.setModel(model);
    }
    
    private void tableMember(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id Member");
        model.addColumn("Nama Member");
        model.addColumn("No. Telp");
        model.addColumn("Alamat");
        TableMember.setModel(model);
    }
    private void comboBox()
    {
        cbxMember.removeAllItems();
        try{
            String sql = "Select * from member";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next()){
                String name=rs.getString("idMem");
                cbxMember.addItem(name);
            }
        }
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(null, e);
        }
    }

    public JLabel getMemberkd() {
        return memberkd;
    }

    public JLabel getPelanggankd() {
        return pelanggankd;
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

    public JLabel getReport() {
        return report;
    }
  
    private void change2member(){
        kode.setText("Id Member");
        nama.setText("Nama Member");
        idtelp.setText("No. Telp");
        telpalamat.setText("Alamat");
        jLabel1.setText("MEMBER");
        cbxMember.setVisible(false);
        txtIdTelp.setVisible(true);
        btnInsert.setText("INSERT");
        btnInsert.setBackground(Color.green);
        btnInsert.setForeground(Color.white);
        btnDelete.setVisible(false);
        form1.setVisible(true);
        form1.setText("Input Pelanggan");
        form2.setVisible(false);
        txtKode.setEnabled(true);
        txtKode.requestFocus();
        jLabel3.setText("Form Member");
        jLabel5.setText("Id Member Terakhir :");
        pelanggankd.setVisible(false);
        memberkd.setVisible(true);
        x = true;
    }
    
    private void change2plg(){
        kode.setText("Kode Pelanggan");
        nama.setText("Nama Pelanggan");
        idtelp.setText("Id Member");
        telpalamat.setText("No. Telpon");
        jLabel1.setText("PELANGGAN");
        cbxMember.setVisible(true);
        txtIdTelp.setVisible(false);
        btnDelete.setVisible(false);
        form1.setVisible(true);
        form1.setText("Daftar Member ?");
        form2.setVisible(false);
        btnInsert.setText("INSERT");
        btnInsert.setBackground(Color.green);
        btnInsert.setForeground(Color.white);
        txtKode.setEnabled(true);
        txtKode.requestFocus();
        jLabel3.setText("Form Pelanggan");
        jLabel5.setText("Kode Pelanggan Terakhir :");
        pelanggankd.setVisible(true);
        memberkd.setVisible(false);
        comboBox();
        x = false;
        
    }

    public JLabel getForm1() {
        return form1;
    }

    public JLabel getForm2() {
        return form2;
    }

    public JTextField getTxtTelpAlm() {
        return txtTelpAlm;
    }

    public JTextField getTxtIdTelp() {
        return txtIdTelp;
    }

    public JTextField getTxtKode() {
        return txtKode;
    }

    public JTextField getTxtNama() {
        return txtNama;
    }

    public JComboBox getCbxMember() {
        return cbxMember;
    }

    public JTable getTableMember() {
        return TableMember;
    }

    public JTable getTablePelanggan() {
        return TablePelanggan;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        home = new javax.swing.JLabel();
        penyewaan = new javax.swing.JLabel();
        pemesanan = new javax.swing.JLabel();
        pembayaran = new javax.swing.JLabel();
        report = new javax.swing.JLabel();
        kode = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        nama = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        idtelp = new javax.swing.JLabel();
        cbxMember = new javax.swing.JComboBox();
        txtIdTelp = new javax.swing.JTextField();
        telpalamat = new javax.swing.JLabel();
        txtTelpAlm = new javax.swing.JTextField();
        form2 = new javax.swing.JLabel();
        form1 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablePelanggan = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableMember = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        ket = new javax.swing.JLabel();
        pelanggan = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pelanggankd = new javax.swing.JLabel();
        memberkd = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        a = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1152, 688));
        getContentPane().setLayout(null);

        jLabel13.setText("-----------------------------------------");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(20, 190, 170, 14);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel2.setText("PELANGGAN");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 150, 250, 50);

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

        home.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        home.setText("Home");
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });
        getContentPane().add(home);
        home.setBounds(20, 210, 70, 20);

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

        kode.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        kode.setText("Kode Pelanggan");
        getContentPane().add(kode);
        kode.setBounds(380, 130, 170, 30);
        getContentPane().add(txtKode);
        txtKode.setBounds(380, 170, 180, 30);

        nama.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nama.setText("Nama Pelanggan");
        getContentPane().add(nama);
        nama.setBounds(380, 200, 170, 30);
        getContentPane().add(txtNama);
        txtNama.setBounds(380, 230, 180, 30);

        idtelp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        idtelp.setText("ID Member");
        getContentPane().add(idtelp);
        idtelp.setBounds(380, 270, 170, 20);

        cbxMember.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMemberActionPerformed(evt);
            }
        });
        getContentPane().add(cbxMember);
        cbxMember.setBounds(380, 300, 180, 30);
        getContentPane().add(txtIdTelp);
        txtIdTelp.setBounds(380, 300, 180, 30);

        telpalamat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        telpalamat.setText("No.Telepon");
        getContentPane().add(telpalamat);
        telpalamat.setBounds(380, 340, 170, 30);
        getContentPane().add(txtTelpAlm);
        txtTelpAlm.setBounds(380, 370, 180, 30);

        form2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        form2.setText(" ");
        form2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                form2MouseClicked(evt);
            }
        });
        getContentPane().add(form2);
        form2.setBounds(550, 520, 120, 17);

        form1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        form1.setText(" ");
        form1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                form1MouseClicked(evt);
            }
        });
        getContentPane().add(form1);
        form1.setBounds(420, 520, 120, 17);

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete);
        btnDelete.setBounds(430, 470, 90, 40);

        btnInsert.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        getContentPane().add(btnInsert);
        btnInsert.setBounds(380, 420, 90, 40);

        btnReset.setBackground(new java.awt.Color(0, 0, 0));
        btnReset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        getContentPane().add(btnReset);
        btnReset.setBounds(490, 420, 80, 40);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Daftar Pelanggan");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(780, 120, 140, 30);

        TablePelanggan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablePelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablePelangganMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablePelanggan);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(630, 160, 452, 90);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Daftar Member");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(780, 270, 140, 30);

        TableMember.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TableMember.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMemberMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableMember);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(630, 310, 452, 90);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Status :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(380, 20, 80, 20);

        ket.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(ket);
        ket.setBounds(450, 20, 80, 20);

        pelanggan.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        pelanggan.setForeground(new java.awt.Color(255, 0, 0));
        pelanggan.setText("Pelanggan");
        pelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pelangganMouseClicked(evt);
            }
        });
        getContentPane().add(pelanggan);
        pelanggan.setBounds(20, 250, 130, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(390, 80, 240, 40);

        jLabel5.setText("Kode Pelanggan Terakhir :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(850, 410, 160, 30);
        getContentPane().add(pelanggankd);
        pelanggankd.setBounds(1000, 410, 80, 30);
        getContentPane().add(memberkd);
        memberkd.setBounds(1000, 410, 80, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Pelanggan (1).png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -10, 1152, 670);

        user.setText("jLabel2");
        getContentPane().add(user);
        user.setBounds(0, 0, 34, 14);

        a.setText("jLabel2");
        getContentPane().add(a);
        a.setBounds(20, 70, 34, 14);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbxMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMemberActionPerformed
       
    }//GEN-LAST:event_cbxMemberActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int z = JOptionPane.showConfirmDialog(this, "Yakin Data mau Di Hapus?", "Delete Data", JOptionPane.OK_CANCEL_OPTION);
        if(z == 0){
            if(x == TRUE)
            {
                control.deleteMember();
                control.MemberTabel();
                control.PelangganTabel();
                txtKode.setEnabled(true);
                change2member();
            }
            else
            {
                control.deletePelanggan();
                control.PelangganTabel();
                control.MemberTabel();
                txtKode.setEnabled(true);
                change2plg();
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Data tidak jadi dihapus");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        if(x == TRUE)
        {
            if(btnInsert.getText().equalsIgnoreCase("update")){
                control.updateMember();
                txtKode.setEnabled(true);
            }
            else{
                control.insertMember();
            }
            control.MemberTabel();
            change2member();
            control.clear();
        }
        else
        {
            if(btnInsert.getText().equalsIgnoreCase("update")){
                control.updatePelanggan();
                txtKode.setEnabled(true);
            }
            else{
                control.insertPelanggan();
            }
            control.PelangganTabel();
            change2plg();
            control.clear();
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void form2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_form2MouseClicked
        if(form2.getText().equalsIgnoreCase("input pelanggan")){
            change2plg();
        }
        else{
            change2member();
        }
        control.clear();
    }//GEN-LAST:event_form2MouseClicked

    private void form1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_form1MouseClicked
        if(form1.getText().equalsIgnoreCase("input pelanggan")){
            change2plg();
        }
        else{
            change2member();
        }
        control.clear();
    }//GEN-LAST:event_form1MouseClicked

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        new FormAwal().setVisible(true);
        dispose();
    }//GEN-LAST:event_logoutMouseClicked

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
            utama.getUser().setText(user.getText());
            utama.getUser1().setText(user.getText());
            utama.getA().setText(a.getText());
        }
        utama.setVisible(true);
        dispose();
    }//GEN-LAST:event_homeMouseClicked

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
        FormReport report = new FormReport();  
        report.getA().setText(a.getText());
        report.getUser().setText(user.getText());
        report.setVisible(true);
        dispose();
    }//GEN-LAST:event_reportMouseClicked

    private void TablePelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePelangganMouseClicked
        change2plg();
        control.onMouseClickTablePelanggan();
        btnInsert.setText("UPDATE");
        txtKode.setEnabled(false);
        btnInsert.setBackground(Color.orange);
        btnInsert.setForeground(Color.white);
        if(btnInsert.getText().equalsIgnoreCase("update")){
            btnDelete.setVisible(true);
            btnDelete.setBackground(Color.red);
            btnDelete.setForeground(Color.white);
            txtKode.setEnabled(false);
            form1.setVisible(true);
            form1.setText("Daftar Member ?");
            txtNama.requestFocus();
            TablePelanggan.clearSelection();
        }
    }//GEN-LAST:event_TablePelangganMouseClicked

    private void TableMemberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMemberMouseClicked
        change2member();
        control.onMouseClickTableMember();
        btnInsert.setText("UPDATE");
        txtKode.setEnabled(false);
        btnInsert.setBackground(Color.orange);
        btnInsert.setForeground(Color.white);
        if(btnInsert.getText().equalsIgnoreCase("update")){
            btnDelete.setVisible(true);
            btnDelete.setBackground(Color.red);
            btnDelete.setForeground(Color.white);
            txtKode.setEnabled(false);
            form1.setVisible(true);
            form1.setText("Input Pelanggan");
            txtNama.requestFocus();
            TableMember.clearSelection();
        }
    }//GEN-LAST:event_TableMemberMouseClicked

    private void pelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pelangganMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pelangganMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        control.clear();
        btnInsert.setText("INSERT");
        txtKode.setEnabled(true);
        btnInsert.setBackground(Color.green);
        btnInsert.setForeground(Color.white);
        btnDelete.setVisible(false);
    }//GEN-LAST:event_btnResetActionPerformed

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
            java.util.logging.Logger.getLogger(FormPelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAwal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableMember;
    private javax.swing.JTable TablePelanggan;
    private javax.swing.JLabel a;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox cbxMember;
    private javax.swing.JLabel form1;
    private javax.swing.JLabel form2;
    private javax.swing.JLabel home;
    private javax.swing.JLabel idtelp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel ket;
    private javax.swing.JLabel kode;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel memberkd;
    private javax.swing.JLabel nama;
    private javax.swing.JLabel pelanggan;
    private javax.swing.JLabel pelanggankd;
    private javax.swing.JLabel pembayaran;
    private javax.swing.JLabel pemesanan;
    private javax.swing.JLabel penyewaan;
    private javax.swing.JLabel report;
    private javax.swing.JLabel telpalamat;
    private javax.swing.JTextField txtIdTelp;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtTelpAlm;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
