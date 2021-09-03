package com.xl.houseonline.controller;

import com.xl.houseonline.dao.HouseImgDao;
import com.xl.houseonline.entity.HouseImg;
import com.xl.houseonline.entity.RespData;
import com.xl.houseonline.utils.TencentUploadUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
public class UploadController {
    @Autowired
    HouseImgDao houseImgDao;

    SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
    @PostMapping("/import/{id}")
    public RespData importData(MultipartFile file, HttpServletRequest req, @PathVariable("id") Integer id) throws IOException {
        String format = sdf.format(new Date());
        String realPath = req.getServletContext().getRealPath("/upload") + format;
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        System.out.println(folder.getAbsolutePath());
        String oldName = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
        file.transferTo(new File(folder,newName));
        String url = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/upload" + format + newName;
        System.out.println(url);
//        String url1=folder.getAbsolutePath()+""+newName;
        File file1=new File(folder.getAbsolutePath()+"/"+newName);
        String result=TencentUploadUtil.uploadFile("xlmall/images/"+format+newName,file1);
        HouseImg houseImg=new HouseImg();
        houseImg.setHouseId(id);
        houseImg.setImg(result);
//        houseImg.setIndex(1);
        houseImgDao.insertSelective(houseImg);


        return RespData.success("上传成功!");
    }
    @PostMapping("/importIndex/{id}")
    public RespData importIndex(MultipartFile file, HttpServletRequest req, @PathVariable("id") Integer id) throws IOException {
        String format = sdf.format(new Date());
        String realPath = req.getServletContext().getRealPath("/upload") + format;
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        System.out.println(folder.getAbsolutePath());
        String oldName = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
        file.transferTo(new File(folder,newName));
        String url = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/upload" + format + newName;
        System.out.println(url);
//        String url1=folder.getAbsolutePath()+""+newName;
        File file1=new File(folder.getAbsolutePath()+"/"+newName);
        String result=TencentUploadUtil.uploadFile("xlmall/images/"+format+newName,file1);
        HouseImg houseImg=new HouseImg();
        houseImg.setHouseId(id);
        houseImg.setImg(result);
        houseImg.setIndex(1);

        houseImgDao.insertSelective(houseImg);


        return RespData.success("上传成功!");
    }

}
