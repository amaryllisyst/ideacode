package com.yst.entity;

import java.io.Serializable;
import java.util.List;

public class Menu  implements Serializable {
    private String id;
    private String name;
    private String href;
    private String iconCls;
    private List<Menu> menus;

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", href='" + href + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", menus=" + menus +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public Menu(String id, String name, String href, String iconCls, List<Menu> menus) {

        this.id = id;
        this.name = name;
        this.href = href;
        this.iconCls = iconCls;
        this.menus = menus;
    }

    public Menu() {

    }
}
