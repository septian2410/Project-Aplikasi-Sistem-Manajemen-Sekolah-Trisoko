/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu_Inventory;

import Menu_Administrasi.Pembayaran_lain;
import Menu_Administrasi.Pembayaran_spp;

import static Menu_Inventory.Data_Inventory_Barang.getTanggalFromTable;
import Menu_Laporan.Laporan_data_guru;
import Menu_Laporan.Laporan_data_kelas;
import Menu_Laporan.Laporan_data_Daftar_BR_IN;
import Menu_Laporan.Laporan_data_Daftar_BR_IN1;
import Menu_Laporan.Laporan_data_Daftar_BR_IN2;
import Menu_Laporan.Laporan_data_Daftar_BR_OUT;
import Menu_Laporan.Laporan_data_Daftar_BR_OUT1;
import Menu_Laporan.Laporan_data_Daftar_BR_OUT2;
import Menu_Laporan.Laporan_data_siswa;
import Menu_Laporan.Laporan_pembayaran_lain;
import Menu_Laporan.Laporan_pembayaran_spp;

import Menu_Master.Data_Guru;
import Menu_Master.Data_Kelas;
import beranda.menu_utama;
import beranda.menu_utama;
import beranda.menu_utama2;

import java.awt.HeadlessException;
import java.io.InputStream;
import static java.lang.Thread.sleep;
import java.sql.*;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import server.koneksi;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Data_Permohonan_Barang extends javax.swing.JFrame {

     public void tanggal_jam_sekarang(){
        Thread p;
        p = new Thread(){
            public void run(){
                for(;;){
                    
                    Calendar cal = new GregorianCalendar();
           
                    int jam = cal.get(Calendar.HOUR);
                    int menit = cal.get(Calendar.MINUTE);
                    int detik = cal.get(Calendar.SECOND);
                    int AM_PM = cal.get(Calendar.AM_PM);
                    
                    String day_night = "";
                    if(AM_PM == 1)
                    {
                        day_night = "PM";       
                    }
                    else
                    {
                        day_night ="AM";
                    }
                    String waktuu = jam + ":" + menit + ":" + detik + " " + day_night;
                    waktu.setText(waktuu);
                    
                    try{
                        sleep(1000);
                    }catch(InterruptedException ex){
                        Logger.getLogger(Data_Permohonan_Barang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
p.start();
}
    
    public Data_Permohonan_Barang() {
        initComponents();
        setLocationRelativeTo(this);
        loadDataTable();
        loadDataTable_BarangMasuk();
        clear();
        tanggal();
        tanggal_jam_sekarang();
    }

     public  void tanggal(){           
     Date ys = new Date();
     SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
     txtTGL2.setText(s.format(ys));
    }
    
      private void loadDataTable(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Permohonan");
        model.addColumn("Kode Barang");
        model.addColumn("Nama");
        model.addColumn("Jumlah");
        model.addColumn("Keadaan");
        model.addColumn("Model");
        model.addColumn("Tanggal Permohonan");
        model.addColumn("Status");

        try {
           int no = 1;
              String sql = "SELECT * FROM tb_out_barang WHERE id_barang_rusak like '%"
               + txtCARI2.getText ()+ "%'"
               +" or nama_barang like '%" + txtCARI2.getText()+"%'";;
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
                    res.getString(7),
                    res.getString(8)
                 });
            }
            tabel_Barang_Keluar.setModel(model);
        } catch (SQLException e) {
            System.out.println("There is an error : " + e.getMessage());
        }
    }
    
      private void loadDataTable_BarangMasuk( ){
        DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Kode Barang");
            model.addColumn("Nama");
            model.addColumn("Jumlah");
            model.addColumn("Tanggal Masuk");
            model.addColumn("Model");
            model.addColumn("Keterangan");
         try {
            int no = 1;
            String sql = "SELECT * FROM tb_in_barang WHERE kode_barang like '%"
               + txtCARI3.getText ()+ "%'"
               +" or nama_barang like '%" + txtCARI3.getText()+"%'";
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
                    res.getString(6)
                 });
            }
            tabel_BARANG_IN.setModel(model);
        } catch (SQLException e) {
            System.out.println("There is an error : " + e.getMessage());
        }
    }
    
    private void clear(){
        txtID_BR_OUT.setText("");
        TKD_BR.setText("");
        txtNAMA.setText("");
        txtJMLH.setText("");
        TMODEL.setText("");
        txtTGL_KELUAR.setDate(null);
        cmbKEADAAN.setSelectedItem("--Pilih Keadaan--");
        otomatis_kode();
    }
    
       public static Date getTanggalFromTable(JTable table, int kolom){
        JTable tabel = table;
        String str_tgl = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), kolom));
        Date tanggal = null;
        try{
            tanggal = new SimpleDateFormat("yyyy-MM-dd").parse(str_tgl);
        }catch(ParseException ex) {
            Logger.getLogger(Data_Permohonan_Barang.class.getName()).log(Level.SEVERE, null, ex);
              System.out.println("There is an error : " + ex.getMessage());
        }
        return tanggal;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        BG_JUDUL = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        waktu = new javax.swing.JLabel();
        txtTGL2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnHAPUS = new javax.swing.JButton();
        btnSIMPAN = new javax.swing.JButton();
        btnUPDATE = new javax.swing.JButton();
        btnRESET = new javax.swing.JButton();
        btnKEMBALI = new javax.swing.JButton();
        btnCETAK = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtNAMA = new javax.swing.JTextField();
        txtJMLH = new javax.swing.JTextField();
        cmbKEADAAN = new javax.swing.JComboBox<>();
        TKD_BR = new javax.swing.JTextField();
        TMODEL = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtID_BR_OUT = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtTGL_KELUAR = new com.toedter.calendar.JDateChooser();
        txtCARI2 = new javax.swing.JTextField();
        btnCARI2 = new javax.swing.JButton();
        btnreset2 = new javax.swing.JButton();
        txtCARI3 = new javax.swing.JTextField();
        btnCARI3 = new javax.swing.JButton();
        btnreset3 = new javax.swing.JButton();
        btnUPDATEPROSES = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_Barang_Keluar = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_BARANG_IN = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        TSTATUS2 = new javax.swing.JTextField();
        TKEADAAN = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        TSTATUS = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        MAKS = new javax.swing.JButton();
        MIN1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        LAB_AK = new javax.swing.JMenuItem();
        LAB_AP = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        Barang_IN = new javax.swing.JMenuItem();
        Barang_OUT = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        BG_JUDUL.setBackground(new java.awt.Color(57, 62, 70));

        jLabel1.setFont(new java.awt.Font("Source Sans Pro", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Daftar Permohonan Barang");

        exit.setBackground(new java.awt.Color(57, 62, 70));
        exit.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-shutdown-30.png"))); // NOI18N
        exit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        waktu.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        waktu.setForeground(new java.awt.Color(255, 255, 255));
        waktu.setText("jLabel8");

        txtTGL2.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        txtTGL2.setForeground(new java.awt.Color(255, 255, 255));
        txtTGL2.setText("jLabel8");

        jPanel4.setBackground(new java.awt.Color(30, 174, 152));

        jPanel2.setBackground(new java.awt.Color(170, 216, 211));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnHAPUS.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnHAPUS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-delete-30.png"))); // NOI18N
        btnHAPUS.setText("HAPUS");
        btnHAPUS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnHAPUS.setEnabled(false);
        btnHAPUS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHAPUSActionPerformed(evt);
            }
        });

        btnSIMPAN.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnSIMPAN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-plus-30-2.png"))); // NOI18N
        btnSIMPAN.setText("TAMBAH");
        btnSIMPAN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSIMPAN.setEnabled(false);
        btnSIMPAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSIMPANActionPerformed(evt);
            }
        });

        btnUPDATE.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnUPDATE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-edit-30-2.png"))); // NOI18N
        btnUPDATE.setText("UBAH");
        btnUPDATE.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUPDATE.setEnabled(false);
        btnUPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUPDATEActionPerformed(evt);
            }
        });

        btnRESET.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnRESET.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-reset-30.png"))); // NOI18N
        btnRESET.setText("REFRESH");
        btnRESET.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRESET.setEnabled(false);
        btnRESET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRESETActionPerformed(evt);
            }
        });

        btnKEMBALI.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnKEMBALI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-home-30.png"))); // NOI18N
        btnKEMBALI.setText("MENU UTAMA");
        btnKEMBALI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnKEMBALI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKEMBALIActionPerformed(evt);
            }
        });

        btnCETAK.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnCETAK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-print-30.png"))); // NOI18N
        btnCETAK.setText("CETAK");
        btnCETAK.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCETAK.setEnabled(false);
        btnCETAK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCETAKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnHAPUS, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRESET, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSIMPAN, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCETAK, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnKEMBALI)
                        .addGap(16, 16, 16)
                        .addComponent(btnUPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCETAK, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKEMBALI, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHAPUS, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRESET, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSIMPAN, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(170, 216, 211));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Kode Barang");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Jumlah permintaan");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Keadaan");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Model/Merek");

        txtNAMA.setEnabled(false);

        cmbKEADAAN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih Keadaan--", "Maintance", "Habis", "Rusak", "Normal" }));

        TKD_BR.setEnabled(false);

        TMODEL.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Nama Barang");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbKEADAAN, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNAMA, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(TMODEL))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(TKD_BR, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(72, 72, 72))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtJMLH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TKD_BR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtNAMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJMLH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TMODEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cmbKEADAAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(170, 216, 211));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Kode Permohonan ");

        txtID_BR_OUT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtID_BR_OUT.setEnabled(false);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Tanggal Permohonan");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addComponent(jLabel13))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(jLabel18)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTGL_KELUAR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtID_BR_OUT))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtID_BR_OUT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTGL_KELUAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCARI2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnCARI2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-search-30-2.png"))); // NOI18N
        btnCARI2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCARI2ActionPerformed(evt);
            }
        });

        btnreset2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnreset2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-clear-search-30.png"))); // NOI18N
        btnreset2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreset2ActionPerformed(evt);
            }
        });

        btnCARI3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnCARI3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-search-30-2.png"))); // NOI18N
        btnCARI3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCARI3ActionPerformed(evt);
            }
        });

        btnreset3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnreset3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-clear-search-30.png"))); // NOI18N
        btnreset3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreset3ActionPerformed(evt);
            }
        });

        btnUPDATEPROSES.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnUPDATEPROSES.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-reset-30.png"))); // NOI18N
        btnUPDATEPROSES.setText("Update Proses");
        btnUPDATEPROSES.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUPDATEPROSES.setEnabled(false);
        btnUPDATEPROSES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUPDATEPROSESActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Daftar Permohonan"));

        tabel_Barang_Keluar.setFont(new java.awt.Font("Source Sans Pro", 0, 12)); // NOI18N
        tabel_Barang_Keluar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Barang", "Nama Barang", "Jumlah", "Kategori Barang", "Keterangan"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabel_Barang_Keluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_Barang_KeluarMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_Barang_Keluar);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Daftar Barang "));

        tabel_BARANG_IN.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_BARANG_IN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_BARANG_INMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_BARANG_IN);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(30, 174, 152));

        TSTATUS2.setText("Permintaan Telah Selesai");
        TSTATUS2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TSTATUS2ActionPerformed(evt);
            }
        });

        TKEADAAN.setText("Normal");
        TKEADAAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TKEADAANActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TSTATUS2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TKEADAAN, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(TSTATUS2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TKEADAAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.setBackground(new java.awt.Color(30, 174, 152));

        TSTATUS.setText("Sedang Memohon");
        TSTATUS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TSTATUSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TSTATUS, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TSTATUS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel10.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Cari Permohonan Barang");

        jLabel12.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Cari Barang");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnUPDATEPROSES, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(btnreset2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCARI2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCARI2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(btnreset3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCARI3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCARI3, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnUPDATEPROSES, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnreset2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCARI2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCARI2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtCARI3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnreset3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnCARI3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))))
        );

        MAKS.setBackground(new java.awt.Color(57, 62, 70));
        MAKS.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        MAKS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-maximize-window-30 (2).png"))); // NOI18N
        MAKS.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MAKS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MAKSActionPerformed(evt);
            }
        });

        MIN1.setBackground(new java.awt.Color(57, 62, 70));
        MIN1.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        MIN1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-subtract-30 (1).png"))); // NOI18N
        MIN1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MIN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MIN1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BG_JUDULLayout = new javax.swing.GroupLayout(BG_JUDUL);
        BG_JUDUL.setLayout(BG_JUDULLayout);
        BG_JUDULLayout.setHorizontalGroup(
            BG_JUDULLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BG_JUDULLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BG_JUDULLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTGL2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(waktu, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(194, 194, 194)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(62, 62, 62)
                .addComponent(MIN1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MAKS, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        BG_JUDULLayout.setVerticalGroup(
            BG_JUDULLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BG_JUDULLayout.createSequentialGroup()
                .addGroup(BG_JUDULLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BG_JUDULLayout.createSequentialGroup()
                        .addGroup(BG_JUDULLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BG_JUDULLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel1))
                            .addGroup(BG_JUDULLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(MIN1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(MAKS, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(exit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BG_JUDULLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(waktu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTGL2)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(46, 46, 46))
        );

        jMenu2.setText("Form");

        LAB_AK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconnan/file-edit-16x16.png"))); // NOI18N
        LAB_AK.setText("Data Inventory Barang");
        LAB_AK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LAB_AKActionPerformed(evt);
            }
        });
        jMenu2.add(LAB_AK);

        LAB_AP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconnan/file-edit-16x16.png"))); // NOI18N
        LAB_AP.setText("Data Permohonan Barang");
        LAB_AP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LAB_APActionPerformed(evt);
            }
        });
        jMenu2.add(LAB_AP);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Report");

        Barang_IN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconnan/report.png"))); // NOI18N
        Barang_IN.setText("Daftar Inventory Barang");
        Barang_IN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Barang_INActionPerformed(evt);
            }
        });
        jMenu3.add(Barang_IN);

        Barang_OUT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconnan/report.png"))); // NOI18N
        Barang_OUT.setText("Daftar Permohonan Barang");
        Barang_OUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Barang_OUTActionPerformed(evt);
            }
        });
        jMenu3.add(Barang_OUT);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BG_JUDUL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BG_JUDUL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 1200, 662);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHAPUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHAPUSActionPerformed
        try {
            String sql = "DELETE FROM tb_out_barang WHERE id_barang_rusak='"+txtID_BR_OUT.getText()+"'";
            java.sql.Connection conn = (Connection)koneksi.getConnection();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();    
                JOptionPane.showMessageDialog(null, "Proses Hapus Data Berhasil");
                loadDataTable();
                clear();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
        }
        
        Data_Permohonan_Barang user = new  Data_Permohonan_Barang();
        user.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnHAPUSActionPerformed

    private void btnSIMPANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSIMPANActionPerformed
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(txtTGL_KELUAR.getDate()));
        try {
            String sql = "INSERT INTO `tb_out_barang` VALUES ("
                    + "'"+txtID_BR_OUT.getText()+"',"
                    + "'"+TKD_BR.getText()+"',"
                    + "'"+txtNAMA.getText()+"',"
                    + "'"+txtJMLH.getText()+"',"
                    + "'"+cmbKEADAAN.getSelectedItem().toString()+"',"
                    + "'"+TMODEL.getText()+"',"
                    + "'"+tanggal+"',"
                    + "'"+TSTATUS.getText()+"')";
            java.sql.Connection conn = (Connection)koneksi.getConnection();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
                JOptionPane.showMessageDialog(null, "Proses Simpan Data Berhasil");
                loadDataTable();
                clear();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
        }
    }//GEN-LAST:event_btnSIMPANActionPerformed

    private void btnUPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUPDATEActionPerformed
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(txtTGL_KELUAR.getDate()));
           try {
            String sql = "UPDATE `tb_out_barang` SET "
                    + "`kode_barang`='"+TKD_BR.getText()+"',"
                    + "`nama_barang`='"+txtNAMA.getText()+"',"
                    + "`jumlah`='"+txtJMLH.getText()+"',"
                    + "`model`='"+TMODEL.getText()+"',"
                    + "`tanggal_perbaikan`='"+tanggal+"',"
                    + "`status`='"+TSTATUS.getText()+"',"
                    + "`keadaan`='"+cmbKEADAAN.getSelectedItem()+"' "
                    + "WHERE id_barang_rusak='"+txtID_BR_OUT.getText()+"'";
            java.sql.Connection conn = (Connection)koneksi.getConnection();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
                JOptionPane.showMessageDialog(null, "Proses Ubah Data Berhasil");
                loadDataTable();
                clear();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
        }
    }//GEN-LAST:event_btnUPDATEActionPerformed

    private void btnRESETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRESETActionPerformed
        clear();
        Data_Permohonan_Barang user = new  Data_Permohonan_Barang();
        user.setExtendedState(JFrame.MAXIMIZED_BOTH);
        user.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRESETActionPerformed

    private void btnKEMBALIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKEMBALIActionPerformed
        menu_utama2 dsb = new menu_utama2();
        dsb.dashInventory();
        dsb.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnKEMBALIActionPerformed

    private void btnCETAKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCETAKActionPerformed
    try{
        InputStream file = getClass().getResourceAsStream("/Menu_Inventory/lap_barang_permohonan_rekap.jrxml");
        JasperDesign jasperDesign = JRXmlLoader.load(file);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null,koneksi.getConnection());
        JasperViewer.viewReport(jasperPrint,false);
    }catch(Exception ex)
    {
        System.out.println(ex);
        }
    }//GEN-LAST:event_btnCETAKActionPerformed

    private void tabel_Barang_KeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_Barang_KeluarMouseClicked
        int baris = tabel_Barang_Keluar.rowAtPoint(evt.getPoint());
            String id = tabel_Barang_Keluar.getValueAt(baris, 0).toString();
            txtID_BR_OUT.setText(id);
            String kode = tabel_Barang_Keluar.getValueAt(baris, 1).toString();
            TKD_BR.setText(kode);
            String nama = tabel_Barang_Keluar.getValueAt(baris, 2).toString();
            txtNAMA.setText(nama);
            String jml = tabel_Barang_Keluar.getValueAt(baris, 3).toString();
            txtJMLH.setText(jml);
            String keadaan = tabel_Barang_Keluar.getValueAt(baris, 4).toString();
            cmbKEADAAN.setSelectedItem(keadaan);
            String model = tabel_Barang_Keluar.getValueAt(baris, 5).toString();
            TMODEL.setText(model);
            txtTGL_KELUAR.setDate(getTanggalFromTable(tabel_Barang_Keluar, 6));
            String status = tabel_Barang_Keluar.getValueAt(baris, 7).toString();
        TSTATUS.setText(status);
        btnSIMPAN.setEnabled(false);
        btnUPDATE.setEnabled(true);
        btnHAPUS.setEnabled(true);
        btnCETAK.setEnabled(true);
        btnUPDATEPROSES.setEnabled(true);
        btnRESET.setEnabled(true);
    }//GEN-LAST:event_tabel_Barang_KeluarMouseClicked

    private void btnCARI2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCARI2ActionPerformed
        try {
            String sql = "SELECT * FROM tb_out_barang where id_barang_rusak like '%"
                    + txtCARI2.getText() + "%'"
                    + "or nama_barang like '%" + txtCARI2.getText();
            java.sql.Connection conn = (Connection)koneksi.getConnection();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
        } catch (HeadlessException | SQLException e){
        }
         loadDataTable();  
    }//GEN-LAST:event_btnCARI2ActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
      if (JOptionPane.showConfirmDialog(null, "Yakin ingin Logout?", "Data Permohonan Barang SMP", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            new login.Menu_Login().setVisible(true);
                this.dispose();
                    this.setVisible(false);
        }
    }//GEN-LAST:event_exitActionPerformed

    private void LAB_AKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LAB_AKActionPerformed
        new Data_Inventory_Barang().show();
        this.dispose();
    }//GEN-LAST:event_LAB_AKActionPerformed

    private void LAB_APActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LAB_APActionPerformed
        new Data_Permohonan_Barang().show();
        this.dispose();
    }//GEN-LAST:event_LAB_APActionPerformed

    private void Barang_INActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Barang_INActionPerformed
        new Laporan_data_Daftar_BR_IN2().show();
        this.dispose();
    }//GEN-LAST:event_Barang_INActionPerformed

    private void Barang_OUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Barang_OUTActionPerformed
        new Laporan_data_Daftar_BR_OUT2().show();
        this.dispose();
    }//GEN-LAST:event_Barang_OUTActionPerformed

    private void btnreset2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreset2ActionPerformed
        clear();
        loadDataTable();
        txtCARI2.setText("");  
    }//GEN-LAST:event_btnreset2ActionPerformed

    private void btnCARI3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCARI3ActionPerformed
        try {
            String sql = "SELECT * FROM tb_in_barang where kode_barang like '%"
                    + txtCARI3.getText() + "%'"
                    + "or nama_barang like '%" + txtCARI3.getText();
            java.sql.Connection conn = (Connection)koneksi.getConnection();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
        } catch (HeadlessException | SQLException e){
        }
         loadDataTable_BarangMasuk();
    }//GEN-LAST:event_btnCARI3ActionPerformed

    private void btnreset3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreset3ActionPerformed
        clear();
        loadDataTable_BarangMasuk();
        txtCARI3.setText("");
    }//GEN-LAST:event_btnreset3ActionPerformed

    private void tabel_BARANG_INMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_BARANG_INMouseClicked
        int baris = tabel_BARANG_IN.rowAtPoint(evt.getPoint());
            String kd = tabel_BARANG_IN.getValueAt(baris,0).toString();
            TKD_BR.setText(kd);
            String nama = tabel_BARANG_IN.getValueAt(baris, 1).toString();
            txtNAMA.setText(nama);
            String jml = tabel_BARANG_IN.getValueAt(baris, 2).toString();
            txtJMLH.setText(jml);
            String model = tabel_BARANG_IN.getValueAt(baris, 4).toString();
            TMODEL.setText(model);
   btnSIMPAN.setEnabled(true);
   btnUPDATE.setEnabled(false);
   btnHAPUS.setEnabled(false);
   btnUPDATEPROSES.setEnabled(false);
   btnCETAK.setEnabled(false);
   btnRESET.setEnabled(true);      
    }//GEN-LAST:event_tabel_BARANG_INMouseClicked

    private void MAKSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MAKSActionPerformed
         if (this.getExtendedState()!= Data_Permohonan_Barang.MAXIMIZED_BOTH) {
            this.setExtendedState (Data_Permohonan_Barang.MAXIMIZED_BOTH);
        }else{
            this.setExtendedState (Data_Permohonan_Barang.NORMAL);
        }
    }//GEN-LAST:event_MAKSActionPerformed

    private void MIN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MIN1ActionPerformed
        this.setExtendedState(Data_Permohonan_Barang.ICONIFIED);
    }//GEN-LAST:event_MIN1ActionPerformed

    private void btnUPDATEPROSESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUPDATEPROSESActionPerformed
    String tampilan = "yyyy-MM-dd";
    SimpleDateFormat fm = new SimpleDateFormat(tampilan);
    String tanggal = String.valueOf(fm.format(txtTGL_KELUAR.getDate()));
        try {
            String sql = "UPDATE `tb_out_barang` SET "
                    + "`kode_barang`='"+TKD_BR.getText()+"',"
                    + "`nama_barang`='"+txtNAMA.getText()+"',"
                    + "`jumlah`='"+txtJMLH.getText()+"',"
                    + "`model`='"+TMODEL.getText()+"',"
                    + "`tanggal_perbaikan`='"+tanggal+"',"
                    + "`status`='"+TSTATUS2.getText()+"',"
                    + "`keadaan`='"+TKEADAAN.getText()+"' "
                    + "WHERE id_barang_rusak='"+txtID_BR_OUT.getText()+"'";
            java.sql.Connection conn = (Connection)koneksi.getConnection();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
                JOptionPane.showMessageDialog(null, "Proses Permintaan Telah Berhasil");
                loadDataTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
        }
            cmbKEADAAN.setEnabled(false);
            txtJMLH.setEnabled(false);
            txtID_BR_OUT.setEnabled(false);
            txtTGL_KELUAR.setEnabled(false);
            btnUPDATE.setEnabled(false);
            btnHAPUS.setEnabled(false);           
    }//GEN-LAST:event_btnUPDATEPROSESActionPerformed

    private void TSTATUS2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TSTATUS2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TSTATUS2ActionPerformed

    private void TKEADAANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TKEADAANActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TKEADAANActionPerformed

    private void TSTATUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TSTATUSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TSTATUSActionPerformed

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
            java.util.logging.Logger.getLogger(Data_Permohonan_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Data_Permohonan_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Data_Permohonan_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Data_Permohonan_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Data_Permohonan_Barang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BG_JUDUL;
    private javax.swing.JMenuItem Barang_IN;
    private javax.swing.JMenuItem Barang_OUT;
    private javax.swing.JMenuItem LAB_AK;
    private javax.swing.JMenuItem LAB_AP;
    private javax.swing.JButton MAKS;
    private javax.swing.JButton MIN1;
    private javax.swing.JTextField TKD_BR;
    private javax.swing.JTextField TKEADAAN;
    private javax.swing.JTextField TMODEL;
    private javax.swing.JTextField TSTATUS;
    private javax.swing.JTextField TSTATUS2;
    private javax.swing.JButton btnCARI2;
    private javax.swing.JButton btnCARI3;
    private javax.swing.JButton btnCETAK;
    private javax.swing.JButton btnHAPUS;
    private javax.swing.JButton btnKEMBALI;
    private javax.swing.JButton btnRESET;
    private javax.swing.JButton btnSIMPAN;
    private javax.swing.JButton btnUPDATE;
    private javax.swing.JButton btnUPDATEPROSES;
    private javax.swing.JButton btnreset2;
    private javax.swing.JButton btnreset3;
    private javax.swing.JComboBox<String> cmbKEADAAN;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.swing.JTable tabel_BARANG_IN;
    private javax.swing.JTable tabel_Barang_Keluar;
    private javax.swing.JTextField txtCARI2;
    private javax.swing.JTextField txtCARI3;
    private javax.swing.JTextField txtID_BR_OUT;
    private javax.swing.JTextField txtJMLH;
    private javax.swing.JTextField txtNAMA;
    private javax.swing.JLabel txtTGL2;
    private com.toedter.calendar.JDateChooser txtTGL_KELUAR;
    private javax.swing.JLabel waktu;
    // End of variables declaration//GEN-END:variables

 private void otomatis_kode(){
        try{    
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_datasekolah","root","");
             Statement stat = con.createStatement();                                                                                                  //descending
             ResultSet rs = stat.executeQuery("SELECT * from tb_out_barang order by id_barang_rusak desc ");
                if (rs.next()){
                    String kode = rs.getString("id_barang_rusak").substring(2);
                                           //misal AB00[1], AB00[2], ... (Penambahan otomatis angka descending 
                    String AN = "" + (Integer.parseInt(kode) + 1);
                    String Nol = "";

                    if(AN.length()==1)
                    {Nol = "00";}
                    else if (AN.length()==2)
                    {Nol = "0";}
                    else if (AN.length()==3)
                    {Nol = "";}
                                    // SBN    00    1,2,3,4,..
                    txtID_BR_OUT.setText("PM" + Nol +AN);
                }else{
                    txtID_BR_OUT.setText("PM001");
                }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
    }
    }

}
