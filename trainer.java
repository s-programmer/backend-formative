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
import jakarta.servlet.http.HttpSession;


public class trainer extends HttpServlet {

   
    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html"); 
PrintWriter out=response.getWriter(); 

 HttpSession session=request.getSession(false); 
 if(session!=null&& "username".equals("trainer123")){ 
 String name=(String)session.getAttribute("username"); 
 out.print("Hello, "+name+" Welcome to Profile");
 request.getRequestDispatcher("student.html").include(request, response);
 } 
 else{ 
 out.print("<script>alert('Please login first')</script>"); 
  request.getRequestDispatcher("index.html").include(request, response);
 } 
out.close(); 
    }

    }

   


