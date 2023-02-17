/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.*;
import Context.*;
import Util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class AccountDao extends MyDao implements SqlQuery {

    public Account loginByUserName(String userName, String passWord) {
        Account account = new Account();
        try {
            ps = con.prepareStatement(SqlQuery.account.login);
            ps.setString(1, userName);
            ps.setString(2, passWord);
            rs = ps.executeQuery();
            if (rs.next()) {
                account = new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));
                return account;
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public int signUp(Account accout) {

        try {
            ps = con.prepareStatement(SqlQuery.account.signUp);
            ps.setString(1, accout.getUserName());
            ps.setString(2, accout.getPassWord());
            ps.setInt(3, accout.getPhoneNumber());
            ps.setInt(4, accout.getRole());
            ps.setString(5, accout.getEmail());
            if (ps.executeUpdate() > 0) {
                return 1;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int changePassword(String userName, String newpass){
      try {
            ps = con.prepareStatement(SqlQuery.account.changePass);
            ps.setString(1, newpass);
            ps.setString(2, userName);
            
            if (ps.executeUpdate() > 0) {
                return 1;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public String getEmail(String userName){
      try {
            ps = con.prepareStatement(SqlQuery.account.getEmail);  
            ps.setString(1, userName);
            rs = ps.executeQuery();
             if (rs.next()) {
            return rs.getString(1);
             }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        AccountDao a = new AccountDao();
        System.out.println(a.getEmail("TRONG"));
    }

//        Account account = new Account("account", "1234h", 326576545, 5, "email@gmail.com");
//       // System.out.println(a.signUp(account));
        }


