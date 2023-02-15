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

        String check = " select [CartID],[Quantity] from [CART] where UserID= " + uId + " AND SizeID =  " + sizeId;
        int checkNumber = 0;
        int quantityOld = 0;
        try {
            System.out.println(check);
            PreparedStatement statement = cnn.prepareCall(check);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                checkNumber = rs.getInt(1);
                quantityOld = rs.getInt(2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (checkNumber != 0) {
            new CartDAO().changeQuantity(String.valueOf(checkNumber), String.valueOf(quantityOld + Integer.valueOf(quantity)));
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

        String sql = "  delete from [CART] where [CartID] = ?";
        try {
            PreparedStatement statement = cnn.prepareCall(sql);
            statement.setString(1, itemId);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeQuantity(String itemId, String quantity) {
        String sql = "  update [CART] set [Quantity] = ? where [CartID] = ?";
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

    public static void main(String[] args) {
        CartDAO cartDsao = new CartDAO();
//        List<Cart> list = cartDsao.getAllCartItemByUid("2");
//        for (Cart cart : list) {
//            System.out.println(cart.toString());
//        }
Cart cart = cartDsao.getCartByCartId("3");
         System.out.println(cart.toString());

    }

}
