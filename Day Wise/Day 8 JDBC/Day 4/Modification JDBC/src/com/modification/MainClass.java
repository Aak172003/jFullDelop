/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modification;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aakash Prajapati
 */
public class MainClass {

    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {

        try {
            // TODO code application logic here
            Connection c = ConnectionProvider.getConnection();

            if (c.isClosed()) {
                System.out.println("Connection is Still Closed ");
            } else {
                System.out.println("Connection Successfully Created  .....");
            }

//            // Create A Query
//            String q = "create table secondTable(tId int(20) primary key auto_increment, tName varchar(200) not null , tCity varchar(400))";
//
//            // Create a Statement
//            Statement stmt = c.createStatement();
//            stmt.executeUpdate(q);
//            System.out.println("Table created succesfully in DB");



            // Insert Values into Table 
            
            
            // Create A Query
            String q = "insert into firsttable(tName , tCity) values (?,?)";

            // Create a Prepared Statement
            PreparedStatement pstmt = c.prepareStatement(q);

            // Set Static Data values to Query 
            
//                pstmt.setString(1, "Aakash Prajapati");
//                pstmt.setString(2, "Lucknow");

            // Set values to Query 
            
//                pstmt.setString(1, "Aman Prajapati");
//                pstmt.setString(2, "Ghaziabad");


            // Set Dynamic Data values to Query 
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Name  : ");
            String name = br.readLine();
            System.out.println("Enter City: ");
            String city = br.readLine();

            pstmt.setString(1, name);
            pstmt.setString(2, city);
            
            //this Command is used to make change on DB
            pstmt.executeUpdate();

            System.out.println("Items Inserted Succesfully ..... ");

        } catch (SQLException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
