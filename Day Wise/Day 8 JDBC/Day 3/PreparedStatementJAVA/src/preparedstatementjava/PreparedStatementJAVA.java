package preparedstatementjava;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;

/**
 *
 * @author Aakash Prajapati
 */
public class PreparedStatementJAVA {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        try {

            // Load the Driver 
            Class.forName("com.mysql.cj.jdbc.Driver");

            try ( 
                 // Crate a Connection
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadbdemo", "root", "93104")) {
                System.out.println(con);

                if (con.isClosed()) {
                    System.out.println("Connection is Still Closed ");
                } else {
                    System.out.println("Connection is Created SuccesFully .....");
                }

                // Create A Query
                String q = "insert into table1(tName , tCity) values (?,?)";

                // Create a OPrepared Statement
                PreparedStatement pstmt = con.prepareStatement(q);

                // Set values to Query 
//                pstmt.setString(1, "Aakash Prajapati");
//                pstmt.setString(2, "Lucknow");
//
//                // Set values to Query 
//                pstmt.setString(1, "Aman Prajapati");
//                pstmt.setString(2, "Ghaziabad");
//
//                // Set values to Query 
//                pstmt.setString(1, "Arpit Narang");
//                pstmt.setString(2, "Delhi");


                // How insert Dynamic data from user  -> use Buffer Reader &  Input Reader
                
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Enter Name  : ");
                String name = br.readLine();
                System.out.println("Enter City: ");
                String city = br.readLine();

                pstmt.setString(1, name);
                pstmt.setString(2, city);
                pstmt.executeUpdate();

                pstmt.executeUpdate();
                System.out.println("Items Inserted Succesfully ..... ");

                con.close();
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PreparedStatementJAVA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
