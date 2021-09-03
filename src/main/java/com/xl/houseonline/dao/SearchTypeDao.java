package com.xl.houseonline.dao;

import com.xl.houseonline.entity.SearchType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SearchTypeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SearchType record);

    int insertSelective(SearchType record);

    SearchType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SearchType record);

    int updateByPrimaryKey(SearchType record);
    //标签tab列表
    List<SearchType> findAll();
    List<SearchType> findById(@Param("id") Integer id);
    List<SearchType> SearchTypeWithChildren();//获取类别及其子类的属性

}