package com.baizhi.service;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImp implements AdminService {

    @Autowired
    private AdminDao adminDao;
    @Override
    public void motity(Admin admin) {
        adminDao.update(admin);
    }

    @Override
    public Admin login(Admin admin) {
        return adminDao.login(admin);
    }

    @Override
    public Admin queryOneAdmin(String name) {
        return adminDao.queryOneAdmin(name);
    }
}
