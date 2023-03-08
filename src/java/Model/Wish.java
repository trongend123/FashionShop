/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS
 */
public class Wish {

    private int prodcutId;
    private int userId;

    public Wish() {
    }

    public Wish(int prodcutId, int userId) {
        this.prodcutId = prodcutId;
        this.userId = userId;
    }

    public int getProdcutId() {
        return prodcutId;
    }

    public void setProdcutId(int prodcutId) {
        this.prodcutId = prodcutId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Wish{" + "prodcutId=" + prodcutId + ", userId=" + userId + '}';
    }

}
