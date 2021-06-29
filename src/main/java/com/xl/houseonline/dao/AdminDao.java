package com.xl.houseonline.dao;

import com.xl.houseonline.entity.Admin;
import com.xl.houseonline.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
    @Select("select * from admin where username=#{username}")
    Admin findByUsername(String username);
    @Select("select r.* from role r,admin_role ar where ar.`rid`=r.`id` and ar.`adminid`=#{id}")
    List<Role> findAdminRolesById(int id);

//    @Select("select * from admin where id=#{id}")
    Admin findByUserID(Integer id);

    List<Admin> findAllAdmin(@Param("id") Integer id);


}