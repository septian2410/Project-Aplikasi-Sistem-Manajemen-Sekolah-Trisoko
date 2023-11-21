package Menu_Inventory;

import beranda.menu_utama;
import beranda.menu_utama1;
import beranda.menu_utama2;

import Menu_Administrasi.Pembayaran_lain;
import Menu_Administrasi.Pembayaran_spp;
import Menu_Master.Data_Guru;
import Menu_Master.Data_Kelas;
import Menu_Inventory.Data_Permohonan_Barang;

import Menu_Laporan.Laporan_data_guru;
import Menu_Laporan.Laporan_data_kelas;
import Menu_Laporan.Laporan_data_Daftar_BR_IN;
import Menu_Laporan.Laporan_data_Daftar_BR_IN1;
import Menu_Laporan.Laporan_data_Daftar_BR_OUT;
import Menu_Laporan.Laporan_data_Daftar_BR_OUT1;
import Menu_Laporan.Laporan_data_siswa;
import Menu_Laporan.Laporan_pembayaran_lain;
import Menu_Laporan.Laporan_pembayaran_spp;
import Menu_Laporan.Laporan_data_Daftar_BR_IN2;
import Menu_Laporan.Laporan_data_Daftar_BR_OUT2;

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

public class Data_Inventory_Barang extends javax.swing.JFrame {

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
                        Logger.getLogger(Data_Inventory_Barang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
p.start();
}
      
    public Data_Inventory_Barang() {
        initComponents();
        setLocationRelativeTo(this);
        loadDataTable_BarangMasuk();
        clear();
        otomatis_kode();
        tanggal();
        tanggal_jam_sekarang();
    }

     public  void tanggal(){            
     Date ys = new Date();
     SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
     txtTGL2.setText(s.format(ys));
    }
    
    private void loadDataTable_BarangMasuk( ){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Barang");
        model.addColumn("Nama");
        model.addColumn("Jumlah");
        model.addColumn("Tanggal Masuk");
        model.addColumn("Merek");
        model.addColumn("Keterangan");
        try {
            int no = 1;
            String sql = "SELECT * FROM tb_in_barang WHERE kode_barang like '%"
               + txtCARI.getText ()+ "%'"
               +" or nama_barang like '%" + txtCARI.getText()+"%'";
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
        txtNAMA.setText("");
        txtJMLH.setText("");
        txtTGL.setDate(null);
        TMODEL.setText("");
        TKET.setText("");
        otomatis_kode();  
    }
        
    public static Date getTanggalFromTable(JTable table, int kolom){
        JTable tabel = table;
        String str_tgl = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), kolom));
        Date tanggal = null;
        try{
            tanggal = new SimpleDateFormat("yyyy-MM-dd").parse(str_tgl);
        }catch(ParseException ex) {
            Logger.getLogger(Data_Inventory_Barang.class.getName()).log(Level.SEVERE, null, ex);
              System.out.println("There is an error : " + ex.getMessage());
        }
        return tanggal;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BG_JUDUL = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        waktu = new javax.swing.JLabel();
        txtTGL2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNAMA = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtKD = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtJMLH = new javax.swing.JTextField();
        txtTGL = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TKET = new javax.swing.JTextArea();
        TMODEL = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnHAPUS = new javax.swing.JButton();
        btnSIMPAN = new javax.swing.JButton();
        btnUPDATE = new javax.swing.JButton();
        btnRESET = new javax.swing.JButton();
        btnCETAK = new javax.swing.JButton();
        btnKEMBALI = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_BARANG_IN = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnreset = new javax.swing.JButton();
        btnCARI = new javax.swing.JButton();
        txtCARI = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        MIN1 = new javax.swing.JButton();
        MAKS = new javax.swing.JButton();
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
        jLabel1.setText("Data Inventory Barang SMP");

        exit.setBackground(new java.awt.Color(57, 62, 70));
        exit.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-shutdown-30.png"))); // NOI18N
        exit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        waktu.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        waktu.setForeground(new java.awt.Color(255, 255, 255));
        waktu.setText("jLabel8");

        txtTGL2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtTGL2.setForeground(new java.awt.Color(255, 255, 255));
        txtTGL2.setText("jLabel8");

        jPanel1.setBackground(new java.awt.Color(30, 174, 152));

        jPanel3.setBackground(new java.awt.Color(170, 216, 211));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Nama Barang");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Jumlah");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Tanggal Input");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Kode Barang");

        txtKD.setEnabled(false);
        txtKD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKDActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Keterangan");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Model");

        TKET.setColumns(20);
        TKET.setRows(5);
        jScrollPane1.setViewportView(TKET);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtJMLH, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNAMA, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKD, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TMODEL, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTGL, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtKD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNAMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtJMLH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TMODEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel6))
                    .addComponent(txtTGL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(170, 216, 211));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnHAPUS.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnHAPUS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-delete-30.png"))); // NOI18N
        btnHAPUS.setText("HAPUS");
        btnHAPUS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnHAPUS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHAPUSActionPerformed(evt);
            }
        });

        btnSIMPAN.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnSIMPAN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-plus-30-2.png"))); // NOI18N
        btnSIMPAN.setText("TAMBAH");
        btnSIMPAN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSIMPAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSIMPANActionPerformed(evt);
            }
        });

        btnUPDATE.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnUPDATE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-edit-30-2.png"))); // NOI18N
        btnUPDATE.setText("UBAH");
        btnUPDATE.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUPDATEActionPerformed(evt);
            }
        });

        btnRESET.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnRESET.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-reset-30.png"))); // NOI18N
        btnRESET.setText("REFRESH");
        btnRESET.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRESET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRESETActionPerformed(evt);
            }
        });

        btnCETAK.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnCETAK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-print-30.png"))); // NOI18N
        btnCETAK.setText("CETAK");
        btnCETAK.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCETAK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCETAKActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnHAPUS, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCETAK, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSIMPAN, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUPDATE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnRESET, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKEMBALI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSIMPAN, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRESET, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHAPUS, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCETAK, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKEMBALI, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabel_BARANG_IN.setFont(new java.awt.Font("Source Sans Pro", 0, 12)); // NOI18N
        tabel_BARANG_IN.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_BARANG_IN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_BARANG_INMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_BARANG_IN);

        jPanel4.setBackground(new java.awt.Color(170, 216, 211));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnreset.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnreset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-clear-search-30.png"))); // NOI18N
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });

        btnCARI.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnCARI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-search-30-2.png"))); // NOI18N
        btnCARI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCARIActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Source Sans Pro", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Cari Barang");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtCARI, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 436, Short.MAX_VALUE)
                        .addComponent(btnreset, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCARI, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCARI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCARI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnreset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
        );

        MIN1.setBackground(new java.awt.Color(57, 62, 70));
        MIN1.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        MIN1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-subtract-30 (1).png"))); // NOI18N
        MIN1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MIN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MIN1ActionPerformed(evt);
            }
        });

        MAKS.setBackground(new java.awt.Color(57, 62, 70));
        MAKS.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        MAKS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-maximize-window-30 (2).png"))); // NOI18N
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
                    .addComponent(txtTGL2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(waktu, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(237, 237, 237)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                .addGap(112, 112, 112)
                .addComponent(MIN1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MAKS, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        BG_JUDULLayout.setVerticalGroup(
            BG_JUDULLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BG_JUDULLayout.createSequentialGroup()
                .addGroup(BG_JUDULLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BG_JUDULLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1))
                    .addGroup(BG_JUDULLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(MIN1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(MAKS, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(exit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BG_JUDULLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtTGL2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(waktu)))
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(41, 41, 41))
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
            String sql = "DELETE FROM tb_in_barang WHERE kode_barang='"+txtKD.getText()+"'";
            java.sql.Connection conn = (Connection)koneksi.getConnection();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
                JOptionPane.showMessageDialog(null, "Proses Hapus Data Berhasil");
                loadDataTable_BarangMasuk();
                clear();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
        }
    }//GEN-LAST:event_btnHAPUSActionPerformed

    private void btnSIMPANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSIMPANActionPerformed
    String tampilan = "yyyy-MM-dd";
    SimpleDateFormat fm = new SimpleDateFormat(tampilan);
    String tanggal = String.valueOf(fm.format(txtTGL.getDate()));
        try {
            String sql = "INSERT INTO `tb_in_barang` VALUES ("
                    + "'"+txtKD.getText()+"',"
                    + "'"+txtNAMA.getText()+"',"
                    + "'"+txtJMLH.getText()+"',"
                    + "'"+tanggal+"',"
                    + "'"+TMODEL.getText()+"',"
                    + "'"+TKET.getText()+"')";
            java.sql.Connection conn = (Connection)koneksi.getConnection();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
                JOptionPane.showMessageDialog(null, "Proses Simpan Data Berhasil");
                loadDataTable_BarangMasuk();
                clear();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
        }    
    }//GEN-LAST:event_btnSIMPANActionPerformed

    private void btnUPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUPDATEActionPerformed
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(txtTGL.getDate()));
         try {
            String sql = "UPDATE `tb_in_barang` SET "
                    + "`nama_barang`='"+txtNAMA.getText()+"',"
                    + "`jumlah`='"+txtJMLH.getText()+"',"
                    + "`tanggal_masuk`='"+tanggal+"',"
                    
                    + "`model`='"+TMODEL.getText()+"',"
                    + "`keterangan`='"+TKET.getText()+"' "
                    
                    + "WHERE kode_barang='"+txtKD.getText()+"' ";
            java.sql.Connection conn = (Connection)koneksi.getConnection();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
                JOptionPane.showMessageDialog(null, "Proses Ubah Data Berhasil");
                loadDataTable_BarangMasuk();
                clear();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
        }   
    }//GEN-LAST:event_btnUPDATEActionPerformed

    private void btnRESETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRESETActionPerformed
    clear();    
    }//GEN-LAST:event_btnRESETActionPerformed

    private void btnKEMBALIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKEMBALIActionPerformed
        menu_utama2 dsb = new menu_utama2();
        dsb.dashInventory();
        dsb.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnKEMBALIActionPerformed

    private void btnCETAKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCETAKActionPerformed
    try{
        InputStream file = getClass().getResourceAsStream("/Menu_Inventory/lap_barang_inventory_rekap.jrxml");
        JasperDesign jasperDesign = JRXmlLoader.load(file);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null,koneksi.getConnection());
        JasperViewer.viewReport(jasperPrint,false);
    }catch(Exception ex)
    {
        System.out.println(ex);
        }
    }//GEN-LAST:event_btnCETAKActionPerformed

    private void txtKDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKDActionPerformed

    private void tabel_BARANG_INMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_BARANG_INMouseClicked
        int baris = tabel_BARANG_IN.rowAtPoint(evt.getPoint());
            String kd = tabel_BARANG_IN.getValueAt(baris, 0).toString();
            txtKD.setText(kd);
            String nama = tabel_BARANG_IN.getValueAt(baris, 1).toString();
            txtNAMA.setText(nama);
            String jml = tabel_BARANG_IN.getValueAt(baris, 2).toString();
            txtJMLH.setText(jml);
            txtTGL.setDate(getTanggalFromTable(tabel_BARANG_IN, 3));
            String model = tabel_BARANG_IN.getValueAt(baris, 4).toString();
            TMODEL.setText(model);
            String keterangan = tabel_BARANG_IN.getValueAt(baris, 5).toString();
            TKET.setText(keterangan);
    }//GEN-LAST:event_tabel_BARANG_INMouseClicked

    private void btnCARIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCARIActionPerformed
     try {
            String sql = "SELECT * FROM tb_in_barang where kode_barang like '%"
                    + txtCARI.getText() + "%'"
                    + "or nama_barang like '%" + txtCARI.getText();        
            java.sql.Connection conn = (Connection)koneksi.getConnection();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
        } catch (HeadlessException | SQLException e){
        }
         loadDataTable_BarangMasuk(); 
    }//GEN-LAST:event_btnCARIActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
    if (JOptionPane.showConfirmDialog(null, "Yakin ingin Logout?", "Data Inventory Barang SMP", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
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

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        clear();
        loadDataTable_BarangMasuk();
        txtCARI.setText("");    
    }//GEN-LAST:event_btnresetActionPerformed

    private void MIN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MIN1ActionPerformed
      this.setExtendedState(Data_Inventory_Barang.ICONIFIED);
    }//GEN-LAST:event_MIN1ActionPerformed

    private void MAKSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MAKSActionPerformed
     if (this.getExtendedState()!= Data_Inventory_Barang.MAXIMIZED_BOTH) {
            this.setExtendedState (Data_Inventory_Barang.MAXIMIZED_BOTH);
       }else{
            this.setExtendedState (Data_Inventory_Barang.NORMAL);
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
            java.util.logging.Logger.getLogger(Data_Inventory_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Data_Inventory_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Data_Inventory_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Data_Inventory_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Data_Inventory_Barang().setVisible(true);
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
    private javax.swing.JTextArea TKET;
    private javax.swing.JTextField TMODEL;
    private javax.swing.JButton btnCARI;
    private javax.swing.JButton btnCETAK;
    private javax.swing.JButton btnHAPUS;
    private javax.swing.JButton btnKEMBALI;
    private javax.swing.JButton btnRESET;
    private javax.swing.JButton btnSIMPAN;
    private javax.swing.JButton btnUPDATE;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabel_BARANG_IN;
    private javax.swing.JTextField txtCARI;
    private javax.swing.JTextField txtJMLH;
    private javax.swing.JTextField txtKD;
    private javax.swing.JTextField txtNAMA;
    private com.toedter.calendar.JDateChooser txtTGL;
    private javax.swing.JLabel txtTGL2;
    private javax.swing.JLabel waktu;
    // End of variables declaration//GEN-END:variables

     private void otomatis_kode(){
        try{    
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_datasekolah","root","");
             Statement stat = con.createStatement();
                                                                                                             //descending
             ResultSet rs = stat.executeQuery("SELECT * from tb_in_barang order by kode_barang desc ");
                if (rs.next()){
                    String kode = rs.getString("kode_barang").substring(2);
                    String AN = "" + (Integer.parseInt(kode) + 1);
                    String Nol = "";
                        if(AN.length()==1)
                        {Nol = "00";}
                        else if (AN.length()==2)
                        {Nol = "0";}
                        else if (AN.length()==3)
                        {Nol = "";}
                    txtKD.setText("BR" + Nol +AN);
                }else{
                    txtKD.setText("BR001");
                }
             }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
    }
  
    }
    
}
