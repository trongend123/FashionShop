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

/**
 *
 * @author laptop 368
 */
public class ChangePasswordServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);

        //get Information
        String userName = request.getParameter("usernameName");
        String passWord = request.getParameter("passwordName");
        String newPass = request.getParameter("newPass");
        AccountDao accountDao = new AccountDao();

        // if found account
        if (accountDao.loginByUserName(userName, passWord) != null) {

            accountDao.changePassword(userName, newPass);
            // save into session

        }

        // if not found
        if (accountDao.loginByUserName(userName, passWord) == null) {
            request.setAttribute("result", "Wrong password or username !");
            request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
        }
        request.getRequestDispatcher("Login.jsp").forward(request, response);
        response.sendRedirect("Login.jsp");
    }
}
