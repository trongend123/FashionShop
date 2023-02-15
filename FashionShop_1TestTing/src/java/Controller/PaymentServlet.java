/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.CartDAO;
import Model.Cart;
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
public class PaymentServlet extends HttpServlet {

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
            out.println("<title>Servlet PaymentServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PaymentServlet at " + request.getContextPath() + "</h1>");
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

        CartDAO cartDao = new CartDAO();

        String cartId[] = request.getParameterValues("cartId");

        List<Cart> listCart = new ArrayList<>();
        // get list cart by list cartId and to arrayList 
        Double totalPrice = 0.0;
        int totalQuantity = 0;
        for (int i = 0; i < cartId.length; i++) {
            Cart cart = cartDao.getCartByCartId(cartId[i]);
            listCart.add(cart);
        }

        for (Cart cart : listCart) {
            totalQuantity += cart.getQuantity();
            totalPrice += cart.getPrice() * cart.getQuantity();
        }

        request.setAttribute("listCart", listCart);
        request.setAttribute("totalPrice", totalPrice);
        request.setAttribute("totalQuantity", totalQuantity);

        request.getRequestDispatcher("Payment.jsp").forward(request, response);
    }

    public static void main(String[] args) {
        CartDAO cartDao = new CartDAO();
        String cartId[] = {"6", "7", "8"};
        List<Cart> listCart = new ArrayList<>();
        // get list cart by list cartId
        for (int i = 0; i < cartId.length; i++) {
            Cart cart = cartDao.getCartByCartId(cartId[i]);
            listCart.add(cart);
        }

        for (Cart cart : listCart) {
            System.out.println(cart.toString());
        }

    }

}
