package com.xl.houseonline.controller;

import com.xl.houseonline.entity.RespData;
import com.xl.houseonline.entity.SearchType;
import com.xl.houseonline.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    SearchService searchService;
    @GetMapping("/")
    public List<SearchType> findAll(){
        return searchService.findAll();
    }
    @PostMapping("/add")
    public int add(String name,Integer pid){
        return searchService.add(name, pid);
    }
    @DeleteMapping("/{id}")
    public int del(@PathVariable("id")Integer id){
        return searchService.delte(id);
    }
    @GetMapping("/get/{id}")
    public List<SearchType> findById(@PathVariable("id")Integer id){
        return searchService.findById(id);
    }
    @GetMapping("/getSearchType")
    public RespData getSearchType(){
        return searchService.list();
    }
    @GetMapping("/allWithChildren")
    public HashMap allWithChildren(){
        List<SearchType> list=searchService.AllWithChildren();
        HashMap<String,List<SearchType>> hashMap=new HashMap();
        for (SearchType s:list
             ) {
            hashMap.put(s.getEn(),s.getChildren());

        }
        return hashMap;
    }



}
