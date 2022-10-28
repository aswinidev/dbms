package com.dbms.HotelManagement.controller;

import com.dbms.HotelManagement.model.User;
import com.dbms.HotelManagement.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LogInController {

    private final AuthenticationManager authenticationManager;
    private final AuthenticationService authenticationService;

    @Autowired
    public LogInController(AuthenticationManager authenticationManager, AuthenticationService authenticationService) {
        this.authenticationManager = authenticationManager;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public String customerLogIn(@RequestBody User user){
        String pEmail = user.getpEmail();
        String pswd = user.getPswd();

        try{
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(pEmail, pswd));
            SecurityContextHolder.getContext().setAuthentication(authentication);
//            Authentication auth = SecurityContextHolder.getContext().getAuthentication(); // if null then noone logged in
//            UserDetails obj = (UserDetails) auth.getPrincipal(); // isse username (in this case pEmail) mil jayega tumeh
//            String pEmail = obj.getUsername();
            return "login";
        }
        catch(Exception e){
            System.out.println(e);
            return "redirect:/";
        }
    }
}