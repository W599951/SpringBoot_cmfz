package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumService {
    public void save(Album album);

    public void remove(String id);

    public void motify(Album album);

    List<Album> findAll();

    Album queryOne(String id);

    List<Album> findByPage(Integer page, Integer rows);

    Long findTotals();
}
