package com.dbms.HotelManagement.model;

import java.util.UUID;

public class Customer {
    private UUID customerID;
    private int numberOfMembers;
    private String alternateEmailAddress;
    private String aadharCardNumber;
    private UUID userID;

    public Customer() {
    }

    public Customer(UUID customerID, int numberOfMembers, String alternateEmailAddress, String aadharCardNumber, UUID userID) {
        this.customerID = customerID;
        this.numberOfMembers = numberOfMembers;
        this.alternateEmailAddress = alternateEmailAddress;
        this.aadharCardNumber = aadharCardNumber;
        this.userID = userID;
    }

    public UUID getCustomerID() {
        return customerID;
    }

    public void setCustomerID(UUID customerID) {
        this.customerID = customerID;
    }

    public int getNumberOfMembers() {
        return numberOfMembers;
    }

    public void setNumberOfMembers(int numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
    }

    public String getAlternateEmailAddress() {
        return alternateEmailAddress;
    }

    public void setAlternateEmailAddress(String alternateEmailAddress) {
        this.alternateEmailAddress = alternateEmailAddress;
    }

    public String getAadharCardNumber() {
        return aadharCardNumber;
    }

    public void setAadharCardNumber(String aadharCardNumber) {
        this.aadharCardNumber = aadharCardNumber;
    }

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }
}
