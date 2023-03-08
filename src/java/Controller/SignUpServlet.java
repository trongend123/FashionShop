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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
        PrintWriter out = response.getWriter();
        //get Information
        String name = request.getParameter("nameName");
        String userName = request.getParameter("userNameName");
        String passWord = request.getParameter("passwordName");
        String email = request.getParameter("emailName");
        String phoneNumber = request.getParameter("phoneName");
        String city = request.getParameter("city");
        String district = request.getParameter("district");
        String addressDetails = request.getParameter("addressDetailsName");

        Account account = new Account(userName, passWord, phoneNumber, 5, email, city, district, addressDetails, null, name);
        AccountDao accountDao = new AccountDao();
        // insert to Database
        accountDao.signUp(account);
        request.getRequestDispatcher("Login.jsp").forward(request, response);
        response.sendRedirect("Login.jsp");
    }
}
