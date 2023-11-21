package server;

import java.sql.*;
import javax.swing.JOptionPane;

public class koneksi {

  static Connection con;
   public static Connection getConnection() {
     try {
         con = DriverManager.getConnection("jdbc:mysql://localhost/db_datasekolah","root","");         
     }catch (Exception e) {
         JOptionPane.showMessageDialog(null, "ERROR : Koneksi Gagal!");
         System.exit(0);
     }
       return con;
   }
}
