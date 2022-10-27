package com.dbms.HotelManagement.controller;

import com.dbms.HotelManagement.model.User;
import com.dbms.HotelManagement.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RegisterController {
    private final AuthenticationService authenticationService;

    @Autowired

    public RegisterController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public String submitRegister(@RequestBody User user) {
        String fname = user.getFname();
        String lname = user.getLname();
        String pEmail = user.getpEmail();
        String pswd = user.getPswd();
        String houseNo = user.getHouseNo();
        String state = user.getState();
        String city = user.getCity();
        String country = user.getCountry();
        String pinCode = user.getPinCode();
        String gender = user.getGender();
        authenticationService.register(fname, lname, pEmail, pswd, houseNo, state, city, country, pinCode, gender);
        return fname + " " + lname + " " + pEmail + " " + pswd + " " + houseNo + " " + state + " " + city + " " + country + " " + pinCode + " " + gender;
    }
}
