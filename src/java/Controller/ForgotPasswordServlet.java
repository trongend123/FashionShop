/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.AccountDao;
import Model.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author laptop 368
 */
public class ForgotPasswordServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //  processRequest(request, response);

        // get information from user
        String userName = request.getParameter("usernameName");
        String newpass = "123@123a";
        AccountDao accountDao = new AccountDao();

        // if found account
        if (accountDao.getEmail(userName) != null) {
            String email = accountDao.getEmail(userName);
            accountDao.changePassword(userName, newpass);
            resetPassword(userName, email, newpass);
            request.getRequestDispatcher("Login.jsp").forward(request, response);
            response.sendRedirect("Login.jsp");
        }
       if (accountDao.getEmail(userName) == null) {
           request.setAttribute("result", "Wrong username !");
            request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);
       }

    }

    public void resetPassword(String user, String email, String newpass) {
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
            message.setSubject("New Password");
            message.setText("Dear " + user + ","
                    + "\n\n Your account created successful"
                    + "\n New Password of your account is: " + newpass
                    + "\n ASIN FASHION SHOP FROM GR5-SE1643");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
