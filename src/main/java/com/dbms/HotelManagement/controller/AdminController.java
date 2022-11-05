package com.dbms.HotelManagement.controller;

import com.dbms.HotelManagement.jsonResponse.UserEmployee;
import com.dbms.HotelManagement.model.*;
import com.dbms.HotelManagement.service.AdminService;
import com.dbms.HotelManagement.service.AuthenticationService;
import com.dbms.HotelManagement.service.DashboardService;
import com.dbms.HotelManagement.service.LeavesSalariesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {
    private final AdminService adminService;
    private final AuthenticationService authenticationService;

    private final DashboardService dashboardService;
//    private final
    private final PasswordEncoder passwordEncoder;
    private final LeavesSalariesService leavesSalariesService;

    @Autowired
    public AdminController(AdminService adminService, AuthenticationService authenticationService, DashboardService dashboardService, PasswordEncoder passwordEncoder, LeavesSalariesService leavesSalariesService) {
        this.adminService = adminService;
        this.authenticationService = authenticationService;
        this.dashboardService = dashboardService;
        this.passwordEncoder = passwordEncoder;
        this.leavesSalariesService = leavesSalariesService;
    }

    // TODO make another model that would contain the attributes of both user and employee
    // TODO add on Delete cascade in sql user table

    @GetMapping("/admin/allEmployee")
    public List<Employee> allEmployee(){
        return adminService.getEmployees();
    }


    @PostMapping("/admin/deleteEmployee")
    public String deleteEmployee(@RequestBody User user){
        String pEmail = user.getpEmail();
        adminService.removeUser(pEmail);
        return "deleted user with pEmail" + pEmail;
    }

    @PostMapping("/admin/addEmployee")
    public String addEmployee(@RequestBody UserEmployee userEmployee){
        UUID userID = UUID.randomUUID();
        String fname = userEmployee.getFname();
        String lname = userEmployee.getLname();
        String pEmail = userEmployee.getpEmail();
        String pswd = passwordEncoder.encode(userEmployee.getPswd());
        String houseNo = userEmployee.getHouseNo();
        String state = userEmployee.getState();
        String city = userEmployee.getCity();
        String country = userEmployee.getCountry();
        String pinCode = userEmployee.getPincode();
        String gender = userEmployee.getGender();
        authenticationService.register(userID, fname, lname, pEmail, pswd, houseNo, state, city, country, pinCode, gender);
        // Employee Details
        // UUID empID, String houseNo, String pincode, String city, String state, String maritalStatus, String panCard, String accountNo, String IFSCCode, String bankName, UUID userID, String deptName, UUID superID
        UUID empID = UUID.randomUUID();
        Employee employee = new Employee(
                empID,
                userEmployee.getCurrHouseNo(),
                userEmployee.getCurrPincode(),
                userEmployee.getCurrCity(),
                userEmployee.getCurrState(),
                userEmployee.getMaritalStatus(),
                userEmployee.getSalary(),
                userEmployee.getPanCard(),
                userEmployee.getAccountNo(),
                userEmployee.getIFSCCode(),
                userEmployee.getBankName(),
                userID,
                userEmployee.getDeptName(),
                UUID.fromString(userEmployee.getSuperID())
        );
        adminService.addEmployee(employee);

        // add leaves and salaries
        int salary = userEmployee.getSalary();
        Calendar c = Calendar.getInstance();
        int month = c.get(Calendar.MONTH) + 1;
        int year = c.get(Calendar.YEAR);
        int leavesAllowed = userEmployee.getLeavesAllowed();
        int leavesTaken = 0;

        adminService.addSalary(salary, empID, month, year, leavesAllowed, leavesTaken);

        return "Added Employee";
    }


    @GetMapping("/admin/allFeedback")
    public List<Feedback> allFeedback(){
        return adminService.getFeedback();
    }

//    TODO UNCOMMENT
//    @GetMapping("/admin/allQuery")
//    public List<ContactUs> allQuery() {
//        return adminService.getQuery();
//    }

//    @PostMapping("/admin/addReply")
//    public String addReply(@RequestBody ContactUs contactUs){
//        UUID queryID = contactUs.getQueryID();
//        String reply = contactUs.getReply();
////        ContactUs query = adminService.getQueryByID(queryID);
//        adminService.replyQuery(queryID,reply);
//        return "Replied..";
//    }

    @PostMapping("/admin/paySalary")
    public int paySalary(@RequestBody LeavesSalaries leavesSalaries){
        Employee emp= dashboardService.getEmp(leavesSalaries.getEmpID());
        return leavesSalariesService.paySalary(leavesSalaries.getEmpID(), leavesSalaries.getMonth(), leavesSalaries.getYear(), emp.getSalary(), leavesSalaries.getLeavesAllowed());
    }

    @PostMapping("/admin/getLeavesSalaries")
    public LeavesSalaries getLeavesSalaries(@RequestBody UUID empID){
        Calendar c = Calendar.getInstance();
        int month = c.get(Calendar.MONTH) + 1;
        int year = c.get(Calendar.YEAR);
        return leavesSalariesService.getLeavesSalaries(empID, month , year);

    }

    @PostMapping("/admin/addLeave")
    public int addLeave(@RequestBody LeavesSalaries leavesSalaries){
        return leavesSalariesService.addLeave(leavesSalaries.getEmpID(), leavesSalaries.getLeavesTaken());
    }

    
//    @GetMapping("/admin/listCustomer")
//    public List<Customer> allCustomer(){
//        return
//    }
//
//    @PostMapping("/admin/deleteCustomer")
//    public String deleteCustomer(@RequestBody User user){
//
//    }
//
//    @PostMapping("/admin/addCustomer")
//    public String addCustomer(@RequestBody UserCustomer userCustomer){
//
//    }

}