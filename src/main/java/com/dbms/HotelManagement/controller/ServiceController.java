package com.dbms.HotelManagement.controller;

import com.dbms.HotelManagement.model.Service;
import com.dbms.HotelManagement.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {
    private final ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @PostMapping("/admin/addService")
    public int addService(@RequestBody Service service){
        return serviceService.addService(service.getServiceName(), service.getPrice(), service.isAvailability(), service.getHeadedBy());

    }

    @PostMapping("/admin/deleteService")
    public int deleteService(@RequestBody String serviceName){
        return serviceService.deleteService(serviceName);
    }

    @PostMapping("/admin/updateService")
    public String updateService(@RequestBody Service service){

        serviceService.updateService(service.getServiceName(), service.getPrice(), service.isAvailability(), service.getHeadedBy());


        return "Success";
    }

}
