package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


public class Album {
    private String id;
    private String title;
    private String coverImg;
    private Integer count;
    private String author;
    private String broadCast;
    private String content;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;
    List<Chapter> children;

    public Album() {
    }

    public Album(String id, String title, String coverImg, Integer count, String author, String broadCast, String content, Date releaseDate, List<Chapter> children) {
        this.id = id;
        this.title = title;
        this.coverImg = coverImg;
        this.count = count;
        this.author = author;
        this.broadCast = broadCast;
        this.content = content;
        this.releaseDate = releaseDate;
        this.children = children;
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

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadCat() {
        return broadCast;
    }

    public void setBroadCat(String broadCast) {
        this.broadCast = broadCast;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", coverImg='" + coverImg + '\'' +
                ", count=" + count +
                ", author='" + author + '\'' +
                ", broadCast='" + broadCast + '\'' +
                ", content='" + content + '\'' +
                ", releaseDate=" + releaseDate +
                ", children=" + children +
                '}';
    }
}
