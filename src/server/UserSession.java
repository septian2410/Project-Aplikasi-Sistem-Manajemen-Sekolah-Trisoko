package server;

public class UserSession {
    private static String id;
    private static String username;
    private static String nama;
    private static String level;
   
    //user session : id_________________________________________________________
    public static String get_id() {
        return id;
    } 
    public static void set_id(String id) {
        UserSession.id = id;
    }    
    //user session : username___________________________________________________
    public static String get_username() {
        return username;
    } 
    public static void set_username(String username) {
        UserSession.username = username;
    }
    //user session : nama_______________________________________________________
    public static String get_nama() {
        return nama;
    } 
    public static void set_nama(String nama) {
        UserSession.nama = nama;
    }
    //user session : level______________________________________________________
    public static String get_level() {
        return level;
    } 
    public static void set_level(String level) {
        UserSession.level = level;
    }    
}
