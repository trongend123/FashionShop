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
import java.util.ArrayList;


/**
 *
 * @author win
 */
public class EditServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        int pid= Integer.parseInt(request.getParameter("pid"));
       Dao.ProductDao prodb= new ProductDao();
       
       Product p= prodb.get(pid);
       request.setAttribute("detail", p);
       Dao.CategoryDao cadb= new CategoryDao();
       ArrayList<Category> cats= cadb.list();
       request.setAttribute("listC", cats);
       
       request.getRequestDispatcher("edit.jsp").forward(request, response);
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
        int pid= Integer.parseInt(request.getParameter("pid"));
       int aid=Integer.parseInt(request.getParameter("aid"));
       Dao.ProductDao prodb= new ProductDao();
        Product p= prodb.get(pid);
        
        String pname= request.getParameter("name");
        int price= Integer.parseInt(request.getParameter("price"));
        String image= request.getParameter("image");
        int season= Integer.parseInt(request.getParameter("season"));
        String description = request.getParameter("description");
        String gender= request.getParameter("gender");
        int categoryid= Integer.parseInt(request.getParameter("category"));
        String sizeName= request.getParameter("size");
        int quantity= Integer.parseInt(request.getParameter("quantity"));
        Size size= new Size(sizeName, quantity);
        Dao.CategoryDao cadb= new CategoryDao();
        Category c= cadb.get(categoryid);
        prodb.update(new Product(pid, pname, price, image, season, description, gender, c, size));
       response.sendRedirect("manage?aid="+aid);
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
