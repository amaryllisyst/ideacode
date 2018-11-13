package com.yst.entity;

import java.io.Serializable;

//上师表 与 文章表   “一” 的一方
//这边暂无两张表查询方法
public class Guru  implements Serializable {
    private String guruId;
    private String guruName;
    private String guruAvatar;//头像
    private String guruGender;//性别

    public Guru(String guruId, String guruName) {
        this.guruId = guruId;
        this.guruName = guruName;
    }

    @Override
    public String toString() {
        return "Guru{" +
                "guruId='" + guruId + '\'' +
                ", guruName='" + guruName + '\'' +
                ", guruAvatar='" + guruAvatar + '\'' +
                ", guruGender='" + guruGender + '\'' +
                '}';
    }

    public String getGuruId() {
        return guruId;
    }

    public void setGuruId(String guruId) {
        this.guruId = guruId;
    }

    public String getGuruName() {
        return guruName;
    }

    public void setGuruName(String guruName) {
        this.guruName = guruName;
    }

    public String getGuruAvatar() {
        return guruAvatar;
    }

    public void setGuruAvatar(String guruAvatar) {
        this.guruAvatar = guruAvatar;
    }

    public String getGuruGender() {
        return guruGender;
    }

    public void setGuruGender(String guruGender) {
        this.guruGender = guruGender;
    }

    public Guru(String guruId, String guruName, String guruAvatar, String guruGender) {

        this.guruId = guruId;
        this.guruName = guruName;
        this.guruAvatar = guruAvatar;
        this.guruGender = guruGender;
    }

    public Guru() {

    }
}
