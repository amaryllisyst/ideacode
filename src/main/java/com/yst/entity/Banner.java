package com.yst.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Banner  implements Serializable {
    private String bannerId;
    private String bannerTitle;
    private String bannerImgPath;
    private String bannerDesc;
    private String bannerStatus;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date bannerDate;

    public String getBannerId() {
        return bannerId;
    }

    public void setBannerId(String bannerId) {
        this.bannerId = bannerId;
    }

    public String getBannerTitle() {
        return bannerTitle;
    }

    public void setBannerTitle(String bannerTitle) {
        this.bannerTitle = bannerTitle;
    }

    public String getBannerImgPath() {
        return bannerImgPath;
    }

    public void setBannerImgPath(String bannerImgPath) {
        this.bannerImgPath = bannerImgPath;
    }

    public String getBannerDesc() {
        return bannerDesc;
    }

    public void setBannerDesc(String bannerDesc) {
        this.bannerDesc = bannerDesc;
    }

    public String getBannerStatus() {
        return bannerStatus;
    }

    public void setBannerStatus(String bannerStatus) {
        this.bannerStatus = bannerStatus;
    }

    public Date getBannerDate() {
        return bannerDate;
    }

    public void setBannerDate(Date bannerDate) {
        this.bannerDate = bannerDate;
    }

    public Banner() {

    }

    @Override
    public String toString() {
        return "Banner{" +
                "bannerId='" + bannerId + '\'' +
                ", bannerTitle='" + bannerTitle + '\'' +
                ", bannerImgPath='" + bannerImgPath + '\'' +
                ", bannerDesc='" + bannerDesc + '\'' +
                ", bannerStatus='" + bannerStatus + '\'' +
                ", bannerDate=" + bannerDate +
                '}';
    }

    public Banner(String bannerTitle, String bannerImgPath, String bannerDesc, String bannerStatus, Date bannerDate) {
        this.bannerTitle = bannerTitle;
        this.bannerImgPath = bannerImgPath;
        this.bannerDesc = bannerDesc;
        this.bannerStatus = bannerStatus;
        this.bannerDate = bannerDate;
    }

    public Banner(String bannerId, String bannerTitle, String bannerImgPath, String bannerDesc, String bannerStatus, Date bannerDate) {
        this.bannerId = bannerId;
        this.bannerTitle = bannerTitle;
        this.bannerImgPath = bannerImgPath;
        this.bannerDesc = bannerDesc;
        this.bannerStatus = bannerStatus;
        this.bannerDate = bannerDate;
    }
}
