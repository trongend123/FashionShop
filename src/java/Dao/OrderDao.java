/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Context.MyDao;
import Model.Category;
import Model.Order;
import Util.SqlQuery;

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

    public static void main(String[] args) {
        OrderDao orderDao = new OrderDao();
        // System.out.println(orderDao.getMaxorderId());
        Order o = new Order(100, "hanoi", "closed");

        int x = orderDao.insertOrder(o);
    }
}
