package com.dbms.HotelManagement.controller;

import com.dbms.HotelManagement.model.Customer;
import com.dbms.HotelManagement.model.Employee;
import com.dbms.HotelManagement.model.User;
import com.dbms.HotelManagement.service.AuthenticationService;
import com.dbms.HotelManagement.service.DashboardService;
import com.mysql.cj.conf.ConnectionUrlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class DashboardController {
    private final DashboardService dashboardService;
    private final AuthenticationService authenticationService;
    private User user;
    private Employee emp;
    private Customer cust;

    @Autowired
    public DashboardController(DashboardService dashboardService, AuthenticationService authenticationService){
        this.dashboardService = dashboardService;
        this.authenticationService = authenticationService;
    }

    @GetMapping("/dashboard")
    public User dashboard(HttpSession session){
        String pEmail = authenticationService.getCurrentUser(session);
        user = dashboardService.getDetails(pEmail);
        emp = dashboardService.getEmp(user.getUserID());
        if(emp!=null) {
            user.setIsEmp(true);
        }
        else{
            user.setIsEmp(false);
        }
        return user;
    }

    @GetMapping("/dashboard/employee")
    public Employee employee(HttpSession session){
        return emp;
    }

    @GetMapping("/dashboard/customer")
    public Customer customer(HttpSession session){
        cust = dashboardService.getCust(user.getUserID());
        return cust;
    }
}


