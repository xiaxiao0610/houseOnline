package com.xl.houseonline.dao;

import com.xl.houseonline.entity.MsgContent;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MsgContentDao {
    int deleteByPrimaryKey(Integer id);

    int insert(MsgContent record);

    int insertSelective(MsgContent record);

    MsgContent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MsgContent record);

    int updateByPrimaryKey(MsgContent record);
}