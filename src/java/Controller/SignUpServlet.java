package Controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import Dao.AccountDao;
import Model.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ASUS
 */

public class SignUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);

        //get Information
        String userName = request.getParameter("usernameName");
        String passWord = request.getParameter("passwordName");
        String email = request.getParameter("emailName");
        String phone = request.getParameter("phoneName");
        int phoneNumber = Integer.parseInt(phone);
        SendMail(userName, email);
        Account account = new Account(userName, passWord, phoneNumber, 5, email);
        AccountDao accountDao = new AccountDao();

        // insert to Database
        accountDao.signUp(account);
        request.getRequestDispatcher("HomePage.jsp").forward(request, response);
        response.sendRedirect("HomePage.jsp");

    }
     public void SendMail(String user, String email)  {
            final String username = "fashionshopgr5swp391@gmail.com";
        final String password = "msbjuohhtywyrhdi";

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("fashionshopgr5swp391@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject("Create Account");
            message.setText("Dear "+user+","
                    + "\n\n Your account created successful"
                    + "\n Now you can use our services."
                    + "\n ASIN FASHION SHOP FROM GR5-SE1643");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
