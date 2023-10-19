package com.modification;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdateJDBC {

    public static void main(String[] args) throws ClassNotFoundException, IOException {

        try {
            // TODO code application logic here
            Connection c = ConnectionProvider.getConnection();

            if (c.isClosed()) {
                System.out.println("Connection is Still Closed ");
            } else {
                System.out.println("Connection Successfully Created , Now i can perform my Opration  .....");
            }
            
            // Create Query 
            String q = "update firsttable set tName=? , tCity=? where tId=?";
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.println("Enter new Name  : ");
            
            String newName = br.readLine();
            
            System.out.println("Enter new City: ");
            String newCity = br.readLine();
            
            // Get Id from user 
            System.out.println("Enter the Student Id : ");
            int id = Integer.parseInt(br.readLine());
            
            // Create a Prepared Statement
            PreparedStatement pstmt = c.prepareStatement(q);
            pstmt.setString(1, newName);
            pstmt.setString(2, newCity);
            
            pstmt.setInt(3, id);
            
             //this Command is used to make change on DB
            pstmt.executeUpdate();

            System.out.println("Update Operation Succesfully Done  ..... ");
            

        } catch (SQLException ex) {
            Logger.getLogger(UpdateJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
