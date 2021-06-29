package com.xl.houseonline.dao;

import com.xl.houseonline.entity.Political;

public interface PoliticalDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Political record);

    int insertSelective(Political record);

    Political selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Political record);

    int updateByPrimaryKey(Political record);
}