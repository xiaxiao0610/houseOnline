package com.xl.houseonline.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * user
 * @author 
 */
//@JsonInclude(JsonInclude.Include.NON_NULL)
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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getTelephone() == null ? other.getTelephone() == null : this.getTelephone().equals(other.getTelephone()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getEnabled() == null ? other.getEnabled() == null : this.getEnabled().equals(other.getEnabled()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getUserface() == null ? other.getUserface() == null : this.getUserface().equals(other.getUserface()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getWedlock() == null ? other.getWedlock() == null : this.getWedlock().equals(other.getWedlock()))
            && (this.getNationId() == null ? other.getNationId() == null : this.getNationId().equals(other.getNationId()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getPoliticId() == null ? other.getPoliticId() == null : this.getPoliticId().equals(other.getPoliticId()))
            && (this.getSpeak() == null ? other.getSpeak() == null : this.getSpeak().equals(other.getSpeak()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getTelephone() == null) ? 0 : getTelephone().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getEnabled() == null) ? 0 : getEnabled().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getUserface() == null) ? 0 : getUserface().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getWedlock() == null) ? 0 : getWedlock().hashCode());
        result = prime * result + ((getNationId() == null) ? 0 : getNationId().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getPoliticId() == null) ? 0 : getPoliticId().hashCode());
        result = prime * result + ((getSpeak() == null) ? 0 : getSpeak().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", phone=").append(phone);
        sb.append(", telephone=").append(telephone);
        sb.append(", address=").append(address);
        sb.append(", enabled=").append(enabled);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", userface=").append(userface);
        sb.append(", remark=").append(remark);
        sb.append(", gender=").append(gender);
        sb.append(", wedlock=").append(wedlock);
        sb.append(", nationId=").append(nationId);
        sb.append(", email=").append(email);
        sb.append(", politicId=").append(politicId);
        sb.append(", speak=").append(speak);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}