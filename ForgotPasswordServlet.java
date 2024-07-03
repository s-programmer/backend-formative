import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class ForgotPasswordServlet extends HttpServlet {
    static final HashMap<String, String> resetCodes = new HashMap<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String code = generateCode();

        resetCodes.put(email, code);

        // Send the code to the user's email
        sendEmail(email, code);

        // Forward to the reset password form
        request.setAttribute("email", email);
        request.getRequestDispatcher("resetPassword.html").forward(request, response);
    }

    private String generateCode() {
        Random random = new Random();
        return String.valueOf(100000 + random.nextInt(900000));
    }

    private void sendEmail(String email, String code) {
        final String fromEmail = "mutijimaeloi@gmail.com";
        final String password = "20042020";

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });
session.setDebug(true);
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Password Reset Code");
            message.setText("Your password reset code is: " + code);
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}