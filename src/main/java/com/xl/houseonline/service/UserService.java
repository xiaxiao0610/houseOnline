package com.xl.houseonline.service;

import com.xl.houseonline.dao.UserDao;
import com.xl.houseonline.entity.RespData;
import com.xl.houseonline.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserDao userDao;
    public List<User> findAllByPage(Integer page,Integer size,User user){
        if (page!=null&& size!=null){
            page=(page-1)*size;
        }
        List<User> userList=userDao.findAllPage(page, size,user);

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
    public int delIds(Integer[] delIds){
        return userDao.deleteIds(delIds);
    }
    //用户注册
    public RespData userReg(String username, String password){
//        System.out.println("2"+userDao.findByUserName(username));
        if (userDao.findByUserName(username)!=null){
            return RespData.fail("该用户存在");
        } else{
            BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
            String code=bCryptPasswordEncoder.encode(password);
            userDao.userReg(username, code);

        }
        return RespData.success("ok");



    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
    public RespData login(String username,String password){
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();

        User user=userDao.doLogin(username);

        if (user==null){
            return RespData.fail("请检查您的用户名！");
        }else {
           boolean checkPassword= bCryptPasswordEncoder.matches(password,user.getPassword());
           if (checkPassword){
               return RespData.success("ok",user);
           }else {
               return RespData.fail("密码错误！");
           }

        }
    }
}
