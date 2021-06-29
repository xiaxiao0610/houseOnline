package com.xl.houseonline.controller;

import com.xl.houseonline.entity.Appointment;
import com.xl.houseonline.entity.RespData;
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
    public RespData addAppointment(@RequestParam("rentalId") Integer rentalId, @RequestParam("appointmentDate") Long appointmentDate){
        if (appointmentService.addAppointment(rentalId, appointmentDate)==1){
            return RespData.success("ok");
        }
        else {
            return RespData.fail("fail");
        }
    }
    @GetMapping("/getAllStatus0")
    public List<Appointment> findStatus0(){
        return appointmentService.findAllStatus0();
    }
}
