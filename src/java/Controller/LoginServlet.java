/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.AccountDao;
import Model.Account;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author ASUS
 */
public class LoginServlet extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispath = request.getRequestDispatcher("Login.jsp");
        dispath.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //  processRequest(request, response);

        // get information from user
        String userName = request.getParameter("usernameName");
        String passWord = request.getParameter("passwordName");

        AccountDao accountDao = new AccountDao();

        // if found account
        if (accountDao.loginByUserName(userName, passWord) != null) {

            Account account = accountDao.loginByUserName(userName, passWord);
            // save into session
            HttpSession session = request.getSession();
            session.setAttribute("account", account);
            response.sendRedirect("setUpHomePage");
        }

         // if not found
        if (accountDao.loginByUserName(userName, passWord) == null) {
            request.setAttribute("result", "Wrong password or username !");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
    }
}
