package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void save(User user) {
        userDao.insert(user);
    }

    @Override
    public void motify(User user) {
        userDao.update(user);
    }

    @Override
    public User login(User user) {
        return userDao.login(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User queryOne(String id) {
        return userDao.queryOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> findByPage(Integer page, Integer rows) {
        int start = (page-1)*rows;
        return userDao.findByPage(start,rows);
    }

    @Override
    public Long findTotals() {
        return userDao.findTotals();
    }
}
