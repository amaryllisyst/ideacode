package com.yst.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

//文章表  与 上师表（Guru）  多 对 一
public class Article  implements Serializable {
    private String articleId;
    private String articleTitle;
    private String articleImgPath;
    private String articleContent;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date articlePulishDate;
    private Guru guru;

    @Override
    public String toString() {
        return "Article{" +
                "articleId='" + articleId + '\'' +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleImgPath='" + articleImgPath + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articlePulishDate='" + articlePulishDate + '\'' +
                ", guru=" + guru +
                '}';
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleImgPath() {
        return articleImgPath;
    }

    public void setArticleImgPath(String articleImgPath) {
        this.articleImgPath = articleImgPath;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Date getArticlePulishDate() {
        return articlePulishDate;
    }

    public void setArticlePulishDate(Date articlePulishDate) {
        this.articlePulishDate = articlePulishDate;
    }

    public Guru getGuru() {
        return guru;
    }

    public void setGuru(Guru guru) {
        this.guru = guru;
    }

    public Article(String articleId, String articleTitle, String articleImgPath, String articleContent, Date articlePulishDate, Guru guru) {

        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.articleImgPath = articleImgPath;
        this.articleContent = articleContent;
        this.articlePulishDate = articlePulishDate;
        this.guru = guru;
    }

    public Article() {

    }
}
