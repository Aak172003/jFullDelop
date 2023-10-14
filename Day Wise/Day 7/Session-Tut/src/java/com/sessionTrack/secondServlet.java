
package com.sessionTrack;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;

/**
 *
 * @author Aakash Prajapati
 */
public class secondServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet secondServlet</title>");            
            out.println("</head>");
            out.println("<body>");
 
            // Geeting All the Cookies 
            Cookie[] cookies = request.getCookies();  // array
            
            boolean f = false;
            String name = "";
            
            if(cookies == null ){
                out.println("<h2> You are new user please go to Home and add your name </h2>");
            }
            else
            {
                for(Cookie c : cookies) {
                    String tname = c.getName();
                    if(tname.equals("user_name")){
                        f = true;
                        name = c.getValue();
                    }
                }
            }
            
            if(f){
                out.println("<h1>Welcome Back , " + name +  " How r u ? </h1>");
                out.println("<h1>Thank u . Please Visit Again</h1>");
            }

            
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
