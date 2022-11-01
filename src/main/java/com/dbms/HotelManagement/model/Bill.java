package com.dbms.HotelManagement.model;

import java.util.UUID;

public class Bill {
    private UUID billID;
    private UUID bookingID;
    private float amount;
    private String date;
    private String time;

    public Bill(UUID billID, UUID bookingID, float amount, String date, String time) {
        this.billID = billID;
        this.bookingID = bookingID;
        this.amount = amount;
        this.date = date;
        this.time = time;
    }

    public Bill() {
    }

    public UUID getBillID() {
        return billID;
    }

    public void setBillID(UUID billID) {
        this.billID = billID;
    }

    public UUID getBookingID() {
        return bookingID;
    }

    public void setBookingID(UUID bookingID) {
        this.bookingID = bookingID;
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
