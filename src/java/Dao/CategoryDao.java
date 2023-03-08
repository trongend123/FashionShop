/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.*;
import Util.*;
import Context.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class CategoryDao extends MyDao implements SqlQuery {

    public List<Category> getAllCategoryName() {
        List<Category> list = new ArrayList<>();

        try {
            ps = con.prepareStatement(SqlQuery.category.getAllCategory);
            rs = ps.executeQuery();
            Category category = null;
            //get all category
            while (rs.next()) {
                category = new Category(rs.getInt(1), rs.getString(2));
                list.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Category getCategoryByCategoryId(int categoryId) {
        Category category = new Category();

        try {
            ps = con.prepareStatement(SqlQuery.category.getCategoryByCategoryId);
            ps.setInt(1, categoryId);
            rs = ps.executeQuery();
            //get Categrory by category ID 
            if (rs.next()) {
                category = new Category(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return category;
    }

    public Category get(int id) {
        try {
            String sql = "select * from CATEGORIES c where c.CategoryID=?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {

                Category c = new Category();
                c.setCategoryId(rs.getInt("CategoryID"));
                c.setCategoryName(rs.getString("CategoryName"));
                return c;
            }
        } catch (SQLException e) {

        }
        return null;
    }

    public ArrayList<Category> list() {
        ArrayList<Category> cate = new ArrayList<>();
        try {
            String sql = "select * from CATEGORIES c ";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Category c = new Category();
                c.setCategoryId(rs.getInt("CategoryID"));
                c.setCategoryName(rs.getString("CategoryName"));
                cate.add(c);
            }
        } catch (SQLException e) {

        }
        return cate;
    }

    public static void main(String[] args) {
        CategoryDao a = new CategoryDao();
//        List<Category> list = a.getAllCategoryName();
//
//        for (Category string : list) {
//            System.out.println(string);
//        
        Category x = a.getCategoryByCategoryId(1);
        System.out.println(x.getCategoryName());

    }

}
