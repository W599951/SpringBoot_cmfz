package com.baizhi.service;

import com.baizhi.entity.Admin;

public interface AdminService {
    void motity(Admin admin);
    Admin login(Admin admin);
    Admin queryOneAdmin(String name);
}
