package com.xl.houseonline.dao;

import com.xl.houseonline.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MenuDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    //通过admin的id去获取对应的菜单
    List<Menu> findMenuByAdminId(Integer id);
    //过去所有的目录明细
    List<Menu> findAllMenus();
    //通过角色的Id获取到当前角色所具有的默认权限
    List<Integer> findMenuByRoleId(Integer rid);
}