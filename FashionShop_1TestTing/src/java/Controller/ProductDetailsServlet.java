/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.CategoryDao;
import Dao.ProductDao;
import Model.Agent;
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
public class ProductDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        ProductDao productDao = new ProductDao();
        CategoryDao categoryDao = new CategoryDao();

        List<Category> listCategory = categoryDao.getAllCategoryName();
        List<Product> listNewProduct = productDao.getNewProdcuts();
        String selectsize=request.getParameter("selectsizes");
        String productID = request.getParameter("productId");     
        String agent = request.getParameter("agent");     
        ProductDao pd2 = new ProductDao();
        ArrayList<Product> products;
        ArrayList<Size> sizesGroup;
        ArrayList<Agent> agents;
        if (Integer.parseInt(productID) == 0) {         
            products = pd2.getProducts();
        request.setAttribute("products", products);
        request.getRequestDispatcher("/HomePage.jsp").forward(request, response);

        } else {
            Product product = pd2.getProductByProductId(Integer.parseInt(productID));
            sizesGroup = pd2.getSizebyProductId(Integer.parseInt(productID),agent);
            agents= pd2.getAllAgent();
            request.setAttribute("selectsize", selectsize);
            request.setAttribute("product", product);
            request.setAttribute("agents", agents);
            request.setAttribute("sizesG", sizesGroup); 
            request.setAttribute("listCategory", listCategory);
            request.setAttribute("listNewProduct", listNewProduct);
        request.getRequestDispatcher("ProductDetails.jsp").forward(request, response);
        }
    }
        

        

  
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //    processRequest(request, response);
    }

    public static void main(String[] args) {
        ProductDao a = new ProductDao();

        Product p = a.getProductByProductId(1);
        System.out.println(p);
    }


}