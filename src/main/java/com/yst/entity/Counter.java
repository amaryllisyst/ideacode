package com.yst.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Counter implements Serializable {
    private String CounterId;
    private String CounterTitle;
    private Integer CounterCount;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date CounterRecordDate;
    private User user;
    private Cource cource;

    public Counter(String counterId, String counterTitle, Integer counterCount, Date counterRecordDate, Cource cource) {
        CounterId = counterId;
        CounterTitle = counterTitle;
        CounterCount = counterCount;
        CounterRecordDate = counterRecordDate;
        this.cource = cource;
    }

    public Counter(String counterId, String counterTitle, Integer counterCount, Date counterRecordDate, User user) {

        CounterId = counterId;
        CounterTitle = counterTitle;
        CounterCount = counterCount;
        CounterRecordDate = counterRecordDate;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "CounterId='" + CounterId + '\'' +
                ", CounterTitle='" + CounterTitle + '\'' +
                ", CounterCount=" + CounterCount +
                ", CounterRecordDate=" + CounterRecordDate +
                ", user=" + user +
                ", cource=" + cource +
                '}';
    }

    public String getCounterId() {
        return CounterId;
    }

    public void setCounterId(String counterId) {
        CounterId = counterId;
    }

    public String getCounterTitle() {
        return CounterTitle;
    }

    public void setCounterTitle(String counterTitle) {
        CounterTitle = counterTitle;
    }

    public Integer getCounterCount() {
        return CounterCount;
    }

    public void setCounterCount(Integer counterCount) {
        CounterCount = counterCount;
    }

    public Date getCounterRecordDate() {
        return CounterRecordDate;
    }

    public void setCounterRecordDate(Date counterRecordDate) {
        CounterRecordDate = counterRecordDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cource getCource() {
        return cource;
    }

    public void setCource(Cource cource) {
        this.cource = cource;
    }

    public Counter() {

    }

    public Counter(String counterId, String counterTitle, Integer counterCount, Date counterRecordDate, User user, Cource cource) {

        CounterId = counterId;
        CounterTitle = counterTitle;
        CounterCount = counterCount;
        CounterRecordDate = counterRecordDate;
        this.user = user;
        this.cource = cource;
    }
}
