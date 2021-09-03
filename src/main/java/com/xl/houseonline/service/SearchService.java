package com.xl.houseonline.service;

import com.xl.houseonline.dao.SearchTypeDao;
import com.xl.houseonline.entity.RespData;
import com.xl.houseonline.entity.SearchType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class SearchService {
    @Autowired
    SearchTypeDao searchTypeDao;
    public List<SearchType> findAll(){
        return searchTypeDao.findAll();
    }
    public  int add(String name,Integer pid){
        SearchType searchType=new SearchType();
        searchType.setName(name);
        searchType.setParentId(pid);
        return searchTypeDao.insertSelective(searchType);
    }
    public int delte(Integer id){
        return searchTypeDao.deleteByPrimaryKey(id);
    }
    public List<SearchType> findById(Integer id){
        return searchTypeDao.findById(id);
    }
    public RespData list(){
        List list=new ArrayList();

        List<SearchType> searchTypes=searchTypeDao.findAll();
        for (SearchType s: searchTypes
             ) {
            list=searchTypeDao.findById(s.getId());
            s.setChildren(list);




        }
        return RespData.success("ok",searchTypes);
    }
    public List<SearchType> AllWithChildren(){
        return searchTypeDao.SearchTypeWithChildren();
    }

}
