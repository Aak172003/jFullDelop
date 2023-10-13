package com.attributeTut;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class attributeServlet extends HttpServlet {

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

            out.println("<h1>This is my OutPut from servlet</h1>");

            String number1 = request.getParameter("n1");
            int num1 = Integer.parseInt(number1);

            String number2 = request.getParameter("n2");
            int num2 = Integer.parseInt(number2);

            out.println("<h2> Num1 : " + number1 + "</h2>");
            out.println("<h2> Num2 : " + number2 + "</h2>");

            out.println(num1);
            out.println(num2);

//        Add 
            int add = num1 + num2;

//        attribute 
            request.setAttribute("addition", add);
            // here send the add variable to secondServlet with the name of addition 

            // Secondservlet access that add value from itskey "addition "
            RequestDispatcher rd = request.getRequestDispatcher("secondServlet");

            // forward Method 
            rd.forward(request, response);

            out.println("</body>");
            out.println("</html>");
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
