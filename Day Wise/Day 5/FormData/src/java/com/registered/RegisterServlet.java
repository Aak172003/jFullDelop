package com.registered;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        PrintWriter out = res.getWriter();
        out.println("<h1>This is my OutPut from servlet</h1>");

        out.println("<div>Mera Naam hai Joker</div>");
        String name = req.getParameter("user_name");

        out.println(name);
        String password = req.getParameter("user_pass");
        String email = req.getParameter("user_email");

        String cond = req.getParameter("condition");

        if (cond != null) {
            if (cond.equals("checked")) {
                out.println("<h2> You have Accepted Terms and Conditions</h2>");
                out.println("<h2> Name : " + name + "</h2>");
                out.println("<h2> Password : " + password + "</h2>");
                out.println("<h2> Email : " + email + "</h2>");

//              JDBC
//              Save to DB 

//              Means If condition true , then goes ti Success Servlet 

                RequestDispatcher rd = req.getRequestDispatcher("success");

                // forward Method 
                rd.forward(req, res);

            } else {
                out.println("<h2> You have not Accepted Terms and Conditions</h2>");
            }
        } else {
            out.println("<h2> You have not Accepted Terms and Conditions</h2>");

            // If Null , Which means i want to include index.html page 
            // Get the Object of Request Dispatcher 
            RequestDispatcher rd = req.getRequestDispatcher("index.html");

            // include Method 
            rd.include(req, res);
        }
    }

}
