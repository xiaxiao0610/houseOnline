package com.xl.houseonline.controller;

import com.xl.houseonline.entity.Menu;
import com.xl.houseonline.entity.RespData;
import com.xl.houseonline.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {
    @Autowired
    MenuService menuService;

    @GetMapping("/system/menu")
    public List<Menu> findMenuById(){
        return menuService.findMenuById();
    }
    @GetMapping("/system/allMenus")
    public List<Menu>findAllMenu(){
        return menuService.findAllMenus();
    }
    @GetMapping("/system/findByRid/{rid}")
    public List<Integer>findMenuByRid(@PathVariable Integer rid){
        return menuService.findMenuByRoleId(rid);
    }
    @PutMapping("/system/updateMenusRole")
    public RespData updateMenuRole(Integer rid, Integer[] mids){
        if (menuService.updateMenuRole(rid, mids)){
            return RespData.success("success");
        }
        return RespData.fail("fail");
    }

}
