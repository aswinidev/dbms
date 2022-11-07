package com.dbms.HotelManagement.controller;

import com.dbms.HotelManagement.extraclass.GetBooking;
import com.dbms.HotelManagement.extraclass.TempBooking1;
import com.dbms.HotelManagement.model.*;
import com.dbms.HotelManagement.service.BookingService;
import com.dbms.HotelManagement.service.DashboardService;
import com.dbms.HotelManagement.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BookingController {

    private final BookingService bookingService;
    private final MemberService memberService;
    private final DashboardService dashboardService;
    @Autowired
    public BookingController(BookingService bookingService, MemberService memberService, DashboardService dashboardService) {
        this.bookingService = bookingService;
        this.memberService = memberService;
        this.dashboardService = dashboardService;
    }

    @PostMapping("/booking/check")
    public boolean checkAvail(@RequestBody TempBooking1 booking){
        System.out.println("reached");
        boolean isBooking = bookingService.getAvail(booking.getCheckIn(), booking.getCheckOut(), booking.getSingleOcc(), booking.getDoubleOcc());
//        if(isBooking){
//            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//            UserDetails obj = (UserDetails) auth.getPrincipal();
//            String pEmail = obj.getUsername();
//            User user = dashboardService.getDetails(pEmail);
//            Customer cust = dashboardService.getCust(user.getUserID());
//            bookingService.book(cust.getCustomerID(), booking.getCheckIn(), booking.getCheckOut(), booking.getSingleOcc(), booking.getDoubleOcc());
//        }
        return isBooking;


    }
    @PostMapping("/booking/book")
    public String bookRoom(@RequestBody GetBooking booking) {
//        System.out.println(booking.getMembersList());
        System.out.println(booking.getMembersList().get(0).getAadharNo());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails obj = (UserDetails) auth.getPrincipal();
        String pEmail = obj.getUsername();
        User user = dashboardService.getDetails(pEmail);
        Customer cust = dashboardService.getCust(user.getUserID());
        UUID customerID = cust.getCustomerID();
        String checkInDate = booking.getCheckInDate();
        String checkOutDate = booking.getCheckOutDate();
        System.out.println(checkInDate);
        System.out.println(booking.getSingleRoom());
        UUID bookingID = bookingService.book(customerID, checkInDate, checkOutDate, booking.getSingleRoom(), booking.getDoubleRoom());
        int r = memberService.addMember(bookingID, booking.getCountMember(), booking.getMembersList());
        return "booking successful";
    }

    @GetMapping("/customer/booking")
    public List<GetBooking> getCustBooking(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails obj = (UserDetails) auth.getPrincipal();
        String pEmail = obj.getUsername();

        User user = dashboardService.getDetails(pEmail);
        Customer cust = dashboardService.getCust(user.getUserID());
//        cust = dashboardService.getCust(user.getUserID());

        List<GetBooking> b =  bookingService.getBookings(cust.getCustomerID());
        System.out.println(b.size() + " " + b.get(0).getCheckOutDate() + " " + b.get(0).getCountMember());
        return b;
    }




}
