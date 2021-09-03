package com.xl.houseonline.dao;

import com.xl.houseonline.entity.HouseImg;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HouseImgDao {
    int deleteByPrimaryKey(Integer id);

    int insert(HouseImg record);

    int insertSelective(HouseImg record);

    HouseImg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HouseImg record);

    int updateByPrimaryKey(HouseImg record);
}