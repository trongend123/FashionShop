/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Hoang Phi Hung
 */
public class Cart {

    private int CartID;
    private int UserID;
    private int ProductID;
    private int agentID;
    private int Quantity;
    private String Size;
    private Product product;
    private Agent agent;
    private String img;
    private int price;
    private int agentId;
    private String productName;
    private Order order;
    private int UserId;
    private String username;
    private String phoneNum;

    public Cart(int CartID, int UserID, int ProductID, int Quantity, String Size) {
        this.CartID = CartID;
        this.UserID = UserID;
        this.ProductID = ProductID;
        this.Quantity = Quantity;
        this.Size = Size;
    }
    

    public Cart(int CartID, int UserID, int ProductID, int agentID, int Quantity, String Size, Product product, Agent agent) {
        this.CartID = CartID;
        this.UserID = UserID;
        this.ProductID = ProductID;
        this.agentID = agentID;
        this.Quantity = Quantity;
        this.Size = Size;
        this.product = product;
        this.agent = agent;
    }

    // constructor to view cart
    public Cart(int userId, int productId, String productName, String size, int price, String img, int agentId, int quantity, int cartId) {

        this.UserID = userId;
        this.ProductID = productId;
        this.productName = productName;
        this.agentID = agentId;
        this.Quantity = quantity;
        this.Size = size;
        this.agentId = agentId;
        this.img = img;
        this.Quantity = quantity;
        this.CartID = cartId;
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public int getAgentID() {
        return agentID;
    }

    public void setAgentID(int agentID) {
        this.agentID = agentID;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Cart() {
    }

    public int getCartID() {
        return CartID;
    }

    public void setCartID(int CartID) {
        this.CartID = CartID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    
    
    @Override
    public String toString() {
        return "Cart{" + "CartID=" + CartID + ", UserID=" + UserID + ", ProductID=" + ProductID + ", agentID=" + agentID + ", Quantity=" + Quantity + ", Size=" + Size + ", product=" + product + ", agent=" + agent + ", img=" + img + ", price=" + price + ", agentId=" + agentId + ", productName=" + productName + '}';
    }

}
