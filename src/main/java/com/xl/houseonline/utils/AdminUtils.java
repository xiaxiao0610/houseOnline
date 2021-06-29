package com.xl.houseonline.utils;

import com.xl.houseonline.entity.Admin;

import org.springframework.security.core.context.SecurityContextHolder;


public class AdminUtils {
    public static Admin getCurrentHr() {
        return ((Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
