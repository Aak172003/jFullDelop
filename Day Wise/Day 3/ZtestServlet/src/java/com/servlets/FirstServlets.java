package com.servlets;

//In this We implement Servlet Interface , to create Servlet
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import java.io.IOException;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.PrintWriter;
import java.util.Date;

public class FirstServlets implements Servlet {

    ServletConfig conf;

    //    Life Cycle Methods
//    @Override
    @Override
    public void init(ServletConfig conf) throws ServletException {
        this.conf = conf;
        System.out.println("Creating New Objects By Servlets :......");
    }

//    @Override
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Servicing ......");

//        Set the content type , Means browser can able to understand type of response what i will send 
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h1>This is my OutPut from servlet</h1>");
        out.println("<h1>Today date and time is " + new Date().toString() + "</h1>");
        out.println("<div>Mera Naam hai Joker</div>");

        out.println("<div> <button style=\"background-color: yellow\" ><a href=\"secondServlet\" target=\"_blank\">Click Me </a> </button></div>");

    }
//    @Override

    @Override
    public void destroy() {
        System.out.println("Going to destroy Servlet Object ......");
    }

//    Non LifeCycle Method
    
//    @Override
    @Override
    public ServletConfig getServletConfig() {
        return this.conf;
    }
//    @Override

    @Override
    public String getServletInfo() {
        return "this servlet is created by Aakash Prajapati";
    }
}
