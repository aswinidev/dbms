package com.dbms.HotelManagement.service;

import com.dbms.HotelManagement.model.Room;
import com.dbms.HotelManagement.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public void book(UUID customerID, String checkInDate, String checkOutDate, int singleRoom, int doubleRoom){
        UUID bookingID = UUID.randomUUID();
        try {

            List<Room> singleAvailRoom = bookingRepository.getRoomSingle(checkInDate, checkOutDate);
            List<Room> doubleAvailRoom = bookingRepository.getRoomDouble(checkInDate, checkOutDate);
            for(int i=0;i<singleRoom;i++){
                bookingRepository.bookRoom(bookingID, singleAvailRoom.get(i).getRoomNo());
            }
            for(int i=0;i<doubleRoom;i++) {
                bookingRepository.bookRoom(bookingID, doubleAvailRoom.get(i).getRoomNo());
            }
            bookingRepository.book(bookingID, checkInDate, checkOutDate, customerID);
            

//            System.out.println(userID + " " + fname + " " + lname + " " + pEmail + " " + pswd + " " + houseNo + " " + state + " " + city + " " + country + " " + pinCode + " " + gender);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
