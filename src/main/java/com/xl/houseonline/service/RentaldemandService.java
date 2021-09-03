package com.xl.houseonline.service;

import com.xl.houseonline.config.Websocket;
import com.xl.houseonline.dao.MsgContentDao;
import com.xl.houseonline.dao.RentaldemandDao;
import com.xl.houseonline.dao.SysMessageDao;
import com.xl.houseonline.entity.*;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutorService;

@Service
public class RentaldemandService {
    @Autowired
    RentaldemandDao rentaldemandDao;
    @Autowired
    SysMessageDao sysMessageDao;
    @Autowired
    ExecutorService executorService;
    @Autowired
    MsgContentDao msgContentDao;
    @Autowired
    SendMessage sendMessage;
    //查询所有的委托房源
    public List<Rentaldemand> findAllRentData(Integer page, Integer size, Rentaldemand rentaldemand, User user){
        if (page!=null && size!=null){
            page=(page-1)*size;
        }

        return rentaldemandDao.findAllRentalData(page, size, rentaldemand,user);
    }
    //查询返回id的委托信息
    public Rentaldemand findOneData(Integer id){
        return rentaldemandDao.selectById(id);
    }
    //根据传递过来的id和uid更新对应的delflag的状态已经发送消息
    public int updateAndSendMess(int id,int uid){
        Rentaldemand rentaldemand=findOneData(id);
        rentaldemand.setDelFlag(true);

        MsgContent msgContent=new MsgContent();
        msgContent.setTitle("取消提醒！");
        msgContent.setMessage("您的订单已经被取消！");
        sendMessage.send(uid,msgContent);

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                Websocket.sendMessage(msgContent.getMessage(),uid);
            }
        });




       return rentaldemandDao.updateByPrimaryKey(rentaldemand);
    }
}
