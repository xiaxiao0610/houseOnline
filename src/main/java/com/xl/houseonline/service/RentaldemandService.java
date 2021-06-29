package com.xl.houseonline.service;

import com.xl.houseonline.dao.RentaldemandDao;
import com.xl.houseonline.entity.Rentaldemand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentaldemandService {
    @Autowired
    RentaldemandDao rentaldemandDao;
    //查询所有的委托房源
    public List<Rentaldemand> findAllRentData(){
        return rentaldemandDao.findAllRentalData();
    }
    //查询返回id的委托信息
    public Rentaldemand findOneData(Integer id){
        return rentaldemandDao.selectById(id);
    }
}
