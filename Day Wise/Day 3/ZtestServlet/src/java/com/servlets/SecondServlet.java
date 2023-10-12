package com.servlets;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SecondServlet extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Servicing ......");

//        Set the content type , Means browser can able to understand type of response what i will send 
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h1>This is my OutPut from Generic Servlet</h1>");
//        out.println("<h1>Today date and time is " + new Date().toString() + "</h1>");
        out.println("<div>Mera Naam hai Joker</div>");
        out.println("<div> <button style=\"background-color: yellow\" ><a href=\"firstServlet\" target=\"_blank\">Click Me </a> </button></div>");
    }

}
