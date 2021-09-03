package com.xl.houseonline.service;

import com.xl.houseonline.dao.AdminDao;
import com.xl.houseonline.dao.MenuDao;
import com.xl.houseonline.dao.UserDao;
import com.xl.houseonline.entity.Admin;
import com.xl.houseonline.entity.Menu;
import com.xl.houseonline.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements UserDetailsService {
    @Autowired
    AdminDao adminDao;
    @Autowired
    UserDao userDao;
    @Autowired
    MenuDao menuDao;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //查询是否有该用户名
        Admin admin=adminDao.findByUsername(s);
        //用户名
//        User user=userDao.findByUserName(s);
        //没有的话抛出异常
        if (admin==null){
            throw new UsernameNotFoundException("用户名不存在");
        }
//        if (user==null){
//            throw  new UsernameNotFoundException("用户不存在");
//        }
        //有的话根据获取到的id，获取到它的所有权限
        admin.setRoles(adminDao.findAdminRolesById(admin.getId()));
        return admin;
    }
    //获取个人信息
    public Admin findByUserID(){
        return adminDao.findByUserID(((Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }
    //获取所有的admin表的信息
    public List<Admin> findAllAdmin(Integer page,Integer size){
        if (page!=null&& size!=null){
            page=(page-1)*size;
        }
        System.out.println(((Admin)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
        return adminDao.findAllAdmin(((Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId(),page,size);
    }
    //更新信息
    public Integer updateMess(Admin admin){
        return adminDao.updateByPrimaryKeySelective(admin);
    }
    //添加管理员人员账号
    public int addAdmin(String username,String password){
        if (adminDao.findByUsername(username)!=null){
            return -1;
        }
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        String code=bCryptPasswordEncoder.encode(password);
        return adminDao.AdminReg(username,code);
    }
    //删除admin
    public int deleteAdmin(Integer id){
        return adminDao.deleteByPrimaryKey(id);
    }
    public int count(){
        return adminDao.count();
    }
    public List<Admin> findSearch(Integer page,Integer size,String name){
        if (page!=null&& size!=null){
            page=(page-1)*size;
        }
        return adminDao.findAdminSearch(page, size, name);
    }
    public int searchCount(String name){
        return adminDao.likeCount(name);
    }

}
