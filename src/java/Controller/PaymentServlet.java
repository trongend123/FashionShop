/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.CartDAO;
import Dao.OrderDao;
import Model.Cart;
import Model.Order;
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        CartDAO cartDao = new CartDAO();

        String cartId[] = request.getParameterValues("cartId");

        List<Cart> listCart = new ArrayList<>();
        // get list cart by list cartId and to arrayList 
        Double totalPrice = 0.0;
        int totalQuantity = 0;
        // run to get all cart by cartId from cart.jsp that user choose
        for (int i = 0; i < cartId.length; i++) {
            Cart cart = cartDao.getCartByCartId(cartId[i]);
            listCart.add(cart);
        }
        // run to cal total quantity of product and total price
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
