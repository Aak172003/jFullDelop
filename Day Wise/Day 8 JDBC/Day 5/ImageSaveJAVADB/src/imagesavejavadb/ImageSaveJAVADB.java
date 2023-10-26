/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package imagesavejavadb;

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
public class ImageSaveJAVADB {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        try {
            // Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadbdemo", "root", "93104")) {
                System.out.println(con);

                if (con.isClosed()) {
                    System.out.println("Connection is Still Closed ");
                } else {
                    System.out.println("Connection Successfully .....");
                }

                // Create A Query
                String q = "insert into images(pic) values (?)";

                // Create a Prepared Statement
                PreparedStatement pstmt = con.prepareStatement(q);
                
                FileInputStream fis = new FileInputStream("C:\\Users\\Aakash Prajapati\\Downloads\\cmpress.jpg");
                

                pstmt.setBinaryStream(1, fis, fis.available());
                pstmt.executeUpdate();
                
                System.out.println("Image Insert SuccesFully");

                
                con.close();

            }
        } catch (SQLException ex) {
            Logger.getLogger(ImageSaveJAVADB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
