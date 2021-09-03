package com.xl.houseonline.dao;

import com.xl.houseonline.entity.Rentaldemand;
import com.xl.houseonline.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface RentaldemandDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Rentaldemand record);

    int insertSelective(Rentaldemand record);

    Rentaldemand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Rentaldemand record);

    int updateByPrimaryKey(Rentaldemand record);
    List<Rentaldemand> findAllRentalData(@Param("page")Integer page,@Param("size") Integer size,@Param("rent") Rentaldemand rentaldemand,@Param("user")User user);
    Rentaldemand selectById(Integer id);

}