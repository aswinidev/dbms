package com.dbms.HotelManagement.repository;

import com.dbms.HotelManagement.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookingRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookingRepository(JdbcTemplate jdbcTemplate){ this.jdbcTemplate = jdbcTemplate; }

    public int getSingle(String in, String out){
        String sql = "select count(*) from Room where type = 'single' and roomNo NOT IN " +
                "(select roomNo from BookingRoom where bookingID IN " +
                "(select Booking.bookingID from Booking where checkInDate<? and checkOutDate>?))";
//        String sql = "select count(*) from Room where type='single' ";
        try{
            return jdbcTemplate.queryForObject(sql, new Object[]{out, in}, Integer.class);
        }
        catch (Exception e){
            System.out.println(e);
        }
        return 3;
    }

    public int getDouble(String in, String out){
        String sql = "select count(*) from Room where type = 'double' and roomNo NOT IN " +
                "(select roomNo from BookingRoom where bookingID IN " +
                "(select Booking.bookingID from Booking where checkInDate<? and checkOutDate>?))";
        try{
            return jdbcTemplate.queryForObject(sql, new Object[]{out, in}, Integer.class);
        }
        catch (Exception e){
            System.out.println(e);
        }
        return 0;
    }


    public List<Room> getRoomSingle(String in, String out){
        String sql = "select * from Room where type = 'single' and roomNo NOT IN " +
                "(select roomNo from BookingRoom where bookingID IN " +
                "(select Booking.bookingID from Booking where checkInDate<? and checkOutDate>?))";
        try{
            return jdbcTemplate.query(sql, new Object[]{out, in}, new BeanPropertyRowMapper(Room.class));
        }
        catch (Exception e){
            System.out.println(e);
            return new ArrayList<Room>();
        }
    }

    public List<Room> getRoomDouble(String in, String out){
        String sql = "select * from Room where type = 'double' and roomNo NOT IN " +
                "(select roomNo from BookingRoom where bookingID IN " +
                "(select Booking.bookingID from Booking where checkInDate<? and checkOutDate>?))";
        try{
            return jdbcTemplate.query(sql, new Object[]{out, in}, new BeanPropertyRowMapper(Room.class));
        }
        catch (Exception e){
            System.out.println(e);
            return new ArrayList<Room>();
        }
//        return 0;
    }

    public int bookRoom(UUID bookingID, int roomNo){
        String sql = "INSERT INTO BookingRoom values(?, ?)";

        return jdbcTemplate.update(sql, bookingID.toString(), roomNo);
    }
    private RowMapper<Room> RoomMapper() {
        return (resultSet, i) -> {
            return new Room(
                    resultSet.getInt("roomNo"),
                    resultSet.getString("type"),
                    resultSet.getFloat("price"),
                    resultSet.getInt("floor")
            );
        };
    }

    public int book(UUID bookingID, String checkInDate, String checkOutDate, UUID customerID) {
        String sql = "INSERT INTO Booking(bookingID, checkInDate, checkOutDate, customerID) VALUES (?,?,?,?)";
//        System.out.println(userID + " " + fname + " " + lname + " " + pEmail + " " + pswd + " " + houseNo + " " + state + " " + city + " " + country + " " + pinCode + " " + gender);
//        try {
        return jdbcTemplate.update(sql, bookingID.toString(), checkInDate, checkOutDate, customerID.toString());
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    }

}
