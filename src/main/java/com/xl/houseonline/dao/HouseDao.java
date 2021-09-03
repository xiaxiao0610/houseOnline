package com.xl.houseonline.dao;

import com.xl.houseonline.entity.House;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HouseDao {
    int deleteByPrimaryKey(Integer id);

    int insert(House record);

    int insertSelective(House record);

    House selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(@Param("id")Integer id,@Param("community") String community);

    int updateByPrimaryKey(House record);

    List<House> all(@Param("page") Integer page, @Param("size") Integer size);
    House findByID(@Param("id") Integer id);
    Integer updatePublish(@Param("id")Integer id,@Param("state") Boolean state);



}