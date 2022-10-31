package com.dbms.HotelManagement.controller;

import com.dbms.HotelManagement.model.User;
import com.dbms.HotelManagement.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RegisterController {
    private final AuthenticationService authenticationService;
    private final PasswordEncoder passwordEncoder;

    @Autowired

    public RegisterController(AuthenticationService authenticationService, PasswordEncoder passwordEncoder) {
        this.authenticationService = authenticationService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public String submitRegister(@RequestBody User user) {
        String fname = user.getFname();
        String lname = user.getLname();
        String pEmail = user.getpEmail();
        String pswd = passwordEncoder.encode(user.getPswd());
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
