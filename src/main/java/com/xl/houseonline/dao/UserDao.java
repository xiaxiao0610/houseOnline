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
    List<User> findAllPage(@Param("page") Integer page, @Param("size") Integer size,@Param("user") User user);
    Integer UserCount();
    Integer updateEnabled(@Param("id") Integer id,@Param("enabled") Boolean enabled);
    Integer updateSpeak(@Param("id") Integer id,@Param("speak") Boolean speak);
    //删除选择的ids
    Integer deleteIds(@Param("delIds") Integer[] delIds);
    //根据查询该登录的账户是否存在
    User findByUserName(@Param("username") String username);
    Boolean userReg(@Param("username") String username,@Param("password") String password);
    //登录
    User doLogin(@Param("username") String username);
}