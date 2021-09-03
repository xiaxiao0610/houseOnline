package com.xl.houseonline.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * rentaldemand
 * @author 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Rentaldemand implements Serializable {
    private Integer id;

    private Integer uid;

    /**
     * 区域
     */
    private String location;

    /**
     * 小区
     */
    private String community;

    /**
     * 楼
     */
    private String building;

    /**
     * 门牌
     */
    private String door;

    /**
     * 联系电话
     */
    private String demandPhone;

    /**
     * 申请状态
     */
    private Boolean demandState;

    /**
     * 删除标准
     */
    private Boolean delFlag;
    private User user;
    private String call;
    private Integer expectedPrice;//期望售价
    private Long createDate;

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public Integer getExpectedPrice() {
        return expectedPrice;
    }

    public void setExpectedPrice(Integer expectedPrice) {
        this.expectedPrice = expectedPrice;
    }

    public Rentaldemand() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    public String getDemandPhone() {
        return demandPhone;
    }

    public void setDemandPhone(String demandPhone) {
        this.demandPhone = demandPhone;
    }

    public Boolean getDemandState() {
        return demandState;
    }

    public void setDemandState(Boolean demandState) {
        this.demandState = demandState;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }
}