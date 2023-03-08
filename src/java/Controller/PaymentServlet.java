/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.CartDAO;
import Dao.OrderDao;
import Model.Account;
import Model.Cart;
import Model.Order;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class PaymentServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response, String[] cartIdArray)
            throws ServletException, IOException {
        CartDAO cartDao = new CartDAO();

        List<Cart> listCart = new ArrayList<>();
        // get list cart by list cartId and to arrayList 
        Double totalPrice = 0.0;
        int totalQuantity = 0;
        // run to get all cart by cartId from cart.jsp that user choose
        for (int i = 0; i < cartIdArray.length; i++) {
            Cart cart = cartDao.getCartByCartId(cartIdArray[i]);
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        CartDAO cartDao = new CartDAO();

        String cartIdArray[] = request.getParameterValues("cartId");
        List<Integer> listAgentId = cartDao.getAgentIdByCartId(cartIdArray);
        //       check if all cart item must be the same agent 
        if (cartDao.checkAllItemsInAgent(listAgentId)) {
            processRequest(request, response, cartIdArray);
        } else {
      
            request.setAttribute("textDanger", "items must be in the same Agent");
            RequestDispatcher rd = request.getRequestDispatcher("ViewCart");
            rd.forward(request, response);
        }

    }

}
