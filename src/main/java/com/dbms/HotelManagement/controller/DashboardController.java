package com.dbms.HotelManagement.controller;

import com.dbms.HotelManagement.model.User;
import com.dbms.HotelManagement.service.AuthenticationService;
import com.dbms.HotelManagement.service.DashboardService;
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

    @Autowired
    public DashboardController(DashboardService dashboardService, AuthenticationService authenticationService){
        this.dashboardService = dashboardService;
        this.authenticationService = authenticationService;
    }

    @GetMapping("/dashboard")
    public User dashboard(HttpSession session){
        String pEmail = authenticationService.getCurrentUser(session);
        User user = dashboardService.getDetails(pEmail);
        return user;
    }
}
