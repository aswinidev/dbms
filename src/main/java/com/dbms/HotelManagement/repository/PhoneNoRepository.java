package com.dbms.HotelManagement.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public class PhoneNoRepository {
    private final JdbcTemplate jdbcTemplate;

    public PhoneNoRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    public void addNo(UUID userID, String s) {
        String sql = "INSERT INTO UserPhoneNumber(userID, phoneNumber) values (?,?)";

        jdbcTemplate.update(sql, userID.toString(), s);
    }
}
