package com.dbms.HotelManagement.service;

import com.dbms.HotelManagement.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServiceService {
    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public int addService(String serviceName, int price, boolean isAvail, UUID head){
        return serviceRepository.addService(serviceName, isAvail, price, head);
    }

    public int deleteService(String serviceName){
        return serviceRepository.deleteService(serviceName);
    }

    public void updateService(String serviceName, int price, boolean isAvailable, UUID head){
        serviceRepository.updatePrice(serviceName, price);
        serviceRepository.updateAvailabilty(serviceName, isAvailable);
        serviceRepository.updateHeadedBy(serviceName, head);
    }

    public List<com.dbms.HotelManagement.model.Service> getServices(){
        return serviceRepository.getAllService();
    }
}
