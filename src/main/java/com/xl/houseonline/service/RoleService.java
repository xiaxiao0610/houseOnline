package com.xl.houseonline.service;

import com.xl.houseonline.dao.AdminRoleDao;
import com.xl.houseonline.dao.RoleDao;
import com.xl.houseonline.entity.AdminRole;
import com.xl.houseonline.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleDao roleDao;
    @Autowired
    AdminRoleDao adminRoleDao;
    public List<Role> findAll(){
        return roleDao.findAll();
    }
    public List<Integer> findByAid(Integer adminId){
        return adminRoleDao.findByAid(adminId);
    }
    @Transactional
    public boolean InterIntoAdminRole(Integer adminid, Integer[] rids){
        adminRoleDao.deleteByAid(adminid);
        if (rids.length  == 0 || rids == null){
            return true;
        }
        Integer result=adminRoleDao.InsertAdminRole(adminid,rids);
        return result==rids.length;
    }
//    @Transactional
//    public boolean updateMenuRole(Integer rid, Integer[] mids) {
//        menuRoleDao.deleteByRid(rid);
//        if (mids == null || mids.length == 0) {
//            return true;
//        }
//        Integer result = menuRoleDao.insertRecord(rid, mids);
//        return result==mids.length;
//    }



}
