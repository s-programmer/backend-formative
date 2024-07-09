/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author user
 */
public class loginpage extends HttpServlet {

 
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String n=request.getParameter("username");
          String p=request.getParameter("password");
          if(p.equals("admin123")&& n.equals("admin")){
         request.getRequestDispatcher("admin.html").include(request, response);
         HttpSession session=request.getSession();
         session.setAttribute("username", n);
         
          }
          
          else if(p.equals("stud123")&& n.equals("student")){
         request.getRequestDispatcher("student.html").include(request, response);
         HttpSession session=request.getSession();
         session.setAttribute("username", n);
                  }
          else if(p.equals("trainer123")&& n.equals("trainer")){
         request.getRequestDispatcher("trainer.html").include(request, response);
         HttpSession session=request.getSession();
         session.setAttribute("username", n);
                  }
          else if(p.equals("evaluator123")&& n.equals("evaluator")){
         request.getRequestDispatcher("user.html").include(request, response);
         HttpSession session=request.getSession();
         session.setAttribute("username", n);
                  }
          
          
          
          else{
          
          out.print("sorry username or password error");
           RequestDispatcher rd=request.getRequestDispatcher("index.html");
          rd.include(request, response);
          
          
          
          }
    }

   

}
