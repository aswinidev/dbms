package com.dbms.HotelManagement.controller;

import com.dbms.HotelManagement.model.Customer;
import com.dbms.HotelManagement.model.Employee;
import com.dbms.HotelManagement.model.User;
import com.dbms.HotelManagement.service.AuthenticationService;
import com.dbms.HotelManagement.service.DashboardService;
import com.mysql.cj.conf.ConnectionUrlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class DashboardController {
    private final DashboardService dashboardService;
    private final AuthenticationService authenticationService;

    @Autowired
    public DashboardController(DashboardService dashboardService, AuthenticationService authenticationService){
        this.dashboardService = dashboardService;
        this.authenticationService = authenticationService;
    }

    @GetMapping("/dashboard")
    public User dashboard(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails obj = (UserDetails) auth.getPrincipal();
        String pEmail = obj.getUsername();
//        return pEmail;

        User user = dashboardService.getDetails(pEmail);
        Employee emp = dashboardService.getEmp(user.getUserID());
        System.out.println(emp);
        user.setIsEmp(user.getUserID() == emp.getUserID());
        return user;
    }


    @GetMapping("/dashboard/employee")
    public Employee employee(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails obj = (UserDetails) auth.getPrincipal();
        String pEmail = obj.getUsername();

        User user = dashboardService.getDetails(pEmail);
        Employee emp = dashboardService.getEmp(user.getUserID());
        return emp;
    }

    @GetMapping("/dashboard/customer")
    public Customer customer(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails obj = (UserDetails) auth.getPrincipal();
        String pEmail = obj.getUsername();

        User user = dashboardService.getDetails(pEmail);
        Customer cust = dashboardService.getCust(user.getUserID());
        cust = dashboardService.getCust(user.getUserID());
        return cust;
    }
}


