/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class Comment {

    private int productId;
    private int userId;
    private Date date;
    private String content;
    private String userName;

    public Comment() {
    }

    public Comment(int productId, int userId, Date date, String content) {
        this.productId = productId;
        this.userId = userId;
        this.date = date;
        this.content = content;
    }

    // without date to insert
    public Comment(int productId, int userId, String content) {
        this.productId = productId;
        this.userId = userId;
        this.content = content;
    }

    // to get userName to upload to view
    public Comment(String userName, int productId, int userId, Date date, String content) {
        this.productId = productId;
        this.userId = userId;
        this.date = date;
        this.content = content;
        this.userName = userName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Comment{" + "productId=" + productId + ", userId=" + userId + ", date=" + date + ", content=" + content + ", userName=" + userName + '}';
    }
}
