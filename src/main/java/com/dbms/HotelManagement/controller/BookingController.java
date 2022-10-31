package com.dbms.HotelManagement.controller;

import com.dbms.HotelManagement.model.Customer;
import com.dbms.HotelManagement.model.TempBooking;
import com.dbms.HotelManagement.model.User;
import com.dbms.HotelManagement.service.AuthenticationService;
import com.dbms.HotelManagement.service.BookingService;
import com.dbms.HotelManagement.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BookingController {

    private final BookingService bookingService;
    private final DashboardService dashboardService;

    @Autowired
    public BookingController(BookingService bookingService, DashboardService dashboardService) {
        this.bookingService = bookingService;
        this.dashboardService = dashboardService;
    }

    @PostMapping("/booking/check")
    public boolean checkAvail(@RequestBody TempBooking booking){
        boolean isBooking = bookingService.getAvail(booking.getCheckIn(), booking.getCheckOut(), booking.getSingleOcc(), booking.getDoubleOcc());
        if(isBooking){
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            UserDetails obj = (UserDetails) auth.getPrincipal();
            String pEmail = obj.getUsername();
            User user = dashboardService.getDetails(pEmail);
            Customer cust = dashboardService.getCust(user.getUserID());
            bookingService.book(cust.getCustomerID(), booking.getCheckIn(), booking.getCheckOut(), booking.getSingleOcc(), booking.getDoubleOcc());
        }


    }e
//    @PostMapping("/booking/book")
//    public String bookRoom(@RequestBody TempBooking booking, HttpSession session) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        UserDetails obj = (UserDetails) auth.getPrincipal();
//        String pEmail = obj.getUsername();
//        User user = dashboardService.getDetails(pEmail);
//        Customer cust = dashboardService.getCust(user.getUserID());
//        UUID customerID = cust.getCustomerID();
//        String checkInDate = booking.getCheckIn();
//        String checkOutDate = booking.getCheckOut();
//        bookingService.book(customerID, checkInDate, checkOutDate);
//        return "booking successful";
////        return fname + " " + lname + " " + pEmail + " " + pswd + " " + houseNo + " " + state + " " + city + " " + country + " " + pinCode + " " + gender;
//    }




}
