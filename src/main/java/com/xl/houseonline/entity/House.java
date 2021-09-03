package com.xl.houseonline.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * house
 * @author 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class House implements Serializable {
    private Integer id;

    /**
     * 用户的id
     */
    private Integer userId;

    /**
     * 经纪人的id
     */
    private Integer adminId;

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
     * 单元
     */
    private String unit;

    /**
     * 门牌
     */
    private String door;

    /**
     * 房屋描述
     */
    private String houseDescription;

    /**
     * 创建的时间
     */
    private Long createTime;

    /**
     * 删除状态
     */
    private Boolean deleteState;
    //上架状态
    private Boolean publishState;

    private List<HouseInstallation> houseInstallationList;
    private List<HouseImg> houseImgList;
    private Admin admin;
    private User user;
    private Housebasic housebasic;

    public Housebasic getHousebasic() {
        return housebasic;
    }

    public void setHousebasic(Housebasic housebasic) {
        this.housebasic = housebasic;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<HouseInstallation> getHouseInstallationList() {
        return houseInstallationList;
    }

    public void setHouseInstallationList(List<HouseInstallation> houseInstallationList) {
        this.houseInstallationList = houseInstallationList;
    }

    public List<HouseImg> getHouseImgList() {
        return houseImgList;
    }

    public void setHouseImgList(List<HouseImg> houseImgList) {
        this.houseImgList = houseImgList;
    }

    public Boolean getPublishState() {
        return publishState;
    }

    public void setPublishState(Boolean publishState) {
        this.publishState = publishState;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    public String getHouseDescription() {
        return houseDescription;
    }

    public void setHouseDescription(String houseDescription) {
        this.houseDescription = houseDescription;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Boolean getDeleteState() {
        return deleteState;
    }

    public void setDeleteState(Boolean deleteState) {
        this.deleteState = deleteState;
    }
}