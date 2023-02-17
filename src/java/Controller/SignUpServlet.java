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

        Account account = new Account(userName, passWord, phoneNumber, 5, email);
        AccountDao accountDao = new AccountDao();

        // insert to Database
        accountDao.signUp(account);
        request.getRequestDispatcher("Login.jsp").forward(request, response);
        response.sendRedirect("Login.jsp");

    }
}
