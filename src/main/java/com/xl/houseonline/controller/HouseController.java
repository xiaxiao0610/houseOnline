package com.xl.houseonline.controller;

import com.xl.houseonline.entity.House;
import com.xl.houseonline.entity.Housebasic;
import com.xl.houseonline.entity.RespData;
import com.xl.houseonline.entity.RespPage;
import com.xl.houseonline.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/house")
public class HouseController {
    @Autowired
    HouseService houseService;

    @PostMapping("/add")
    public RespData addHouse(@RequestBody House house){
        int id=houseService.insertIntoHouse(house);

        if (id>=0){
          return RespData.success("ok",id);
        }
        return   RespData.fail("fail");
    }
    @PostMapping("/addBasic")
    public RespData addBasic(@RequestBody  Housebasic housebasic,Integer id){
        System.out.println(housebasic);
        int resp=houseService.insertHouseBasic(housebasic,id);
        if (resp>=0){
            return RespData.success("ok",resp);
        }
return RespData.fail("fail");
    }
    @PostMapping("/addInstall")
    public RespData addInstall(Integer id,Integer[]ids){
        if (houseService.insertInstallation(id,ids)){
            return RespData.success("ok");
        }
        return RespData.fail("fail");
    }

    @GetMapping("/all")
    public RespPage all(@RequestParam(defaultValue = "2") Integer page, @RequestParam(defaultValue = "5")Integer size){
        RespPage respPage=new RespPage();
        respPage.setTotal(houseService.all(page, size).size());
        respPage.setData(houseService.all(page, size));
        return respPage;
    }
    @GetMapping("/findById/{id}")
    public House findByI(@PathVariable("id") Integer id){
        return houseService.findById(id);
    }
    //修改上架状态
    @PutMapping("/updatePublish/{id}/{uid}")
    public Integer update(@PathVariable("id") Integer id,@PathVariable("uid")Integer uid){
        return houseService.updatePublishState(id,uid);
    }
    @PutMapping("/updateHouse")
    public Integer update(@RequestBody Housebasic housebasic){
        return houseService.updateHouse(housebasic);
    }
    @PutMapping("/updateIns")
    public Boolean updateIns(Integer houseId,Integer[]ids){
      return   houseService.updateInstallation(houseId, ids);

    }


}
