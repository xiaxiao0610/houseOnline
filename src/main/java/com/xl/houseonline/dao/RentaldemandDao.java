package com.xl.houseonline.dao;

import com.xl.houseonline.entity.Rentaldemand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface RentaldemandDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Rentaldemand record);

    int insertSelective(Rentaldemand record);

    Rentaldemand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Rentaldemand record);

    int updateByPrimaryKey(Rentaldemand record);
    List<Rentaldemand> findAllRentalData();
    Rentaldemand selectById(Integer id);
}