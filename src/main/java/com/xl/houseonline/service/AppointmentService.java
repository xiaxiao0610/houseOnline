package com.xl.houseonline.service;

import com.xl.houseonline.dao.AppointmentDao;
import com.xl.houseonline.dao.RentaldemandDao;
import com.xl.houseonline.entity.Appointment;
import com.xl.houseonline.entity.Rentaldemand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    AppointmentDao appointmentDao;
    @Autowired
    RentaldemandDao rentaldemandDao;
    public int addAppointment(Integer rentalId,Long appointmentDate){
        Appointment appointment=new Appointment();
        appointment.setRentalId(rentalId);
        appointment.setAppointmentDate(appointmentDate);
        Rentaldemand rentaldemand=rentaldemandDao.selectById(rentalId);
        rentaldemand.setDemandState(false);
        rentaldemandDao.updateByPrimaryKeySelective(rentaldemand);
        return appointmentDao.insertSelective(appointment);
    }
    public List<Appointment> findAllStatus0(){


        return appointmentDao.findAllStatus0();
    }
}
