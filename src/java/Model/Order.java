/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Util.StatusForOrder;
import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class Order {

    private int orderId;
    private double payment;
    private String address;
    private Date orderDate;
    private Date shipDate;
    private Date receviedDate;
    // In process  ->   Delivered   ->   Closed
    private String status;
    private String phoneNumber;
    private String email;
    private String CustomerName;
    private String note;

    // for view orders history 
    private int productId;
    private String productName;
    private String size;
    private String image;
    // price per product
    private double price;
    private int quantity;
    private String agent;

    public Order() {
    }

    public Order(int orderId, double payment, String address, Date orderDate, Date shipDate, Date receviedDate, String status, String phoneNumber, String email, String CustomerName, String note) {

        this.orderId = orderId;
        this.payment = payment;
        this.address = address;
        this.orderDate = orderDate;
        this.shipDate = shipDate;
        this.receviedDate = receviedDate;
        this.status = status;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.CustomerName = CustomerName;
        this.note = note;
    }

    // constructor to insert without any date
    public Order(double payment, String address, String status, String phoneNumber, String email, String customerName, String note) {
        this.payment = payment;
        this.address = address;
        this.status = status;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.CustomerName = customerName;
        this.note = note;
    }

    // constructor to view ordersHistory
    public Order(int productId, String productName, String size, String image, double price, int quantity, String agent, Date orderDate, String status, double payment, int orderId) {
        this.productId = productId;
        this.orderId = orderId;
        this.payment = payment;
        this.orderDate = orderDate;
        this.status = status;
        this.productName = productName;
        this.size = size;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.agent = agent;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", payment=" + payment + ", address=" + address + ", orderDate=" + orderDate + ", shipDate=" + shipDate + ", receviedDate=" + receviedDate + ", status=" + status + ", phoneNumber=" + phoneNumber + ", email=" + email + ", CustomerName=" + CustomerName + ", note=" + note + '}';
    }

}
