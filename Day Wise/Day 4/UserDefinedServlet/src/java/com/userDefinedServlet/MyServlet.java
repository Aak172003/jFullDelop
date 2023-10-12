package com.userDefinedServlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {

//    Create using HttpServlet
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("This is Get Request from User Defined Servlet");

        res.setContentType("text/html");
  
        PrintWriter out = res.getWriter();
        out.println("<h1>This is Data From Client Request from servlet</h1>");

        
        
    } 
       
}
