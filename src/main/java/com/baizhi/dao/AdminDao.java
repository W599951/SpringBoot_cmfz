package com.baizhi.dao;

import com.baizhi.entity.Admin;

public interface AdminDao extends BaseDao<Admin> {
    Admin queryOneAdmin(String name);
}
