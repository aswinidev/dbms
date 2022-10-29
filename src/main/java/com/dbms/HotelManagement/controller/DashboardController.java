package com.dbms.HotelManagement.controller;

import com.dbms.HotelManagement.model.User;
import com.dbms.HotelManagement.service.AuthenticationService;
import com.dbms.HotelManagement.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public String dashboard(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Dashboard: " + auth);
//        System.out.println("Hello");
//        try{System.out.println(session.getAttribute("USER_SESSION"));}catch (Exception e){System.out.println(e);}
//        String pEmail = authenticationService.getCurrentUser(session);
//        System.out.println(pEmail);
        return "dashboard";
//        System.out.println(pEmail);
//        User user = dashboardService.getDetails(pEmail);
//        return user;
    }
}
