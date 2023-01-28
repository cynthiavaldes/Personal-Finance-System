/**
 * @author Cynthia Valdes
 * @description
 */

import java.sql.*;
import javax.swing.JOptionPane;

public class javaconnect {
    Connection conn = null;
    
    public static Connection ConnecrDb() {
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\cabba\\Documents\\NetBeansProjects\\Personal_Finance_System\\finances.sqlite");
            return conn;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }   
        return null;
    }
}
