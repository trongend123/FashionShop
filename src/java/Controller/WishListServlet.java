/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.CategoryDao;
import Dao.ProductDao;
import Dao.WishDao;
import Model.Category;
import Model.Product;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class WishListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //  processRequest(request, response);
        PrintWriter out = response.getWriter();
        WishDao wishDao = new WishDao();
        CategoryDao categoryDao = new CategoryDao();
        ProductDao productDao = new ProductDao();

        List<Category> listCategory = categoryDao.getAllCategoryName();

        String productId = request.getParameter("productId");
        int userId = Integer.parseInt(request.getParameter("userId"));
        String option = request.getParameter("option");

        List<Product> wishList = new ArrayList<>();
        // user add product to wishList
        if (option.equalsIgnoreCase("add")) {
            wishDao.addToWishList(Integer.parseInt(productId), userId);
            // user delete wish list from productDetails page
        } else if (option.equalsIgnoreCase("delete")) {
            wishDao.deleteToWishList(Integer.parseInt(productId), userId);
            // user in wishList.jsp page
        } else if (option.equalsIgnoreCase("show")) {
            wishList = wishDao.getWishListByUserId(userId);
            request.setAttribute("listCategory", listCategory);
            request.setAttribute("wishList", wishList);
            request.getRequestDispatcher("WishList.jsp").include(request, response);
            // user delete in wishList.jsp page
        } else if (option.equalsIgnoreCase("deleteInWishPage")) {
            wishDao.deleteToWishList(Integer.parseInt(productId), userId);
            wishList = wishDao.getWishListByUserId(userId);
            request.setAttribute("listCategory", listCategory);
            request.setAttribute("wishList", wishList);
            request.getRequestDispatcher("WishList.jsp").include(request, response);
        }
        request.getRequestDispatcher("product").include(request, response);
    }

}
