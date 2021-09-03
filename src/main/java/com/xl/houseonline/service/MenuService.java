package com.xl.houseonline.service;

import com.xl.houseonline.dao.MenuDao;
import com.xl.houseonline.dao.MenuRoleDao;
import com.xl.houseonline.entity.Admin;
import com.xl.houseonline.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    MenuDao menuDao;
    @Autowired
    MenuRoleDao menuRoleDao;
    public List<Menu> findMenuById(){
        return menuDao.findMenuByAdminId(((Admin)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }
    //获取所有的目录明细
    public List<Menu>findAllMenus(){
        return menuDao.findAllMenus();
    }
    //点击获取到当前角色的默认x选择
public List<Integer> findMenuByRoleId(Integer rid){
        return menuDao.findMenuByRoleId(rid);
}
    @Transactional
    public boolean updateMenuRole(Integer rid, Integer[] mids) {
        menuRoleDao.deleteByRid(rid);
        if (mids == null || mids.length == 0) {
            return true;
        }
        Integer result = menuRoleDao.insertRecord(rid, mids);
        return result==mids.length;
    }
    //查询所以路径的角色
    public List<Menu> getAllMenusWithRole(){
        return menuDao.menuWithRole();
    }
}
