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
                account = new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));
                return account;
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void signUp(Account accout) {
        try {
            ps = con.prepareStatement(SqlQuery.account.signUp);
            ps.setString(1, accout.getUserName());
            ps.setString(2, accout.getPassWord());
            ps.setString(3, accout.getName());
            ps.setString(4, accout.getPhoneNumber());
            ps.setString(5, accout.getEmail());
            ps.setInt(6, accout.getRole());
            ps.setString(7, accout.getAvatar());
            ps.setString(8, accout.getCity());
            ps.setString(9, accout.getDistrict());
            ps.setString(10, accout.getAddress());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdateUserProfile(String name, String userName, String phoneNumber, String email, String city, String district, String address, String userId) {
        try {
            ps = con.prepareStatement(SqlQuery.account.updateUserProfile);
            ps.setString(1, name);
            ps.setString(2, userName);
            ps.setString(3, phoneNumber);
            ps.setString(4, email);
            ps.setString(5, city);
            ps.setString(6, district);
            ps.setString(7, address);
            ps.setString(8, userId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Account getUserInforBuUserId(String userId) {
        Account account = new Account();
        try {
            ps = con.prepareStatement(SqlQuery.account.getUserInforByUserId);
            ps.setString(1, userId);
            rs = ps.executeQuery();
            if (rs.next()) {
                account = new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));
                return account;
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void changePassWordUserId(String userId, String newPass) {
        try {
            ps = con.prepareStatement(SqlQuery.account.changePassByUserId);
            ps.setString(1, newPass);
            ps.setString(2, userId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getPassWordByUserId(String userId) {
        String pass = null;
        try {
            ps = con.prepareStatement(SqlQuery.account.getPassByUserId);
            ps.setString(1, userId);
            rs = ps.executeQuery();
            if (rs.next()) {
                pass = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pass;
    }

    public boolean checkOldPassWord(String passWord, String userId) {
        String OldPass = getPassWordByUserId(userId);
        // user enter right oldPass
        if (passWord.equals(OldPass)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        AccountDao a = new AccountDao();
        Account account = new Account("thang2", "123", "123", 5, "mail@", "hanoi", "tay ho", "duong chinh", null, "name");
        a.signUp(account) ;//        System.out.println(a.signUp(account));
    }

}
