/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Context.MyDao;
import Model.Category;
import Model.Order;
import Util.SqlQuery;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class OrderDao extends MyDao implements SqlQuery {

    public int insertOrder(Order order) {

        try {
            ps = con.prepareStatement(SqlQuery.order.insertOder);
            ps.setDouble(1, order.getPayment());
            ps.setString(2, order.getAddress());
            ps.setString(3, order.getStatus());
            ps.setString(4, order.getPhoneNumber());
            ps.setString(5, order.getEmail());
            ps.setString(6, order.getCustomerName());
            ps.setString(7, order.getNote());
            // insert sucess
            if (ps.executeUpdate() > 0) {
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getMaxorderId() {
        try {
            ps = con.prepareStatement(SqlQuery.order.getMaxOrderId);
            rs = ps.executeQuery();
            if (rs.next()) {
                int maxOrderId = rs.getInt(1);
                return maxOrderId;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Order> getOrdersHistoryByUserId(String userId) {

        List<Order> ordersHistoryList = new ArrayList<>();
        try {
            ps = con.prepareStatement(SqlQuery.order.getOrdersHistoryByUserId);
            ps.setString(1, userId);
            rs = ps.executeQuery();
            // get all orders history 
            while (rs.next()) {
                Order order = new Order(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6), rs.getString(7), rs.getDate(8), rs.getString(9), rs.getDouble(10), rs.getInt(11));
                ordersHistoryList.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ordersHistoryList;
    }

// Search orders history by agent, product name or order Id
    public List<Order> searchOrdersHistory(String userId, String searchKey) {
        List<Order> ordersHistoryList = new ArrayList<>();
        try {
            ps = con.prepareStatement(SqlQuery.order.searchOrdersHistory);
            ps.setString(1, userId);
            // key can be agent, product name
            ps.setString(2, searchKey);
            ps.setString(3, "%" + searchKey + "%");
            rs = ps.executeQuery();
            // get all orders history 
            while (rs.next()) {
                Order order = new Order(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6), rs.getString(7), rs.getDate(8), rs.getString(9), rs.getDouble(10), rs.getInt(11));
                ordersHistoryList.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ordersHistoryList;
    }

    public static void main(String[] args) {
        OrderDao orderDao = new OrderDao();
        // System.out.println(orderDao.getMaxorderId());
//        Order o = new Order(100, "hanoi", "Inprocess", "0326576545", "thang@hehe", "Thien Thang", "Note");
//
//        int x = orderDao.insertOrder(o);
        List<Order> list = orderDao.searchOrdersHistory("5", "áo");
        for (Order order : list) {
            System.out.println(order.toString());

        }
    }
}
