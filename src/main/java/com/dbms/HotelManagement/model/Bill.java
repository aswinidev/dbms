package com.dbms.HotelManagement.model;

import java.util.UUID;

public class Bill {
    private UUID billID;
    private UUID customerID;
    private float discount;
    private float amount;
    private String date;
    private String time;

    public UUID getBillID() {
        return billID;
    }

    public void setBillID(UUID billID) {
        this.billID = billID;
    }

    public UUID getCustomerID() {
        return customerID;
    }

    public void setCustomerID(UUID customerID) {
        this.customerID = customerID;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
