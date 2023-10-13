package com.attributeTut;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class secondServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<h1>This is my OutPut from attribute Servlet</h1>");

            int num1inServ = Integer.parseInt(request.getParameter("n1"));

            int num2inServ = Integer.parseInt(request.getParameter("n2"));

            int prod = num1inServ * num2inServ;

//        Get Attribute from Request Object
            int sum = (int) request.getAttribute("addition");

            out.println("<h1>This is Our data</h1>");
            out.println("<h1>sum = " + sum + "</h1>");
            out.println("<h1>prod = " + prod + "</h1>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}
