/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu_Administrasi;

import Menu_Inventory.Data_Inventory_Barang;
import Menu_Inventory.Data_Permohonan_Barang;

import Menu_Laporan.Laporan_data_guru;
import Menu_Laporan.Laporan_data_kelas;
import Menu_Laporan.Laporan_data_Daftar_BR_IN;
import Menu_Laporan.Laporan_data_Daftar_BR_OUT;
import Menu_Laporan.Laporan_data_siswa;
import Menu_Laporan.Laporan_pembayaran_lain;
import Menu_Laporan.Laporan_pembayaran_lain1;
import Menu_Laporan.Laporan_pembayaran_spp;
import Menu_Laporan.Laporan_pembayaran_spp1;

import Menu_Master.Data_Kelas;
import static Menu_Master.Data_Siswa.getTanggalFromTable;

import beranda.menu_utama;
import beranda.menu_utama1;
import beranda.menu_utama3;

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
import jdk.nashorn.internal.parser.TokenType;

import server.UserSession;

public class Pembayaran_lain extends javax.swing.JFrame {
    
     String id = UserSession.get_id();    
     String nama = UserSession.get_nama();
     String level = UserSession.get_level();
    
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
                        Logger.getLogger(Pembayaran_lain.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
p.start();
}
    
    
    public Pembayaran_lain() {
        initComponents();
        tabelSiswa();
        setLocationRelativeTo(this);
        clear();
        tanggal();
        tanggal_jam_sekarang();
    }
    
    
    Statement st;
    Connection con = koneksi.getConnection();
    ResultSet rs;
    DefaultComboBoxModel modelc;
    DefaultTableModel model;
    DefaultTableModel modelStatus;
    Calendar kalender = new GregorianCalendar();

   public  void tanggal(){             
        Date ys = new Date();
     SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
     txtTGL2.setText(s.format(ys));
        
    }
    
    private void clear(){
        tId_petugas.setText("");
        tPetugas.setText("");
        tId_Angkatan.setText("");
        tTanggal.setText("");
        tNo_Transaki.setText(""); 
        TUTS.setText("-");
        TUAS.setText("-");
        TBUKU.setText("-");
        TSERAGAM.setText("-");
        
        BUTS.setEnabled(false);
        BUAS.setEnabled(false);
        BSERAGAM.setEnabled(false);
        BLKS.setEnabled(false);
        CUTS.setEnabled(false);
        CUAS.setEnabled(false);
        CLKS.setEnabled(false);
        CSERAGAM.setEnabled(false);
    }
    
     private void clearUTS(){
     TUTS.setText("Belum Lunas");
     }
     private void clearUAS(){
     TUAS.setText("Belum Lunas");
     }
     private void clearSERAGAM(){
     TSERAGAM.setText("Belum Lunas");
     }
     private void clearBUKU(){
     TBUKU.setText("Belum Lunas");
     }
      private void CUTS(){
     TUTS.setText("Lunas");
     }
     private void CUAS(){
     TUAS.setText("Lunas");
     }
     private void CSERAGAM(){
     TSERAGAM.setText("Lunas");
     }
     private void CBUKU(){
     TBUKU.setText("Lunas");
     }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jList1 = new javax.swing.JList<>();
        BG_JUDUL = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        waktu = new javax.swing.JLabel();
        txtTGL2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tNisn = new javax.swing.JLabel();
        tNama_siswa = new javax.swing.JLabel();
        tKelas = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        tId_Angkatan = new javax.swing.JTextField();
        tAngkatan = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        tId_petugas = new javax.swing.JTextField();
        tPetugas = new javax.swing.JLabel();
        BUTS = new javax.swing.JButton();
        BUAS = new javax.swing.JButton();
        CUTS = new javax.swing.JButton();
        CUAS = new javax.swing.JButton();
        TUAS = new javax.swing.JTextField();
        TUTS = new javax.swing.JTextField();
        BSERAGAM = new javax.swing.JButton();
        BLKS = new javax.swing.JButton();
        TSERAGAM = new javax.swing.JTextField();
        TBUKU = new javax.swing.JTextField();
        CLKS = new javax.swing.JButton();
        CSERAGAM = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tNo_Transaki = new javax.swing.JLabel();
        tTanggal = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btnSIMPAN = new javax.swing.JButton();
        btnKEMBALI = new javax.swing.JButton();
        btnHAPUS = new javax.swing.JButton();
        btnCETAK = new javax.swing.JButton();
        btnRESET = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelSiswa = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelStatusBayar = new javax.swing.JTable();
        cari = new javax.swing.JTextField();
        btnCARI2 = new javax.swing.JButton();
        btnRESET4 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        tNama_siswa1 = new javax.swing.JLabel();
        MIN2 = new javax.swing.JButton();
        MAKS = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        BAYAR_SPP = new javax.swing.JMenuItem();
        BAYAR_LAIN = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        LAP_BAYAR_SPP = new javax.swing.JMenuItem();
        LAP_BAYAR_LAIN = new javax.swing.JMenuItem();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        BG_JUDUL.setBackground(new java.awt.Color(240, 235, 204));

        jLabel1.setFont(new java.awt.Font("Source Sans Pro", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PEMBAYARAN Non-SPP");

        exit.setBackground(new java.awt.Color(240, 235, 204));
        exit.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-shutdown-30.png"))); // NOI18N
        exit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        waktu.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        waktu.setForeground(new java.awt.Color(51, 51, 51));
        waktu.setText("jLabel8");

        txtTGL2.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        txtTGL2.setForeground(new java.awt.Color(51, 51, 51));
        txtTGL2.setText("jLabel8");

        jPanel8.setBackground(new java.awt.Color(143, 217, 168));

        jPanel1.setBackground(new java.awt.Color(189, 210, 182));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Kelas");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Nama");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("NIS");

        tNisn.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        tNisn.setText("~");
        tNisn.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tNisnPropertyChange(evt);
            }
        });

        tNama_siswa.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        tNama_siswa.setText("~");

        tKelas.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        tKelas.setText("~");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tNisn)
                    .addComponent(tKelas)
                    .addComponent(tNama_siswa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tNisn))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tNama_siswa))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tKelas))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(189, 210, 182));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Angkatan");

        tId_Angkatan.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        tId_Angkatan.setEnabled(false);

        tAngkatan.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        tAngkatan.setText("~");

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Petugas");

        tId_petugas.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        tId_petugas.setEnabled(false);

        tPetugas.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        tPetugas.setText("~");

        BUTS.setBackground(new java.awt.Color(189, 210, 182));
        BUTS.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BUTS.setText("UTS");
        BUTS.setEnabled(false);
        BUTS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUTSActionPerformed(evt);
            }
        });

        BUAS.setBackground(new java.awt.Color(189, 210, 182));
        BUAS.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BUAS.setText("UAS");
        BUAS.setEnabled(false);
        BUAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUASActionPerformed(evt);
            }
        });

        CUTS.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CUTS.setText("√");
        CUTS.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CUTS.setEnabled(false);
        CUTS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CUTSActionPerformed(evt);
            }
        });

        CUAS.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CUAS.setText("√");
        CUAS.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CUAS.setEnabled(false);
        CUAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CUASActionPerformed(evt);
            }
        });

        TUAS.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        TUTS.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        BSERAGAM.setBackground(new java.awt.Color(189, 210, 182));
        BSERAGAM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BSERAGAM.setText("SERAGAM");
        BSERAGAM.setEnabled(false);
        BSERAGAM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSERAGAMActionPerformed(evt);
            }
        });

        BLKS.setBackground(new java.awt.Color(189, 210, 182));
        BLKS.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BLKS.setText("BUKU LKS");
        BLKS.setEnabled(false);
        BLKS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLKSActionPerformed(evt);
            }
        });

        TSERAGAM.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        TBUKU.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        CLKS.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CLKS.setText("√");
        CLKS.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CLKS.setEnabled(false);
        CLKS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CLKSActionPerformed(evt);
            }
        });

        CSERAGAM.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CSERAGAM.setText("√");
        CSERAGAM.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CSERAGAM.setEnabled(false);
        CSERAGAM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CSERAGAMActionPerformed(evt);
            }
        });

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tAngkatan, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(tId_Angkatan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(36, 36, 36)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tPetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tId_petugas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 109, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BUAS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BUTS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(CUTS, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TUTS, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(CUAS, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TUAS)))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BLKS)
                            .addComponent(BSERAGAM))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CLKS, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CSERAGAM, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TSERAGAM, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(TBUKU))
                        .addGap(32, 32, 32))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BUTS)
                            .addComponent(CUTS, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TUTS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BUAS)
                            .addComponent(CUAS, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TUAS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(BLKS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BSERAGAM)
                            .addComponent(CSERAGAM, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TSERAGAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CLKS, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TBUKU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tId_petugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(17, 17, 17)
                            .addComponent(tPetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tId_Angkatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))
                            .addGap(18, 18, 18)
                            .addComponent(tAngkatan, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(189, 210, 182));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("No.Pembayaran NONSPP");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Tanggal Pembayaran");

        tNo_Transaki.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        tNo_Transaki.setText("Trns000");
        tNo_Transaki.setEnabled(false);

        tTanggal.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        tTanggal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tTanggal.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(tNo_Transaki))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tNo_Transaki))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(189, 210, 182));

        btnSIMPAN.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnSIMPAN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-plus-30-2.png"))); // NOI18N
        btnSIMPAN.setText("TAMBAH");
        btnSIMPAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSIMPANActionPerformed(evt);
            }
        });

        btnKEMBALI.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnKEMBALI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-home-30.png"))); // NOI18N
        btnKEMBALI.setText("MENU UTAMA");
        btnKEMBALI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKEMBALIActionPerformed(evt);
            }
        });

        btnHAPUS.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnHAPUS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-delete-30.png"))); // NOI18N
        btnHAPUS.setText("HAPUS");
        btnHAPUS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHAPUSActionPerformed(evt);
            }
        });

        btnCETAK.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnCETAK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-print-30.png"))); // NOI18N
        btnCETAK.setText("CETAK");
        btnCETAK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCETAKActionPerformed(evt);
            }
        });

        btnRESET.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnRESET.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-reset-30.png"))); // NOI18N
        btnRESET.setText("REFRESH");
        btnRESET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRESETActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnSIMPAN, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnKEMBALI, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                    .addComponent(btnCETAK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRESET, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHAPUS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(btnCETAK, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRESET, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHAPUS, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKEMBALI, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSIMPAN, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(189, 210, 182));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TabelSiswa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TabelSiswa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "NIS", "Nama Siswa", "Jurusan", "Kelas", "Periode Bayar", "Jumlah Bulan", "Total"
            }
        ));
        TabelSiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelSiswaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TabelSiswa);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(189, 210, 182));
        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tabelStatusBayar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabelStatusBayar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "NIS", "Nama Siswa", "Jurusan", "Kelas", "Periode Bayar", "Jumlah Bulan", "Total"
            }
        ));
        tabelStatusBayar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelStatusBayarMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelStatusBayar);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCARI2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnCARI2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-search-30-2.png"))); // NOI18N
        btnCARI2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCARI2ActionPerformed(evt);
            }
        });

        btnRESET4.setBackground(new java.awt.Color(250, 242, 218));
        btnRESET4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-clear-search-30.png"))); // NOI18N
        btnRESET4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRESET4ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 102));
        jLabel17.setText("Daftar Siswa ");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 102));
        jLabel18.setText("Status Bayar");

        tNama_siswa1.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        tNama_siswa1.setForeground(new java.awt.Color(0, 102, 102));
        tNama_siswa1.setText("~");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(tNama_siswa1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRESET4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCARI2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(40, 40, 40))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tNama_siswa1)))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnCARI2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRESET4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        MIN2.setBackground(new java.awt.Color(240, 235, 204));
        MIN2.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        MIN2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-subtract-30.png"))); // NOI18N
        MIN2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MIN2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MIN2ActionPerformed(evt);
            }
        });

        MAKS.setBackground(new java.awt.Color(240, 235, 204));
        MAKS.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        MAKS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-maximize-window-30 (1).png"))); // NOI18N
        MAKS.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MAKS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MAKSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BG_JUDULLayout = new javax.swing.GroupLayout(BG_JUDUL);
        BG_JUDUL.setLayout(BG_JUDULLayout);
        BG_JUDULLayout.setHorizontalGroup(
            BG_JUDULLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BG_JUDULLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BG_JUDULLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BG_JUDULLayout.createSequentialGroup()
                        .addComponent(txtTGL2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(286, 286, 286))
                    .addGroup(BG_JUDULLayout.createSequentialGroup()
                        .addComponent(waktu, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(235, 235, 235)
                .addComponent(MIN2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MAKS, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        BG_JUDULLayout.setVerticalGroup(
            BG_JUDULLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BG_JUDULLayout.createSequentialGroup()
                .addGroup(BG_JUDULLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BG_JUDULLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(BG_JUDULLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BG_JUDULLayout.createSequentialGroup()
                                .addComponent(txtTGL2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(waktu))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(BG_JUDULLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(MIN2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(MAKS, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(exit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
        LAP_BAYAR_SPP.setText("Cetak Laporan Pembayaran SPP");
        LAP_BAYAR_SPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LAP_BAYAR_SPPActionPerformed(evt);
            }
        });
        jMenu3.add(LAP_BAYAR_SPP);

        LAP_BAYAR_LAIN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconnan/report.png"))); // NOI18N
        LAP_BAYAR_LAIN.setText("Cetak Laporan Pembayaran Lain-lain");
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
            .addComponent(BG_JUDUL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BG_JUDUL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSIMPANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSIMPANActionPerformed
        try {
            String sql = "INSERT INTO `tb_data_bayar_lain` VALUES ("
            + "'"+tNama_siswa.getText()+"',"
            + "'"+tKelas.getText()+"',"
            + "'"+tNo_Transaki.getText()+"',"  
            + "'"+tTanggal.getText()+"',"
            + "'"+tAngkatan.getText()+"'," 
            + "'"+tId_Angkatan.getText()+"',"
            + "'"+TUTS.getText()+"',"
            + "'"+TUAS.getText()+"',"
            + "'"+TSERAGAM.getText()+"',"
            + "'"+TBUKU.getText()+"',"
            + "'"+tNisn.getText()+"'," 
            + "'"+tId_petugas.getText()+"')";
                java.sql.Connection conn = (Connection)koneksi.getConnection();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.execute();
                JOptionPane.showMessageDialog(null, "Proses Simpan Data Berhasil");
        clear();
        tabelStatBayar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
        }
    }//GEN-LAST:event_btnSIMPANActionPerformed

    private void btnHAPUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHAPUSActionPerformed
       try {
            String sql = "DELETE FROM tb_data_bayar_lain WHERE no_pembayaran_lain='"+tNo_Transaki.getText()+"'";
            java.sql.Connection conn = (Connection)koneksi.getConnection();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
                JOptionPane.showMessageDialog(null, "Proses Hapus Data Berhasil");
                 tabelStatBayar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
        }
            clear();
    }//GEN-LAST:event_btnHAPUSActionPerformed

    private void btnCETAKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCETAKActionPerformed
   try{
        InputStream file = getClass().getResourceAsStream("/Menu_Administrasi/lap_pembayaran_non_spp.jrxml");
        JasperDesign jasperDesign = JRXmlLoader.load(file);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null,koneksi.getConnection());
        JasperViewer.viewReport(jasperPrint,false);
    }catch(Exception ex)
    {
        System.out.println(ex);
        }
    }//GEN-LAST:event_btnCETAKActionPerformed

    private void btnRESETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRESETActionPerformed
        clear();
        Pembayaran_lain user = new  Pembayaran_lain();
        user.setExtendedState(JFrame.MAXIMIZED_BOTH);
        user.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRESETActionPerformed

    private void btnKEMBALIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKEMBALIActionPerformed
        menu_utama3 dsb = new menu_utama3();
        dsb.dashAdminstrasi();
        dsb.setVisible(true);
        dispose();  
    }//GEN-LAST:event_btnKEMBALIActionPerformed

    private void TabelSiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelSiswaMouseClicked
        ID_AUTO();
        int tahun = kalender.get(Calendar.YEAR);
        int bulan = kalender.get(Calendar.MONTH)+1;
        int hari = kalender.get(Calendar.DAY_OF_MONTH);
        String tanggal = tahun+"/"+bulan+"/"+hari;
        tTanggal.setText(tanggal);                                      

        int i = TabelSiswa.getSelectedRow();                         
        tNisn.setText(model.getValueAt(i, 0).toString());               
        tNama_siswa.setText(model.getValueAt(i, 1).toString());        
        tNama_siswa1.setText(model.getValueAt(i, 1).toString());        
        tKelas.setText(model.getValueAt(i, 2).toString());              
        tAngkatan.setText(model.getValueAt(i, 4).toString());           
        
        tId_petugas.setText(id);       
        tPetugas.setText(nama);                         

        try {
             rs = con.createStatement().executeQuery("select tb_data_siswa.*, spp.* from tb_data_siswa INNER JOIN spp Using(id_spp)where nis like '%"+tNisn.getText()+"%'");
          
            while (rs.next()) {
                tId_Angkatan.setText(rs.getString("id_spp"));     
                TUTS.setText(rs.getString("uts"));   
                TUAS.setText(rs.getString("uas"));   
                TSERAGAM.setText(rs.getString("seragam"));   
                TBUKU.setText(rs.getString("buku"));  
            }
        } catch (Exception e) {
            System.out.println(e);
        }

      BUTS.setEnabled(true);
      BUAS.setEnabled(true);
      BSERAGAM.setEnabled(true);
      BLKS.setEnabled(true);
      CUTS.setEnabled(true);
      CUAS.setEnabled(true);
      CSERAGAM.setEnabled(true);    
      CLKS.setEnabled(true);
    }//GEN-LAST:event_TabelSiswaMouseClicked

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
    if (JOptionPane.showConfirmDialog(null, "Yakin ingin Logout?", "Pembayaran Non-SPP", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            new login.Menu_Login().setVisible(true);
                this.dispose();
                    this.setVisible(false);
        } 
    }//GEN-LAST:event_exitActionPerformed

    private void BAYAR_SPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAYAR_SPPActionPerformed
        new Pembayaran_spp().show();
        this.dispose();
    }//GEN-LAST:event_BAYAR_SPPActionPerformed

    private void BAYAR_LAINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAYAR_LAINActionPerformed
        new Pembayaran_lain().show();
        this.dispose();
    }//GEN-LAST:event_BAYAR_LAINActionPerformed

    private void LAP_BAYAR_SPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LAP_BAYAR_SPPActionPerformed
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
    }//GEN-LAST:event_LAP_BAYAR_SPPActionPerformed

    private void LAP_BAYAR_LAINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LAP_BAYAR_LAINActionPerformed
    try{
        InputStream file = getClass().getResourceAsStream("/Menu_Administrasi/lap_pembayaran_lain.jrxml");
        JasperDesign jasperDesign = JRXmlLoader.load(file);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null,koneksi.getConnection());
        JasperViewer.viewReport(jasperPrint,false);
    }catch(Exception ex)
    {
        System.out.println(ex);
        }
    }//GEN-LAST:event_LAP_BAYAR_LAINActionPerformed

    private void tabelStatusBayarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelStatusBayarMouseClicked
    int trans = tabelStatusBayar.getSelectedRow();          
        tNo_Transaki.setText(modelStatus.getValueAt(trans, 0).toString());
        tTanggal.setText(modelStatus.getValueAt(trans, 1).toString());
        TUTS.setText(modelStatus.getValueAt(trans, 2).toString());
        TUAS.setText(modelStatus.getValueAt(trans, 3).toString());
        TSERAGAM.setText(modelStatus.getValueAt(trans, 4).toString());
        TBUKU.setText(modelStatus.getValueAt(trans, 5).toString());
        try {
            rs = con.createStatement().executeQuery("select tb_data_bayar_lain.*, petugas.*, spp.* from tb_data_bayar_lain INNER JOIN petugas Using(id_petugas) INNER JOIN spp Using(id_spp) where no_pembayaran_lain like '%"+tNo_Transaki.getText()+"%'");
            while (rs.next()) {  
                tId_Angkatan.setText(rs.getString("id_spp"));
                tAngkatan.setText(rs.getString("tahun"));
                tId_petugas.setText(rs.getString("id_petugas"));
                tPetugas.setText(rs.getString("nama_lengkap"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
      BUTS.setEnabled(true);
      BUAS.setEnabled(true);
      BSERAGAM.setEnabled(true);
      BLKS.setEnabled(true);
      CUTS.setEnabled(true);
      CUAS.setEnabled(true);
      CSERAGAM.setEnabled(true);    
      CLKS.setEnabled(true);        
    }//GEN-LAST:event_tabelStatusBayarMouseClicked

    private void btnRESET4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRESET4ActionPerformed
    clear();
    tabelSiswa();
    cari.setText("");
    }//GEN-LAST:event_btnRESET4ActionPerformed

    private void btnCARI2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCARI2ActionPerformed
        try {
            String sql = "SELECT tb_data_siswa.*, spp.tahun from tb_data_siswa INNER JOIN spp Using(id_spp) where nis like '%"+cari.getText()+"%' or nama like '%"+cari.getText()+"%'";
            java.sql.Connection conn = (Connection)koneksi.getConnection();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
        } catch (HeadlessException | SQLException e){
        }
     tabelSiswa();
    }//GEN-LAST:event_btnCARI2ActionPerformed

    private void MIN2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MIN2ActionPerformed
        this.setExtendedState(Pembayaran_lain.ICONIFIED);
    }//GEN-LAST:event_MIN2ActionPerformed

    private void MAKSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MAKSActionPerformed
        if (this.getExtendedState()!= Pembayaran_lain.MAXIMIZED_BOTH) {
            this.setExtendedState (Pembayaran_lain.MAXIMIZED_BOTH);
        }else{
            this.setExtendedState (Pembayaran_lain.NORMAL);
        }
    }//GEN-LAST:event_MAKSActionPerformed

    private void tNisnPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tNisnPropertyChange
        tabelStatBayar();
    }//GEN-LAST:event_tNisnPropertyChange

    private void BUTSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUTSActionPerformed
      clearUTS();
    }//GEN-LAST:event_BUTSActionPerformed

    private void BUASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUASActionPerformed
        clearUAS(); 
    }//GEN-LAST:event_BUASActionPerformed

    private void BSERAGAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSERAGAMActionPerformed
        clearSERAGAM();
    }//GEN-LAST:event_BSERAGAMActionPerformed

    private void BLKSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLKSActionPerformed
        clearBUKU();
    }//GEN-LAST:event_BLKSActionPerformed

    private void CUASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CUASActionPerformed
        CUAS();
    }//GEN-LAST:event_CUASActionPerformed

    private void CUTSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CUTSActionPerformed
        CUTS();
    }//GEN-LAST:event_CUTSActionPerformed

    private void CLKSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLKSActionPerformed
         CBUKU();
    }//GEN-LAST:event_CLKSActionPerformed

    private void CSERAGAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CSERAGAMActionPerformed
     CSERAGAM();
    }//GEN-LAST:event_CSERAGAMActionPerformed

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
            java.util.logging.Logger.getLogger(Pembayaran_lain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pembayaran_lain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pembayaran_lain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pembayaran_lain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pembayaran_lain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem BAYAR_LAIN;
    private javax.swing.JMenuItem BAYAR_SPP;
    private javax.swing.JPanel BG_JUDUL;
    private javax.swing.JButton BLKS;
    private javax.swing.JButton BSERAGAM;
    private javax.swing.JButton BUAS;
    private javax.swing.JButton BUTS;
    private javax.swing.JButton CLKS;
    private javax.swing.JButton CSERAGAM;
    private javax.swing.JButton CUAS;
    private javax.swing.JButton CUTS;
    private javax.swing.JMenuItem LAP_BAYAR_LAIN;
    private javax.swing.JMenuItem LAP_BAYAR_SPP;
    private javax.swing.JButton MAKS;
    private javax.swing.JButton MIN2;
    private javax.swing.JTextField TBUKU;
    private javax.swing.JTextField TSERAGAM;
    private javax.swing.JTextField TUAS;
    private javax.swing.JTextField TUTS;
    private javax.swing.JTable TabelSiswa;
    private javax.swing.JButton btnCARI2;
    private javax.swing.JButton btnCETAK;
    private javax.swing.JButton btnHAPUS;
    private javax.swing.JButton btnKEMBALI;
    private javax.swing.JButton btnRESET;
    private javax.swing.JButton btnRESET4;
    private javax.swing.JButton btnSIMPAN;
    private javax.swing.JTextField cari;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel tAngkatan;
    private javax.swing.JTextField tId_Angkatan;
    private javax.swing.JTextField tId_petugas;
    private javax.swing.JLabel tKelas;
    private javax.swing.JLabel tNama_siswa;
    private javax.swing.JLabel tNama_siswa1;
    private javax.swing.JLabel tNisn;
    private javax.swing.JLabel tNo_Transaki;
    private javax.swing.JLabel tPetugas;
    private javax.swing.JTextField tTanggal;
    private javax.swing.JTable tabelStatusBayar;
    private javax.swing.JLabel txtTGL2;
    private javax.swing.JLabel waktu;
    // End of variables declaration//GEN-END:variables

private void tabelStatBayar() {
        String[] header = {"No Transaksi","Tanggal","uts","uas","seragam","Buku"};
        modelStatus = new DefaultTableModel(header,0);
        tabelStatusBayar.setModel(modelStatus);
        String dataStat = "SELECT * from tb_data_bayar_lain where nis='"+tNisn.getText()+"'"; 
        try {
            ResultSet queryStat = con.createStatement().executeQuery(dataStat);
            while(queryStat.next()) {
               String no = queryStat.getString("no_pembayaran_lain");
               String tanggal = queryStat.getString("tgl_bayar");
               String uts = queryStat.getString("uts");
               String uas = queryStat.getString("uas");
               String seragam = queryStat.getString("seragam");
               String buku = queryStat.getString("buku");
                
               String[] record = {no,tanggal,uts,uas,seragam,buku};
               modelStatus.addRow(record);
           }
        }catch(Exception e) {
           System.out.println(e);
        }
    }

private void ID_AUTO(){
        try {
            String sql="select max(right(no_pembayaran_lain,3)) as no_trans from tb_data_bayar_lain";
            rs = con.createStatement().executeQuery(sql);

            while(rs.next()){
                if(rs.first()==false){
                    tNo_Transaki.setText("TRN001");            
                } else{
                    rs.last();
                    int autoid = rs.getInt(1) + 1;
                    String nomor=String.valueOf(autoid);
                    
                    for(int a=0;a<3;a++){ 
                        nomor = "0" + nomor;
                    }
                    tNo_Transaki.setText("TRS" + nomor);
                }
            }
        } catch (Exception e) {
            System.out.println("error pembayaran | "+e);
        }
}

private void tabelSiswa() {
    String[] judul = {"NIS","Nama","Kelas","No.Telp","Angkatan"};
    model = new DefaultTableModel(judul,0);
    TabelSiswa.setModel(model);
    String sql = "SELECT tb_data_siswa.*, spp.tahun from tb_data_siswa INNER JOIN spp Using(id_spp) where nis like '%"+cari.getText()+"%' or nama like '%"+cari.getText()+"%'";
        try {
            rs = con.createStatement().executeQuery(sql);
            while(rs.next()) {
               String nis = rs.getString("nis");
               String nama = rs.getString("nama");
               String kelas = rs.getString("kelas");   
               String telp = rs.getString("telp");
               String tahun = rs.getString("tahun");
                
               String[] data = {nis, nama, kelas, telp, tahun};              
               model.addRow(data);
           }
        }catch(Exception e) {
           System.out.println(e);
        }
    }

}


