package com.baizhi.service;

import com.baizhi.entity.Counter;

import java.util.List;

public interface CounterService {
    public void save(Counter counter);

    public void remove(String id);

    public void motify(Counter counter);

    List<Counter> findAll();

    Counter queryOne(String id);

    List<Counter> findByPage(Integer page, Integer rows);

    Long findTotals();
}
