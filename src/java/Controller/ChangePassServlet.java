/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.AccountDao;
import Dao.CategoryDao;
import Model.Category;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ChangePassServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response, String notification)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String userId = request.getParameter("userId");
        CategoryDao categoryDao = new CategoryDao();
        List<Category> listCategory = categoryDao.getAllCategoryName();
        request.setAttribute("listCategory", listCategory);
        request.setAttribute("notification", notification);
        request.getRequestDispatcher("ChangePass.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response, "");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccountDao accountDao = new AccountDao();
        PrintWriter out = response.getWriter();
        // get info 
        String userId = request.getParameter("userId");
        String oldPass = request.getParameter("editOldPassWordName");
        String newPass = request.getParameter("editNewPassWordName");

        String notificattionChangePass = "";

        //   user enter right old pass
        if (accountDao.checkOldPassWord(oldPass, userId)) {
            accountDao.changePassWordUserId(userId, newPass);
            notificattionChangePass = "Change Password Successfully !";
            processRequest(request, response, notificattionChangePass);
        } else {
            notificattionChangePass = "Wrong Pass !";
            processRequest(request, response, notificattionChangePass);
        }
        

    }

}
