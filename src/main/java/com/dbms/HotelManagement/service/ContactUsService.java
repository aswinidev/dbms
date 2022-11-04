package com.dbms.HotelManagement.service;

import com.dbms.HotelManagement.repository.ContactUsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ContactUsService {
    private final ContactUsRepository contactUsRepository;

    @Autowired
    public ContactUsService(ContactUsRepository contactUsRepository) {
        this.contactUsRepository = contactUsRepository;
    }

    public void addQuery(UUID queryID, String name, String contactNumber, String reply, String query, String emailID, String date, String time, UUID customerID) {
        contactUsRepository.submitQuery(queryID, name, contactNumber, reply, query, emailID, date, time, customerID);
    }
}
