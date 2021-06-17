/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Toolkit;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Lenovo
 */
public class FormUtama extends javax.swing.JFrame {
    /**
     * Creates new form FormUtama
     */
    Controller.login control;
    FormLogin login;
    public FormUtama() {
        initComponents();
        login = new FormLogin();
        control = new Controller.login(login,this);
        awal();
        icon();
    }
    private void icon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
    }
    private void awal(){
        juser.setVisible(false);
        user.setVisible(false);
        jpass.setVisible(false);
        passkon.setVisible(false);
        jStatus.setVisible(false);
        status.setVisible(false);
        jpassnew.setVisible(false);
        pass.setVisible(false);
        jkonpass.setVisible(false);
        passkon.setVisible(false);
        btnInsert.setVisible(false);
        Home.setVisible(true);
        jLabel3.setText("");
        if(a.getText().equalsIgnoreCase("operator")){
            jEdit.setVisible(false);
            jInsert.setBackground(Color.orange);
            jLabel4.setForeground(Color.white);
            jLabel4.setText("Edit Akun");
        }
        else{
            jEdit.setVisible(true);
            jEdit.setBackground(Color.orange);
            jLabel5.setForeground(Color.white);
            jInsert.setBackground(Color.green);
            jLabel4.setForeground(Color.white);
            jLabel4.setText("Tambah Akun");
            jLabel5.setText("Edit Akun");
        }
    }
    
    public void pushInsert(){
        juser.setVisible(true);
        user.setVisible(true);
        user.setEnabled(true);
        user.setText("");
        jpass.setVisible(true);
        jpass.setText("Password");
        pass.setVisible(true);
        pass.setText("");
        jStatus.setVisible(true);
        status.setVisible(true);
        jpassnew.setVisible(false);
        passnew.setVisible(false);
        jkonpass.setVisible(false);
        passkon.setVisible(false);
        btnInsert.setVisible(true);
        btnInsert.setText("Insert");
        Home.setVisible(false);
        jLabel4.setText("Edit Akun");
        jInsert.setBackground(Color.orange);
        jLabel4.setForeground(Color.white);
        jLabel3.setText("Tambah Akun Sewaja");
        jLabel5.setText("Home");
        jEdit.setBackground(Color.blue);
        jEdit.setForeground(Color.white);
        user.requestFocus();
    }
    
    public void editPass(){
        juser.setVisible(true);
        user.setVisible(true);
        user.setText(user1.getText());
        user.setEnabled(false);
        jpass.setVisible(true);
        jpass.setText("Password Lama");
        pass.setVisible(true);
        pass.setText("");
        jpassnew.setVisible(true);
        passnew.setVisible(true);
        passnew.setText("");
        jkonpass.setVisible(true);
        passkon.setVisible(true);
        passkon.setText("");
        btnInsert.setVisible(true);
        jStatus.setVisible(false);
        status.setVisible(false);
        btnInsert.setText("Update");
        if(a.getText().equalsIgnoreCase("Operator")){
            jEdit.setVisible(false);
            jInsert.setBackground(Color.blue);
            jLabel4.setForeground(Color.white);
            jLabel4.setText("Home");
        }
        else{
            jInsert.setVisible(true);
            jInsert.setBackground(Color.green);
            jLabel4.setForeground(Color.white);
            jEdit.setVisible(true);
            jEdit.setBackground(Color.blue);
            jLabel5.setForeground(Color.white);
            jLabel4.setText("Tambah Akun");
            jLabel5.setText("Home");
        }
        jLabel3.setText("Edit Akun Sewaja");
        Home.setVisible(false);
        pass.requestFocus();
    }
    public JLabel getA() {
        return a;
    }

    public JLabel getUser1() {
        return user1;
    }

    public JLabel getReport() {
        return report;
    }

    public JTextField getUser() {
        return user;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public JPanel getjInsert() {
        return jInsert;
    }

    public JPanel getjEdit() {
        return jEdit;
    }

    public JPasswordField getPass() {
        return pass;
    }

    public JPasswordField getPasskon() {
        return passkon;
    }

    public JPasswordField getPassnew() {
        return passnew;
    }

    public JComboBox<String> getStatus() {
        return status;
    }

    public JLabel getKet() {
        return ket;
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
        pelanggan = new javax.swing.JLabel();
        penyewaan = new javax.swing.JLabel();
        pemesanan = new javax.swing.JLabel();
        pembayaran = new javax.swing.JLabel();
        report = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Home = new javax.swing.JPanel();
        akun = new javax.swing.JLabel();
        ket = new javax.swing.JLabel();
        statusText = new javax.swing.JLabel();
        jInsert = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        home = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        juser = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        jkonpass = new javax.swing.JLabel();
        jpass = new javax.swing.JLabel();
        jpassnew = new javax.swing.JLabel();
        jStatus = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<String>();
        jEdit = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnInsert = new javax.swing.JButton();
        passkon = new javax.swing.JPasswordField();
        passnew = new javax.swing.JPasswordField();
        pass = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        a = new javax.swing.JLabel();
        user1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1160, 688));
        setPreferredSize(new java.awt.Dimension(1160, 688));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel2.setText("HOME");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 150, 250, 50);

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

        jLabel13.setText("-----------------------------------------");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(20, 190, 170, 14);

        akun.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        akun.setText("SELAMAT DATANG DI APLIKASI SEWAJA");

        javax.swing.GroupLayout HomeLayout = new javax.swing.GroupLayout(Home);
        Home.setLayout(HomeLayout);
        HomeLayout.setHorizontalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeLayout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(akun)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HomeLayout.setVerticalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeLayout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(akun)
                .addContainerGap(201, Short.MAX_VALUE))
        );

        getContentPane().add(Home);
        Home.setBounds(440, 120, 620, 400);

        ket.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(ket);
        ket.setBounds(450, 20, 80, 20);

        statusText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        statusText.setText("Status :");
        getContentPane().add(statusText);
        statusText.setBounds(380, 20, 80, 20);

        jInsert.setBackground(new java.awt.Color(255, 255, 255));
        jInsert.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jInsert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jInsertMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("Tambah Akun");

        javax.swing.GroupLayout jInsertLayout = new javax.swing.GroupLayout(jInsert);
        jInsert.setLayout(jInsertLayout);
        jInsertLayout.setHorizontalGroup(
            jInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInsertLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInsertLayout.setVerticalGroup(
            jInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInsertLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jInsert);
        jInsert.setBounds(920, 550, 140, 20);

        home.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        home.setForeground(new java.awt.Color(255, 0, 0));
        home.setText("Home");
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });
        getContentPane().add(home);
        home.setBounds(20, 210, 70, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(580, 80, 310, 40);

        juser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        juser.setText("Username :");
        getContentPane().add(juser);
        juser.setBounds(470, 130, 100, 30);
        getContentPane().add(user);
        user.setBounds(470, 160, 170, 30);

        jkonpass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jkonpass.setText("Konfirmasi Password :");
        getContentPane().add(jkonpass);
        jkonpass.setBounds(470, 350, 180, 30);

        jpass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jpass.setText("Password :");
        getContentPane().add(jpass);
        jpass.setBounds(470, 210, 190, 30);

        jpassnew.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jpassnew.setText("Password Baru :");
        getContentPane().add(jpassnew);
        jpassnew.setBounds(470, 280, 140, 30);

        jStatus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jStatus.setText("Level :");
        getContentPane().add(jStatus);
        jStatus.setBounds(690, 220, 110, 20);

        status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "admin", "operator" }));
        getContentPane().add(status);
        status.setBounds(690, 240, 130, 30);

        jEdit.setBackground(new java.awt.Color(255, 255, 255));
        jEdit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jEditMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("Edit Akun");

        javax.swing.GroupLayout jEditLayout = new javax.swing.GroupLayout(jEdit);
        jEdit.setLayout(jEditLayout);
        jEditLayout.setHorizontalGroup(
            jEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jEditLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jEditLayout.setVerticalGroup(
            jEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jEditLayout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jEdit);
        jEdit.setBounds(790, 550, 120, 20);

        btnInsert.setText("jButton1");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        getContentPane().add(btnInsert);
        btnInsert.setBounds(710, 380, 80, 30);
        getContentPane().add(passkon);
        passkon.setBounds(470, 380, 170, 30);
        getContentPane().add(passnew);
        passnew.setBounds(470, 310, 170, 30);
        getContentPane().add(pass);
        pass.setBounds(470, 240, 170, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Pelanggan (1).png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1152, 648);
        getContentPane().add(a);
        a.setBounds(10, 60, 90, 30);

        user1.setText("jLabel2");
        getContentPane().add(user1);
        user1.setBounds(0, 0, 34, 14);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pelangganMouseClicked
        FormPelanggan member = new FormPelanggan();
        if (a.getText().equals("operator")) {
            member.getReport().setVisible(false);
            member.getKet().setText("Operator");
            member.getA().setText(a.getText());
            member.getUser().setText(user1.getText());
        }
        else{
            member.getKet().setText("Admin");
            member.getA().setText(a.getText());
            member.getUser().setText(user1.getText());
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
            sewa.getUser().setText(user1.getText());
        }
        else{
            sewa.getKet().setText("Admin");
            sewa.getA().setText(a.getText());
            sewa.getUser().setText(user1.getText());
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
            pesan.getUser().setText(user1.getText());
        }
        else{
            pesan.getKet().setText("Admin");
            pesan.getA().setText(a.getText());
            pesan.getUser().setText(user1.getText());
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
            bayar.getUser().setText(user1.getText());
        }
        else{
            bayar.getKet().setText("Admin");
            bayar.getA().setText(a.getText());
            bayar.getUser().setText(user1.getText());
        }
        bayar.setVisible(true);
        dispose();
    }//GEN-LAST:event_pembayaranMouseClicked

    private void reportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportMouseClicked
        FormReport report = new FormReport();  
        report.getA().setText(a.getText());
        report.getUser().setText(user1.getText());
        report.setVisible(true);
        dispose();
    }//GEN-LAST:event_reportMouseClicked

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
       new FormAwal().setVisible(true);
       dispose();
    }//GEN-LAST:event_logoutMouseClicked

    private void jInsertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jInsertMouseClicked
        if (jLabel4.getText().equalsIgnoreCase("tambah akun")) {
            pushInsert();
        } else if(jLabel4.getText().equalsIgnoreCase("edit akun")){
            editPass();
        }
        else{
            awal();
        }
    }//GEN-LAST:event_jInsertMouseClicked

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_homeMouseClicked

    private void jEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jEditMouseClicked
        if (jLabel5.getText().equalsIgnoreCase("edit akun")) {
            editPass();
        } else{
            awal();
        }
    }//GEN-LAST:event_jEditMouseClicked

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        if (btnInsert.getText().equalsIgnoreCase("insert")) 
        {
            control.insert();
            user.setText("");
            pass.setText("");
            awal();
        } else{
            control.update();
            pass.setText("");
            passnew.setText("");
            passkon.setText("");
            if (a.getText().equals("admin")) {
                user.setText(user1.getText());
            }
            else{
                user.setText(user1.getText());
            }
            awal();
        }
    }//GEN-LAST:event_btnInsertActionPerformed

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
            java.util.logging.Logger.getLogger(FormUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JPanel Home;
    public javax.swing.JLabel a;
    private javax.swing.JLabel akun;
    private javax.swing.JButton btnInsert;
    private javax.swing.JLabel home;
    private javax.swing.JPanel jEdit;
    private javax.swing.JPanel jInsert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jStatus;
    private javax.swing.JLabel jkonpass;
    private javax.swing.JLabel jpass;
    private javax.swing.JLabel jpassnew;
    private javax.swing.JLabel juser;
    private javax.swing.JLabel ket;
    private javax.swing.JLabel logout;
    private javax.swing.JPasswordField pass;
    private javax.swing.JPasswordField passkon;
    private javax.swing.JPasswordField passnew;
    private javax.swing.JLabel pelanggan;
    private javax.swing.JLabel pembayaran;
    private javax.swing.JLabel pemesanan;
    private javax.swing.JLabel penyewaan;
    private javax.swing.JLabel report;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JLabel statusText;
    private javax.swing.JTextField user;
    private javax.swing.JLabel user1;
    // End of variables declaration//GEN-END:variables
}
