package com.xl.houseonline.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * appointment
 * @author
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Appointment implements Serializable {
    private Integer id;

    /**
     * 房子的id
     */
    private Integer houseId;

    /**
     * 房东的id
     */
    private Integer userId;

    /**
     * 经纪人的id
     */
    private Integer adminId;

    /**
     * 委托信息id
     */
    private Integer rentalId;

    /**
     * 预约的日期
     */
    private Long appointmentDate;

    /**
     * 行程的状态,0--等待经纪人，1--看房中，2--已经完成
     */
    private Boolean appointmentStatus;

    /**
     * 创建的时间
     */
    private Long createDate;
    private Boolean success;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    private Rentaldemand rentaldemand;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Rentaldemand getRentaldemand() {
        return rentaldemand;
    }

    public void setRentaldemand(Rentaldemand rentaldemand) {
        this.rentaldemand = rentaldemand;
    }

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

    public Integer getRentalId() {
        return rentalId;
    }

    public void setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
    }

    public Long getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Long appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Boolean getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(Boolean appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }






}