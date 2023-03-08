/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.OrderDao;
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
public class OrdersHistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OrderDao orderDao = new OrderDao();

        // get user id
        String userId = request.getParameter("userId");
        String option = request.getParameter("option");

        List<Order> ordersHistoryList = new ArrayList<>();
        // show all order history
        if (option.equalsIgnoreCase("show")) {
            ordersHistoryList = orderDao.getOrdersHistoryByUserId(userId);
        }// user search 
        else if (option.equalsIgnoreCase("search")) {

        }

        // request to jsp
        request.setAttribute("ordersHistoryList", ordersHistoryList);
        request.getRequestDispatcher("OrdersHitory.jsp").forward(request, response);

    }

}
