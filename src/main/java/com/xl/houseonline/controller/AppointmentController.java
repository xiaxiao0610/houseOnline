package com.xl.houseonline.controller;

import com.xl.houseonline.entity.*;
import com.xl.houseonline.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;
    @PostMapping("/add")
    public RespData addAppointment(@RequestParam("rentalId") Integer rentalId, @RequestParam("appointmentDate") Long appointmentDate,@RequestParam("uid")Integer uid){
        if (appointmentService.addAppointment(rentalId, appointmentDate,uid)==1){
            return RespData.success("ok");
        }
        else {
            return RespData.fail("fail");
        }
    }
    @GetMapping("/getAllStatus0")
    public RespPage findStatus0(@RequestParam(defaultValue = "2") Integer page, @RequestParam(defaultValue = "5")Integer size, Rentaldemand rentaldemand){
       RespPage respPage=new RespPage();
       respPage.setTotal(appointmentService.findAllStatus0(page, size, rentaldemand).size());
       respPage.setData(appointmentService.findAllStatus0(page, size, rentaldemand));
        return respPage;
    }
    @PutMapping("/updateAdminId")
    public int updateAppointment(@RequestParam("adminId") Integer adminId,@RequestParam("id") Integer id,@RequestParam("uid") Integer uid){
        return appointmentService.updateAppointment(adminId, id,uid);
    }
    @GetMapping("/getMine")
    public List<Appointment> findByMine(){
        return appointmentService.findByMine();
    }
    @GetMapping("/findById/{id}")
    public Appointment findById(@PathVariable("id") Integer id){
        return appointmentService.findById(id);
    }
@PutMapping("/updateSuccess/{id}")
    public int updateSuccess(@PathVariable("id")Integer id){
        return appointmentService.updateSuccess(id);
}
}
