package com.xl.houseonline.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * house_installation
 * @author 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HouseInstallation implements Serializable {
    private Integer id;

    /**
     * 房子的id
     */
    private Integer houseId;

    /**
     * 配置的id
     */
    private Integer iid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }
}