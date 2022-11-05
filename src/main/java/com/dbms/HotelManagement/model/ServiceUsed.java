package com.dbms.HotelManagement.model;

import java.util.UUID;

public class ServiceUsed {
    private String serviceName;
    private UUID customerID;

    public String getDeptName() {
        return serviceName;
    }

    public void setDeptName(String serviceName) {
        this.serviceName = serviceName;
    }

    public UUID getCustomerID() {
        return customerID;
    }

    public void setCustomerID(UUID customerID) {
        this.customerID = customerID;
    }
}
