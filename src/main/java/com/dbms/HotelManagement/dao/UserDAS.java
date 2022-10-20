package com.dbms.HotelManagement.dao;

import com.dbms.HotelManagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import java.util.UUID;

public class UserDAS {

    private final JdbcTemplate jdbcTemplate;

    public UserDAS(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    List<User> selectAllUser(){
        String sql = "SELECT " +
                " student_id, " +
                " first_name, " +
                " last_name, " +
                " email, " +
                " house_no, " +
                " state " +
                " city " +
                " country " +
                " pin_code " +
                " gender " +
                "FROM user";
        return jdbcTemplate.query(sql, mapUserFromDb());
    }

    private RowMapper<User> mapUserFromDb() {
        return (resultSet, i) -> {
            String userIdStr = resultSet.getString("student_id");

            UUID userID = UUID.fromString(userIdStr);
            String fName = resultSet.getString("first_name");
            String lName = resultSet.getString("last_name");
            String pEmail = resultSet.getString("email");
            String houseNo = resultSet.getString("house_no");
            String state = resultSet.getString("state");
            String city = resultSet.getString("city");
            String country = resultSet.getString("country");
            String pinCode = resultSet.getString("pin_code");
            String gender = resultSet.getString("gender").toUpperCase();

            return new User(userID, fName, lName, pEmail, houseNo, state, city, country, pinCode, gender);
        };
    }
}

// @todo: - change column labels in the row-mapper
//        - create sql tables and change the query