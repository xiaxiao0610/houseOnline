package com.xl.houseonline.dao;

import com.xl.houseonline.entity.AdminRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface AdminRoleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AdminRole record);

    int insertSelective(AdminRole record);

    AdminRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdminRole record);

    int updateByPrimaryKey(AdminRole record);
    List<Integer> findByAid(@Param(value = "adminId") Integer adminId);

    int deleteByAid(Integer adminid);

    Integer InsertAdminRole(@Param("adminid") Integer adminid,@Param("rids") Integer[] rids);
}