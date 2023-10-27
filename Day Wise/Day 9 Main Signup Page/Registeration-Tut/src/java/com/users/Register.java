package com.users;

import jakarta.servlet.ServletContext;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;

import java.io.FileOutputStream;
import java.io.InputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aakash Prajapati
 */
@MultipartConfig
public class Register extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            // Getting all the data from request 
            String name = request.getParameter("user_name");
//            out.println("<h1> The name is : " + name + "</h1>");

            String password = request.getParameter("user_password");
//            out.println("<h1> The Password is : " + password + "</h1>");

            String Email = request.getParameter("user_email");
//            out.println("<h1> The Email is : " + Email + "</h1>");

            Part part = request.getPart("image");
            String fileName = part.getSubmittedFileName();

//            out.println(fileName);

            // Connection Create 
            try {

                Thread.sleep(3000);

                Class.forName("com.mysql.cj.jdbc.Driver");

                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "root", "93104")) {
//                    System.out.println(con);

//                    if (con.isClosed()) {
//                        System.out.println("Connection is Still Closed ");
//                    } else {
//                        System.out.println("Connection is Created SuccesFully .....");
//                    }
                    // Create A Query
                    String q = "insert into register(name , Email , imageName) values (?,?, ?)";

                    // Create a OPrepared Statement
                    PreparedStatement pstmt = con.prepareStatement(q);

                    // Set values to Query
                    pstmt.setString(1, name);
//                    pstmt.setString(2, password);
                    pstmt.setString(2, Email);
                    pstmt.setString(3, fileName);

                    pstmt.executeUpdate();

                    // Upload on any Server
                    InputStream is = part.getInputStream();
                    byte []data = new byte[is.available()];

                    is.read(data);

                    // Using java.nio.file.Path
                    ServletContext context = getServletContext();
//                    Path path = Paths.get(context.getRealPath("/") +  "img" + File.sepeartor + fileName);
                    
                    Path path = Paths.get(context.getRealPath("/") + "img" + File.separator + fileName);

                    
//                    out.println("The file Path is : " + path);
                    
                    String absolutePath = path.toAbsolutePath().toString();

//                  out.println("The file Path is : " + absolutePath);

                    FileOutputStream fos = new FileOutputStream(absolutePath);
//                        out.println("the fos is : " + fos);
                        fos.write(data);
                        
//                        out.println("Read Complete");
                        fos.close();
                   
                    out.println("done");
                }
            } catch (IOException | ClassNotFoundException | InterruptedException | SQLException ex) {
            out.println("error");
        }
    }
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
