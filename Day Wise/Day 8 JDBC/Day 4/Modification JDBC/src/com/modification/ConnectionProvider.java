/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modification;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Aakash Prajapati
 */
public class ConnectionProvider {
    
    private static Connection con;
    
    public static Connection getConnection() throws ClassNotFoundException {
        
        try{
        if (con == null) {
                
                // Load the Driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/upddel", "root", "93104");
                
                System.out.println(con);
            }
 
            }
        catch (SQLException ex) {
            Logger.getLogger(ConnectionProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
}
