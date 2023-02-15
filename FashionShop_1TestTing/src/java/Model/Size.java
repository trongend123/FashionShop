/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS
 */
public class Size {

    int sizeId;
    int agentId;
    int productId;
    String size;
    int quantity;
    int categoryId;
    private Agent agent;

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Size() {
    }

    // constructor with all attribute & cart
    public Size(int agentId, int productId, String size, int quantity) {
        this.agentId = agentId;
        this.productId = productId;
        this.size = size;
        this.quantity = quantity;
    }

    // to get categoryId and size for FileSr
    public Size(int categoryId, String size) {
        this.categoryId = categoryId;
        this.size = size;
    }

    public Size(int sizeId, int agentId, int productId, String size, int quantity) {
        this.sizeId = sizeId;
        this.agentId = agentId;
        this.productId = productId;
        this.size = size;
        this.quantity = quantity;

    }

    public Size(String size, int quantity) {
        this.size = size;
        this.quantity = quantity;
    }

    public int getAgentId() {
        return agentId;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Size{" + "agentId=" + agentId + ", productId=" + productId + ", size=" + size + ", quantity=" + quantity + ", sizeId " + sizeId;
    }

    public String toString2() {
        return "size=" + size + ", categoryId=" + categoryId;
    }

}
