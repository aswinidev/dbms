package com.dbms.HotelManagement.model;

import java.util.UUID;

public class Feedback {
    private UUID feedbackID;
    private String reviews;
    private String suggestions;
    private String fDate;
    private String fTime;
    private UUID customerID;

    public Feedback() {
    }

    public Feedback(UUID feedbackID, String reviews, String suggestions, String date, String time, UUID customerID) {
        this.feedbackID = feedbackID;
        this.reviews = reviews;
        this.suggestions = suggestions;
        this.fDate = date;
        this.fTime = time;
        this.customerID = customerID;
    }

    public UUID getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(UUID feedbackID) {
        this.feedbackID = feedbackID;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public String getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(String suggestions) {
        this.suggestions = suggestions;
    }

    public String getDate() {
        return fDate;
    }

    public void setDate(String date) {
        this.fDate = date;
    }

    public String getTime() {
        return fTime;
    }

    public void setTime(String time) {
        this.fTime = time;
    }

    public UUID getCustomerID() {
        return customerID;
    }

    public void setCustomerID(UUID customerID) {
        this.customerID = customerID;
    }
}
