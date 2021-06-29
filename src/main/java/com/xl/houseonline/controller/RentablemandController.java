package com.xl.houseonline.controller;

import com.xl.houseonline.entity.Rentaldemand;
import com.xl.houseonline.service.RentaldemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rent")
public class RentablemandController {
    @Autowired
    RentaldemandService rentaldemandService;
    @GetMapping("/findAll")
    public List<Rentaldemand> findAllRent(){
        return rentaldemandService.findAllRentData();
    }
    @GetMapping("/findOne/{id}")
    public Rentaldemand findOne(@PathVariable("id") Integer id){
        return rentaldemandService.findOneData(id);
    }
}
