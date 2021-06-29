package com.xl.houseonline.entity;

import java.io.Serializable;

/**
 * appointment
 * @author 
 */
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
        Appointment other = (Appointment) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getHouseId() == null ? other.getHouseId() == null : this.getHouseId().equals(other.getHouseId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getAdminId() == null ? other.getAdminId() == null : this.getAdminId().equals(other.getAdminId()))
            && (this.getRentalId() == null ? other.getRentalId() == null : this.getRentalId().equals(other.getRentalId()))
            && (this.getAppointmentDate() == null ? other.getAppointmentDate() == null : this.getAppointmentDate().equals(other.getAppointmentDate()))
            && (this.getAppointmentStatus() == null ? other.getAppointmentStatus() == null : this.getAppointmentStatus().equals(other.getAppointmentStatus()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getHouseId() == null) ? 0 : getHouseId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getAdminId() == null) ? 0 : getAdminId().hashCode());
        result = prime * result + ((getRentalId() == null) ? 0 : getRentalId().hashCode());
        result = prime * result + ((getAppointmentDate() == null) ? 0 : getAppointmentDate().hashCode());
        result = prime * result + ((getAppointmentStatus() == null) ? 0 : getAppointmentStatus().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", houseId=").append(houseId);
        sb.append(", userId=").append(userId);
        sb.append(", adminId=").append(adminId);
        sb.append(", rentalId=").append(rentalId);
        sb.append(", appointmentDate=").append(appointmentDate);
        sb.append(", appointmentStatus=").append(appointmentStatus);
        sb.append(", createDate=").append(createDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}