package com.dbms.HotelManagement.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public int registerUser(UUID userID, String fname, String lname, String pEmail, String pswd, String houseNo, String state, String city, String country, String pinCode, String gender) {
        String sql = "INSERT INTO User(userID, fname, lname, pEmail, pswd, houseNo, state, city, country, pinCode, gender) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
//        System.out.println(userID + " " + fname + " " + lname + " " + pEmail + " " + pswd + " " + houseNo + " " + state + " " + city + " " + country + " " + pinCode + " " + gender);
//        try {
            return jdbcTemplate.update(sql, userID.toString(), fname, lname, pEmail, pswd, houseNo, state, city, country, pinCode, gender);
//        } catch (Exception e) {
//            System.out.println(e);
//        }

    }
}
