/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginapps;

/**
 *
 * @author riswanardiansah
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
public class Koneksi {
     Connection con;
    Statement stm;
    private static Connection mysqlkonek;
    
        public static Connection koneksiDB() throws SQLException {
        if(mysqlkonek==null){
            try {
                String DB="jdbc:mysql://127.0.0.1:3306/login"; // delta_db database
                String user="root"; // user database
                String pass=""; // password database
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                mysqlkonek = (Connection) DriverManager.getConnection(DB,user,pass);
//                mysqlkonek.createStatement();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"gagal koneksi");
            }
        }
        return mysqlkonek;
    }
    
    public void config(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login", "root", "");
            stm = con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "koneksi gagal "+e.getMessage());
        }
    }
}
