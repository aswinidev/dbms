package com.dbms.HotelManagement.model;

import java.util.UUID;

public class ServiceUsed {
    private String deptName;
    private UUID customerID;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public UUID getCustomerID() {
        return customerID;
    }

    public void setCustomerID(UUID customerID) {
        this.customerID = customerID;
    }
}
