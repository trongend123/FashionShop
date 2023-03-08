/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.ProductDao;
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
public class FilterProductBySearch extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String productName = request.getParameter("productNameInSearch");
        ProductDao productDao = new ProductDao();
        List<Product> listProductByNameInSearch = productDao.getNewProductByName(productName);

        try ( PrintWriter out = response.getWriter()) {
            for (Product product : listProductByNameInSearch) {
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

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String minPrice = request.getParameter("minPrice");
        String maxPrice = request.getParameter("maxPrice");
        String productName = request.getParameter("productNameInSearch");

        ProductDao productDao = new ProductDao();
        List<Product> listProductBySearchPrice = productDao.filterListInSearchProduct(minPrice, maxPrice, productName);

        try ( PrintWriter out = response.getWriter()) {
            for (Product product : listProductBySearchPrice) {
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
