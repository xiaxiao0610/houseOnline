package com.xl.houseonline.service;

import com.xl.houseonline.dao.AdminDao;
import com.xl.houseonline.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements UserDetailsService {
    @Autowired
    AdminDao adminDao;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //查询是否有该用户名
        Admin admin=adminDao.findByUsername(s);
        //没有的话抛出异常
        if (admin==null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        //有的话根据获取到的id，获取到它的所有权限
        admin.setRoles(adminDao.findAdminRolesById(admin.getId()));
        return admin;
    }
    //获取个人信息
    public Admin findByUserID(){
        return adminDao.findByUserID(((Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }
    //获取所有的admin表的信息
    public List<Admin> findAllAdmin(){
        System.out.println(((Admin)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
        return adminDao.findAllAdmin(((Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }
    //更新信息
    public Integer updateMess(Admin admin){
        return adminDao.updateByPrimaryKeySelective(admin);
    }
}
