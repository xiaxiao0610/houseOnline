package com.xl.houseonline.service;

import com.xl.houseonline.dao.UserDao;
import com.xl.houseonline.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    public List<User> findAllByPage(Integer page,Integer size){
        if (page!=null&& size!=null){
            page=(page-1)*size;
        }
        List<User> userList=userDao.findAllPage(page, size);

          return userList;
    }
    public Integer UserCount(){
        return userDao.UserCount();
    }
    public boolean UpdateEnabled(Integer id){
        boolean result=userDao.selectByPrimaryKey(id).getEnabled();
        if (result){
            userDao.updateEnabled(id,false);
            return true;
        }else {
            userDao.updateEnabled(id,true);
            return true;
        }


    }
    public boolean UpdateSpeak(Integer id){
        boolean result=userDao.selectByPrimaryKey(id).getSpeak();
        if (result){
            userDao.updateSpeak(id,false);
            return true;
        }else {
            userDao.updateSpeak(id,true);
            return true;
        }


    }
}
