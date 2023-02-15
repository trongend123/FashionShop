/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.CategoryDao;
import Dao.ProductDao;
import Dao.SizeDao;
import Model.Category;
import Model.Product;
import Model.Size;
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
public class CategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String categoryId = request.getParameter("categoryId");
        int categoryIdNumber = Integer.parseInt(categoryId);

        ProductDao productDao = new ProductDao();
        CategoryDao categoryDao = new CategoryDao();
        SizeDao sizeDao = new SizeDao();

        List<Product> listProductByCategoryId = productDao.getProductByCategoryId(categoryIdNumber);
        List<Category> listCategory = categoryDao.getAllCategoryName();
        List<Size> listSizeByCategoryId = sizeDao.getSizeOfProductsByCategoryId(categoryIdNumber);
        Category categoryName = categoryDao.getCategoryByCategoryId(categoryIdNumber);

        request.setAttribute("listCategory", listCategory);
        request.setAttribute("listProductByCategoryId", listProductByCategoryId);
        request.setAttribute("listSizeByCategoryId", listSizeByCategoryId);
        request.setAttribute("categoryIdNumber", categoryIdNumber);
        request.setAttribute("categoryName", categoryName);

        request.getRequestDispatcher("AllProduct.jsp").include(request, response);
        //   processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // get information from filtet
        String season = request.getParameter("season");
        String price = request.getParameter("price");
        String gender = request.getParameter("gender");
        String size = request.getParameter("size");
        String categoryIdString = request.getParameter("categoryId");
        int categoryId = Integer.parseInt(categoryIdString);

        ProductDao productDao = new ProductDao();
        List<Product> listProduct = productDao.getListByFilter(season, price, gender, size, categoryId);

        try ( PrintWriter out = response.getWriter()) {
            for (Product product : listProduct) {
                out.println("\n"
                        + "               <div class=\"product-item\">\n"
                        + "                    <div class=\"product-item-img\">\n"
                        + "                       <a href=\"product?productId=" + product.getProductId() + "\"><img src=\"" + product.getImg() + "\" alt=\"\"></a>\n"
                        + "                    </div>\n"
                        + "\n"
                        + "                    <div class=\"product-item-name\">\n"
                        + "                        <p>" + product.getProductnName() + "</p>\n"
                        + "                    </div>\n"
                        + "\n"
                        + "                    <div class=\"product-item-price\">\n"
                        + "                        <p>" + product.getPrice() + "</p>\n"
                        + "                    </div>\n"
                        + "                </div>  ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
