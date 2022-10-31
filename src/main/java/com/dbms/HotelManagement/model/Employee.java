package com.dbms.HotelManagement.model;

import java.util.UUID;

public class Employee {
    private UUID empID;
    private String currHouseNo;
    private String currPincode;
    private String currCity;
    private String currState;
    private String maritalStatus;
    private String panCard;
    private String accountNo;
    private String IFSCCode;
    private String bankName;
    private UUID userID;
    private String deptName;
    private UUID superID;

    public UUID getEmpID() {
        return empID;
    }

    public void setEmpID(UUID empID) {
        this.empID = empID;
    }

    public String getCurrHouseNo() {
        return currHouseNo;
    }

    public void setCurrHouseNo(String currHouseNo) {
        this.currHouseNo = currHouseNo;
    }

    public String getCurrPincode() {
        return currPincode;
    }

    public void setCurrPincode(String currPincode) {
        this.currPincode = currPincode;
    }

    public String getCurrCity() {
        return currCity;
    }

    public void setCurrCity(String currCity) {
        this.currCity = currCity;
    }

    public String getCurrState() {
        return currState;
    }

    public void setCurrState(String currState) {
        this.currState = currState;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getPanCard() {
        return panCard;
    }

    public void setPanCard(String panCard) {
        this.panCard = panCard;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }

    public void setIFSCCode(String IFSCCode) {
        this.IFSCCode = IFSCCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public UUID getSuperID() {
        return superID;
    }

    public void setSuperID(UUID superID) {
        this.superID = superID;
    }

}
