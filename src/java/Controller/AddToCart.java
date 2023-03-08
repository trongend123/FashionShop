/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.CartDAO;
import Model.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Hoang Phi Hung
 */
public class AddToCart extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("account") == null) {
            response.sendRedirect("login");
        } else {
            Account account = (Account) session.getAttribute("account");
            String selectedAgent = request.getParameter("selectedAgent");
            String selectedSize = request.getParameter("size");
            String quantity = request.getParameter("quantity");
            String productId = request.getParameter("productId");
            String[] sizeArray = selectedSize.split("-");
            String size = sizeArray[0];
            CartDAO cdao = new CartDAO();
            int sizeId = cdao.getSizeId(productId, selectedAgent, size);

            cdao.addCart(sizeId, quantity, String.valueOf(account.getUserId()));

            response.sendRedirect("product?productId="+productId);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
