/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Util.StatusForOrder;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Order {

    int orderId;
    double payment;
    String address;
    Date orderDate;
    Date shipDate;
    Date receviedDate;
    // In process  ->   Delivered   ->   Closed
    String status;
    int quantity;
    int phoneNumber;
    int productId;
    String username;
    String email;
    String productName;
    String img;
    double UnitPrice;
    
    
    

    public Order() {
    }

    public Order(int orderId, double payment, String address, Date orderDate, Date shipDate, Date receviedDate, String status) {
        this.orderId = orderId;
        this.payment = payment;
        this.address = address;
        this.orderDate = orderDate;
        this.shipDate = shipDate;
        this.receviedDate = receviedDate;
        this.status = status;
    }
    
    // constructor to insert without any date
    public Order(double payment, String address, String status) {
        this.payment = payment;
        this.address = address;
        this.status = status;
    }

//    public Order(int orderId, double payment, String address, Date orderDate, Date shipDate, Date receviedDate, 
//            String status, int quantity, int phoneNumber, int productId, String username, String email, 
//            String productName, String img, double UnitPrice) {
//        this.orderId = orderId;
//        this.payment = payment;
//        this.address = address;
//        this.orderDate = orderDate;
//        this.shipDate = shipDate;
//        this.receviedDate = receviedDate;
//        this.status = status;
//        this.quantity = quantity;
//        this.phoneNumber = phoneNumber;
//        this.productId = productId;
//        this.username = username;
//        this.email = email;
//        this.productName = productName;
//        this.img = img;
//        this.UnitPrice = UnitPrice;
//    }
    public Order(String username, int phoneNum, String email, int OrderId, double payment, Date orderDAte, 
            Date shipDare, Date receviedDate, String status, int quantity, int productId, String productName, String img, double Unitprice){
        this.username= username;
        this.phoneNumber= phoneNum;
        this.email=email;
        this.orderId= OrderId;
        this.payment=payment;
        this.orderDate= orderDAte;
        this.shipDate= shipDare;
        this.receviedDate= receviedDate;
        this.status= status;
        this.quantity= quantity;
        this.productId= productId;
        this.productName= productName;
        this.img= img;
        this.UnitPrice= Unitprice;
    }

    public Order(int OrderId, String status) {
        this.orderId= OrderId;
        this.status= status;
    }
  

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    
    
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public Date getReceviedDate() {
        return receviedDate;
    }

    public void setReceviedDate(Date receviedDate) {
        this.receviedDate = receviedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", payment=" + payment + ", address=" + address + ", orderDate=" + orderDate + ", shipDate=" + shipDate + ", receviedDate=" + receviedDate + ", status=" + status + ", UnitPrice="+UnitPrice+'}';
    }

}
