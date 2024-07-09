/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.HashMap;


public class LoginServlet extends HttpServlet {
     private static HashMap<String, String> users = new HashMap<>();
    
    static {
        users.put("user@example.com", "password123");
    }

    
    

    
  

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (users.containsKey(email) && users.get(email).equals(password)) {
            response.getWriter().println("Login successful!");
        } else {
            response.getWriter().println("Invalid email or password.");
        }
    }
}
      
    

   


