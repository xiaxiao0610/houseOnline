package com.xl.houseonline.controller;

import com.xl.houseonline.entity.RespData;
import com.xl.houseonline.entity.Role;
import com.xl.houseonline.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {
    @Autowired
    RoleService roleService;
    @GetMapping("/role/message")
    //查询所有的role角色信息
    public List<Role> findAllRoleMess(){
        return roleService.findAll();
    }
    @GetMapping("/adminRole/{adminId}")
    public List<Integer> findByAid(@PathVariable("adminId") Integer adminId){
        return roleService.findByAid(adminId);
    }
    @PutMapping("/adminRole/update")
    public RespData updateRole(Integer adminid,Integer[] rids){
        if (roleService.InterIntoAdminRole(adminid, rids)){
            return RespData.success("更新成功");
        }
        return RespData.fail("插入失败！");
    }
}
