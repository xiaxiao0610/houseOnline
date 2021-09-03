package com.xl.houseonline.controller;

import com.xl.houseonline.entity.RespData;
import com.xl.houseonline.entity.RespPage;
import com.xl.houseonline.entity.User;
import com.xl.houseonline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/basic")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/getAll")
    public RespPage findAllByPage(@RequestParam(defaultValue = "2") Integer page, @RequestParam(defaultValue = "5")Integer size,User user){
        RespPage respPage=new RespPage();
        respPage.setTotal(userService.UserCount());
        respPage.setData(userService.findAllByPage(page, size,user));
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
    @DeleteMapping("/")
    public int  delIds(Integer[] delIds){
        return userService.delIds(delIds);
    }
    @PostMapping("/reg/{username}/{password}")
    public RespData userReg( @PathVariable("username") String username,@PathVariable("password") String password){
        return userService.userReg(username, password);
    }
    @PostMapping("/doLogin/{username}/{password}")
    public  RespData doLogin(@PathVariable("username") String username,@PathVariable("password") String password){
        return userService.login(username, password);
    }
}
