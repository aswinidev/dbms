package com.dbms.HotelManagement.repository;

import com.dbms.HotelManagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

    public User getUser(String pEmail){
        String sql = "SELECT * FROM User WHERE pEmail = ?";
        System.out.println(sql);
//        var rowMapper = BeanPropertyRowMapper.newInstance(User.class);
//        var user = jdbcTemplate.query(sql, rowMapper);
//        return user.get(0);
       // return jdbcTemplate.queryForObject(sql, new Object[] {pEmail}, new BeanPropertyRowMapper<>(User.class));
        return jdbcTemplate.queryForObject(sql,
                new Object[]{pEmail},
                (resultSet, i)->{
            System.out.println(resultSet);
            return new User(
                    UUID.fromString(resultSet.getString("userID")),
                    resultSet.getString("fname"),
                    resultSet.getString("lname"),
                    resultSet.getString("pEmail"),
                    resultSet.getString("pswd"),
                    resultSet.getString("houseNo"),
                    resultSet.getString("city"),
                    resultSet.getString("state"),
                    resultSet.getString("country"),
                    resultSet.getString("pinCode"),
                    resultSet.getString("gender")
                );
//                user.setUserID(UUID.fromString(resultSet.getString("userID")));
//                    user.setFname(resultSet.getString("fname"));
//                    user.setLname(resultSet.getString("lname"));
//                    user.setpEmail(resultSet.getString("pEmail"));
//                    user.setPswd(resultSet.getString("pswd"));
//                    user.setHouseNo(resultSet.getString("houseNo"));
//                    user.setCity(resultSet.getString("city"));
//                    user.setState(resultSet.getString("state"));
//                    user.setCountry(resultSet.getString("country"));
//                    user.setPinCode(resultSet.getString("pinCode"));
//                    user.setGender(resultSet.getString("gender"));
//                    return user;
                });
//        return jdbcTemplate.query(sql, new Object[]{pEmail},
//                (resultSet, i)->{
//                    User user =  new User();
//                    user.setUserID(UUID.fromString(resultSet.getString("userID")));
//                    user.setFname(resultSet.getString("fname"));
//
//                    return user;
//                })
    }
}
