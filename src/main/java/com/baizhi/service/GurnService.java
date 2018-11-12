package com.baizhi.service;

import com.baizhi.entity.Gurn;

import java.util.List;

public interface GurnService {
    public void save(Gurn gurn);

    public void remove(String id);

    public void motify(Gurn gurn);

    List<Gurn> findAll();

    Gurn queryOne(String id);

    List<Gurn> findByPage(Integer page, Integer rows);

    Long findTotals();
}
