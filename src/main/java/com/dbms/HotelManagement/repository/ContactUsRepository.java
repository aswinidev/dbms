package com.dbms.HotelManagement.repository;

import com.dbms.HotelManagement.model.ContactUs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ContactUsRepository {
    
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ContactUsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ContactUs> getAllQuery() {
        String sql = "SELECT * FROM ContactUs WHERE reply IS NULL";
        List<ContactUs> allQuery = jdbcTemplate.query(sql, new Object[]{}, new BeanPropertyRowMapper(ContactUs.class));
        return allQuery;
    }

    public ContactUs getQueryByID(UUID queryID) {
        String sql = "SELECT * FROM ContactUS WHERE queryID = ?";
//        List<User> u=jdbcTemplate.query(sql,new Object[] {pEmail},UserMapper());
//        return u.get(0);
        ContactUs query=jdbcTemplate.queryForObject(sql,new Object[] {queryID}, new BeanPropertyRowMapper<>(ContactUs.class));
        return query;
    }

    public void replyQuery(UUID queryID, String reply) {
        String sql = "UPDATE ContactUs SET reply = ? WHERE queryID = ?";
        jdbcTemplate.update(sql,reply,queryID.toString());
    }

    public void submitQuery(UUID queryID, String name, String contactNumber, String reply, String query, String emailID, UUID customerID) {
        String sql = "INSERT INTO ContactUs (queryID, name, contactNumber, reply, query, emailID, qdate, qtime, customerID) VALUES (?,?,?,?,?,?,current_date,current_time,?)";
        jdbcTemplate.update(sql, queryID.toString(), name, contactNumber, reply, query, emailID, customerID.toString());
    }
}
