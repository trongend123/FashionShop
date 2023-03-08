/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.AccountDao;
import Dao.CategoryDao;
import Model.Account;
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
public class EditUserProfileServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response, String notification)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        Account account = new Account();
        AccountDao accountDao = new AccountDao();
        CategoryDao categoryDao = new CategoryDao();

        String userId = request.getParameter("userId");

        List<Category> listCategory = categoryDao.getAllCategoryName();
        account = accountDao.getUserInforBuUserId(userId);

        request.setAttribute("listCategory", listCategory);
        request.setAttribute("account", account);
        request.setAttribute("updateNotification", notification);
        request.getRequestDispatcher("UserProfile.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AccountDao accountDao = new AccountDao();

        String userName = request.getParameter("editUserNameName");
        String name = request.getParameter("editNameName");
        String phoneNumber = request.getParameter("editPhoneNumberName");
        String email = request.getParameter("editEmailName");
        String city = request.getParameter("editCityName");
        String district = request.getParameter("editDistrictname");
        String addressDetails = request.getParameter("editAddressName");
        String userId = request.getParameter("userId");
        //   update
        accountDao.UpdateUserProfile(name, userName, phoneNumber, email, city, district, addressDetails, userId);
        processRequest(request, response, "Update successfully !");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response, "");
    }

}
