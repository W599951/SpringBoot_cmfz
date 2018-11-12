package com.baizhi.service;

import com.baizhi.dao.CourseDao;
import com.baizhi.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CourseServiceImp implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public void save(Course course) {
        course.setId(UUID.randomUUID().toString());
        course.setCreateDate(new Date());
        courseDao.insert(course);
    }

    @Override
    public void remove(String id) {
        courseDao.delete(id);
    }

    @Override
    public void motify(Course course) {
        courseDao.update(course);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Course> findAll() {
        return courseDao.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Course queryOne(String id) {
        return courseDao.queryOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Course> findByPage(Integer page, Integer rows) {
        int start = (page-1)*rows;
        return courseDao.findByPage(start,rows);
    }

    @Override
    public Long findTotals() {
        return courseDao.findTotals();
    }
}
