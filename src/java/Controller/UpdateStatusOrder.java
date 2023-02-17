/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.OrderDao;
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
public class UpdateStatusOrder extends HttpServlet {

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
            int aid= Integer.parseInt(request.getParameter("aid"));
        String []status= request.getParameterValues("status");
        
        String []OrderId_raw= request.getParameterValues("orderId");
        String first= OrderId_raw[0];
       
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateStatusOrder</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateStatusOrder at " + request.getContextPath() + "</h1>");
            out.println(first);
            for (String statu : status) {
                out.println(statu);
            }
            for(int i=0;i<OrderId_raw.length;i++){
                out.println(OrderId_raw[i]);
            }
            
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
         int aid= Integer.parseInt(request.getParameter("aid"));
        String []status= request.getParameterValues("status"+aid);
        String []OrderId_raw= request.getParameterValues("orderId");
        

        Dao.OrderDao orderDao= new OrderDao();
        orderDao.updateStatusAndReceivedDateByOrderId(status, OrderId_raw);
        response.sendRedirect("vieworder?aid="+aid);
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
       int aid= Integer.parseInt(request.getParameter("aid"));
        String []status= request.getParameterValues("status"+aid);
        String []OrderId_raw= request.getParameterValues("orderId");
        
        

        Dao.OrderDao orderDao= new OrderDao();
//        orderDao.updateStatusAndReceivedDateByOrderId(status, OrderId_raw);
//        orderDao.updateStatusAndShipDateByOrderId(status, OrderId_raw);
        for(int i=0;i<OrderId_raw.length;i++){
            if(status[i].equalsIgnoreCase("Delivered")){
                orderDao.UpdateshipDate(status[i], OrderId_raw[i]);
            }else if(status[i].equalsIgnoreCase("Closed")){
                orderDao.UpdateReceiveDate(status[i], OrderId_raw[i]);
            }
        }
        response.sendRedirect("vieworder?aid="+aid);
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
