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
                account = new Account(rs.getInt(1), rs.getString(2), rs.getString(3), 
                        rs.getInt(4), rs.getInt(5), rs.getString(6));
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

    public static void main(String[] args) {
        AccountDao a = new AccountDao();
        Account x = a.loginByUserName("KHOA", "nguyendangkhoa2002");
        System.out.println(x);

//        Account account = new Account("account", "1234h", 326576545, 5, "email@gmail.com");
//       // System.out.println(a.signUp(account));
    }

}
