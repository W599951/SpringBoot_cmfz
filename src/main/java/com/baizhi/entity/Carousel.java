package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Carousel {
    private String id;
    private String title;
    private String imgPath;
    private String status;
    private Integer ordernum;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createDate;

    public Carousel() {
    }

    public Carousel(String id, String title, String imgPath, String status, Integer ordernum, Date createDate) {
        this.id = id;
        this.title = title;
        this.imgPath = imgPath;
        this.status = status;
        this.ordernum = ordernum;
        this.createDate = createDate;
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

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getOrder() {
        return ordernum;
    }

    public void setOrder(Integer ordernum) {
        this.ordernum = ordernum;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Carousel{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", status='" + status + '\'' +
                ", ordernum=" + ordernum +
                ", createDate=" + createDate +
                '}';
    }

    public Carousel(String id, String title, String imgPath, String status, Date createDate) {
        this.id = id;
        this.title = title;
        this.imgPath = imgPath;
        this.status = status;
        this.createDate = createDate;
    }
}
