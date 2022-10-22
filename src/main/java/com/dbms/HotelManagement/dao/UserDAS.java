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

    public static void updateActivity(UUID userID, int i) {
//        TODO set the activity of the user to i.
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

    public static User findUserByToken(String token) {
//        TODO Implement Logic.
        User user = null;
        return user;
    }
    public static boolean alreadyExist(String username){
//        TODO Implement Logic.
        return true;
    }

    private RowMapper<User> mapUserFromDb() {
        return (resultSet, i) -> {
            String userIdStr = resultSet.getString("student_id");
            User user = new User();

            user.setUserID(UUID.fromString(userIdStr));
            user.setFname(resultSet.getString("first_name"));
            user.setLname(resultSet.getString("last_name"));
            user.setpEmail(resultSet.getString("email"));
            user.setHouseNo(resultSet.getString("house_no"));
            user.setState(resultSet.getString("state"));
            user.setCity(resultSet.getString("city"));
            user.setCountry(resultSet.getString("country"));
            user.setPinCode(resultSet.getString("pin_code"));
            user.setGender(resultSet.getString("gender").toUpperCase());

            return user;
        };
    }
}

// @todo: - change column labels in the row-mapper
//        - create sql tables and change the query