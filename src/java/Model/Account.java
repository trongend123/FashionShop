/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS
 */
public class Account {

    private int userId;
    private String userName;
    private String passWord;
    private String phoneNumber;
    private int role;
    private String email;
    private String city;
    private String district;
    private String address;
    private String avatar;
    private String name ;

    public Account() {
    }


  
    public Account(int userId, String userName, String passWord, String name, String phoneNumber, String email, int role, String avatar, String city, String district, String address) {
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.email = email;
        this.address = address;
        this.avatar = avatar;
        this.name = name;
        this.city = city;
        this.district = district;
    }

    // to insert
    public Account(String userName, String passWord, String phoneNumber, int role, String email, String city, String district, String address, String avatar, String name) {
        this.userName = userName;
        this.passWord = passWord;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.email = email;
        this.city = city;
        this.district = district;
        this.address = address;
        this.avatar = avatar;
        this.name = name;
    }
    
    

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "Account{" + "userId=" + userId + ", userName=" + userName + ", passWord=" + passWord + ", phoneNumber=" + phoneNumber + ", role=" + role + ", email=" + email + ", city=" + city + ", district=" + district + ", address=" + address + ", avatar=" + avatar + ", name=" + name + '}';
    }

}
