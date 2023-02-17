/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.CartDAO;
import Dao.CategoryDao;
import Model.Account;
import Model.Cart;
import Model.Category;
import Model.Product;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hoang Phi Hung
 */
public class ViewCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("account") == null) {
            response.sendRedirect("login");
        } else {
            Account account = (Account) session.getAttribute("account");
            CartDAO cdao = new CartDAO();
            CategoryDao categoryDao = new CategoryDao();
            List<Category> listCategory = categoryDao.getAllCategoryName();
            ArrayList<Cart> clist = cdao.getAllCartItemByUid(String.valueOf(account.getUserId()));
            request.setAttribute("clist", clist);
            request.setAttribute("listCategory", listCategory);
            RequestDispatcher dispath = request.getRequestDispatcher("ViewCart.jsp");
            dispath.forward(request, response);
        }
    }

    public static void main(String[] args) {
        CartDAO cartDsao = new CartDAO();
        List<Cart> list = cartDsao.getAllCartItemByUid("2");
        for (Cart cart : list) {
            System.out.println(cart.toString());
        }
    }
}
