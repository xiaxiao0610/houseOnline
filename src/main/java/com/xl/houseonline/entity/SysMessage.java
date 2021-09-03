package com.xl.houseonline.entity;

import java.io.Serializable;

/**
 * sys_message
 * @author 
 */
public class SysMessage implements Serializable {
    private Integer id;

    /**
     * 消息id
     */
    private Integer mid;

    /**
     * 消息状态
     */
    private Integer state;

    /**
     * 消息类型
     */
    private Integer type;

    /**
     * 发送的adminId
     */
    private Integer aid;

    /**
     * 接收的uid
     */
    private Integer uid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}