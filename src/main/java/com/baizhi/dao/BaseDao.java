package com.baizhi.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDao<T> {
    T login(T t);

    public void insert(T t);

    public void delete(String id);

    public void update(T t);

    List<T> findAll();

    T queryOne(String id);

    //参数1:起始条数 //参数2:每页显示的记录数
    List<T> findByPage(@Param("start") Integer start, @Param("rows") Integer rows);

    Long findTotals();
}
