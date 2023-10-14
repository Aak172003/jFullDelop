package com.sessionTrack;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SessTrackServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SessTrackServlet</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<h1>This is my SessTrack Servlet Page </h1>");

            String name = request.getParameter("name");
            String email = request.getParameter("email");

            out.println("<h2> Num1 : " + name + "</h2>");
            out.println("<h2> Num2 : " + email + "</h2>");
            
            out.println("<a href=\"secondServlet\">Go to Next Page</a>");
            
//            Cookies 
            Cookie c = new Cookie("user_name" , name);
            c.setMaxAge(300);
            
            response.addCookie(c);
            
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
