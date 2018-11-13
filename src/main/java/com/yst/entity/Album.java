package com.yst.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
//"一"的一方
public class Album  implements Serializable {
    @JsonProperty("id")
    private String albumId;
    private String title;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date albumPublishDate;
    private String albumConverPath;
    private Integer albumStar;
    private String albumAuthor;
    private String albumBroadCast;
    private String albumBrief;
    private List<Chapter> children;

    @Override
    public String toString() {
        return "Album{" +
                "albumId='" + albumId + '\'' +
                ", title='" + title + '\'' +
                ", albumPublishDate=" + albumPublishDate +
                ", albumConverPath='" + albumConverPath + '\'' +
                ", albumStar=" + albumStar +
                ", albumAuthor='" + albumAuthor + '\'' +
                ", albumBroadCast='" + albumBroadCast + '\'' +
                ", albumBrief='" + albumBrief + '\'' +
                ", children=" + children +
                '}';
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getAlbumPublishDate() {
        return albumPublishDate;
    }

    public void setAlbumPublishDate(Date albumPublishDate) {
        this.albumPublishDate = albumPublishDate;
    }

    public String getAlbumConverPath() {
        return albumConverPath;
    }

    public void setAlbumConverPath(String albumConverPath) {
        this.albumConverPath = albumConverPath;
    }

    public Integer getAlbumStar() {
        return albumStar;
    }

    public void setAlbumStar(Integer albumStar) {
        this.albumStar = albumStar;
    }

    public String getAlbumAuthor() {
        return albumAuthor;
    }

    public void setAlbumAuthor(String albumAuthor) {
        this.albumAuthor = albumAuthor;
    }

    public String getAlbumBroadCast() {
        return albumBroadCast;
    }

    public void setAlbumBroadCast(String albumBroadCast) {
        this.albumBroadCast = albumBroadCast;
    }

    public String getAlbumBrief() {
        return albumBrief;
    }

    public void setAlbumBrief(String albumBrief) {
        this.albumBrief = albumBrief;
    }

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }

    public Album(String albumId, String title, Date albumPublishDate, String albumConverPath, Integer albumStar, String albumAuthor, String albumBroadCast, String albumBrief) {

        this.albumId = albumId;
        this.title = title;
        this.albumPublishDate = albumPublishDate;
        this.albumConverPath = albumConverPath;
        this.albumStar = albumStar;
        this.albumAuthor = albumAuthor;
        this.albumBroadCast = albumBroadCast;
        this.albumBrief = albumBrief;
    }


    public Album(String albumId) {
        this.albumId = albumId;
    }

    public Album() {

    }
}
