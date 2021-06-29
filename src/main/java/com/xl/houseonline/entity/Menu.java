package com.xl.houseonline.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

/**
 * menu
 * @author 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Menu implements Serializable {
    private Integer id;

    /**
     * 对应的路径
     */
    private String url;

    private String path;

    private String component;

    private String name;

    private String iconCls;

    private Boolean keepAlive;

    /**
     * 用于登录拦截
     */
    private Boolean requireAuth;

    private Integer parentId;

    private Boolean enabled;
    private Meta meta;
    private String label;
    private String icon;
    private Integer value;

    public Integer getValue() {
        return this.getId();
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getIcon() {
        return this.getIconCls();
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    private List<Menu> children;
    private List<Role> roles;

    public String getLabel() {
        return this.getName();
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public Boolean getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(Boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public Boolean getRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(Boolean requireAuth) {
        this.requireAuth = requireAuth;
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