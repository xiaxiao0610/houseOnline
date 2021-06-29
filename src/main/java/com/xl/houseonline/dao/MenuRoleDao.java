package com.xl.houseonline.dao;

import com.xl.houseonline.entity.MenuRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface MenuRoleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(MenuRole record);

    int insertSelective(MenuRole record);

    MenuRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MenuRole record);

    int updateByPrimaryKey(MenuRole record);
    //通过rid删除掉对应的目录
    void deleteByRid(Integer rid);
    //再批量插入对于的权限
    Integer insertRecord(@Param("rid") Integer rid, @Param("mids") Integer[] mids);
}