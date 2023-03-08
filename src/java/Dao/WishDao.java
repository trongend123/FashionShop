/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Context.MyDao;
import Model.Product;
import Util.SqlQuery;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class WishDao extends MyDao implements SqlQuery {

    public void addToWishList(int productId, int userId) {
        try {
            ps = con.prepareStatement(SqlQuery.wish.addToWishList);
            ps.setInt(1, productId);
            ps.setInt(2, userId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteToWishList(int productId, int userId) {
        try {
            ps = con.prepareStatement(SqlQuery.wish.deleteFromWish);
            ps.setInt(1, productId);
            ps.setInt(2, userId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // check product in the user'wishList
    public boolean checkProductAndUser(int productId, String userId) {
        try {
            ps = con.prepareStatement(SqlQuery.wish.checkWishList);
            ps.setInt(1, productId);
            ps.setString(2, userId);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Product> getWishListByUserId(int userId) {
        List<Product> wishList = new ArrayList<>();
        try {
            ps = con.prepareStatement(SqlQuery.wish.getWishListByUserId);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            // get all product in user'wishList
            while (rs.next()) {
                Product product = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                wishList.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wishList;
    }

    public static void main(String[] args) {
        WishDao a = new WishDao();
        List<Product> list = a.getWishListByUserId(5);

        for (Product pro : list) {
            System.out.println(pro);
        }
    }
}
