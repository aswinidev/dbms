package com.dbms.HotelManagement.controller;

import com.dbms.HotelManagement.model.TempBooking;
import com.dbms.HotelManagement.service.AuthenticationService;
import com.dbms.HotelManagement.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/booking/check")
    public boolean checkAvail(@RequestBody TempBooking booking){
        return bookingService.getAvail(booking.getCheckIn(), booking.getCheckOut(), booking.getSingleOcc(), booking.getDoubleOcc());


    }


}
