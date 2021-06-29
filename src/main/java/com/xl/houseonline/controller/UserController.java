package com.xl.houseonline.controller;

import com.xl.houseonline.entity.RespData;
import com.xl.houseonline.entity.RespPage;
import com.xl.houseonline.entity.User;
import com.xl.houseonline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/getAll")
    public RespPage findAllByPage(@RequestParam(defaultValue = "2") Integer page, @RequestParam(defaultValue = "5")Integer size){
        RespPage respPage=new RespPage();
        respPage.setTotal(userService.UserCount());
        respPage.setData(userService.findAllByPage(page, size));
        return respPage;
    }
    @PutMapping("/updateEnabled")
    public RespData updateEnabled(Integer id){
        if (userService.UpdateEnabled(id)){
            return RespData.success("success");
        }else {
            return RespData.fail("fail");
        }

    }
    @PutMapping("/updateSpeak")
    public RespData updateSpeak(Integer id){
        if (userService.UpdateSpeak(id)){
            return RespData.success("success");
        }else {
            return RespData.fail("fail");
        }

    }
}
