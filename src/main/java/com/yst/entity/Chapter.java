package com.yst.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

//专辑有多个章节   album 有多个chapter    “多”的一方
//数量问题
public class Chapter  implements Serializable {
    @JsonProperty("id")
    private String chapterId;
    private String title;
    private Double chapterSize;//大小
    private String chapterDuration;//时长
    private String chapterDownloadPath;//路径
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date chapterUploadDate;
    private Album album;

    @Override
    public String toString() {
        return "Chapter{" +
                "chapterId='" + chapterId + '\'' +
                ", title='" + title + '\'' +
                ", chapterSize=" + chapterSize +
                ", chapterDuration=" + chapterDuration +
                ", chapterDownloadPath='" + chapterDownloadPath + '\'' +
                ", chapterUploadDate=" + chapterUploadDate +
                ", album=" + album +
                '}';
    }

    public String getChapterId() {
        return chapterId;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getChapterSize() {
        return chapterSize;
    }

    public void setChapterSize(Double chapterSize) {
        this.chapterSize = chapterSize;
    }

    public String getChapterDuration() {
        return chapterDuration;
    }

    public void setChapterDuration(String chapterDuration) {
        this.chapterDuration = chapterDuration;
    }

    public String getChapterDownloadPath() {
        return chapterDownloadPath;
    }

    public void setChapterDownloadPath(String chapterDownloadPath) {
        this.chapterDownloadPath = chapterDownloadPath;
    }

    public Date getChapterUploadDate() {
        return chapterUploadDate;
    }

    public void setChapterUploadDate(Date chapterUploadDate) {
        this.chapterUploadDate = chapterUploadDate;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Chapter(String chapterId, String title, Double chapterSize, String chapterDuration, String chapterDownloadPath, Date chapterUploadDate) {

        this.chapterId = chapterId;
        this.title = title;
        this.chapterSize = chapterSize;
        this.chapterDuration = chapterDuration;
        this.chapterDownloadPath = chapterDownloadPath;
        this.chapterUploadDate = chapterUploadDate;
    }

    public Chapter(String chapterId, String title, Double chapterSize, String chapterDuration, String chapterDownloadPath, Date chapterUploadDate, Album album) {

        this.chapterId = chapterId;
        this.title = title;
        this.chapterSize = chapterSize;
        this.chapterDuration = chapterDuration;
        this.chapterDownloadPath = chapterDownloadPath;
        this.chapterUploadDate = chapterUploadDate;
        this.album = album;
    }

    public Chapter() {

    }

    public Chapter(String chapterId, Album album) {
        this.chapterId = chapterId;
        this.album = album;
    }
}
