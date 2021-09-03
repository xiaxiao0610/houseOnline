package com.xl.houseonline.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

/**
 * user
 * @author 
 */

public class User implements Serializable {
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 住宅电话
     */
    private String telephone;

    /**
     * 联系地址
     */
    private String address;

    private Boolean enabled;
    private Boolean del;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    private String userface;

    private String remark;

    /**
     * 性别
     */
    private String gender;

    /**
     * 婚姻状况
     */
    private Object wedlock;

    /**
     * 民族
     */
    private Integer nationId;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 政治面貌
     */
    private Integer politicId;

    /**
     * 是否可留言状态
     */
    private Boolean speak;
    private Nation nation;
    private Political political;

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    public Political getPolitical() {
        return political;
    }

    public void setPolitical(Political political) {
        this.political = political;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }



    public void setUsername(String username) {
        this.username = username;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserface() {
        return userface;
    }

    public void setUserface(String userface) {
        this.userface = userface;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Object getWedlock() {
        return wedlock;
    }

    public void setWedlock(Object wedlock) {
        this.wedlock = wedlock;
    }

    public Integer getNationId() {
        return nationId;
    }

    public void setNationId(Integer nationId) {
        this.nationId = nationId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPoliticId() {
        return politicId;
    }

    public void setPoliticId(Integer politicId) {
        this.politicId = politicId;
    }

    public Boolean getSpeak() {
        return speak;
    }

    public void setSpeak(Boolean speak) {
        this.speak = speak;
    }

    public Boolean getDel() {
        return del;
    }

    public void setDel(Boolean del) {
        this.del = del;
    }



}