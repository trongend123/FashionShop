/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.CategoryDao;
import Dao.ProductDao;
import Model.Category;
import Model.Product;
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
public class SetUpHomePage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoryDao categoryDao = new CategoryDao();
        ProductDao productDao = new ProductDao();

        List<Category> listCategory = categoryDao.getAllCategoryName();
        List<Product> listNewProduct = productDao.getNewProdcuts();

        request.setAttribute("listCategory", listCategory);
        request.setAttribute("listNewProduct", listNewProduct);

        request.getRequestDispatcher("HomePage.jsp").forward(request, response);

    }

}
