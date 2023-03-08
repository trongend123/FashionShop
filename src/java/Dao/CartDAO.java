/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Context.DBContext;
import Context.DBContext;
import Context.MyDao;
import Model.Agent;
import Model.Cart;
import Model.Product;
import Util.SqlQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hoang Phi Hung
 */
public class CartDAO extends MyDao implements SqlQuery {

    public CartDAO() {
        connectDB();
    }

    Connection cnn; // ket noi db

    ResultSet rs; // luu tru va xu ly du lieu

    private void connectDB() {
        try {
            cnn = (new DBContext().connection);
            System.out.println("Connect successfully!");
        } catch (Exception e) {
            System.out.println("Connect error:" + e.getMessage());
        }
    }

    // lam cart
    public int addCart(int sizeId, String quantity, String uId) {

        String check = " select [CartID],[Quantity], [OrderID]  from [CART] where UserID= " + uId + " AND SizeID =  " + sizeId;
        int checkNumber = 0;
        int quantityOld = 0;
        String OrderId = "";
        try {
            System.out.println(check);
            PreparedStatement statement = cnn.prepareCall(check);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                checkNumber = rs.getInt(1);
                quantityOld = rs.getInt(2);
                OrderId = rs.getString(3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // cart was exsit and ordered yet -> update quantity for cart
        if (checkNumber != 0 && OrderId == null) {
            new CartDAO().changeQuantity(String.valueOf(checkNumber), String.valueOf(quantityOld + Integer.valueOf(quantity)));
            // cart dosen't exist -> add to cart
        } else {
            try {
                PreparedStatement statement = cnn.prepareCall(SqlQuery.cart.addToCart);
                statement.setString(1, uId);
                statement.setInt(2, sizeId);
                statement.setString(3, quantity);
                statement.setString(4, null);
                statement.executeUpdate();
                return 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public void deleteItems(String itemId) {

        String sql = "delete from [CART] where [CartID] = ?";
        try {
            PreparedStatement statement = cnn.prepareCall(sql);
            statement.setString(1, itemId);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeQuantity(String itemId, String quantity) {
        String sql = "update [CART] set [Quantity] = ? where [CartID] = ?";
        try {
            PreparedStatement statement = cnn.prepareCall(sql);
            statement.setString(1, quantity);
            statement.setString(2, itemId);
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Cart> getAllCartItemByUid(String uid) {
        ArrayList<Cart> list = new ArrayList<>();
        try {
            ps = con.prepareStatement(SqlQuery.cart.viewCart);
            ps.setString(1, uid);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cart cart = new Cart(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
                list.add(cart);
            }
        } catch (Exception e) {
            System.out.println("getlist Error:" + e.getMessage());
        }
        return list;
    }

    // get cart by cartId to move to payment
    public Cart getCartByCartId(String cartId) {
        try {
            ps = con.prepareStatement(SqlQuery.cart.getCartByCartId);
            ps.setString(1, cartId);
            rs = ps.executeQuery();
            // get Cart by cart ID if cartId exists
            if (rs.next()) {
                Cart cart = new Cart(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
                return cart;
            }
        } catch (Exception e) {
            System.out.println("getlist Error:" + e.getMessage());
        }
        return null;
    }

    public int getSizeId(String productId, String agentId, String size) {
        int sizeId = 0;

        try {
            ps = con.prepareStatement(SqlQuery.size.getSizeId);
            ps.setString(1, productId);
            ps.setString(2, agentId);
            ps.setString(3, size);
            rs = ps.executeQuery();
            if (rs.next()) {
                sizeId = rs.getInt(1);
                return sizeId;
            }
        } catch (Exception e) {
            System.out.println("getlist Error:" + e.getMessage());
        }
        return sizeId;
    }

    public void updateOrderIdForCart(String[] cartId, int orderId) {
        try {

            // run from first to the last element cartId 
            for (int i = 0; i < cartId.length; i++) {
                ps = con.prepareStatement(SqlQuery.cart.updateOrderIdForCart);
                ps.setInt(1, orderId);
                ps.setString(2, cartId[i]);
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkCart(int sizeId, String uId) {
        String check = " select [CartID],[Quantity], [OrderID]  from [CART] where UserID= " + uId + " AND SizeID =  " + sizeId;
        int checkNumber = 0;
        int quantityOld = 0;
        String OrderId = "";
        try {
            //      System.out.println(check);
            PreparedStatement statement = cnn.prepareCall(check);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                checkNumber = rs.getInt(1);
                quantityOld = rs.getInt(2);
                OrderId = rs.getString(3);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.print(checkNumber + " ");
        System.out.print(quantityOld + " ");
        System.out.println(OrderId);

    }

    // get AgentId by cartId to check all items in cart must be the same agent
    public List<Integer> getAgentIdByCartId(String[] listCartId) {
        List<Integer> list = new ArrayList<>();
        try {

            // run from fist item in the last item of listCartId
            for (int i = 0; i < listCartId.length; i++) {
                ps = con.prepareStatement(SqlQuery.cart.getAgentIdByCartId);
                ps.setString(1, listCartId[i]);
                rs = ps.executeQuery();
                // get agentID by cart Id if cartId exists 
                if (rs.next()) {
                    int agentId = rs.getInt(1);
                    list.add(agentId);
                }
            }
        } catch (Exception e) {
            System.out.println("getlist Error:" + e.getMessage());
        }
        return list;
    }

    // to check all items in cart must be the same agent
    public boolean checkAllItemsInAgent(List<Integer> list) {
        // run from fist item in the last item of listCartId\
        for (int i = 0; i < list.size(); i++) {
            // if exits an item not the same agent with another
            if (list.get(0).equals(list.get(i)) == false) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CartDAO cartDsao = new CartDAO();
        // cartDsao.checkCart(25, "5");
        String[] listCart = {"3", "4"};

//        System.out.println(cartDsao.checkAllItemsInAgent(listCart));
        List<Integer> listAgentId = cartDsao.getAgentIdByCartId(listCart);
        for (Integer integer : listAgentId) {
            System.out.println(integer);
        }
        System.out.println(cartDsao.checkAllItemsInAgent(listAgentId));
    }
}
