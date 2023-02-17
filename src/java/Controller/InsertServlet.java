/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.CategoryDao;
import Dao.ProductDao;
import Model.Category;
import Model.Product;
import Model.Size;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author win
 */
public class InsertServlet extends HttpServlet {
                                 
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
        String id_raw= request.getParameter("aid");
        int id= Integer.parseInt(id_raw);
        ProductDao db= new ProductDao();
        Product pMax= db.getMaxIdProduct();
        int idMax= pMax.getProductId();
        Dao.CategoryDao cadb= new CategoryDao();

       
        
        String pname= request.getParameter("pname");
        int price= Integer.parseInt(request.getParameter("price"));
        String image= request.getParameter("image");
        int season= Integer.parseInt(request.getParameter("season"));
        String description = request.getParameter("description");
        String gender= request.getParameter("gender");
        int categoryid= Integer.parseInt(request.getParameter("category"));
        String sizeName= request.getParameter("size");
        int quantity= Integer.parseInt(request.getParameter("quantity"));
        
        Size size= new Size(sizeName, quantity);
        Category c= cadb.get(categoryid);
        
        request.setAttribute("pMax", pMax);
        request.setAttribute("c", c);
        db.insert(new Product(pname, price, image, season, description, gender, c, size), id, idMax);
       
        
        response.sendRedirect("manage?aid="+id);
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
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
