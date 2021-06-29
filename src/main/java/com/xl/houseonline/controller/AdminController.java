package com.xl.houseonline.controller;

import com.xl.houseonline.entity.Admin;
import com.xl.houseonline.entity.RespData;
import com.xl.houseonline.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    AdminService adminService;
    @GetMapping("/admin/message")
    public Admin findById(Authentication authentication){

        return (Admin) authentication.getPrincipal();
    }
    @GetMapping("/admin/getAll")
    public List<Admin> findAll(){
        System.out.println(adminService.findAllAdmin());
        return adminService.findAllAdmin();
    }
    @PutMapping("/admin/update")
    public RespData update(@RequestBody Admin admin,Authentication authentication){
//        adminService.updateMess(admin);
        if (adminService.updateMess(admin)==1){
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(admin, authentication.getCredentials(), authentication.getAuthorities()));
            return RespData.success("更新成功！");
        }
        return RespData.fail("更新失败！");

    }
}
