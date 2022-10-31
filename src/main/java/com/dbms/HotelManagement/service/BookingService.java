package com.dbms.HotelManagement.service;

import com.dbms.HotelManagement.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public boolean getAvail(String checkIn, String checkOut, int singleOcc, int doubleOcc){
        int singleAvail = bookingRepository.getSingle(checkIn, checkOut);
        int doubleAvail = bookingRepository.getDouble(checkIn, checkOut);
        return singleAvail >= singleOcc && doubleAvail >= doubleOcc;

    }
}
