/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS
 */
public class Product {

    private int productId;
    private String productnName;
    private int price;
    private String img;
    private int season;
    private String descripTion;
    private String gender;
    private int categoryId;
    private String size;
    private Category categoryObject;
    private Size sizeObject;
    private String Size;
    private int Quantity;
    private int AgentId;

    

    public Product() {
    }
    //cho cart
    public Product(int productId, String productnName, int price, String img,int Quantity,int AgentID, String Size) {
        this.productId = productId;
        this.productnName = productnName;
        this.price = price;
        this.img = img;
        this.Quantity = Quantity;
        this.AgentId = AgentID;
        this.Size = Size;
    }

    // without product id to insert
    public Product(String productnName, int price, String img, int season, String descripTion, String gender, int categoryId) {
        this.productnName = productnName;
        this.price = price;
        this.img = img;
        this.season = season;
        this.descripTion = descripTion;
        this.gender = gender;
        this.categoryId = categoryId;
    }

    // with productId to get product from database
    public Product(int productId, String productnName, int price, String img, int season, String descripTion, String gender, int categoryId) {
        this.productId = productId;
        this.productnName = productnName;
        this.price = price;
        this.img = img;
        this.season = season;
        this.descripTion = descripTion;
        this.gender = gender;
        this.categoryId = categoryId;
    }

    // with size form [SIZE] table
    public Product(int productId, String productnName, int price, String img, int season, String descripTion, String gender, int categoryId, String size) {
        this.productId = productId;
        this.productnName = productnName;
        this.price = price;
        this.img = img;
        this.season = season;
        this.descripTion = descripTion;
        this.gender = gender;
        this.categoryId = categoryId;
        this.size = size;
    }

    public Product(int productId, String productnName, int price, String img, int season, String descripTion, String gender, Category categoryObject, Size sizeObject) {
        this.productId = productId;
        this.productnName = productnName;
        this.price = price;
        this.img = img;
        this.season = season;
        this.descripTion = descripTion;
        this.gender = gender;
        this.categoryObject = categoryObject;
        this.sizeObject = sizeObject;
    }
    
    
    public Product(String productnName, int price, String img, int season, String descripTion, String gender, Category categoryObject, Size sizeObject) {
        this.productnName = productnName;
        this.price = price;
        this.img = img;
        this.season = season;
        this.descripTion = descripTion;
        this.gender = gender;
        this.categoryObject = categoryObject;
        this.sizeObject = sizeObject;
    }

   
    
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductnName() {
        return productnName;
    }

    public void setProductnName(String productnName) {
        this.productnName = productnName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public int getAgentId() {
        return AgentId;
    }

    public void setAgentId(int AgentId) {
        this.AgentId = AgentId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public String getDescripTion() {
        return descripTion;
    }

    public void setDescripTion(String descripTion) {
        this.descripTion = descripTion;
    }

    public Category getCategoryObject() {
        return categoryObject;
    }

    public void setCategoryObject(Category categoryObject) {
        this.categoryObject = categoryObject;
    }

    public Size getSizeObject() {
        return sizeObject;
    }

    public void setSizeObject(Size sizeObject) {
        this.sizeObject = sizeObject;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", productnName=" + productnName + ", price=" + price + ", img=" + img + ", season=" + season + ", descripTion=" + descripTion + ", gender=" + gender + ", categoryId=" + categoryId + '}';
    }

    public String toStringWithSize() {
        return "Product{" + "productId=" + productId + ", productnName=" + productnName + ", price=" + price + ", img=" + img + ", season=" + season + ", descripTion=" + descripTion + ", gender=" + gender + ", categoryId=" + categoryId + ", size=" + size + '}';
    }

}
