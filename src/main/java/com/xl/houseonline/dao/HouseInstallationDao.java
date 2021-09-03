package com.xl.houseonline.dao;

import com.xl.houseonline.entity.HouseInstallation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface HouseInstallationDao {
    int deleteByPrimaryKey(Integer id);

    int insert(HouseInstallation record);

    int insertSelective(HouseInstallation record);

    HouseInstallation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HouseInstallation record);

    int updateByPrimaryKey(HouseInstallation record);
    int addInstallation(@Param("ids") Integer[]ids, @Param("houseId") Integer id);
    int deleteByHouseId(Integer id);
}