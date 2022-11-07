package com.dbms.HotelManagement.jsonResponse;

import java.util.UUID;

public class GenerateBill {
    private UUID billID;
    private UUID bookingID;
    private int amount;
    private int singleRoom;
    private int doubleRoom;
    private int singlePrice;
    private int doublePrice;
    private String fname;
    private String lname;

    public GenerateBill(UUID billID, UUID bookingID, int amount, int singleRoom, int doubleRoom, int singlePrice, int doublePrice, String fname, String lname) {
        this.billID = billID;
        this.bookingID = bookingID;
        this.amount = amount;
        this.singleRoom = singleRoom;
        this.doubleRoom = doubleRoom;
        this.singlePrice = singlePrice;
        this.doublePrice = doublePrice;
        this.fname = fname;
        this.lname = lname;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSingleRoom() {
        return singleRoom;
    }

    public void setSingleRoom(int singleRoom) {
        this.singleRoom = singleRoom;
    }

    public int getDoubleRoom() {
        return doubleRoom;
    }

    public void setDoubleRoom(int doubleRoom) {
        this.doubleRoom = doubleRoom;
    }

    public int getSinglePrice() {
        return singlePrice;
    }

    public void setSinglePrice(int singlePrice) {
        this.singlePrice = singlePrice;
    }

    public int getDoublePrice() {
        return doublePrice;
    }

    public void setDoublePrice(int doublePrice) {
        this.doublePrice = doublePrice;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}
