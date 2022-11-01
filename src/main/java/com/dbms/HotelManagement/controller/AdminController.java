package com.dbms.HotelManagement.controller;

import com.dbms.HotelManagement.jsonResponse.UserEmployee;
import com.dbms.HotelManagement.model.Employee;
import com.dbms.HotelManagement.model.Feedback;
import com.dbms.HotelManagement.model.User;
import com.dbms.HotelManagement.service.AdminService;
import com.dbms.HotelManagement.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {
    private final AdminService adminService;
    private final AuthenticationService authenticationService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AdminController(AdminService adminService, AuthenticationService authenticationService, PasswordEncoder passwordEncoder) {
        this.adminService = adminService;
        this.authenticationService = authenticationService;
        this.passwordEncoder = passwordEncoder;
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
        Employee employee = new Employee(
                UUID.randomUUID(),
                userEmployee.getCurrHouseNo(),
                userEmployee.getCurrPincode(),
                userEmployee.getCurrCity(),
                userEmployee.getCurrState(),
                userEmployee.getMaritalStatus(),
                userEmployee.getPanCard(),
                userEmployee.getAccountNo(),
                userEmployee.getIFSCCode(),
                userEmployee.getBankName(),
                userID,
                userEmployee.getDeptName(),
                UUID.fromString(userEmployee.getSuperID())
        );
        adminService.addEmployee(employee);
        return "Added Employee";
    }

    @GetMapping("/admin/allFeedback")
    public List<Feedback> allFeedback(){
        return adminService.getFeedback();
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
