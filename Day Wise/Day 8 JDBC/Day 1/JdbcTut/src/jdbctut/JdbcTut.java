
package jdbctut;

//import com.sun.jdi.connect.spi.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JdbcTut {

    public static void main(String[] args) {
        try {
            // TODO code application logic here

            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "93104");
            System.out.println(con);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JdbcTut.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
