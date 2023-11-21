package beranda;

import Menu_Administrasi.Pembayaran_lain;
import Menu_Administrasi.Pembayaran_spp;
import Menu_Inventory.Data_Inventory_Barang;
import Menu_Inventory.Data_Permohonan_Barang;

import Menu_Laporan.Laporan_data_guru;
import Menu_Laporan.Laporan_data_kelas;
import Menu_Laporan.Laporan_data_Daftar_BR_IN;
import Menu_Laporan.Laporan_data_Daftar_BR_OUT;
import Menu_Laporan.Laporan_data_siswa;
import Menu_Laporan.Laporan_pembayaran_lain;
import Menu_Laporan.Laporan_pembayaran_spp;
import Menu_Master.Data_Guru;
import Menu_Master.Data_Kelas;
import Menu_Master.Data_Siswa;


import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

import static java.lang.Thread.sleep;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import server.koneksi;

public class menu_utama extends javax.swing.JFrame {

    private  final JPopupMenu popupMenu = new JPopupMenu();
    private JMenuItem menuItem = null;
    
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
                        Logger.getLogger(menu_utama.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
p.start();
}
    
    
    
    public menu_utama() {
        initComponents();
        setLocationRelativeTo(this);
        tanggal();
        tanggal_jam_sekarang();
        setLocationRelativeTo(this);
        master.setVisible(false);
        inventory.setVisible(false);
        administrasi.setVisible(false);
        laporan.setVisible(false);
        home.setVisible(true);
    }
    
     public  void tanggal(){           
        Date ys = new Date();
     SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
     txtTGL2.setText(s.format(ys));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        BG_JUDUL = new javax.swing.JPanel();
        waktu = new javax.swing.JLabel();
        txtTGL2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        judul_signin = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        judul_signin1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        home = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        master = new javax.swing.JPanel();
        btnKELAS = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        btnSISWA = new javax.swing.JButton();
        btnGURU = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        inventory = new javax.swing.JPanel();
        btnAK = new javax.swing.JButton();
        btnAP = new javax.swing.JButton();
        btnTKJ = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        administrasi = new javax.swing.JPanel();
        btnSPP = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        btnNONSPP = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        laporan = new javax.swing.JPanel();
        btnLAP_GURU = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        btnLAP_SISWA = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        btnLAP_KELAS = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        btnLAP_BARANG_IN = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        btnLAP_BARANG_OUT = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        btnLAP_SPP = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        btnLAP_LAIN = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        btnADMINISTRASI.setBackground(new java.awt.Color(255, 255, 255));
        btnADMINISTRASI.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        btnADMINISTRASI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-payment-history-50.png"))); // NOI18N
        btnADMINISTRASI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnADMINISTRASI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnADMINISTRASIActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("ADMINISTRASI");

        btnMASTER.setBackground(new java.awt.Color(255, 255, 255));
        btnMASTER.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        btnMASTER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-home-50.png"))); // NOI18N
        btnMASTER.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMASTER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMASTERActionPerformed(evt);
            }
        });

        btnINVENTORY.setBackground(new java.awt.Color(255, 255, 255));
        btnINVENTORY.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        btnINVENTORY.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-microscope-40.png"))); // NOI18N
        btnINVENTORY.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnINVENTORY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnINVENTORYActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("INVENTORY");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("MASTER");

        btnLAPORAN.setBackground(new java.awt.Color(255, 255, 255));
        btnLAPORAN.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        btnLAPORAN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-report-card-50.png"))); // NOI18N
        btnLAPORAN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLAPORAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLAPORANActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("LAPORAN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMASTER, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnADMINISTRASI, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnINVENTORY, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLAPORAN, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnMASTER, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnINVENTORY, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnADMINISTRASI, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLAPORAN, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(20, 20, 20))
        );

        BG_JUDUL.setBackground(new java.awt.Color(204, 204, 255));
        BG_JUDUL.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BG_JUDUL.setLayout(null);

        waktu.setFont(new java.awt.Font("Comic Sans MS", 1, 10)); // NOI18N
        waktu.setText("jLabel8");
        BG_JUDUL.add(waktu);
        waktu.setBounds(20, 50, 110, 18);

        txtTGL2.setFont(new java.awt.Font("Comic Sans MS", 1, 10)); // NOI18N
        txtTGL2.setText("jLabel8");
        BG_JUDUL.add(txtTGL2);
        txtTGL2.setBounds(20, 10, 110, 14);
        BG_JUDUL.add(jLabel1);
        jLabel1.setBounds(10, 90, 0, 0);

        exit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-shutdown-30.png"))); // NOI18N
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        BG_JUDUL.add(exit);
        exit.setBounds(890, 10, 40, 40);

        judul_signin.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        judul_signin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judul_signin.setText("Aplikasi Sistem Manajemen Sekolah");
        BG_JUDUL.add(judul_signin);
        judul_signin.setBounds(170, 10, 700, 40);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        tuser.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        tuser.setForeground(new java.awt.Color(0, 0, 153));
        tuser.setText("Nama User");

        tlevel.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        tlevel.setForeground(new java.awt.Color(0, 0, 153));
        tlevel.setText("level");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tuser, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tlevel, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 13, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(tlevel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tuser)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BG_JUDUL.add(jPanel2);
        jPanel2.setBounds(10, 70, 170, 70);

        judul_signin1.setFont(new java.awt.Font("Source Sans Pro", 1, 18)); // NOI18N
        judul_signin1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judul_signin1.setText("Yayasan Perguruan Trisoko");
        BG_JUDUL.add(judul_signin1);
        judul_signin1.setBounds(370, 60, 270, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Jalan Dukuh IV No. 12B, Dukuh, Kramat jati, RT.5/RW.1, Dukuh, Kec. Kramat jati, Kota Jakarta Timur");
        BG_JUDUL.add(jLabel4);
        jLabel4.setBounds(240, 100, 570, 15);

        jLabel5.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel5.setText("Daerah Khusus Ibukota Jakarta 13550, Indonesia");
        BG_JUDUL.add(jLabel5);
        jLabel5.setBounds(370, 120, 280, 20);

        jLayeredPane2.setBackground(new java.awt.Color(102, 255, 102));
        jLayeredPane2.setPreferredSize(new java.awt.Dimension(667, 464));

        home.setBackground(new java.awt.Color(0, 51, 102));
        home.setPreferredSize(new java.awt.Dimension(667, 464));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/Trisoko Logo 279x256.png"))); // NOI18N

        javax.swing.GroupLayout homeLayout = new javax.swing.GroupLayout(home);
        home.setLayout(homeLayout);
        homeLayout.setHorizontalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(241, 241, 241))
        );
        homeLayout.setVerticalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jLabel29)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        master.setBackground(new java.awt.Color(143, 217, 168));
        master.setPreferredSize(new java.awt.Dimension(667, 464));

        btnKELAS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-classroom-50.png"))); // NOI18N
        btnKELAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKELASActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(51, 51, 51));
        jLabel30.setText("DATA GURU");

        btnSISWA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-students-50.png"))); // NOI18N
        btnSISWA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSISWAActionPerformed(evt);
            }
        });

        btnGURU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-teacher-50.png"))); // NOI18N
        btnGURU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGURUActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 51, 51));
        jLabel31.setText("DATA KELAS");

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(51, 51, 51));
        jLabel33.setText("DATA SISWA");

        javax.swing.GroupLayout masterLayout = new javax.swing.GroupLayout(master);
        master.setLayout(masterLayout);
        masterLayout.setHorizontalGroup(
            masterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(masterLayout.createSequentialGroup()
                .addGroup(masterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(masterLayout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jLabel33)
                        .addGap(93, 93, 93)
                        .addComponent(jLabel31))
                    .addGroup(masterLayout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addGroup(masterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(masterLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel30))
                            .addGroup(masterLayout.createSequentialGroup()
                                .addGroup(masterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnGURU, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSISWA, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(78, 78, 78)
                                .addComponent(btnKELAS, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(201, Short.MAX_VALUE))
        );
        masterLayout.setVerticalGroup(
            masterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, masterLayout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addComponent(btnGURU, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addGap(38, 38, 38)
                .addGroup(masterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSISWA, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKELAS, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(masterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addComponent(jLabel31))
                .addGap(79, 79, 79))
        );

        inventory.setBackground(new java.awt.Color(143, 217, 168));
        inventory.setPreferredSize(new java.awt.Dimension(667, 464));

        btnAK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-business-report-65.png"))); // NOI18N
        btnAK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAKActionPerformed(evt);
            }
        });

        btnAP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-business-building-65.png"))); // NOI18N
        btnAP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAPActionPerformed(evt);
            }
        });

        btnTKJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-computer-65.png"))); // NOI18N

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(51, 51, 51));
        jLabel34.setText("DATA LAB TKJ");

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(51, 51, 51));
        jLabel35.setText("DATA LAB AP");

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(51, 51, 51));
        jLabel36.setText("DATA LAB AK");

        javax.swing.GroupLayout inventoryLayout = new javax.swing.GroupLayout(inventory);
        inventory.setLayout(inventoryLayout);
        inventoryLayout.setHorizontalGroup(
            inventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inventoryLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(inventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAK, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(inventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addComponent(btnAP, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(inventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnTKJ, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addGap(103, 103, 103))
        );
        inventoryLayout.setVerticalGroup(
            inventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventoryLayout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addGroup(inventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTKJ, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAP, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAK, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36))
                .addContainerGap(199, Short.MAX_VALUE))
        );

        administrasi.setBackground(new java.awt.Color(143, 217, 168));
        administrasi.setPreferredSize(new java.awt.Dimension(667, 464));

        btnSPP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-business-e-mail-65.png"))); // NOI18N
        btnSPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSPPActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(51, 51, 51));
        jLabel37.setText("PEMBAYARAN SPP");

        btnNONSPP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-business-e-mail-65.png"))); // NOI18N
        btnNONSPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNONSPPActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(51, 51, 51));
        jLabel38.setText("PEMBAYARAN LAIN-LAIN");

        javax.swing.GroupLayout administrasiLayout = new javax.swing.GroupLayout(administrasi);
        administrasi.setLayout(administrasiLayout);
        administrasiLayout.setHorizontalGroup(
            administrasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(administrasiLayout.createSequentialGroup()
                .addGroup(administrasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(administrasiLayout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(btnSPP, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(administrasiLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel37)))
                .addGap(103, 103, 103)
                .addGroup(administrasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addGroup(administrasiLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(btnNONSPP, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        administrasiLayout.setVerticalGroup(
            administrasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(administrasiLayout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addGroup(administrasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSPP, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNONSPP, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(administrasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel37)
                    .addComponent(jLabel38))
                .addContainerGap(213, Short.MAX_VALUE))
        );

        laporan.setBackground(new java.awt.Color(0, 51, 102));
        laporan.setPreferredSize(new java.awt.Dimension(667, 464));

        btnLAP_GURU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-report-card-65.png"))); // NOI18N
        btnLAP_GURU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLAP_GURUActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(204, 204, 204));
        jLabel39.setText("DATA GURU");

        btnLAP_SISWA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-report-card-65.png"))); // NOI18N
        btnLAP_SISWA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLAP_SISWAActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(204, 204, 204));
        jLabel40.setText("DATA SISWA");

        btnLAP_KELAS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-report-card-65.png"))); // NOI18N
        btnLAP_KELAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLAP_KELASActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(204, 204, 204));
        jLabel42.setText("DATA KELAS");

        btnLAP_BARANG_IN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-report-card-65.png"))); // NOI18N
        btnLAP_BARANG_IN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLAP_BARANG_INActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(204, 204, 204));
        jLabel43.setText("Daftar Inventory Barang");

        btnLAP_BARANG_OUT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-report-card-65.png"))); // NOI18N
        btnLAP_BARANG_OUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLAP_BARANG_OUTActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(204, 204, 204));
        jLabel44.setText("Daftar Barang Rusak");

        btnLAP_SPP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-report-card-65.png"))); // NOI18N
        btnLAP_SPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLAP_SPPActionPerformed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(204, 204, 204));
        jLabel46.setText("PEMBAYARAN SPP");

        btnLAP_LAIN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-report-card-65.png"))); // NOI18N
        btnLAP_LAIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLAP_LAINActionPerformed(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(204, 204, 204));
        jLabel47.setText("PEMBAYARAN LAIN-LAIN");

        javax.swing.GroupLayout laporanLayout = new javax.swing.GroupLayout(laporan);
        laporan.setLayout(laporanLayout);
        laporanLayout.setHorizontalGroup(
            laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(laporanLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(laporanLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel43)
                            .addGroup(laporanLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(btnLAP_BARANG_IN, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnLAP_BARANG_OUT, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44))
                        .addGap(139, 139, 139))
                    .addGroup(laporanLayout.createSequentialGroup()
                        .addGroup(laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(laporanLayout.createSequentialGroup()
                                .addGap(320, 320, 320)
                                .addComponent(jLabel47))
                            .addGroup(laporanLayout.createSequentialGroup()
                                .addGroup(laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel46)
                                    .addGroup(laporanLayout.createSequentialGroup()
                                        .addComponent(btnLAP_GURU, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(btnLAP_SISWA, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(199, 199, 199)
                                .addComponent(btnLAP_KELAS, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(laporanLayout.createSequentialGroup()
                                .addGroup(laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(laporanLayout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jLabel39)
                                        .addGap(83, 83, 83)
                                        .addComponent(jLabel40))
                                    .addGroup(laporanLayout.createSequentialGroup()
                                        .addGap(162, 162, 162)
                                        .addComponent(btnLAP_LAIN, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(55, 55, 55)
                                .addGroup(laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnLAP_SPP, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(laporanLayout.createSequentialGroup()
                                        .addGap(159, 159, 159)
                                        .addComponent(jLabel42)))))
                        .addGap(61, 61, 61))))
        );
        laporanLayout.setVerticalGroup(
            laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, laporanLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLAP_KELAS, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnLAP_SISWA, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLAP_GURU, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel40)
                        .addComponent(jLabel42))
                    .addComponent(jLabel39))
                .addGap(30, 30, 30)
                .addGroup(laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLAP_BARANG_OUT, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLAP_BARANG_IN, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44)
                    .addComponent(jLabel43))
                .addGap(18, 18, 18)
                .addGroup(laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLAP_LAIN, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLAP_SPP, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(jLabel47))
                .addGap(31, 31, 31))
        );

        jLayeredPane2.setLayer(home, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(master, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(inventory, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(administrasi, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(laporan, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 735, Short.MAX_VALUE)
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(home, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(master, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(inventory, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(administrasi, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(laporan, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 472, Short.MAX_VALUE)
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(home, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(master, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(inventory, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(administrasi, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(laporan, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BG_JUDUL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BG_JUDUL, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setBounds(0, 0, 943, 622);
    }// </editor-fold>//GEN-END:initComponents

    private void btnADMINISTRASIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnADMINISTRASIActionPerformed
        master.setVisible(false);
        inventory.setVisible(false);
        administrasi.setVisible(true);
        laporan.setVisible(false);
        home.setVisible(false); 
    }//GEN-LAST:event_btnADMINISTRASIActionPerformed

    private void btnMASTERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMASTERActionPerformed
        master.setVisible(true);
        inventory.setVisible(false);
        administrasi.setVisible(false);
        laporan.setVisible(false);
        home.setVisible(false); 
    }//GEN-LAST:event_btnMASTERActionPerformed

    private void btnINVENTORYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnINVENTORYActionPerformed
        master.setVisible(false);
        inventory.setVisible(true);
        administrasi.setVisible(false);
        laporan.setVisible(false);
        home.setVisible(false);
    }//GEN-LAST:event_btnINVENTORYActionPerformed

    private void btnLAPORANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLAPORANActionPerformed
        master.setVisible(false);
        inventory.setVisible(false);
        administrasi.setVisible(false);
        laporan.setVisible(true);
        home.setVisible(false);
    }//GEN-LAST:event_btnLAPORANActionPerformed

    private void btnGURUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGURUActionPerformed
        Data_Guru user = new  Data_Guru();
        user.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnGURUActionPerformed

    private void btnSISWAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSISWAActionPerformed
        Data_Siswa user = new  Data_Siswa();
        user.setVisible(true);
        dispose(); 
    }//GEN-LAST:event_btnSISWAActionPerformed

    private void btnKELASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKELASActionPerformed
        Data_Kelas user = new  Data_Kelas();
        user.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnKELASActionPerformed

    private void btnAKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAKActionPerformed
        Data_Inventory_Barang user = new  Data_Inventory_Barang();
        user.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAKActionPerformed

    private void btnAPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAPActionPerformed
        Data_Permohonan_Barang user = new  Data_Permohonan_Barang();
        user.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAPActionPerformed

    private void btnSPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSPPActionPerformed
        Pembayaran_spp user = null;
        user = new  Pembayaran_spp();
        user.setVisible(true);
        dispose();   
    }//GEN-LAST:event_btnSPPActionPerformed

    private void btnNONSPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNONSPPActionPerformed
        new Pembayaran_lain().show();
        this.dispose();
    }//GEN-LAST:event_btnNONSPPActionPerformed

    private void btnLAP_GURUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLAP_GURUActionPerformed
        Laporan_data_guru user = new  Laporan_data_guru();
        user.setVisible(true);
        dispose();  
    }//GEN-LAST:event_btnLAP_GURUActionPerformed

    private void btnLAP_SISWAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLAP_SISWAActionPerformed
        Laporan_data_siswa user = new  Laporan_data_siswa();
        user.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLAP_SISWAActionPerformed

    private void btnLAP_KELASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLAP_KELASActionPerformed
       Laporan_data_kelas user = new  Laporan_data_kelas();
       user.setVisible(true);
       dispose(); 
    }//GEN-LAST:event_btnLAP_KELASActionPerformed

    private void btnLAP_BARANG_INActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLAP_BARANG_INActionPerformed
        Laporan_data_Daftar_BR_IN user = new  Laporan_data_Daftar_BR_IN();
        user.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLAP_BARANG_INActionPerformed

    private void btnLAP_BARANG_OUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLAP_BARANG_OUTActionPerformed
        Laporan_data_Daftar_BR_OUT user = new  Laporan_data_Daftar_BR_OUT();
        user.setVisible(true);
        dispose(); 
    }//GEN-LAST:event_btnLAP_BARANG_OUTActionPerformed

    private void btnLAP_SPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLAP_SPPActionPerformed
        Laporan_pembayaran_lain  user = new  Laporan_pembayaran_lain();
        user.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLAP_SPPActionPerformed

    private void btnLAP_LAINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLAP_LAINActionPerformed
        Laporan_pembayaran_spp  user = new  Laporan_pembayaran_spp();
        user.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLAP_LAINActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
     if (JOptionPane.showConfirmDialog(null, "Yakin ingin Logout?", "Sistem Manajemen Data Sekolah", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            new login.Menu_Login().setVisible(true);
                this.dispose();
                    this.setVisible(false);
     }
    }//GEN-LAST:event_exitActionPerformed

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
            java.util.logging.Logger.getLogger(menu_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu_utama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BG_JUDUL;
    private javax.swing.JPanel administrasi;
    public static final javax.swing.JButton btnADMINISTRASI = new javax.swing.JButton();
    private javax.swing.JButton btnAK;
    private javax.swing.JButton btnAP;
    private javax.swing.JButton btnGURU;
    public static final javax.swing.JButton btnINVENTORY = new javax.swing.JButton();
    private javax.swing.JButton btnKELAS;
    public static final javax.swing.JButton btnLAPORAN = new javax.swing.JButton();
    private javax.swing.JButton btnLAP_BARANG_IN;
    private javax.swing.JButton btnLAP_BARANG_OUT;
    private javax.swing.JButton btnLAP_GURU;
    private javax.swing.JButton btnLAP_KELAS;
    private javax.swing.JButton btnLAP_LAIN;
    private javax.swing.JButton btnLAP_SISWA;
    private javax.swing.JButton btnLAP_SPP;
    public static final javax.swing.JButton btnMASTER = new javax.swing.JButton();
    private javax.swing.JButton btnNONSPP;
    private javax.swing.JButton btnSISWA;
    private javax.swing.JButton btnSPP;
    private javax.swing.JButton btnTKJ;
    private javax.swing.JButton exit;
    private javax.swing.JPanel home;
    private javax.swing.JPanel inventory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel judul_signin;
    private javax.swing.JLabel judul_signin1;
    private javax.swing.JPanel laporan;
    private javax.swing.JPanel master;
    public static final javax.swing.JLabel tlevel = new javax.swing.JLabel();
    public static final javax.swing.JLabel tuser = new javax.swing.JLabel();
    private javax.swing.JLabel txtTGL2;
    private javax.swing.JLabel waktu;
    // End of variables declaration//GEN-END:variables

}
