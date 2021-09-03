package com.xl.houseonline.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

/**
 * search_type
 * @author 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SearchType implements Serializable {
    private Integer id;

    private String name;

    private Integer parentId;

    private Boolean enabled;
    private List<SearchType> children;
    private String en;
    private String label;
    private String value;

    public String getLabel() {
        return name;
    }

    public String getValue() {
        return name;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public List<SearchType> getChildren() {
        return children;
    }

    public void setChildren(List<SearchType> children) {
        this.children = children;
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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}