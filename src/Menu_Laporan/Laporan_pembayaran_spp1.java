package Menu_Laporan;

import Menu_Administrasi.Pembayaran_lain;
import Menu_Administrasi.Pembayaran_spp;
import Menu_Administrasi.Pembayaran_spp;
import Menu_Inventory.Data_Inventory_Barang;
import Menu_Inventory.Data_Permohonan_Barang;
import Menu_Master.Data_Guru;
import Menu_Master.Data_Kelas;
import beranda.menu_utama;
import beranda.menu_utama3;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import server.koneksi;

public class Laporan_pembayaran_spp1 extends javax.swing.JFrame {

    /**
     * Creates new form Laporan_pembayaran_spp
     */
    public Laporan_pembayaran_spp1() {
        initComponents();
        setLocationRelativeTo(this);
        showdata();
    }

    private void showdata(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nama ");
        model.addColumn("Kelas ");
        model.addColumn("Semester ");
        model.addColumn("No.Pembayaran SPP ");
        model.addColumn("Tanggal Pembayaran");
        model.addColumn("Periode");
        model.addColumn("Total ");
        try {
           int no = 1;
              String sql = "SELECT * FROM tb_data_bayar_spp";
            java.sql.Connection conn = (Connection)koneksi.getConnection();
            java.sql.Statement stat = conn.createStatement();
            java.sql.ResultSet res = stat.executeQuery(sql);
            while( res.next() ){
                model.addRow(new Object[]{
                    res.getString(1), 
                    res.getString(2), 
                    res.getString(3), 
                    res.getString(4), 
                    res.getString(5),
                    res.getString(6), 
                    res.getString(7) 
               });
            }
            tabel_pembayaran_spp.setModel(model);
        } catch (SQLException e) {
            System.out.println("There is an error : " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnPRINT = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_pembayaran_spp = new javax.swing.JTable();
        btnUPDATE1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_pembayaran_spp1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        HOME = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        BAYAR_SPP = new javax.swing.JMenuItem();
        BAYAR_LAIN = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        LAP_BAYAR_SPP = new javax.swing.JMenuItem();
        LAP_BAYAR_LAIN = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(60, 141, 173));
        jPanel1.setPreferredSize(new java.awt.Dimension(1478, 47));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 47, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(18, 93, 152));

        btnPRINT.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnPRINT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-print-100.png"))); // NOI18N
        btnPRINT.setText("Print");
        btnPRINT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPRINTActionPerformed(evt);
            }
        });

        tabel_pembayaran_spp.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_pembayaran_spp.setMaximumSize(new java.awt.Dimension(2147483647, 496));
        tabel_pembayaran_spp.setMinimumSize(new java.awt.Dimension(135, 496));
        tabel_pembayaran_spp.setPreferredSize(new java.awt.Dimension(675, 496));
        jScrollPane1.setViewportView(tabel_pembayaran_spp);

        btnUPDATE1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnUPDATE1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-edit-file-100.png"))); // NOI18N
        btnUPDATE1.setText("Edit");
        btnUPDATE1.setMaximumSize(new java.awt.Dimension(281, 137));
        btnUPDATE1.setMinimumSize(new java.awt.Dimension(281, 137));
        btnUPDATE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUPDATE1ActionPerformed(evt);
            }
        });

        tabel_pembayaran_spp1.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_pembayaran_spp1.setMaximumSize(new java.awt.Dimension(2147483647, 496));
        tabel_pembayaran_spp1.setMinimumSize(new java.awt.Dimension(135, 496));
        tabel_pembayaran_spp1.setPreferredSize(new java.awt.Dimension(675, 496));
        jScrollPane2.setViewportView(tabel_pembayaran_spp1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(811, 811, 811)
                .addComponent(btnUPDATE1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPRINT)
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPRINT)
                    .addComponent(btnUPDATE1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jMenu1.setText("Beranda");

        HOME.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconnan/konfigurasi_univ.png"))); // NOI18N
        HOME.setText("Menu utama");
        HOME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HOMEActionPerformed(evt);
            }
        });
        jMenu1.add(HOME);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Form");

        BAYAR_SPP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconnan/file-edit-16x16.png"))); // NOI18N
        BAYAR_SPP.setText("Data Pembayaran SPP");
        BAYAR_SPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAYAR_SPPActionPerformed(evt);
            }
        });
        jMenu2.add(BAYAR_SPP);

        BAYAR_LAIN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconnan/file-edit-16x16.png"))); // NOI18N
        BAYAR_LAIN.setText("Data Pembayaran Lain-lain");
        BAYAR_LAIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAYAR_LAINActionPerformed(evt);
            }
        });
        jMenu2.add(BAYAR_LAIN);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Report");

        LAP_BAYAR_SPP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconnan/report.png"))); // NOI18N
        LAP_BAYAR_SPP.setText("Pembayaran SPP");
        LAP_BAYAR_SPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LAP_BAYAR_SPPActionPerformed(evt);
            }
        });
        jMenu3.add(LAP_BAYAR_SPP);

        LAP_BAYAR_LAIN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconnan/report.png"))); // NOI18N
        LAP_BAYAR_LAIN.setText("Pembayaran Lain-lain");
        LAP_BAYAR_LAIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LAP_BAYAR_LAINActionPerformed(evt);
            }
        });
        jMenu3.add(LAP_BAYAR_LAIN);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1261, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HOMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HOMEActionPerformed
        new menu_utama3().show();
        this.dispose();
    }//GEN-LAST:event_HOMEActionPerformed

    private void BAYAR_SPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAYAR_SPPActionPerformed
        new Pembayaran_spp().show();
        this.dispose();
    }//GEN-LAST:event_BAYAR_SPPActionPerformed

    private void BAYAR_LAINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAYAR_LAINActionPerformed
        new Pembayaran_lain().show();
        this.dispose();
    }//GEN-LAST:event_BAYAR_LAINActionPerformed

    private void LAP_BAYAR_SPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LAP_BAYAR_SPPActionPerformed
        new Laporan_pembayaran_spp1().show();
        this.dispose();
    }//GEN-LAST:event_LAP_BAYAR_SPPActionPerformed

    private void LAP_BAYAR_LAINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LAP_BAYAR_LAINActionPerformed
        new Laporan_pembayaran_lain1().show();
        this.dispose();
    }//GEN-LAST:event_LAP_BAYAR_LAINActionPerformed

    private void btnPRINTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPRINTActionPerformed
    try{
        InputStream file = getClass().getResourceAsStream("/Menu_Administrasi/lap_pembayaran_spp.jrxml");
        JasperDesign jasperDesign = JRXmlLoader.load(file);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null,koneksi.getConnection());
        JasperViewer.viewReport(jasperPrint,false);
    }catch(Exception ex)
    {
        System.out.println(ex);
        }        
    }//GEN-LAST:event_btnPRINTActionPerformed

    private void btnUPDATE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUPDATE1ActionPerformed
        Pembayaran_spp user = new  Pembayaran_spp();
        user.setVisible(true);
        dispose();       
    }//GEN-LAST:event_btnUPDATE1ActionPerformed

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
            java.util.logging.Logger.getLogger(Laporan_pembayaran_spp1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Laporan_pembayaran_spp1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Laporan_pembayaran_spp1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Laporan_pembayaran_spp1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Laporan_pembayaran_spp1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem BAYAR_LAIN;
    private javax.swing.JMenuItem BAYAR_SPP;
    private javax.swing.JMenuItem HOME;
    private javax.swing.JMenuItem LAP_BAYAR_LAIN;
    private javax.swing.JMenuItem LAP_BAYAR_SPP;
    private javax.swing.JButton btnPRINT;
    private javax.swing.JButton btnUPDATE1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabel_pembayaran_spp;
    private javax.swing.JTable tabel_pembayaran_spp1;
    // End of variables declaration//GEN-END:variables
}
