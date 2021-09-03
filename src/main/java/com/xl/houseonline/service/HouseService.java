package com.xl.houseonline.service;

import com.xl.houseonline.config.Websocket;
import com.xl.houseonline.dao.HouseDao;
import com.xl.houseonline.dao.HouseInstallationDao;
import com.xl.houseonline.dao.HousebasicDao;
import com.xl.houseonline.entity.House;
import com.xl.houseonline.entity.Housebasic;
import com.xl.houseonline.entity.MsgContent;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.ExecutorService;

@Service
public class HouseService {
    @Autowired
    HouseDao houseDao;
    @Autowired
    HousebasicDao housebasicDao;
    @Autowired
    HouseInstallationDao houseInstallationDao;
    @Autowired
    SendMessage sendMessage;
    @Autowired
    ExecutorService executorService;

    public int insertIntoHouse(House house){
        house.setCreateTime(DateTime.now().getMillis());

        houseDao.insert(house);
        int id=house.getId();
        System.out.println(id);
        return id;

    }
    @Transactional
    public int insertHouseBasic(Housebasic housebasic,Integer id){
        housebasic.setHouseId(id);
        return housebasicDao.insertSelective(housebasic);

    }
    //插入ids的值
    public Boolean insertInstallation(Integer id,Integer[] iids){
        if (iids==null||iids.length==0){
            return true;
        }
        Integer result=houseInstallationDao.addInstallation(iids,id);
        return result==iids.length;

    }
    //所有待审核
    public List<House> all(Integer page,Integer size){
        if (page!=null&& size!=null){
            page=(page-1)*size;
        }
        List<House> houseList=houseDao.all(page, size);
        return houseList;

    }
    //根据id找到相关的信息
    public House findById(Integer id){
        return houseDao.findByID(id);
    }
    //修改上架的状态
    public int updatePublishState(Integer id,Integer uid){
        Boolean state=houseDao.selectByPrimaryKey(id).getPublishState();
        MsgContent msgContent=new MsgContent();


       if (state){

           houseDao.updatePublish(id,false);


       }else {

           houseDao.updatePublish(id,true);
           msgContent.setTitle("房源上架提醒！");
           msgContent.setMessage("您的房源已经上架！");
           sendMessage.send(uid,msgContent);
           executorService.execute(new Runnable() {
               @Override
               public void run() {
                   Websocket.sendMessage(msgContent.getMessage(), uid);
               }
           });



       }
    return     1;
    }
    //修改房源信息
    public int updateHouse(Housebasic housebasic){
     return    housebasicDao.updateByPrimaryKey(housebasic);
    }
    //更新房屋基础配置ids
    public boolean updateInstallation(Integer houseId,Integer[]ids){
        houseInstallationDao.deleteByHouseId(houseId);
        if (ids.length  == 0 || ids == null){
            return true;
        }
        Integer result=houseInstallationDao.addInstallation(ids,houseId);
        return result==ids.length;
    }

}
