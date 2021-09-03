package com.xl.houseonline.dao;

import com.xl.houseonline.entity.Housebasic;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HousebasicDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Housebasic record);

    int insertSelective(Housebasic record);

    Housebasic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Housebasic record);

    int updateByPrimaryKey(Housebasic record);
}