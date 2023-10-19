
package jdbcdb.connect;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JdbcDbConnect {

    public static void main(String[] args) {
        // TODO code application logic here
         try {

            // Load the Driver 
            Class.forName("com.mysql.cj.jdbc.Driver");

             try ( // Crate a Connection
                     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadbdemo", "root", "93104")) {
                 System.out.println(con);
                 
                 if(con.isClosed())
                 {
                     System.out.println("Connection is Still Closed ");
                 }else {
                     System.out.println("Connection is Created SuccesFully .....");
                 }
                 
                 // Create A Query
                 String q = "create table table4(tId int(20) primary key auto_increment, tName varchar(200) not null , tCity varchar(400))";
                 
                 // Create a Statement
                 Statement stmt = con.createStatement();
                 stmt.executeUpdate(q);
                 System.out.println("Table created succesfully in DB");
             }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JdbcDbConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

