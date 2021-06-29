package com.xl.houseonline.entity;

import java.io.Serializable;

/**
 * role
 * @author 
 */
public class Role implements Serializable {
    private Integer id;

    private String name;

    /**
     * 角色名称
     */
    private String nameZh;
    private String label;
    private Integer value;

    public String getLabel() {
        return this.getNameZh();
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getValue() {
        return this.getId();
    }

    public void setValue(Integer value) {
        this.value = value;
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

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }
}