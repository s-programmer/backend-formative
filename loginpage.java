/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author pc
 */
public class loginpage extends HttpServlet {


   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String n=request.getParameter("username");
              String p=request.getParameter("password");
              if(p.equals("winner")){
                  RequestDispatcher rd=request.getRequestDispatcher("welcome");
                  rd.forward(request, response);
                  
              }
              else{
                 out.print("sorry username or password");
                  RequestDispatcher rd=request.getRequestDispatcher("/index.html");
                  rd.include(request, response);
              }
    }
       
    

  
    
}
