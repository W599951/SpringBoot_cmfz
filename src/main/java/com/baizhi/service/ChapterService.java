package com.baizhi.service;

import com.baizhi.entity.Chapter;

import java.util.List;

public interface ChapterService {
    public void save(Chapter chapter);

    public void remove(String id);

    public void motify(Chapter chapter);

    List<Chapter> findAll();

    Chapter queryOne(String id);

    List<Chapter> findByPage(Integer page, Integer rows);

    Long findTotals();
}
