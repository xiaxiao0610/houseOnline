package com.xl.houseonline.controller;

import com.xl.houseonline.entity.Rentaldemand;
import com.xl.houseonline.entity.RespPage;
import com.xl.houseonline.entity.User;
import com.xl.houseonline.service.RentaldemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rent")
public class RentablemandController {
    @Autowired
    RentaldemandService rentaldemandService;
    @GetMapping("/findAll")
    public RespPage findAllRent(@RequestParam(defaultValue = "2") Integer page, @RequestParam(defaultValue = "5")Integer size, Rentaldemand rent,User user){
        RespPage respPage=new RespPage();
        respPage.setData(rentaldemandService.findAllRentData(page, size, rent,user));
        respPage.setTotal(rentaldemandService.findAllRentData(page, size, rent,user).size());
       return respPage;
    }
    @GetMapping("/findOne/{id}")
    public Rentaldemand findOne(@PathVariable("id") Integer id){
        return rentaldemandService.findOneData(id);
    }
@PutMapping("/updateAndSend/{id}/{uid}")
    public int updateAndSend(@PathVariable("id")Integer id,@PathVariable("uid")Integer uid){
        return rentaldemandService.updateAndSendMess(id,uid);
}
}

