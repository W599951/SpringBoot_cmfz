package com.baizhi.service;

import com.baizhi.entity.Carousel;

import java.util.List;

public interface CarouselService {
    public void save(Carousel carousel);

    public void remove(String id);

    public void motify(Carousel carousel);

    List<Carousel> findAll();

    Carousel queryOne(String id);

    List<Carousel> findByPage(Integer page, Integer rows);

    Long findTotals();
}
