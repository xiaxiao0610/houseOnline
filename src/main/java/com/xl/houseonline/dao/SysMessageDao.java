package com.xl.houseonline.dao;

import com.xl.houseonline.entity.SysMessage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysMessageDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SysMessage record);

    int insertSelective(SysMessage record);

    SysMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysMessage record);

    int updateByPrimaryKey(SysMessage record);
}