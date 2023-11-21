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
import net.sf.jasperreports.view.JasperViewer;;

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

import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class Data_Guru extends javax.swing.JFrame {

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
                        Logger.getLogger(Data_Guru.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
p.start();
}
    
    public Data_Guru() {
        initComponents();
        setLocationRelativeTo(this);
        loadDataTable();
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
        model.addColumn("NIP");
        model.addColumn("Nama");
        model.addColumn("Mata Pelajaran");
        model.addColumn("Jenis Kelamin");
        model.addColumn("Tanggal Lahir");
        model.addColumn("Asal");
        model.addColumn("Agama");
        model.addColumn("No Telpon");
        model.addColumn("Alamat");
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
                    res.getString(4), 
                    res.getString(5), 
                    res.getString(6),
                    res.getString(7),
                    res.getString(8),
                    res.getString(9)
                 });
            }
            table_guru.setModel(model);
        } catch (SQLException e) {
            System.out.println("There is an error : " + e.getMessage());
        }
    }
    
    private void cariData(String key){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("NIP");
        model.addColumn("Nama");
        model.addColumn("Mata Pelajaran");
        model.addColumn("Jenis Kelamin");
        model.addColumn("Tanggal Lahir");
        model.addColumn("Asal");
        model.addColumn("Agama");
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
                    no++, 
                res.getString(1), 
                    res.getString(2), 
                    res.getString(3), 
                    res.getString(4), 
                    res.getString(5), 
                    res.getString(6),
                    res.getString(7),
                    res.getString(8),
                    res.getString(9)
                    });
            }
            table_guru.setModel(model);
        } catch (SQLException e) {
            System.out.println("There is an error : " + e.getMessage());
        }
    }
    
    private void clear(){
        txtNIP.setText("");
        txtNAMA.setText("");
        cmbMAPEL.setSelectedItem("-- Mata Pelajaran --");
        cmbKELAMIN.setSelectedItem("-- Pilih Jenis Kelamin --");
        txtTTL.setDate(null);
        TASAL.setSelectedItem("-- Pilih Asal Daerah --");
        cmbAGAMA.setSelectedItem("-- Pilih Agama --");
        txtTELP.setText("");
        TALAMAT.setText("");
        
    }

       public static Date getTanggalFromTable(JTable table, int kolom){
        JTable tabel = table;
        String str_tgl = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), kolom));
        Date tanggal = null;
        try{
            tanggal = new SimpleDateFormat("yyyy-MM-dd").parse(str_tgl);
        }catch(ParseException ex) {
            Logger.getLogger(Data_Guru.class.getName()).log(Level.SEVERE, null, ex);
              System.out.println("There is an error : " + ex.getMessage());
        }
        return tanggal;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        txtNIP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNAMA = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbMAPEL = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cmbKELAMIN = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtTTL = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        cmbAGAMA = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtTELP = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TASAL = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TALAMAT = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cmbSearch = new javax.swing.JComboBox<>();
        btnReset = new javax.swing.JButton();
        CARI = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_guru = new javax.swing.JTable();
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
        jLabel18.setText("DATA GURU");

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
                .addComponent(btnKEMBALI)
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

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel1.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("NIP");

        txtNIP.setFont(new java.awt.Font("Source Sans Pro", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Nama");

        txtNAMA.setFont(new java.awt.Font("Source Sans Pro", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Mapel");

        cmbMAPEL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Mata Pelajaran --", "--Umum--", "Bahasa Indonesia", "Bahasa Inggris", "Ipa", "Ips", "Kewirausahaan", "Matematika", "Kewarganegaraan", "Pendidikan Agama", "Penjasorkes", "Seni Budaya", "Bimbingan konseling" }));

        jLabel4.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Jenis Kelamin");

        cmbKELAMIN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih Jenis Kelamin --", "Laki-laki", "Perempuan" }));

        jLabel5.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Tanggal Lahir");

        jLabel11.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Agama");

        cmbAGAMA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih Agama --", "Islam", "Khatolik", "Budha", "Hindu", "Kristen" }));

        jLabel10.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Telp");

        jLabel6.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Asal Daerah");

        TASAL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih Asal Daerah --", "Jawa Timur", "Jawa Tengah ", "Jawa Barat", "Yogyakarta ", "Lampung", "Madura", "DKI Jakarta", "Sumatera Utara", "Sumatera Barat", "Sumatera Timur ", "Sulawesi Selatan", "Kalimantan", "Kalimantan Barat", "Kalimantan Selatan", "Jambi", "Bengkulu", "Riau", "Kepulauan Riau", "Bangka-Belitung", "Banten", "Bali", "Lombok", "Sumbawa" }));

        jLabel7.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Alamat");

        TALAMAT.setColumns(20);
        TALAMAT.setRows(5);
        jScrollPane1.setViewportView(TALAMAT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNAMA)
                            .addComponent(cmbMAPEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNIP)
                            .addComponent(cmbKELAMIN, 0, 150, Short.MAX_VALUE)
                            .addComponent(TASAL, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(95, 95, 95)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cmbAGAMA, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTELP)
                        .addComponent(txtTTL, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtNIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNAMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(cmbMAPEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(cmbKELAMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(TASAL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(txtTTL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(cmbAGAMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txtTELP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jSeparator1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(253, 250, 246));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel8.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Cari Mapel");

        cmbSearch.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        cmbSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Mata Pelajaran ---", "Bahasa Indonesia", "Bahasa Inggris", "Ipa", "Ips", "Kewirausahaan", "Matematika", "Kewarganegaraan", "Pendidikan Agama", "Penjasorkes", "Seni Budaya", "Bimbingan konseling" }));

        btnReset.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-clear-search-30.png"))); // NOI18N
        btnReset.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        CARI.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        CARI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-search-30-2.png"))); // NOI18N
        CARI.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CARI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CARIActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CARI))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(cmbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CARI))
                .addContainerGap(19, Short.MAX_VALUE))
        );

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
        jScrollPane2.setViewportView(table_guru);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
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
                        .addComponent(txtTGL2, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                        .addGap(365, 365, 365)
                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                        .addGap(388, 388, 388)
                        .addComponent(MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MAKS, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(waktu, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(1040, Short.MAX_VALUE))))
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTGL2)
                            .addComponent(jLabel18)))
                    .addComponent(MAKS, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(waktu, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 1136, 662);
    }// </editor-fold>//GEN-END:initComponents

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

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
     if (JOptionPane.showConfirmDialog(null, "Yakin ingin Logout?", "Data Guru", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            new login.Menu_Login().setVisible(true);
            this.dispose();
            this.setVisible(false);
        }
    }//GEN-LAST:event_exitActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        clear();
        loadDataTable();
        cmbSearch.setSelectedItem("--- Mata Pelajaran ---");
    }//GEN-LAST:event_btnResetActionPerformed

    private void CARIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CARIActionPerformed
        String key = cmbSearch.getSelectedItem().toString();
        System.out.println(key);
         if(key!=""){
            cariData(key);
            cmbSearch.setSelectedItem("--- Mata Pelajaran ---");
        } else{
            loadDataTable();
        }
    }//GEN-LAST:event_CARIActionPerformed

    private void btnSIMPANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSIMPANActionPerformed
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(txtTTL.getDate()));
         try {
            String sql = "INSERT INTO `tb_data_guru` VALUES ("
            + "'"+txtNIP.getText()+"',"
            + "'"+txtNAMA.getText()+"',"
            + "'"+cmbMAPEL.getSelectedItem().toString()+"',"
            + "'"+cmbKELAMIN.getSelectedItem().toString()+"',"
            + "'"+tanggal+"',"
            + "'"+TASAL.getSelectedItem().toString()+"',"
            + "'"+cmbAGAMA.getSelectedItem().toString()+"',"
            + "'"+txtTELP.getText()+"',"
            + "'"+TALAMAT.getText()+"')";
                    
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
        String tanggal = String.valueOf(fm.format(txtTTL.getDate()));
         try {
            String sql = "UPDATE `tb_data_guru` SET "
            + "`nm_guru`='"+txtNAMA.getText()+"',"
            + "`mapel`='"+cmbMAPEL.getSelectedItem()+"',"
            + "`jenis_kelamin`='"+cmbKELAMIN.getSelectedItem()+"',"
            + "`ttl`='"+tanggal+"',"
            + "`asal`='"+TASAL.getSelectedItem()+"',"
            + "`agama`='"+cmbAGAMA.getSelectedItem()+"',"
            + "`telpon`='"+txtTELP.getText()+"',"
            + "`alamat`='"+TALAMAT.getText()+"' "
            + "WHERE nip='"+txtNIP.getText()+"'";
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
    }//GEN-LAST:event_btnRESETActionPerformed

    private void btnCETAKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCETAKActionPerformed
      try{
            InputStream file = getClass().getResourceAsStream("/Menu_Master/lapguru.jrxml");
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
            String sql = "DELETE FROM tb_data_guru WHERE nip='"+txtNIP.getText()+"'";
            java.sql.Connection conn = (Connection)koneksi.getConnection();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();

            JOptionPane.showMessageDialog(null, "Proses Hapus Data Berhasil");
            loadDataTable();
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

    private void table_guruMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_guruMouseClicked
    int baris = table_guru.rowAtPoint(evt.getPoint());
        String nip = table_guru.getValueAt(baris, 0).toString();
        txtNIP.setText(nip);
        String nama = table_guru.getValueAt(baris, 1).toString();
        txtNAMA.setText(nama);
        String mapel = table_guru.getValueAt(baris, 2).toString();
        cmbMAPEL.setSelectedItem(mapel);
        String jenis_kelamin = table_guru.getValueAt(baris, 3).toString();
        cmbKELAMIN.setSelectedItem(jenis_kelamin);
        txtTTL.setDate(getTanggalFromTable(table_guru, 4));
        String asal = table_guru.getValueAt(baris, 5).toString();
        TASAL.setSelectedItem(asal);
        String agama = table_guru.getValueAt(baris, 6).toString();
        cmbAGAMA.setSelectedItem(agama);
        String telp = table_guru.getValueAt(baris, 7).toString();
        txtTELP.setText(telp);
        String alamat = table_guru.getValueAt(baris, 8).toString();
        TALAMAT.setText(alamat);
    }//GEN-LAST:event_table_guruMouseClicked

    private void MINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MINActionPerformed
    this.setExtendedState(menu_utama.ICONIFIED);    
    }//GEN-LAST:event_MINActionPerformed

    private void MAKSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MAKSActionPerformed
        if (this.getExtendedState()!= Data_Guru.MAXIMIZED_BOTH) {
            this.setExtendedState (Data_Guru.MAXIMIZED_BOTH);

        }else{
            this.setExtendedState (Data_Guru.NORMAL);
        }
    }//GEN-LAST:event_MAKSActionPerformed

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
            java.util.logging.Logger.getLogger(Data_Guru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Data_Guru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Data_Guru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Data_Guru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Data_Guru().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CARI;
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
    private javax.swing.JTextArea TALAMAT;
    private javax.swing.JComboBox<String> TASAL;
    private javax.swing.JButton btnCETAK;
    private javax.swing.JButton btnHAPUS;
    private javax.swing.JButton btnKEMBALI;
    private javax.swing.JButton btnRESET;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSIMPAN;
    private javax.swing.JButton btnUPDATE;
    private javax.swing.JComboBox<String> cmbAGAMA;
    private javax.swing.JComboBox<String> cmbKELAMIN;
    private javax.swing.JComboBox<String> cmbMAPEL;
    private javax.swing.JComboBox<String> cmbSearch;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable table_guru;
    private javax.swing.JTextField txtNAMA;
    private javax.swing.JTextField txtNIP;
    private javax.swing.JTextField txtTELP;
    private javax.swing.JLabel txtTGL2;
    private com.toedter.calendar.JDateChooser txtTTL;
    private javax.swing.JLabel waktu;
    // End of variables declaration//GEN-END:variables
}
