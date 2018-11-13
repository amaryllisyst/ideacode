package com.yst.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Cource  implements Serializable {
    private String courceId;
    private String courceTitle;
    private String courceMarking;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date courceCreateTime;
    private List<Counter> counters;


    @Override
    public String toString() {
        return "Cource{" +
                "courceId='" + courceId + '\'' +
                ", courceTitle='" + courceTitle + '\'' +
                ", courceMarking='" + courceMarking + '\'' +
                ", courceCreateTime=" + courceCreateTime +
                ", counters=" + counters +
                '}';
    }

    public String getCourceId() {
        return courceId;
    }

    public void setCourceId(String courceId) {
        this.courceId = courceId;
    }

    public String getCourceTitle() {
        return courceTitle;
    }

    public void setCourceTitle(String courceTitle) {
        this.courceTitle = courceTitle;
    }

    public String getCourceMarking() {
        return courceMarking;
    }

    public void setCourceMarking(String courceMarking) {
        this.courceMarking = courceMarking;
    }

    public Date getCourceCreateTime() {
        return courceCreateTime;
    }

    public void setCourceCreateTime(Date courceCreateTime) {
        this.courceCreateTime = courceCreateTime;
    }

    public List<Counter> getCounters() {
        return counters;
    }

    public void setCounters(List<Counter> counters) {
        this.counters = counters;
    }

    public Cource(String courceId, String courceTitle, String courceMarking, Date courceCreateTime, List<Counter> counters) {

        this.courceId = courceId;
        this.courceTitle = courceTitle;
        this.courceMarking = courceMarking;
        this.courceCreateTime = courceCreateTime;
        this.counters = counters;
    }

    public Cource() {

    }
}
