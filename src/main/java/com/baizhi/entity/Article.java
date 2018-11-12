package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Article {
    private String id;
    private String title;
    private String content;
    private String imgPath;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;
    private String gurn_id;

    public Article() {
    }

    public Article(String id, String title, String content, String imgPath, Date releaseDate, String gurn_id) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.imgPath = imgPath;
        this.releaseDate = releaseDate;
        this.gurn_id = gurn_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGurn_id() {
        return gurn_id;
    }

    public void setGurn_id(String gurn_id) {
        this.gurn_id = gurn_id;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", releaseDate=" + releaseDate +
                ", gurn_id='" + gurn_id + '\'' +
                '}';
    }
}
