package com.xl.houseonline.config;

import com.xl.houseonline.entity.Menu;
import com.xl.houseonline.entity.Role;
import com.xl.houseonline.service.AdminService;

import com.xl.houseonline.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

//通过当前的请求地址，获取地址需要的用户角色
@Component
public class UrlFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    AdminService adminService;
    @Autowired
    MenuService menuService;
    AntPathMatcher antPathMatcher=new AntPathMatcher();
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //获取当前请求的url
        String requestUrl=((FilterInvocation) o).getRequestUrl();
        if ("/login".equals(requestUrl)){
            return null;
        }
        List<Menu> menusWithRole=menuService.getAllMenusWithRole();
        //获取到该路径下的所有的需要的角色集合
        for (Menu menu:menusWithRole){
            if (antPathMatcher.match(menu.getUrl(), requestUrl)&&menu.getRoles().size()>0){
                List<Role> roles=menu.getRoles();
                int size=roles.size();
                String[] values=new String[size];
                for (int i=0;i<size;i++){
                    values[i]=roles.get(i).getName();
                }
                return SecurityConfig.createList(values);
            }

        }
//        System.out.println("test1");
//        List<Menu> allMenu=menuService.getAllMenu();
//        for (Menu menu:allMenu){
//            if (antPathMatcher.match(menu.getUrl(),requestUrl)&&menu.getRoles().size()>0){
//                List<Role> roles=menu.getRoles();
//                int size=roles.size();
//                String [] values=new String[size];
//                for (int i=0;i<size;i++){
//                    values[i]=roles.get(i).getName();
//                }
//                return SecurityConfig.createList(values);
//            }
//        }



//        return SecurityConfig.createList("ROLE_LOGIN");
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
