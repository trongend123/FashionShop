/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Context.MyDao;
import Model.Size;
import Util.SqlQuery;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class SizeDao extends MyDao implements SqlQuery {

    public List<Size> getSizeOfProductsByCategoryId(int categoryId) {
        List<Size> list = new ArrayList<>();

        try {
            ps = con.prepareStatement(SqlQuery.size.getSizeOfProductsByCategoryId);
            ps.setInt(1, categoryId);
            rs = ps.executeQuery();

            // get all size of Product by CategoryID
            while (rs.next()) {
                Size size = new Size(rs.getInt(1), rs.getString(2));
                list.add(size);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void minusNumberOfProductsByCartId(String[] cartId) {
        try {

            // run from first to the last element cartId 
            for (int i = 0; i < cartId.length; i++) {
                ps = con.prepareStatement(SqlQuery.size.minusNumberProductByCartId);
                ps.setString(1, cartId[i]);
                ps.setString(2, cartId[i]);
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SizeDao sizeDao = new SizeDao();
//        List<Size> list = sizeDao.getSizeOfProductsByCategoryId(1);
//        for (Size size : list) {
//            System.out.println(size.toString2());
//        }

        String[] cartId = {"1", "2"};
        sizeDao.minusNumberOfProductsByCartId(cartId);
    }

}
