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
public class SearchProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String productName = request.getParameter("searchName");
        ProductDao productDao = new ProductDao();
        CategoryDao categoryDao = new CategoryDao();

        List<Product> listProductByName = productDao.searchProductByName(productName);
        List<Category> listCategory = categoryDao.getAllCategoryName();

        request.setAttribute("listCategory", listCategory);
        request.setAttribute("listProductInSearch", listProductByName);
        request.getRequestDispatcher("SearchProduct.jsp").include(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productName = request.getParameter("productName");

        ProductDao productDao = new ProductDao();
        List<Product> listProductLiveSearch = productDao.searchProductByName(productName);

        try ( PrintWriter out = response.getWriter()) {
            for (Product product : listProductLiveSearch) {
                out.println("  <div class=\"product-item\">\n"
                        + "                            <div class=\"product-item-img\">\n"
                        + "                                <a href=\"product?productId=" + product.getProductId() + "\"><img src=\"" + product.getImg() + "\" alt=\"\"></a>\n"
                        + "                            </div>\n"
                        + "\n"
                        + "                            <div class=\"product-item-name\">\n"
                        + "                                  <p>" + product.getProductnName() + "</p>\n"
                        + "                            </div>\n"
                        + "\n"
                        + "                            <div class=\"product-item-price\">\n"
                        + "                               <p>" + product.getPrice() + "</p>\n"
                        + "                            </div>\n"
                        + "                        </div>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
