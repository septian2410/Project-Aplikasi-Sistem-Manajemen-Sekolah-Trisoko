package Menu_Master;

import Menu_Administrasi.Pembayaran_lain;
import Menu_Administrasi.Pembayaran_spp;
import Menu_Inventory.Data_Inventory_Barang;
import Menu_Inventory.Data_Permohonan_Barang;

import Menu_Laporan.Laporan_data_guru;
import Menu_Laporan.Laporan_data_guru1;
import Menu_Laporan.Laporan_data_kelas;
import Menu_Laporan.Laporan_data_kelas1;
import Menu_Laporan.Laporan_data_Daftar_BR_IN;
import Menu_Laporan.Laporan_data_Daftar_BR_OUT;
import Menu_Laporan.Laporan_data_jadwal1;
import Menu_Laporan.Laporan_data_siswa;
import Menu_Laporan.Laporan_data_siswa1;
import Menu_Laporan.Laporan_pembayaran_lain;
import Menu_Laporan.Laporan_pembayaran_spp;
import static Menu_Master.Data_Guru.getTanggalFromTable;

import Menu_Master.Data_Kelas;
import Menu_Master.Data_Siswa;
import beranda.menu_utama;
import beranda.menu_utama;
import beranda.menu_utama1;

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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Data_Jadwal extends javax.swing.JFrame {

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
                        Logger.getLogger(Data_Jadwal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
p.start();
}
    
    public Data_Jadwal() {
       initComponents();
       setLocationRelativeTo(this);
       loadDataTable_guru();
       loadDataTable_kelas();
       loadDataTable_jadwal();
       clear();
       tanggal();
       tanggal_jam_sekarang();
    }

     public  void tanggal(){        
        Date ys = new Date();
     SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
     txtTGL2.setText(s.format(ys));
    }
    
       private void loadDataTable_jadwal(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Jadwal");
        model.addColumn("ID Kelas");
        model.addColumn("Kelas");
        model.addColumn("NIP");
        model.addColumn("Guru");
        model.addColumn("Mata Pelajaran");
        model.addColumn("Hari");
        model.addColumn("Jam");
        
        try {
            int no = 1;
                String sql = "SELECT * FROM tb_jadwal WHERE nm_guru like '%"
               + txtCARI4.getText ()+ "%'"
               +" or mapel like '%" + txtCARI4.getText()+"%'";
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
            table_jadwal.setModel(model);
        } catch (SQLException e) {
            System.out.println("There is an error : " + e.getMessage());
        }
    }
     
    private void loadDataTable_guru(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("NIP");
        model.addColumn("Nama");
        model.addColumn("Mata Pelajaran");
        model.addColumn("No Telpon");
        try {
            int no = 1;
            String sql = "SELECT * FROM tb_data_guru";
            java.sql.Connection conn = (Connection)koneksi.getConnection();
            java.sql.Statement stat = conn.createStatement();
            java.sql.ResultSet res = stat.executeQuery(sql);
            
            while( res.next() ){
                model.addRow(new Object[]{
                    res.getString(1), 
                    res.getString(2), 
                    res.getString(3), 
                    res.getString(8)
                });
            }
            table_guru.setModel(model);
        } catch (SQLException e) {
            System.out.println("There is an error : " + e.getMessage());
        }
    }
    
      private void loadDataTable_kelas(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Kelas");
        model.addColumn("Wali Kelas");
        model.addColumn("Jumlah Siswa");
        model.addColumn("Kelas");
        try {
            int no = 1;
            String sql = "SELECT * FROM tb_data_kelas";
            java.sql.Connection conn = (Connection)koneksi.getConnection();
            java.sql.Statement stat = conn.createStatement();
            java.sql.ResultSet res = stat.executeQuery(sql);
            
            while( res.next() ){
                model.addRow(new Object[]{
                    res.getString(1), 
                    res.getString(2), 
                    res.getString(3), 
                    res.getString(4)  
                    
                });
            }
            table_kelas.setModel(model);
        } catch (SQLException e) {
            System.out.println("There is an error : " + e.getMessage());
        }
      }
    
    
    private void cariData_guru(String key){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("NIP");
        model.addColumn("Nama");
        model.addColumn("Mata Pelajaran");
        model.addColumn("No Telpon");
        model.addColumn("Alamat");
        try {
            int no = 1;
            String sql = "SELECT * FROM `tb_data_guru` WHERE mapel = '"+key+"'";
            java.sql.Connection conn = (Connection)koneksi.getConnection();
            java.sql.Statement stat = conn.createStatement();
            java.sql.ResultSet res = stat.executeQuery(sql);
            
            while( res.next() ){
                model.addRow(new Object[]{
                    res.getString(1), 
                    res.getString(2), 
                    res.getString(3), 
                    res.getString(8),
                    res.getString(9)
                    });
            }
            table_guru.setModel(model);
        } catch (SQLException e) {
            System.out.println("There is an error : " + e.getMessage());
        }
    }
    
      private void cariData_kelas(String key){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Kelas");
        model.addColumn("Wali Kelas");
        model.addColumn("Jumlah Siswa");
        model.addColumn("Kelas");
        try {
            int no = 1;
            String sql = "SELECT * FROM `tb_data_kelas` WHERE kelas = '"+key+"'";
            java.sql.Connection conn = (Connection)koneksi.getConnection();
            java.sql.Statement stat = conn.createStatement();
            java.sql.ResultSet res = stat.executeQuery(sql);
            while( res.next() ){
                model.addRow(new Object[]{
                    res.getString(1), 
                    res.getString(2), 
                    res.getString(3), 
                    res.getString(4)
                            
                });
            }
            table_kelas.setModel(model);
        } catch (SQLException e) {
            System.out.println("There is an error : " + e.getMessage());
        }
      }
    
    private void clear(){
        THARI.setSelectedItem("--Pilih Hari--");
        TWAKTU.setText("");
        TGURU.setText("");
        TNIP.setText("");
        TKD_KELAS.setText("");
        TKD_JADWAL.setText("KJ000");
        TKELAS.setText("--- Kelas ---");
        TMAPEL.setText("--- Mata Pelajaran ---");
        otomatis_kode();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        txtTGL2 = new javax.swing.JLabel();
        waktu = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnSIMPAN = new javax.swing.JButton();
        btnUPDATE = new javax.swing.JButton();
        btnRESET = new javax.swing.JButton();
        btnCETAK = new javax.swing.JButton();
        btnHAPUS = new javax.swing.JButton();
        btnKEMBALI = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TGURU = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TNIP = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TKD_KELAS = new javax.swing.JTextField();
        TMAPEL = new javax.swing.JTextField();
        TKELAS = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        TKD_JADWAL = new javax.swing.JTextField();
        TWAKTU = new javax.swing.JTextField();
        THARI = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_jadwal = new javax.swing.JTable();
        txtCARI4 = new javax.swing.JTextField();
        btnCARI1 = new javax.swing.JButton();
        btnreset1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        cmbSearch = new javax.swing.JComboBox<>();
        btnCARI2 = new javax.swing.JButton();
        btnreset2 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        table_guru = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        btnCARI4 = new javax.swing.JButton();
        btnreset4 = new javax.swing.JButton();
        cmbsearch2 = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_kelas = new javax.swing.JTable();
        MIN = new javax.swing.JButton();
        MAKS = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        GURU = new javax.swing.JMenuItem();
        SISWA = new javax.swing.JMenuItem();
        JADWAL = new javax.swing.JMenuItem();
        KELAS = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        LAP_GURU = new javax.swing.JMenuItem();
        LAP_SISWA = new javax.swing.JMenuItem();
        LAP_JADWAL = new javax.swing.JMenuItem();
        LAP_KELAS = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel6.setBackground(new java.awt.Color(6, 68, 32));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("DATA JADWAL PELAJARAN");

        exit.setBackground(new java.awt.Color(6, 68, 32));
        exit.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-shutdown-30.png"))); // NOI18N
        exit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        txtTGL2.setBackground(new java.awt.Color(255, 255, 255));
        txtTGL2.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        txtTGL2.setForeground(new java.awt.Color(255, 255, 255));
        txtTGL2.setText("jLabel8");

        waktu.setBackground(new java.awt.Color(255, 255, 255));
        waktu.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        waktu.setForeground(new java.awt.Color(255, 255, 255));
        waktu.setText("jLabel8");

        jPanel7.setBackground(new java.awt.Color(228, 239, 231));

        jPanel5.setBackground(new java.awt.Color(253, 250, 246));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnSIMPAN.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnSIMPAN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-plus-30-2.png"))); // NOI18N
        btnSIMPAN.setText("TAMBAH");
        btnSIMPAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSIMPANActionPerformed(evt);
            }
        });

        btnUPDATE.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnUPDATE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-edit-30-2.png"))); // NOI18N
        btnUPDATE.setText("UBAH");
        btnUPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUPDATEActionPerformed(evt);
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

        btnCETAK.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnCETAK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-print-30.png"))); // NOI18N
        btnCETAK.setText("CETAK");
        btnCETAK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCETAKActionPerformed(evt);
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

        btnKEMBALI.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnKEMBALI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-home-30.png"))); // NOI18N
        btnKEMBALI.setText("MENU UTAMA");
        btnKEMBALI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKEMBALIActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSIMPAN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRESET)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCETAK, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHAPUS, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKEMBALI, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSIMPAN, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRESET, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCETAK, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHAPUS, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKEMBALI, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(253, 250, 246));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Kelas");

        TGURU.setFont(new java.awt.Font("Source Sans Pro", 0, 12)); // NOI18N
        TGURU.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Mapel");

        jLabel4.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("NIP");

        jLabel6.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Guru");

        TNIP.setFont(new java.awt.Font("Source Sans Pro", 0, 12)); // NOI18N
        TNIP.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Kode Kelas");

        TKD_KELAS.setFont(new java.awt.Font("Source Sans Pro", 0, 12)); // NOI18N
        TKD_KELAS.setEnabled(false);

        TMAPEL.setEnabled(false);

        TKELAS.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TMAPEL)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TNIP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TGURU, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2))))
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel1))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TKELAS, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(TKD_KELAS))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TKD_KELAS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TKELAS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TNIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TGURU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TMAPEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(253, 250, 246));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel9.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Kode Jadwal");

        jLabel5.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Hari");

        jLabel11.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Waktu");

        TKD_JADWAL.setFont(new java.awt.Font("Source Sans Pro", 0, 12)); // NOI18N
        TKD_JADWAL.setEnabled(false);

        TWAKTU.setFont(new java.awt.Font("Source Sans Pro", 0, 12)); // NOI18N

        THARI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih Hari--", "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel11))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TWAKTU, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(THARI, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(TKD_JADWAL, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(TKD_JADWAL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(THARI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(TWAKTU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(253, 250, 246));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Daftar Jadwal Pelajaran"));

        table_jadwal.setModel(new javax.swing.table.DefaultTableModel(
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
        table_jadwal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_jadwalMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_jadwal);

        btnCARI1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnCARI1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-search-30-2.png"))); // NOI18N
        btnCARI1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCARI1ActionPerformed(evt);
            }
        });

        btnreset1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnreset1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-clear-search-30.png"))); // NOI18N
        btnreset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreset1ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Cari Guru");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(btnreset1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCARI1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCARI4, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnreset1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCARI4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCARI1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(253, 250, 246));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Daftar Guru"));

        cmbSearch.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        cmbSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Mata Pelajaran ---", "--Umum--", "Bahasa Indonesia", "Bahasa Inggris", "Ipa", "Ips", "Kewirausahaan", "Matematika", "Kewarganegaraan", "Pendidikan Agama", "Penjasorkes", "Seni Budaya", "Bimbingan konseling" }));

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

        table_guru.setModel(new javax.swing.table.DefaultTableModel(
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
        table_guru.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_guruMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(table_guru);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnreset2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCARI2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnreset2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCARI2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSearch))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(253, 250, 246));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Daftar Kelas"));

        btnCARI4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnCARI4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-search-30-2.png"))); // NOI18N
        btnCARI4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCARI4ActionPerformed(evt);
            }
        });

        btnreset4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnreset4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-clear-search-30.png"))); // NOI18N
        btnreset4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreset4ActionPerformed(evt);
            }
        });

        cmbsearch2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmbsearch2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Pilih Kelas ---", "VII A", "VII B", "VII C", "VII D", "VII E", " ", "---------", "VIII A", "VIII B", "VIII C", "VIII D", "VIII E", " ", "---------", "IX A", "IX B", "IX C", "IX D", "IX E" }));

        table_kelas.setModel(new javax.swing.table.DefaultTableModel(
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
        table_kelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_kelasMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(table_kelas);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnreset4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCARI4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbsearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane4)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnCARI4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnreset4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbsearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        MIN.setBackground(new java.awt.Color(6, 68, 32));
        MIN.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        MIN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-subtract-30 (1).png"))); // NOI18N
        MIN.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MINActionPerformed(evt);
            }
        });

        MAKS.setBackground(new java.awt.Color(6, 68, 32));
        MAKS.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        MAKS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-maximize-window-30 (2).png"))); // NOI18N
        MAKS.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MAKS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MAKSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txtTGL2, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                        .addGap(302, 302, 302))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(waktu, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                .addGap(256, 256, 256)
                .addComponent(MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MAKS, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtTGL2)
                        .addGap(17, 17, 17)
                        .addComponent(waktu, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel18))
                    .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MAKS, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );

        jMenu2.setText("Form");

        GURU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconnan/file-edit-16x16.png"))); // NOI18N
        GURU.setText("Data Guru");
        GURU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GURUActionPerformed(evt);
            }
        });
        jMenu2.add(GURU);

        SISWA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconnan/file-edit-16x16.png"))); // NOI18N
        SISWA.setText("Data Siswa");
        SISWA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SISWAActionPerformed(evt);
            }
        });
        jMenu2.add(SISWA);

        JADWAL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconnan/file-edit-16x16.png"))); // NOI18N
        JADWAL.setText("Data Jadwal");
        JADWAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JADWALActionPerformed(evt);
            }
        });
        jMenu2.add(JADWAL);

        KELAS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconnan/file-edit-16x16.png"))); // NOI18N
        KELAS.setText("Data Kelas");
        KELAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KELASActionPerformed(evt);
            }
        });
        jMenu2.add(KELAS);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Report");

        LAP_GURU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconnan/report.png"))); // NOI18N
        LAP_GURU.setText("Guru");
        LAP_GURU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LAP_GURUActionPerformed(evt);
            }
        });
        jMenu3.add(LAP_GURU);

        LAP_SISWA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconnan/report.png"))); // NOI18N
        LAP_SISWA.setText("Siswa");
        LAP_SISWA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LAP_SISWAActionPerformed(evt);
            }
        });
        jMenu3.add(LAP_SISWA);

        LAP_JADWAL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconnan/report.png"))); // NOI18N
        LAP_JADWAL.setText("jadwal");
        LAP_JADWAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LAP_JADWALActionPerformed(evt);
            }
        });
        jMenu3.add(LAP_JADWAL);

        LAP_KELAS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconnan/report.png"))); // NOI18N
        LAP_KELAS.setText("Kelas");
        LAP_KELAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LAP_KELASActionPerformed(evt);
            }
        });
        jMenu3.add(LAP_KELAS);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 1220, 662);
    }// </editor-fold>//GEN-END:initComponents

    private void GURUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GURUActionPerformed
        new Data_Jadwal().show();
        this.dispose();
    }//GEN-LAST:event_GURUActionPerformed

    private void SISWAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SISWAActionPerformed
        new Data_Siswa().show();
        this.dispose();
    }//GEN-LAST:event_SISWAActionPerformed

    private void KELASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KELASActionPerformed
        new Data_Kelas().show();
        this.dispose();
    }//GEN-LAST:event_KELASActionPerformed

    private void LAP_GURUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LAP_GURUActionPerformed
        new Laporan_data_guru1().show();
        this.dispose();
    }//GEN-LAST:event_LAP_GURUActionPerformed

    private void LAP_SISWAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LAP_SISWAActionPerformed
        new Laporan_data_siswa1().show();
        this.dispose();
    }//GEN-LAST:event_LAP_SISWAActionPerformed

    private void LAP_KELASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LAP_KELASActionPerformed
        new Laporan_data_kelas1().show();
        this.dispose();
    }//GEN-LAST:event_LAP_KELASActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Yakin ingin Logout?", "Data Jadwal Pelajaran SMP", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            new login.Menu_Login().setVisible(true);
            this.dispose();
            this.setVisible(false);
        }
    }//GEN-LAST:event_exitActionPerformed

    private void btnSIMPANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSIMPANActionPerformed
        try {
            String sql = "INSERT INTO `tb_jadwal` VALUES ("
            + "'"+TKD_JADWAL.getText()+"',"
            + "'"+TKD_KELAS.getText()+"',"
            + "'"+TKELAS.getText().toString()+"',"
            + "'"+TNIP.getText()+"',"
            + "'"+TGURU.getText()+"',"
            + "'"+TMAPEL.getText().toString()+"',"
            + "'"+THARI.getSelectedItem()+"',"
            + "'"+TWAKTU.getText()+"')";             
            java.sql.Connection conn = (Connection)koneksi.getConnection();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
                JOptionPane.showMessageDialog(null, "Proses Simpan Data Berhasil");
                loadDataTable_jadwal();
                clear();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
        }
    }//GEN-LAST:event_btnSIMPANActionPerformed

    private void btnUPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUPDATEActionPerformed
        try {
            String sql = "UPDATE `tb_jadwal` SET "
            + "`kd_kelas`='"+TKD_KELAS.getText()+"',"
            + "`kelas`='"+TKELAS.getText()+"',"
            + "`nip`='"+TNIP.getText()+"',"
            + "`nm_guru`='"+TGURU.getText()+"',"
            + "`mapel`='"+TMAPEL.getText()+"',"
            + "`hari`='"+THARI.getSelectedItem()+"',"
            + "`jam`='"+TWAKTU.getText()+"' "
            + "WHERE kd_jadwal='"+TKD_JADWAL.getText()+"'";
            java.sql.Connection conn = (Connection)koneksi.getConnection();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
                JOptionPane.showMessageDialog(null, "Proses Ubah Data Berhasil");
                loadDataTable_jadwal();
                clear();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
        }
    }//GEN-LAST:event_btnUPDATEActionPerformed

    private void btnRESETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRESETActionPerformed
        clear();
        otomatis_kode();
    }//GEN-LAST:event_btnRESETActionPerformed

    private void btnCETAKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCETAKActionPerformed
    try{
            InputStream file = getClass().getResourceAsStream("/Menu_Master/lapjadwal.jrxml");
            JasperDesign jasperDesign = JRXmlLoader.load(file);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null,koneksi.getConnection());
            JasperViewer.viewReport(jasperPrint,false);
        }catch(Exception ex)
        {
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnCETAKActionPerformed

    private void btnHAPUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHAPUSActionPerformed
        try {
            String sql = "DELETE FROM tb_jadwal WHERE kd_jadwal='"+TKD_JADWAL.getText()+"'";
            java.sql.Connection conn = (Connection)koneksi.getConnection();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Proses Hapus Data Berhasil");
            loadDataTable_jadwal();
            clear();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
        }
    }//GEN-LAST:event_btnHAPUSActionPerformed

    private void btnKEMBALIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKEMBALIActionPerformed
        menu_utama1 dsb = new menu_utama1();
        dsb.dashKesiswaan();
        dsb.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnKEMBALIActionPerformed

    private void table_jadwalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_jadwalMouseClicked
        int baris = table_jadwal.rowAtPoint(evt.getPoint());
            String kd_jadwal = table_jadwal.getValueAt(baris, 0).toString();
            TKD_JADWAL.setText(kd_jadwal);
            String kd_kelas = table_jadwal.getValueAt(baris, 1).toString();
            TKD_KELAS.setText(kd_kelas);
            String kelas = table_jadwal.getValueAt(baris, 2).toString();
            TKELAS.setText(kelas);
            String nip = table_jadwal.getValueAt(baris, 3).toString();
            TNIP.setText(nip);
            String guru = table_jadwal.getValueAt(baris, 4).toString();
            TGURU.setText(guru);
            String mapel = table_jadwal.getValueAt(baris, 5).toString();
            TMAPEL.setText(mapel);
            String hari = table_jadwal.getValueAt(baris, 6).toString();
            THARI.setSelectedItem(hari);
            String jam = table_jadwal.getValueAt(baris, 7).toString();
            TWAKTU.setText(jam);
    }//GEN-LAST:event_table_jadwalMouseClicked

    private void MINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MINActionPerformed
      this.setExtendedState(menu_utama.ICONIFIED);  
    }//GEN-LAST:event_MINActionPerformed

    private void MAKSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MAKSActionPerformed
           if (this.getExtendedState()!= Data_Jadwal.MAXIMIZED_BOTH) {
            this.setExtendedState (Data_Jadwal.MAXIMIZED_BOTH);
        }else{
            this.setExtendedState (Data_Jadwal.NORMAL);
           } 
    }//GEN-LAST:event_MAKSActionPerformed

    private void table_kelasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_kelasMouseClicked
        int baris = table_kelas.rowAtPoint(evt.getPoint());       
            String nim = table_kelas.getValueAt(baris, 0).toString();
            TKD_KELAS.setText(nim);
            String kls = table_kelas.getValueAt(baris, 3).toString();
            TKELAS.setText(kls);   
    }//GEN-LAST:event_table_kelasMouseClicked

    private void btnCARI2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCARI2ActionPerformed
        String key = cmbSearch.getSelectedItem().toString();
        System.out.println(key);
        if(key!=""){
            cariData_guru(key);
            cmbSearch.setSelectedItem("--- Mata Pelajaran ---");
        } else{
            loadDataTable_guru();
        }
    }//GEN-LAST:event_btnCARI2ActionPerformed

    private void btnreset2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreset2ActionPerformed
        clear();
        loadDataTable_guru();
    }//GEN-LAST:event_btnreset2ActionPerformed

    private void btnCARI1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCARI1ActionPerformed
        try {
            String sql = "SELECT * FROM tb_jadwal where nm_guru like '%"
                    + txtCARI4.getText() + "%'"
                    + "or mapel like '%" + txtCARI4.getText();        
            java.sql.Connection conn = (Connection)koneksi.getConnection();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
        } catch (HeadlessException | SQLException e){
        }
         loadDataTable_jadwal();          
    }//GEN-LAST:event_btnCARI1ActionPerformed

    private void btnreset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreset1ActionPerformed
        clear();
        loadDataTable_jadwal();
        txtCARI4.setText("");
    }//GEN-LAST:event_btnreset1ActionPerformed

    private void btnCARI4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCARI4ActionPerformed
     String key = cmbsearch2.getSelectedItem().toString();
        System.out.println(key);
          if(key!=""){
            cariData_kelas(key);
            cmbsearch2.setSelectedItem("--- Pilih Kelas ---");
        } else{
            loadDataTable_kelas();
        }
    }//GEN-LAST:event_btnCARI4ActionPerformed

    private void btnreset4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreset4ActionPerformed
        clear();
        loadDataTable_kelas();
    }//GEN-LAST:event_btnreset4ActionPerformed

    private void table_guruMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_guruMouseClicked
        int baris = table_guru.rowAtPoint(evt.getPoint());
            String nip = table_guru.getValueAt(baris, 0).toString();
            TNIP.setText(nip);
           String nama = table_guru.getValueAt(baris, 1).toString();
            TGURU.setText(nama);
            String mapel = table_guru.getValueAt(baris, 2).toString();
            TMAPEL.setText(mapel);    
    }//GEN-LAST:event_table_guruMouseClicked

    private void LAP_JADWALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LAP_JADWALActionPerformed
        new Laporan_data_jadwal1().show();
        this.dispose(); 
    }//GEN-LAST:event_LAP_JADWALActionPerformed

    private void JADWALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JADWALActionPerformed
        new Data_Jadwal().show();
        this.dispose();
    }//GEN-LAST:event_JADWALActionPerformed

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
            java.util.logging.Logger.getLogger(Data_Jadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Data_Jadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Data_Jadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Data_Jadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Data_Jadwal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem GURU;
    private javax.swing.JMenuItem JADWAL;
    private javax.swing.JMenuItem KELAS;
    private javax.swing.JMenuItem LAP_GURU;
    private javax.swing.JMenuItem LAP_JADWAL;
    private javax.swing.JMenuItem LAP_KELAS;
    private javax.swing.JMenuItem LAP_SISWA;
    private javax.swing.JButton MAKS;
    private javax.swing.JButton MIN;
    private javax.swing.JMenuItem SISWA;
    private javax.swing.JTextField TGURU;
    private javax.swing.JComboBox<String> THARI;
    private javax.swing.JTextField TKD_JADWAL;
    private javax.swing.JTextField TKD_KELAS;
    private javax.swing.JTextField TKELAS;
    private javax.swing.JTextField TMAPEL;
    private javax.swing.JTextField TNIP;
    private javax.swing.JTextField TWAKTU;
    private javax.swing.JButton btnCARI1;
    private javax.swing.JButton btnCARI2;
    private javax.swing.JButton btnCARI4;
    private javax.swing.JButton btnCETAK;
    private javax.swing.JButton btnHAPUS;
    private javax.swing.JButton btnKEMBALI;
    private javax.swing.JButton btnRESET;
    private javax.swing.JButton btnSIMPAN;
    private javax.swing.JButton btnUPDATE;
    private javax.swing.JButton btnreset1;
    private javax.swing.JButton btnreset2;
    private javax.swing.JButton btnreset4;
    private javax.swing.JComboBox<String> cmbSearch;
    private javax.swing.JComboBox<String> cmbsearch2;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable table_guru;
    private javax.swing.JTable table_jadwal;
    private javax.swing.JTable table_kelas;
    private javax.swing.JTextField txtCARI4;
    private javax.swing.JLabel txtTGL2;
    private javax.swing.JLabel waktu;
    // End of variables declaration//GEN-END:variables

   private void otomatis_kode(){
        try{    
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_datasekolah","root","");
             Statement stat = con.createStatement();
                                                                                                             //descending
             ResultSet rs = stat.executeQuery("SELECT * from tb_jadwal order by kd_jadwal desc ");
                if (rs.next()){
                    String kode = rs.getString("kd_jadwal").substring(2);
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
                    TKD_JADWAL.setText("KJ" + Nol +AN);
                }else{
                    TKD_JADWAL.setText("KJ001");
                }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
    }
    }

}
