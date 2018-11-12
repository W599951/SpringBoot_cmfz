package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Chapter {
    private String id;
    private String title;
    private String size;
    private String duration;
    private String downLoadPath;
    private String album_id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date upLoadDate;

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", size='" + size + '\'' +
                ", duration='" + duration + '\'' +
                ", downLoadPath='" + downLoadPath + '\'' +
                ", album_id='" + album_id + '\'' +
                ", upLoadDate=" + upLoadDate +
                '}';
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDownLoadPath() {
        return downLoadPath;
    }

    public void setDownLoadPath(String downLoadPath) {
        this.downLoadPath = downLoadPath;
    }

    public String getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(String album_id) {
        this.album_id = album_id;
    }

    public Date getUpLoadDate() {
        return upLoadDate;
    }

    public void setUpLoadDate(Date upLoadDate) {
        this.upLoadDate = upLoadDate;
    }

    public Chapter(String id, String title, String size, String duration, String downLoadPath, String album_id, Date upLoadDate) {
        this.id = id;
        this.title = title;
        this.size = size;
        this.duration = duration;
        this.downLoadPath = downLoadPath;
        this.album_id = album_id;
        this.upLoadDate = upLoadDate;
    }

    public Chapter() {
    }
}
