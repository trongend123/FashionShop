/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Context.MyDao;
import Model.Category;
import Model.Order;
import Util.SqlQuery;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    public ArrayList<Order> getOrderListByAgentId(int id){
        ArrayList<Order> orderList= new ArrayList<>();
        try{
           ps= con.prepareStatement(SqlQuery.order.getOrderByUserId);
           ps.setInt(1, id);
           ResultSet rs= ps.executeQuery();
           while(rs.next()){
               Order o= new Order(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), 
                       rs.getDate(6), rs.getDate(7), rs.getDate(8), rs.getString(9), rs.getInt(10), 
                       rs.getInt(11), rs.getString(12), rs.getString(13), rs.getDouble(14)); 
               orderList.add(o);
           }
        }catch(SQLException e){
            
        }
        return orderList;
    }
    public void updateStatusAndReceivedDateByOrderId(String []status, String[] Orderid){
        try{
            for(int i=0; i<Orderid.length; i++){
               {
                    ps=con.prepareStatement(SqlQuery.order.updateStatusAndRecievedDateByOrderId);
                    ps.setString(1, status[i]);
                    ps.setInt(2, Integer.parseInt(Orderid[i]));
                    
                    ps.executeUpdate();
                }
           }
        }catch(SQLException e){
            
        }
    }
    public void updateStatusAndShipDateByOrderId(String []status, String[] Orderid){
        try{
            for(int i=0; i<Orderid.length; i++){
               {
                    ps=con.prepareStatement(SqlQuery.order.updateStatusAndShipDateByOrderId);
                    ps.setString(1, status[i]);
                    ps.setInt(2, Integer.parseInt(Orderid[i]));
                    
                    ps.executeUpdate();
                }
           }
        }catch(SQLException e){
            
        }
    }
    public void UpdateshipDate(String status, String orderId){
        try{
            ps=con.prepareStatement(SqlQuery.order.updateStatusAndShipDateByOrderId);
            ps.setString(1, status);
            ps.setInt(2, Integer.parseInt(orderId));
            ps.executeUpdate();
        }catch(NumberFormatException | SQLException e){
            
        }
    }
    public void UpdateReceiveDate(String status, String orderId){
        try{
            ps=con.prepareStatement(SqlQuery.order.updateStatusAndRecievedDateByOrderId);
            ps.setString(1, status);
            ps.setInt(2, Integer.parseInt(orderId));
            ps.executeUpdate();
        }catch(NumberFormatException | SQLException e){
            
        }
    }
    public void DeleteOrderAndUpdateQuantity(int orderId){
        try{
            
        }catch(Exception e){
            
        }
    }
   
    

    public static void main(String[] args) {
        OrderDao orderDao = new OrderDao();
        // System.out.println(orderDao.getMaxorderId());
//        Order o = new Order(100, "hanoi", "closed");
//        
//        int x = orderDao.insertOrder(o);


        ArrayList<Order> orderList= orderDao.getOrderListByAgentId(2);
        for (Order order : orderList) {
            System.out.println(order);
        }
        Order o1= new Order(1, "Progress");
        Order o2= new Order(2, "Progress");
        Order o3= new Order(2, "Progress");
        Order o4= new Order(3, "Progress");
        
        
//        String []status= {"IN Progress", "Deliver", "Close"};
//        int [] OrderId = {1,2,2,3};
//        
//        orderDao.updateStatusByOrderId(status, OrderId);
    }
}
