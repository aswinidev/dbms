package com.dbms.HotelManagement.model;

public class TempBooking {
    private String checkIn;
    private String checkOut;
    private int singleOcc;
    private int doubleOcc;

    public TempBooking() {
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public int getSingleOcc() {
        return singleOcc;
    }

    public void setSingleOcc(int singleOcc) {
        this.singleOcc = singleOcc;
    }

    public int getDoubleOcc() {
        return doubleOcc;
    }

    public void setDoubleOcc(int doubleOcc) {
        this.doubleOcc = doubleOcc;
    }
}
