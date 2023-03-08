/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.CategoryDao;
import Dao.CommentDao;
import Dao.ProductDao;
import Dao.WishDao;
import Model.Agent;
import Model.Category;
import Model.Comment;
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
public class ProductDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProductDao productDao = new ProductDao();
        CategoryDao categoryDao = new CategoryDao();
        CommentDao commentDao = new CommentDao();
        ProductDao pd2 = new ProductDao();
        WishDao wishDao = new WishDao();
        // list category in navBar
        List<Category> listCategory = categoryDao.getAllCategoryName();

        String selectsize = request.getParameter("selectsizes");
        String agent = request.getParameter("agent");
        String userId = request.getParameter("userId");
        int productId = Integer.parseInt(request.getParameter("productId"));

        ArrayList<Product> products;
        ArrayList<Size> sizesGroup;
        ArrayList<Agent> agents;

        if (productId == 0) {
            products = pd2.getProducts();
            request.setAttribute("products", products);
            request.getRequestDispatcher("/HomePage.jsp").forward(request, response);
        } else {

            Product product = pd2.getProductByProductId(productId);
            sizesGroup = pd2.getSizebyProductId(productId, agent);

            List<Comment> commentList = commentDao.getListCommentByProductId(productId);
            List<Product> relateProductList = productDao.getRealateProductByProductId(productId);

            agents = pd2.getAllAgent();
            
            // exists user in session _> print if product in user'wishList
            if (userId != "") {
                boolean wish = wishDao.checkProductAndUser(productId, userId);
                request.setAttribute("wish", wish);
            }
            request.setAttribute("selectsize", selectsize);
            request.setAttribute("product", product);
            request.setAttribute("agents", agents);
            request.setAttribute("sizesG", sizesGroup);
            request.setAttribute("listCategory", listCategory);
            request.setAttribute("commentList", commentList);
            request.setAttribute("relateProductList", relateProductList);

            request.getRequestDispatcher("ProductDetails.jsp").forward(request, response);
        }
    }

}
