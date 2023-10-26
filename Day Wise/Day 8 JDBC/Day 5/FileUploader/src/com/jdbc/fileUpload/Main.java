package com.jdbc.fileUpload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

public class Main extends ConnectionProvider {

    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {

        try {
            // TODO code application logic here
            Connection c = ConnectionProvider.getConnection();

            if (c.isClosed()) {
                System.out.println("Connection is Still Closed ");
            } else {
                System.out.println("Connection Successfully .....");
            }

            String q = "insert into images(pic) value(?)";

            PreparedStatement pstmt = c.prepareStatement(q);

            JFileChooser jfc = new JFileChooser();

            int showOpenDialog = jfc.showOpenDialog(null);

            if (showOpenDialog == JFileChooser.APPROVE_OPTION) {
                File file = jfc.getSelectedFile();

                try (
                    
                    FileInputStream fis = new FileInputStream(file)) {
                    pstmt.setBinaryStream(1, fis, fis.available());
                    pstmt.executeUpdate();
                    System.out.println("Done Submit Successfully ..... ");
                    
                    // Close FileInputStream
                }
            } else {
                System.out.println("No file selected.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionProvider.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
