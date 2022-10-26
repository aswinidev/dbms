package com.dbms.HotelManagement.controller;

import com.dbms.HotelManagement.model.User;
import com.dbms.HotelManagement.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LogInController {
    private final AuthenticationService authenticationService;

    @Autowired
    public LogInController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login/customer")
    public String customerLogIn(@RequestBody User user, HttpSession session){
        String pEmail = user.getpEmail();
        String pswd = user.getPswd();
        try{
            if(authenticationService.checkUserCredentials(pEmail, pswd)){
                authenticationService.login(session, pEmail);
            }

            return "redirect:/";

        }
        catch(Exception e){
            System.out.println(e);
        }
        return "/login";

    }
}
