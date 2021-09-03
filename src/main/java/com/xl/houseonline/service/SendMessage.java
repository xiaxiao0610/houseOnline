package com.xl.houseonline.service;

import com.xl.houseonline.dao.MsgContentDao;
import com.xl.houseonline.dao.SysMessageDao;
import com.xl.houseonline.entity.Admin;
import com.xl.houseonline.entity.MsgContent;
import com.xl.houseonline.entity.SysMessage;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SendMessage {

    @Autowired
    MsgContentDao msgContentDao;
    @Autowired
    SysMessageDao sysMessageDao;

    public void send(Integer uid,MsgContent msgContent){
//        MsgContent msgContent=new MsgContent();
//        msgContent.setTitle("取消提醒！");
//        msgContent.setMessage("您的订单已经被取消！");
        msgContent.setCreateDate(DateTime.now().getMillis());
        msgContentDao.insert(msgContent);
        int mid=msgContent.getId();//返回新增键的id
        System.out.println(mid);

        SysMessage sysMessage=new SysMessage();
        sysMessage.setAid(((Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
        sysMessage.setUid(uid);
        sysMessage.setMid(mid);
        sysMessageDao.insertSelective(sysMessage);
    }

}
