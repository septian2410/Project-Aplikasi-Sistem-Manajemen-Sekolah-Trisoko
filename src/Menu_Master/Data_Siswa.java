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

import beranda.menu_utama;
import beranda.menu_utama1;

import java.awt.HeadlessException;
import java.io.InputStream;
import static java.lang.Thread.sleep;

import java.sql.*;
import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import server.koneksi;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

public class Data_Siswa extends javax.swing.JFrame {

    public void tanggal_jam_sekarang() {
        Thread p;
        p = new Thread() {
            public void run() {
                for (;;) {

                    Calendar cal = new GregorianCalendar();

                    int jam = cal.get(Calendar.HOUR);
                    int menit = cal.get(Calendar.MINUTE);
                    int detik = cal.get(Calendar.SECOND);
                    int AM_PM = cal.get(Calendar.AM_PM);

                    String day_night = "";
                    if (AM_PM == 1) {
                        day_night = "PM";
                    } else {
                        day_night = "AM";
                    }
                    String waktuu = jam + ":" + menit + ":" + detik + " " + day_night;
                    waktu.setText(waktuu);

                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Data_Siswa.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        p.start();
    }
    
    private String kodeAutomatic;

    public Data_Siswa() {
        initComponents();
        setLocationRelativeTo(this);
        loadDataTable();
        clear();
        autofillTAHUN();
        autofillKELAS();
        tanggal();
        tanggal_jam_sekarang();
    }
    
    int _tahun;   

    public void tanggal() {             
        Date ys = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        txtTGL2.setText(s.format(ys));

    }
  
    Statement st;
    Connection con = koneksi.getConnection();
    ResultSet rs;
    DefaultTableModel model;

    private void loadDataTable() {
        DefaultTableModel model = new DefaultTableModel();
        String[] judul = {"NISN","NIS","Nama","Kelas","Tgl Lahir","Asal","Kelamin","Agama","No.Telp","Alamat","Angkatan"};
        model = new DefaultTableModel(judul,0);
        table_siswa.setModel(model);
        String sql = "SELECT tb_data_siswa.*, spp.tahun from tb_data_siswa INNER JOIN spp Using(id_spp) where nis like '%"+cari.getText()+"%' or nama like '%"+cari.getText()+"%'";
        try {
            rs = con.createStatement().executeQuery(sql);
            while(rs.next()) {
               String nisn = rs.getString("nisn");
               String nis = rs.getString("nis");
               String nama = rs.getString("nama");
               String kelas = rs.getString("kelas");
               String ttl = rs.getString("ttl");
               String asal = rs.getString("asal");
               String kelamin = rs.getString("jenis_kelamin");
               String agama = rs.getString("agama");
               String telp = rs.getString("telp");
               String alamat = rs.getString("alamat");
               String tahun = rs.getString("tahun");
               String[] data = {nisn, nis, nama, kelas, ttl, asal, kelamin, agama, telp, alamat, tahun};
               model.addRow(data);
           }
        }catch(Exception e) {
           System.out.println(e);
        }
    
    }
    
    private void cariData(String key) {
        DefaultTableModel model = new DefaultTableModel();
        String[] judul = {"NISN","NIS","Nama","Kelas","Tgl Lahir","Asal","Kelamin","Agama","No.Telp","Alamat","Angkatan"};
        model = new DefaultTableModel(judul,0);
        table_siswa.setModel(model);
        String sql = "SELECT  tb_data_siswa.*, spp.tahun from tb_data_siswa INNER JOIN spp Using(id_spp) WHERE kelas = '"+key+"'";
        try {
            rs = con.createStatement().executeQuery(sql);
            while(rs.next()) {
               String nisn = rs.getString("nisn");
               String nis = rs.getString("nis");
               String nama = rs.getString("nama");
               String kelas = rs.getString("kelas");
               String ttl = rs.getString("ttl");
               String asal = rs.getString("asal");
               String kelamin = rs.getString("jenis_kelamin");
               String agama = rs.getString("agama");
               String telp = rs.getString("telp");
               String alamat = rs.getString("alamat");
               String tahun = rs.getString("tahun");
               String[] data = {nisn ,nis, nama, kelas, ttl, asal, kelamin, agama, telp, alamat, tahun};
               model.addRow(data);
           }
        }catch(Exception e) {
           System.out.println(e);
        }
    
    }

    private void clear() {
        txtNISN.setText("");
        txtNIS.setText("");
        cmbKELAS.setSelectedItem("-- Pilih Kelas --");
        txtNAMA.setText("");
        txtTGL_LAHIR.setDate(null);
        cmbKELAMIN.setSelectedItem("-- Pilih Jenis Kelamin --");
        cmbAGAMA.setSelectedItem("-- Pilih Agama --");
        txtTELP.setText("");
        txtALAMAT.setText("");
        TASAL.setSelectedItem("-- Pilih Asal Daerah --");
        CBTAHUN.setSelectedItem("~angkatan tahun");
    }

       public static Date getTanggalFromTable(JTable table, int kolom){
        JTable tabel = table;
        String str_tgl = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), kolom));
        Date tanggal = null;
        try{
            tanggal = new SimpleDateFormat("yyyy-MM-dd").parse(str_tgl);
        }catch(ParseException ex) {
            Logger.getLogger(Data_Siswa.class.getName()).log(Level.SEVERE, null, ex);
              System.out.println("There is an error : " + ex.getMessage());
        }
        return tanggal;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        txtTGL2 = new javax.swing.JLabel();
        waktu = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnCari = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btnreset = new javax.swing.JButton();
        cmbKELAS2 = new javax.swing.JComboBox<>();
        cari = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnUPDATE = new javax.swing.JButton();
        btnSIMPAN = new javax.swing.JButton();
        btnKEMBALI = new javax.swing.JButton();
        btnRESET = new javax.swing.JButton();
        btnHAPUS = new javax.swing.JButton();
        btnCETAK1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cmbAGAMA = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNIS = new javax.swing.JTextField();
        cmbKELAS = new javax.swing.JComboBox<>();
        txtNAMA = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTELP = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cmbKELAMIN = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtALAMAT = new javax.swing.JTextArea();
        txtTGL_LAHIR = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        TASAL = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        CBTAHUN = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        txtNISN = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_siswa = new javax.swing.JTable();
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

        jPanel5.setBackground(new java.awt.Color(6, 68, 32));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("DATA SISWA");

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

        jPanel4.setBackground(new java.awt.Color(228, 239, 231));

        jPanel2.setBackground(new java.awt.Color(253, 250, 246));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnCari.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-search-30-2.png"))); // NOI18N
        btnCari.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Cari Kelas");

        btnreset.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnreset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-clear-search-30.png"))); // NOI18N
        btnreset.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });

        cmbKELAS2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Pilih Kelas ---", "VII A", "VII B", "VII C", "VII D", "VII E", " ", "---------", "VIII A", "VIII B", "VIII C", "VIII D", "VIII E", " ", "---------", "IX A", "IX B", "IX C", "IX D", "IX E", " " }));

        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cariKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cariKeyReleased(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Cari Siswa");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cari)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnreset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCari))
                    .addComponent(cmbKELAS2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cmbKELAS2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnreset, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(253, 250, 246));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnUPDATE.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnUPDATE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-edit-30-2.png"))); // NOI18N
        btnUPDATE.setText("UBAH");
        btnUPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUPDATEActionPerformed(evt);
            }
        });

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

        btnRESET.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnRESET.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-reset-30.png"))); // NOI18N
        btnRESET.setText("REFRESH");
        btnRESET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRESETActionPerformed(evt);
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

        btnCETAK1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnCETAK1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-print-30.png"))); // NOI18N
        btnCETAK1.setText("CETAK");
        btnCETAK1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCETAK1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSIMPAN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRESET)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCETAK1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHAPUS, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKEMBALI)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSIMPAN, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRESET, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKEMBALI, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHAPUS, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCETAK1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(253, 250, 246));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        cmbAGAMA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih Agama --", "Islam", "Khatolik", "Budha", "Hindu", "Kristen" }));

        jLabel2.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Kelas");

        jLabel7.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Agama");

        txtNIS.setFont(new java.awt.Font("Source Sans Pro", 0, 12)); // NOI18N

        cmbKELAS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih Kelas --" }));

        jLabel3.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Nama");

        jLabel6.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("NIS");

        jLabel4.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Telp");

        jLabel5.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Alamat");

        jLabel9.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Tanggal Lahir");

        jLabel11.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Jenis Kelamin");

        cmbKELAMIN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih Jenis Kelamin --", "Laki-laki", "Perempuan" }));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        txtALAMAT.setColumns(20);
        txtALAMAT.setRows(5);
        jScrollPane2.setViewportView(txtALAMAT);

        jLabel12.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Asal Daerah");

        TASAL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih Asal Daerah --", "Jawa Timur", "Jawa Tengah ", "Jawa Barat", "Yogyakarta ", "Lampung", "Madura", "DKI Jakarta", "Sumatera Utara", "Sumatera Barat", "Sumatera Timur ", "Sulawesi Selatan", "Kalimantan", "Kalimantan Barat", "Kalimantan Selatan", "Jambi", "Bengkulu", "Riau", "Kepulauan Riau", "Bangka-Belitung", "Banten", "Bali", "Lombok", "Sumbawa" }));

        jLabel13.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Tahun");

        CBTAHUN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "~angkatan tahun" }));
        CBTAHUN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBTAHUNActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("NISN");

        txtNISN.setFont(new java.awt.Font("Source Sans Pro", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(37, 37, Short.MAX_VALUE)
                        .addComponent(TASAL, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNISN)
                            .addComponent(txtNAMA, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbKELAS, javax.swing.GroupLayout.Alignment.TRAILING, 0, 204, Short.MAX_VALUE)
                            .addComponent(txtNIS, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTGL_LAHIR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(CBTAHUN, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbKELAMIN, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTELP, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbAGAMA, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbKELAMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbAGAMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTELP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(CBTAHUN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNISN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNIS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbKELAS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtNAMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel9)
                                .addComponent(txtTGL_LAHIR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12)
                                .addComponent(TASAL, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        table_siswa.setModel(new javax.swing.table.DefaultTableModel(
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
        table_siswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_siswaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_siswa);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtTGL2, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .addGap(323, 323, 323)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(347, 347, 347)
                        .addComponent(MIN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MAKS))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(waktu, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTGL2)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(waktu, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(MAKS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(48, 48, 48))
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
        LAP_JADWAL.setText("Jadwal");
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
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 1136, 662);
    }// </editor-fold>//GEN-END:initComponents

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        clear();
        loadDataTable();
        cmbKELAS2.setSelectedItem("--- Pilih Bidang ---");
    }//GEN-LAST:event_btnresetActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        String key = cmbKELAS2.getSelectedItem().toString();
        System.out.println(key);        
        if(key!=""){
            cariData(key);
            cmbKELAS2.setSelectedItem("--- Pilih Kelas ---");
        } else{
            loadDataTable();
        }
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnSIMPANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSIMPANActionPerformed
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(txtTGL_LAHIR.getDate()));
        int tahun = _tahun;
        try {
            String sql = "INSERT INTO `tb_data_siswa` VALUES ("
                    + "'"+txtNISN.getText()+"'," 
                    + "'"+txtNIS.getText()+"',"
                    + "'"+txtNAMA.getText()+"',"
                    + "'"+cmbKELAS.getSelectedItem().toString()+"',"
                    + "'"+tanggal+"',"
                    + "'"+TASAL.getSelectedItem().toString()+"',"
                    + "'"+cmbKELAMIN.getSelectedItem().toString()+"',"
                    + "'"+cmbAGAMA.getSelectedItem().toString()+"',"
                    + "'"+txtTELP.getText()+"',"
                    + "'"+txtALAMAT.getText()+"'," 
                    + "'"+tahun+"')";
            java.sql.Connection conn = (Connection) koneksi.getConnection();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
                JOptionPane.showMessageDialog(null, "Proses Simpan Data Berhasil");
                clear();
                loadDataTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
        }
    }//GEN-LAST:event_btnSIMPANActionPerformed

    private void btnRESETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRESETActionPerformed
  clear();
    }//GEN-LAST:event_btnRESETActionPerformed

    private void btnUPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUPDATEActionPerformed
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(txtTGL_LAHIR.getDate()));
        int tahun = _tahun;
        try {
            String sql = "UPDATE `tb_data_siswa` SET "
                    + "`nisn`='"+txtNISN.getText()+"',"
                    + "`nama`='"+txtNAMA.getText()+"',"
                    + "`kelas`='"+cmbKELAS.getSelectedItem().toString()+"',"
                    + "`ttl`='"+tanggal+"',"
                    + "`asal`='"+TASAL.getSelectedItem().toString()+"',"
                    + "`jenis_kelamin`='"+cmbKELAMIN.getSelectedItem().toString()+"',"
                    + "`agama`='"+cmbAGAMA.getSelectedItem().toString()+"',"
                    + "`telp`='"+txtTELP.getText()+"',"
                    + "`alamat`='"+txtALAMAT.getText()+"',"
                    + "`id_spp`='"+tahun+"' "
                    + "WHERE `nis`='"+txtNIS.getText()+"'";
            java.sql.Connection conn = (Connection) koneksi.getConnection();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
                JOptionPane.showMessageDialog(null, "Proses Ubah Data Berhasil");
                loadDataTable();
                clear();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
        }
    }//GEN-LAST:event_btnUPDATEActionPerformed

    private void btnKEMBALIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKEMBALIActionPerformed
        menu_utama1 dsb = new menu_utama1();
        dsb.dashKesiswaan();
        dsb.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnKEMBALIActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
          if (JOptionPane.showConfirmDialog(null, "Yakin ingin Logout?", "Data Siswa", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            new login.Menu_Login().setVisible(true);
                this.dispose();
                    this.setVisible(false);
        }         
    }//GEN-LAST:event_exitActionPerformed

    private void GURUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GURUActionPerformed
        new Data_Guru().show();
        this.dispose();
    }//GEN-LAST:event_GURUActionPerformed

    private void SISWAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SISWAActionPerformed
        new Data_Siswa().show();
        this.dispose();
    }//GEN-LAST:event_SISWAActionPerformed

    private void JADWALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JADWALActionPerformed
        new Data_Jadwal().show();
        this.dispose();
    }//GEN-LAST:event_JADWALActionPerformed

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
    private void LAP_JADWALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LAP_JADWALActionPerformed
        new Laporan_data_jadwal1().show();
        this.dispose();
    }//GEN-LAST:event_LAP_JADWALActionPerformed
    private void LAP_KELASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LAP_KELASActionPerformed
        new Laporan_data_kelas1().show();
        this.dispose();
    }//GEN-LAST:event_LAP_KELASActionPerformed
    private void table_siswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_siswaMouseClicked
        int baris = table_siswa.rowAtPoint(evt.getPoint());
            String nisn = table_siswa.getValueAt(baris, 0).toString();
            txtNISN.setText(nisn);
            String nis = table_siswa.getValueAt(baris, 1).toString();
            txtNIS.setText(nis);
            String nama = table_siswa.getValueAt(baris, 2).toString();
            txtNAMA.setText(nama);        
            String kelas = table_siswa.getValueAt(baris, 3).toString();
            cmbKELAS.setSelectedItem(kelas);
            txtTGL_LAHIR.setDate(getTanggalFromTable(table_siswa, 4));
            String asal = table_siswa.getValueAt(baris, 5).toString();
            TASAL.setSelectedItem(asal);
            String jeniskelamin = table_siswa.getValueAt(baris, 6).toString();
            cmbKELAMIN.setSelectedItem(jeniskelamin);
            String agama = table_siswa.getValueAt(baris, 7).toString();
            cmbAGAMA.setSelectedItem(agama);
            String telp = table_siswa.getValueAt(baris, 8).toString();
            txtTELP.setText(telp);
            String alamat = table_siswa.getValueAt(baris, 9).toString();
            txtALAMAT.setText(alamat);
            String tahun = table_siswa.getValueAt(baris, 10).toString();
            CBTAHUN.setSelectedItem(tahun); 
    }//GEN-LAST:event_table_siswaMouseClicked

    private void btnHAPUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHAPUSActionPerformed
        try {
            String sql = "DELETE FROM tb_data_siswa WHERE nis='" + txtNIS.getText() + "'";
            java.sql.Connection conn = (Connection) koneksi.getConnection();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Proses Hapus Data Berhasil");
            loadDataTable();
            clear();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
        }
    }//GEN-LAST:event_btnHAPUSActionPerformed

    private void btnCETAK1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCETAK1ActionPerformed
    try{
        InputStream file = getClass().getResourceAsStream("/Menu_Master/lapsiswa.jrxml");
        JasperDesign jasperDesign = JRXmlLoader.load(file);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null,koneksi.getConnection());
        JasperViewer.viewReport(jasperPrint,false);
    }catch(Exception ex)
    {
        System.out.println(ex);
        }
    }//GEN-LAST:event_btnCETAK1ActionPerformed

    private void MINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MINActionPerformed
        // TODO add your handling code here:
        this.setExtendedState(Data_Siswa.ICONIFIED);
    }//GEN-LAST:event_MINActionPerformed

    private void MAKSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MAKSActionPerformed
        if (this.getExtendedState()!= Data_Siswa.MAXIMIZED_BOTH) {
            this.setExtendedState (Data_Siswa.MAXIMIZED_BOTH);
        }else{
            this.setExtendedState (Data_Siswa.NORMAL);
        }
    }//GEN-LAST:event_MAKSActionPerformed

    private void CBTAHUNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBTAHUNActionPerformed
       try {
            String comboboxIsi = CBTAHUN.getSelectedItem().toString();
            rs = con.createStatement().executeQuery("select * from spp where tahun='"+comboboxIsi+"'");
            while(rs.next()) {
                _tahun = Integer.parseInt(rs.getString("id_spp"));
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_CBTAHUNActionPerformed

    private void cariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyPressed
    loadDataTable();
    }//GEN-LAST:event_cariKeyPressed

    private void cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyReleased
    loadDataTable();
    }//GEN-LAST:event_cariKeyReleased

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
            java.util.logging.Logger.getLogger(Data_Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Data_Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Data_Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Data_Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new Data_Siswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBTAHUN;
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
    private javax.swing.JComboBox<String> TASAL;
    private javax.swing.JButton btnCETAK1;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHAPUS;
    private javax.swing.JButton btnKEMBALI;
    private javax.swing.JButton btnRESET;
    private javax.swing.JButton btnSIMPAN;
    private javax.swing.JButton btnUPDATE;
    private javax.swing.JButton btnreset;
    private javax.swing.JTextField cari;
    private javax.swing.JComboBox<String> cmbAGAMA;
    private javax.swing.JComboBox<String> cmbKELAMIN;
    private javax.swing.JComboBox<String> cmbKELAS;
    private javax.swing.JComboBox<String> cmbKELAS2;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable table_siswa;
    private javax.swing.JTextArea txtALAMAT;
    private javax.swing.JTextField txtNAMA;
    private javax.swing.JTextField txtNIS;
    private javax.swing.JTextField txtNISN;
    private javax.swing.JTextField txtTELP;
    private javax.swing.JLabel txtTGL2;
    private com.toedter.calendar.JDateChooser txtTGL_LAHIR;
    private javax.swing.JLabel waktu;
    // End of variables declaration//GEN-END:variables

 private void autofillTAHUN() {                
    try {
           rs = con.createStatement().executeQuery("select * from spp");
           while (rs.next()) {
               CBTAHUN.addItem(rs.getString("tahun"));
           }         
       } catch (Exception e) {
           System.out.println(e);
       }
    }
    
  private void autofillKELAS() {                
       try {
           rs = con.createStatement().executeQuery("select * from tb_data_kelas");
           while (rs.next()) {
               cmbKELAS.addItem(rs.getString("kelas"));
           }         
       } catch (Exception e) {
           System.out.println(e);
       }
    }
  
}
