package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
    public void save(User user);

    public void motify(User user);

    User login(User user);

    List<User> findAll();

    User queryOne(String id);

    List<User> findByPage(Integer page, Integer rows);

    Long findTotals();
}
