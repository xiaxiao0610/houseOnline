package com.xl.houseonline.controller;

import com.xl.houseonline.entity.Admin;
import com.xl.houseonline.entity.RespData;
import com.xl.houseonline.entity.RespPage;
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
    public RespPage findAll(@RequestParam(defaultValue = "2") Integer page, @RequestParam(defaultValue = "5")Integer size){
        System.out.println(adminService.findAllAdmin(page, size));
        RespPage respPage=new RespPage();
        respPage.setTotal(adminService.count());
        respPage.setData(adminService.findAllAdmin(page, size));
        return respPage;
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
    @PostMapping("/admin/reg")
    public RespData add(String username,String password){
        if (adminService.addAdmin(username, password)==1){
           return RespData.success("ok");
        }
        else {
            return RespData.fail("fail");
        }
    }
    @DeleteMapping("/admin/delete/{id}")
    public int delete(@PathVariable("id")Integer id){
        return adminService.deleteAdmin(id);
    }
    @GetMapping("/admin/search")
    public RespPage SearchList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5")Integer size,String name){
        RespPage page1=new RespPage();
        page1.setTotal(adminService.searchCount(name));
        page1.setData(adminService.findSearch(page, size, name));
        System.out.println(adminService.findSearch(page, size, name));
        return page1;
    }
}
