package com.xl.houseonline.dao;

import com.xl.houseonline.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    //分页查询user列表的用户
    List<User> findAllPage(@Param("page") Integer page, @Param("size") Integer size);
    Integer UserCount();
    Integer updateEnabled(@Param("id") Integer id,@Param("enabled") Boolean enabled);
    Integer updateSpeak(@Param("id") Integer id,@Param("speak") Boolean speak);
}