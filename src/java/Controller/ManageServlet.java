/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.CategoryDao;
import Dao.ProductDao;
import Model.Category;
import Model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author win
 */
public class ManageServlet extends BaseAuthentic.BaseAuthentication{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    public void processGet(HttpServletRequest request, HttpServletResponse response) {
          String aid_raw= request.getParameter("aid");
        int aid= Integer.parseInt(aid_raw);
         Dao.ProductDao db= new ProductDao();
         Dao.CategoryDao catedb= new CategoryDao();
         ArrayList<Product> products= db.getProductByAid(aid);
         request.setAttribute("listP", products);
         ArrayList<Category> cates= catedb.list();
         request.setAttribute("listCC", cates);
        try {
            request.getRequestDispatcher("manage.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ManageServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void processPost(HttpServletRequest request, HttpServletResponse response) {
          String aid_raw= request.getParameter("aid");
        int aid= Integer.parseInt(aid_raw);
         Dao.ProductDao db= new ProductDao();
         Dao.CategoryDao catedb= new CategoryDao();
         ArrayList<Product> products= db.getProductByAid(aid);
         request.setAttribute("listP", products);
         ArrayList<Category> cates= catedb.list();
         request.setAttribute("listCC", cates);
        try {
            request.getRequestDispatcher("manage.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ManageServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
