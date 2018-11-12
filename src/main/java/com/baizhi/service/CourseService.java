package com.baizhi.service;

import com.baizhi.entity.Course;

import java.util.List;

public interface CourseService {
    public void save(Course course);

    public void remove(String id);

    public void motify(Course course);

    List<Course> findAll();

    Course queryOne(String id);

    List<Course> findByPage(Integer page, Integer rows);

    Long findTotals();
}
