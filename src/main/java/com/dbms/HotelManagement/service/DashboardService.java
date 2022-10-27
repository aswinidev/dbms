package com.dbms.HotelManagement.service;

import com.dbms.HotelManagement.model.User;
import com.dbms.HotelManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {
    private final UserRepository userRepository;

    @Autowired
    public DashboardService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User getDetails(String pEmail){
        User user = userRepository.getUser(pEmail);
        return user;
    }
}
