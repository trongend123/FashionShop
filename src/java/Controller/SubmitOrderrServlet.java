/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.CartDAO;
import Dao.OrderDao;
import Dao.SizeDao;
import Model.Order;
import Util.StatusForOrder;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.Writer;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class SubmitOrderrServlet extends HttpServlet {

//    protected void processRequest(HttpServletRequest request, HttpServletResponse response, String[] listCart)
//            throws ServletException, IOException {
//        PrintWriter out = response.getWriter();
//        OrderDao orderDao = new OrderDao();
//        CartDAO cartdao = new CartDAO();
//        SizeDao sizedao = new SizeDao();
//
//        // get infomation from cart
//        String email = request.getParameter("emailName");
//        String name = request.getParameter("nameName");
//        String phone = request.getParameter("phoneName");
//        String address = request.getParameter("addressName");
//        String note = request.getParameter("noteName");
//        String city = request.getParameter("cityName");
//        String district = request.getParameter("districName");
//        Double payment = Double.parseDouble(request.getParameter("payment"));
//
//        String fullAddress = address + "-" + district + "-" + city;
//
//        //insert into order table
//        Order order = new Order(payment, fullAddress, "INPROCESS", phone, email, name, note);
//        orderDao.insertOrder(order);
//
//        //get order Id to update for cart
//        int maxOrderId = orderDao.getMaxorderId();
//
//        // update for all cart with max orderId
//        cartdao.updateOrderIdForCart(listCart, maxOrderId);
//
//        // minus number of product in [SIZE] table in agent that user choose by cartid (minus in stock)
//        sizedao.minusNumberOfProductsByCartId(listCart);
//
//        response.sendRedirect("setUpHomePage");
//
//    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        CartDAO cartdao = new CartDAO();
        String[] listCart = request.getParameterValues("lisrCartId");
            OrderDao orderDao = new OrderDao();
        SizeDao sizedao = new SizeDao();

        // get infomation from cart
        String email = request.getParameter("emailName");
        String name = request.getParameter("nameName");
        String phone = request.getParameter("phoneName");
        String address = request.getParameter("addressName");
        String note = request.getParameter("noteName");
        String city = request.getParameter("cityName");
        String district = request.getParameter("districName");
        Double payment = Double.parseDouble(request.getParameter("payment"));

        String fullAddress = address + "-" + district + "-" + city;

        //insert into order table
        Order order = new Order(payment, fullAddress, "INPROCESS", phone, email, name, note);
        orderDao.insertOrder(order);

        //get order Id to update for cart
        int maxOrderId = orderDao.getMaxorderId();

        // update for all cart with max orderId
        cartdao.updateOrderIdForCart(listCart, maxOrderId);

        // minus number of product in [SIZE] table in agent that user choose by cartid (minus in stock)
        sizedao.minusNumberOfProductsByCartId(listCart);

        response.sendRedirect("setUpHomePage");

    }
}
