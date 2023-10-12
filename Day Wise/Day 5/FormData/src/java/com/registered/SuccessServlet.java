
package com.registered;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class SuccessServlet extends HttpServlet  {
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        res.setContentType("text/html");
        
        PrintWriter out = res.getWriter();
        out.println("<h1>This is Success Servlet </h1>");
        
    }
}
