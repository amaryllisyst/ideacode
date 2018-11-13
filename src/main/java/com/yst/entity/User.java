package com.yst.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable {
    private String userId;
    private String userPhone;
    private String userNickname;
    private String userRealname;
    private String userPassword;
    private String userSalt;

    public String getUserSalt() {
        return userSalt;
    }

    public void setUserSalt(String userSalt) {
        this.userSalt = userSalt;
    }

    private String userProvince;
    private String userCity;
    private String userAvatar;//头像
    private String userSign;
    private String userGender;//性别
    private String userStatus;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date userDate;
    private List<Counter> counters;

    public User(String userId, String userPhone, String userNickname, String userRealname, String userPassword, String userSalt, String userProvince, String userCity, String userAvatar, String userSign, String userGender, String userStatus, Date userDate) {
        this.userId = userId;
        this.userPhone = userPhone;
        this.userNickname = userNickname;
        this.userRealname = userRealname;
        this.userPassword = userPassword;
        this.userSalt = userSalt;
        this.userProvince = userProvince;
        this.userCity = userCity;
        this.userAvatar = userAvatar;
        this.userSign = userSign;
        this.userGender = userGender;
        this.userStatus = userStatus;
        this.userDate = userDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", userRealname='" + userRealname + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userSalt='" + userSalt + '\'' +
                ", userProvince='" + userProvince + '\'' +
                ", userCity='" + userCity + '\'' +
                ", userAvatar='" + userAvatar + '\'' +
                ", userSign='" + userSign + '\'' +
                ", userGender='" + userGender + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", userDate=" + userDate +
                ", counters=" + counters +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserRealname() {
        return userRealname;
    }

    public void setUserRealname(String userRealname) {
        this.userRealname = userRealname;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserSex() {
        return userSalt;
    }

    public void setUserSex(String userSalt) {
        this.userSalt = userSalt;
    }

    public String getUserProvince() {
        return userProvince;
    }

    public void setUserProvince(String userProvince) {
        this.userProvince = userProvince;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUserSign() {
        return userSign;
    }

    public void setUserSign(String userSign) {
        this.userSign = userSign;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public Date getUserDate() {
        return userDate;
    }

    public void setUserDate(Date userDate) {
        this.userDate = userDate;
    }

    public List<Counter> getCounters() {
        return counters;
    }

    public void setCounters(List<Counter> counters) {
        this.counters = counters;
    }

    public User(String userId, String userPhone, String userNickname, String userRealname, String userPassword, String userSalt, String userProvince, String userCity, String userAvatar, String userSign, String userGender, String userStatus, Date userDate, List<Counter> counters) {

        this.userId = userId;
        this.userPhone = userPhone;
        this.userNickname = userNickname;
        this.userRealname = userRealname;
        this.userPassword = userPassword;
        this.userSalt = userSalt;
        this.userProvince = userProvince;
        this.userCity = userCity;
        this.userAvatar = userAvatar;
        this.userSign = userSign;
        this.userGender = userGender;
        this.userStatus = userStatus;
        this.userDate = userDate;
        this.counters = counters;
    }

    public User() {

    }
}
