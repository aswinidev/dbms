package com.dbms.HotelManagement.controller;

import com.dbms.HotelManagement.model.ContactUs;
import com.dbms.HotelManagement.service.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ContactUsController {

    private final ContactUsService contactUsService;

    @Autowired
    public ContactUsController(ContactUsService contactUsService) {
        this.contactUsService = contactUsService;
    }

    @PostMapping("/contactus")
    public String contactus(@RequestBody ContactUs contactUs){
        UUID queryID = UUID.randomUUID();
        String name = contactUs.getName();
        String contactNumber = contactUs.getContactNumber();
        String reply = contactUs.getReply();
        String query = contactUs.getQuery();
        String emailID = contactUs.getEmailID();
        String date = contactUs.getDate();
        String time = contactUs.getTime();
        UUID customerID = contactUs.getCustomerID();
        contactUsService.addQuery(queryID,name,contactNumber,reply,query,emailID,date,time,customerID);
        return "Asked query";
    }
}
