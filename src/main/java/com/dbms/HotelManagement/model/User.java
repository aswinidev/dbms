package com.dbms.HotelManagement.model;

import java.util.UUID;

public class User {
    private UUID userID;
    private String fname;
    private String lname;
    private String pEmail;
    private String houseNo;
    private String state;
    private String city;
    private String country;
    private String pinCode;
    private String gender;

    public User(UUID userID, String fname, String lname, String pEmail, String houseNo, String state, String city, String country, String pinCode, String gender) {
        this.userID = userID;
        this.fname = fname;
        this.lname = lname;
        this.pEmail = pEmail;
        this.houseNo = houseNo;
        this.state = state;
        this.city = city;
        this.country = country;
        this.pinCode = pinCode;
        this.gender = gender;
    }

    public UUID getUserID() {
        return userID;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getpEmail() {
        return pEmail;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPinCode() {
        return pinCode;
    }

    public String getGender() {
        return gender;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setpEmail(String pEmail) {
        this.pEmail = pEmail;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
