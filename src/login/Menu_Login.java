package login;

import Menu_Master.Data_Guru;
import beranda.menu_utama;

import beranda.menu_utama1;
import beranda.menu_utama2;
import beranda.menu_utama3;

import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import server.UserSession;
import server.koneksi;

public class Menu_Login extends javax.swing.JFrame {

    Connection con = koneksi.getConnection();;
    ResultSet rs;
    
    String id = UserSession.get_id();
    String username = UserSession.get_username();
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
                        Logger.getLogger(Menu_Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
p.start();
}
    public Menu_Login() {
    initComponents();
        setLocationRelativeTo(this);
        tanggal();
        tanggal_jam_sekarang();  
    }
    
     public  void tanggal(){           
        Date ys = new Date();
     SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
     txtTGL2.setText(s.format(ys));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel3 = new javax.swing.JPanel();
        judul_signin = new javax.swing.JLabel();
        judul_signin1 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtTGL2 = new javax.swing.JLabel();
        waktu = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Kesiswaan3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        In_username5 = new javax.swing.JTextField();
        In_password5 = new javax.swing.JTextField();
        submit5 = new javax.swing.JButton();
        Inventory = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        In_username6 = new javax.swing.JTextField();
        In_password6 = new javax.swing.JTextField();
        submit6 = new javax.swing.JButton();
        Administrasi = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        In_username2 = new javax.swing.JTextField();
        In_password2 = new javax.swing.JTextField();
        submit2 = new javax.swing.JButton();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setLayout(null);

        judul_signin.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        judul_signin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judul_signin.setText("Aplikasi Sistem Manajemen SMP");
        jPanel3.add(judul_signin);
        judul_signin.setBounds(70, 10, 690, 40);

        judul_signin1.setFont(new java.awt.Font("Source Sans Pro", 1, 18)); // NOI18N
        judul_signin1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judul_signin1.setText("Yayasan Perguruan Trisoko");
        jPanel3.add(judul_signin1);
        judul_signin1.setBounds(280, 50, 270, 30);

        exit.setBackground(new java.awt.Color(255, 255, 255));
        exit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Favorites/icons8-shutdown-30.png"))); // NOI18N
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jPanel3.add(exit);
        exit.setBounds(770, 10, 50, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Jalan Dukuh IV No. 12B, Dukuh, Kramatjati, RT.5/RW.1, Dukuh, Kec. Kramat jati, Kota Jakarta Timur");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(130, 90, 570, 15);

        jLabel5.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel5.setText("Daerah Khusus Ibukota Jakarta 13550, Indonesia");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(280, 110, 280, 20);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(836, 649));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/Trisoko Logo 279x256.png"))); // NOI18N

        txtTGL2.setBackground(new java.awt.Color(51, 51, 51));
        txtTGL2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txtTGL2.setForeground(new java.awt.Color(204, 204, 204));
        txtTGL2.setText("jLabel8");

        waktu.setBackground(new java.awt.Color(51, 51, 51));
        waktu.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        waktu.setForeground(new java.awt.Color(204, 204, 204));
        waktu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconnan/time.png"))); // NOI18N
        waktu.setText("jLabel8");

        jLabel6.setFont(new java.awt.Font("Source Sans Pro", 1, 8)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Developer Kelompok KKP ");

        jTabbedPane1.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N

        Kesiswaan3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 5, true));

        jLabel18.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 153));
        jLabel18.setText("Username");

        jLabel19.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 153));
        jLabel19.setText("Password");

        In_username5.setText("pandu");
        In_username5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                In_username5ActionPerformed(evt);
            }
        });

        In_password5.setText("999");

        submit5.setText("Login");
        submit5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Kesiswaan3Layout = new javax.swing.GroupLayout(Kesiswaan3);
        Kesiswaan3.setLayout(Kesiswaan3Layout);
        Kesiswaan3Layout.setHorizontalGroup(
            Kesiswaan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Kesiswaan3Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(Kesiswaan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Kesiswaan3Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel18))
                    .addComponent(In_username5, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Kesiswaan3Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel19))
                    .addComponent(In_password5, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Kesiswaan3Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(submit5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45))
        );
        Kesiswaan3Layout.setVerticalGroup(
            Kesiswaan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Kesiswaan3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel18)
                .addGap(6, 6, 6)
                .addComponent(In_username5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel19)
                .addGap(6, 6, 6)
                .addComponent(In_password5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(submit5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        jTabbedPane1.addTab("Kesiswaan", Kesiswaan3);

        Inventory.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 5, true));

        jLabel20.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 153));
        jLabel20.setText("Username");

        jLabel11.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 153));
        jLabel11.setText("Password");

        In_username6.setText("DWI");

        In_password6.setText("123");

        submit6.setText("Login");
        submit6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout InventoryLayout = new javax.swing.GroupLayout(Inventory);
        Inventory.setLayout(InventoryLayout);
        InventoryLayout.setHorizontalGroup(
            InventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InventoryLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(InventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InventoryLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel20))
                    .addComponent(In_username6, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(InventoryLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel11))
                    .addComponent(In_password6, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(InventoryLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(submit6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45))
        );
        InventoryLayout.setVerticalGroup(
            InventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InventoryLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel20)
                .addGap(6, 6, 6)
                .addComponent(In_username6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel11)
                .addGap(6, 6, 6)
                .addComponent(In_password6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(submit6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        jTabbedPane1.addTab("Inventory", Inventory);

        Administrasi.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 5, true));

        jLabel12.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 153));
        jLabel12.setText("Username");

        jLabel13.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 153));
        jLabel13.setText("Password");

        In_username2.setText("NANDA");

        In_password2.setText("567");

        submit2.setText("Login");
        submit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AdministrasiLayout = new javax.swing.GroupLayout(Administrasi);
        Administrasi.setLayout(AdministrasiLayout);
        AdministrasiLayout.setHorizontalGroup(
            AdministrasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdministrasiLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(AdministrasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AdministrasiLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel12))
                    .addComponent(In_username2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AdministrasiLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel13))
                    .addComponent(In_password2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AdministrasiLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(submit2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45))
        );
        AdministrasiLayout.setVerticalGroup(
            AdministrasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdministrasiLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel12)
                .addGap(6, 6, 6)
                .addComponent(In_username2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel13)
                .addGap(6, 6, 6)
                .addComponent(In_password2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(submit2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        jTabbedPane1.addTab("Administrasi", Administrasi);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(73, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(62, 62, 62)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtTGL2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(waktu, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel6)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTGL2)
                            .addComponent(waktu))
                        .addGap(30, 30, 30)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.add(jPanel1);
        jPanel1.setBounds(0, 140, 836, 530);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(0, 0, 836, 668);
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
    if (JOptionPane.showConfirmDialog(null, "Yakin ingin keluar?", "Sistem Manajemen SMP", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            System.exit(0);
        }    
    }//GEN-LAST:event_exitActionPerformed

    private void submit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit2ActionPerformed
        String user = In_username2.getText();
        String pass = In_password2.getText();
            try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM  petugas where username='"+user+"' and password='"+pass+"'";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                String id = rs.getString("id_petugas");
                String username = rs.getString("username");
                String nama = rs.getString("nama_lengkap");
                String level = rs.getString("level");
                //set user data session
                UserSession.set_id(id);
                UserSession.set_username(username);
                UserSession.set_nama(nama);
                UserSession.set_level(level);

                switch (level) {
                    case "Administrasi":
                    {
                        JOptionPane.showMessageDialog(null, "Selamat datang "+ nama +" !");
                        menu_utama3 dsb = new menu_utama3();
                        dsb.dashAdminstrasi();
                         //                        dsb.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        dsb.setVisible(true);
                        dispose();
                        break;
                    }
                    default:
                }
            } else {
                JOptionPane.showMessageDialog(null, "Username atau password salah");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_submit2ActionPerformed

    private void submit6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit6ActionPerformed
        String user = In_username6.getText();
        String pass = In_password6.getText();
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM  petugas where username='"+user+"' and password='"+pass+"'";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                String id = rs.getString("id_petugas");
                String username = rs.getString("username");
                String nama = rs.getString("nama_lengkap");
                String level = rs.getString("level");
                //set user data session
                UserSession.set_id(id);
                UserSession.set_username(username);
                UserSession.set_nama(nama);
                UserSession.set_level(level);
                  switch (level) {
                    case "Inventory":
                    {
                        JOptionPane.showMessageDialog(null, "Selamat datang "+ nama +" !");
                        menu_utama2 dsb = new menu_utama2();
                        dsb.dashInventory();
                        //                        dsb.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        dsb.setVisible(true);
                        dispose();
                        break;
                    }
                    default:
                }
            } else {
                JOptionPane.showMessageDialog(null, "Username atau password salah");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_submit6ActionPerformed

    private void submit5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit5ActionPerformed
        String user = In_username5.getText();
        String pass = In_password5.getText();
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM  petugas where username='"+user+"' and password='"+pass+"'";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                String id = rs.getString("id_petugas");
                String username = rs.getString("username");
                String nama = rs.getString("nama_lengkap");
                String level = rs.getString("level");
                 //set user data session
                UserSession.set_id(id);
                UserSession.set_username(username);
                UserSession.set_nama(nama);
                UserSession.set_level(level);
                 switch (level) {
                    case "Kesiswaan":
                    {
                        JOptionPane.showMessageDialog(null, "Selamat datang "+ nama +" !");
                        menu_utama1 dsb = new menu_utama1();
                        dsb.dashKesiswaan();
                        //                        dsb.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        dsb.setVisible(true);
                        dispose();
                        break;
                    }
                    default:
                }
            } else {
                JOptionPane.showMessageDialog(null, "Username atau password salah");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_submit5ActionPerformed

    private void In_username5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_In_username5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_In_username5ActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Menu_Login().setVisible(true);
             
            }
        });
        
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Administrasi;
    private javax.swing.JTextField In_password2;
    private javax.swing.JTextField In_password5;
    private javax.swing.JTextField In_password6;
    private javax.swing.JTextField In_username2;
    private javax.swing.JTextField In_username5;
    private javax.swing.JTextField In_username6;
    private javax.swing.JPanel Inventory;
    private javax.swing.JPanel Kesiswaan3;
    private javax.swing.JButton exit;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel judul_signin;
    private javax.swing.JLabel judul_signin1;
    private javax.swing.JButton submit2;
    private javax.swing.JButton submit5;
    private javax.swing.JButton submit6;
    private javax.swing.JLabel txtTGL2;
    private javax.swing.JLabel waktu;
    // End of variables declaration//GEN-END:variables
}
