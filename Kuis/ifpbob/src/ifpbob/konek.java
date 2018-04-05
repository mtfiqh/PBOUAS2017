/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpbob;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author mtauf
 */
public class konek {
    private String host,username,password;
    public konek(String host, String username, String password){
        this.host=host;
        this.username=username;
        this.password=password;
    }
    public Connection getConnection(){
        Connection con;
        Statement st=null;
        ResultSet rs=null;
        try{
            con=DriverManager.getConnection(host, username, password);
            JOptionPane.showMessageDialog(null,"Connect!");
            return con;
        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Call your Administration Server!");
            return null;
        }
    }
    
    
    
}
