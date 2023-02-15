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

    int orderId;
    double payment;
    String address;
    Date orderDate;
    Date shipDate;
    Date receviedDate;
    // In process  ->   Delivered   ->   Closed
    String status;

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
        return "Order{" + "orderId=" + orderId + ", payment=" + payment + ", address=" + address + ", orderDate=" + orderDate + ", shipDate=" + shipDate + ", receviedDate=" + receviedDate + ", status=" + status + '}';
    }

}
