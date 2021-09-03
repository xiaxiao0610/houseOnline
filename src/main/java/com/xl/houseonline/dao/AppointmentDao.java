package com.xl.houseonline.dao;

import com.xl.houseonline.entity.Appointment;
import com.xl.houseonline.entity.Rentaldemand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AppointmentDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Appointment record);

    int insertSelective(Appointment record);

    Appointment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Appointment record);

    int updateByPrimaryKey(Appointment record);

    //查询所有的正在等待经纪人的预约单
    List<Appointment> findAllStatus0(@Param("page")Integer page, @Param("size") Integer size, @Param("rent")Rentaldemand rentaldemand);
    //更新appointment里面的经纪人id
    int updateAdminIdOnAppointment(@Param("adminId") Integer adminId,@Param("id") Integer id);
    List<Appointment> findMine( Integer adminId);
    Appointment findOne(@Param("id")Integer id);

}