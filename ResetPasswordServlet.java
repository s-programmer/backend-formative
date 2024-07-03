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

/**
 *
 * @author pc
 */
public class ResetPasswordServlet extends HttpServlet {

   
   private static HashMap<String, String> users= new HashMap<>();
    private static final HashMap<String, String> resetCodes = ForgotPasswordServlet.resetCodes;
    

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String code = request.getParameter("code");
        String newPassword = request.getParameter("newPassword");

        if (resetCodes.containsKey(email) && resetCodes.get(email).equals(code)) {
            users.put(email, newPassword);
            resetCodes.remove(email);
            response.getWriter().println("Password has been reset successfully!");
        } else {
            response.getWriter().println("Invalid code.");
        }
    }
}
    

    

