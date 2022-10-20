package com.dbms.HotelManagement.model;

import java.util.UUID;

public class LeavesSalaries {
    private UUID salaryID;
    private UUID empID;
    private int overtime;
    private int month;
    private int year;
    private int leavesAllowed;
    private int leavesTaken;

    public UUID getSalaryID() {
        return salaryID;
    }

    public void setSalaryID(UUID salaryID) {
        this.salaryID = salaryID;
    }

    public UUID getEmpID() {
        return empID;
    }

    public void setEmpID(UUID empID) {
        this.empID = empID;
    }

    public int getOvertime() {
        return overtime;
    }

    public void setOvertime(int overtime) {
        this.overtime = overtime;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getLeavesAllowed() {
        return leavesAllowed;
    }

    public void setLeavesAllowed(int leavesAllowed) {
        this.leavesAllowed = leavesAllowed;
    }

    public int getLeavesTaken() {
        return leavesTaken;
    }

    public void setLeavesTaken(int leavesTaken) {
        this.leavesTaken = leavesTaken;
    }
}
