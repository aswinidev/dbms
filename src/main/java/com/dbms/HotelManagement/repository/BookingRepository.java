package com.dbms.HotelManagement.repository;

import ch.qos.logback.core.encoder.EchoEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;

@Repository
public class BookingRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookingRepository(JdbcTemplate jdbcTemplate){ this.jdbcTemplate = jdbcTemplate; }

    public int getSingle(String in, String out){
        String sql = "select count(*) from Room where type = 'single' and roomNo NOT IN " +
                "(select roomNo from BookingRoom where bookingID IN " +
                "(select bookingID from Booking where checkIn<? and checkOut>?));";
        try{
            return jdbcTemplate.queryForObject(sql, new Object[]{out, in}, new BeanPropertyRowMapper<>(Integer.class));
        }
        catch (Exception e){
            System.out.println(e);
        }
        return 0;
    }

    public int getDouble(String in, String out){
        String sql = "select count(*) from Room where type = 'double' and roomNo NOT IN " +
                "(select roomNo from BookingRoom where bookingID IN " +
                "(select bookingID from Booking where checkIn<? and checkOut>?));";
        try{
            return jdbcTemplate.queryForObject(sql, new Object[]{out, in}, new BeanPropertyRowMapper<>(Integer.class));
        }
        catch (Exception e){
            System.out.println(e);
        }
        return 0;
    }

}
