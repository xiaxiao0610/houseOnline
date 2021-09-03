package com.xl.houseonline.service;

import com.xl.houseonline.config.Websocket;
import com.xl.houseonline.dao.AppointmentDao;
import com.xl.houseonline.dao.RentaldemandDao;
import com.xl.houseonline.entity.Admin;
import com.xl.houseonline.entity.Appointment;
import com.xl.houseonline.entity.MsgContent;
import com.xl.houseonline.entity.Rentaldemand;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Service
public class AppointmentService {
    @Autowired
    AppointmentDao appointmentDao;
    @Autowired
    RentaldemandDao rentaldemandDao;
    @Autowired
    SendMessage sendMessage;
    @Autowired
    ExecutorService executorService;
    public int addAppointment(Integer rentalId,Long appointmentDate,Integer uid){
//        SimpleDateFormat dateFormat=new SimpleDateFormat('');
        Appointment appointment=new Appointment();
        appointment.setRentalId(rentalId);
        appointment.setUserId(uid);
        appointment.setCreateDate(DateTime.now().getMillis());
        appointment.setAppointmentDate(appointmentDate);
        Rentaldemand rentaldemand=rentaldemandDao.selectById(rentalId);
        rentaldemand.setDemandState(false);
        rentaldemandDao.updateByPrimaryKeySelective(rentaldemand);
        return appointmentDao.insertSelective(appointment);
    }
    public List<Appointment> findAllStatus0(Integer page,Integer size ,Rentaldemand rentaldemand){
if (page!=null && size!=null){
    page=(page-1)*size;
}

        return appointmentDao.findAllStatus0(page, size, rentaldemand);
    }
    //根据id更新对应的appointment的adminId
    public int updateAppointment(Integer adminId,Integer id,Integer uid){
        Appointment appointment=appointmentDao.selectByPrimaryKey(id);
        appointment.setAppointmentStatus(true);
        appointmentDao.updateByPrimaryKeySelective(appointment);
        //调用message程序
        MsgContent msgContent=new MsgContent();
        msgContent.setMessage("您的委托已经被接受！");
        msgContent.setTitle("委托接受！");
        sendMessage.send(uid,msgContent);
        //新的线程去通知
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                Websocket.sendMessage(msgContent.getMessage(), uid);
            }
        });



        return appointmentDao.updateAdminIdOnAppointment(adminId, id);
    }
    //当前经纪人的看房日程
    public  List<Appointment> findByMine(){
        return appointmentDao.findMine(((Admin)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }
    public  Appointment findById(Integer id){
        return appointmentDao.findOne(id);
    }
    //提交成功后更新行程中的success状态为1
    public int updateSuccess(Integer id){
        Appointment appointment=appointmentDao.selectByPrimaryKey(id);
        appointment.setSuccess(true);
        appointmentDao.updateByPrimaryKeySelective(appointment);

        return appointmentDao.updateByPrimaryKeySelective(appointment);
    }

}
