package com.baizhi.controller;


import com.baizhi.entity.Course;
import com.baizhi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/findAll")
    public @ResponseBody Map<String,Object> findByPage(Integer page, Integer rows){
        Map<String,Object> map = new HashMap<String,Object>();
        Long totals = courseService.findTotals();
        List<Course> byPage = courseService.findByPage(page, rows);
        map.put("total",totals);
        map.put("rows",byPage);
        return map;
    }
    @RequestMapping("/save")
    public void save(Course course){
        courseService.save(course);
    }
    @RequestMapping("/delete")
    @ResponseBody
    public void delete(String id){
        courseService.remove(id);
    }
    @RequestMapping("/delBatchRows")
    @ResponseBody
    public String delBatchRows(String[] id) {
        for (String s : id) {
            courseService.remove(s);
        }
        return "redirect:/course/findAll";
    }
    @RequestMapping("/findOne")
    public @ResponseBody Course findOne(String id){
        return courseService.queryOne(id);
    }
    @RequestMapping("update")
    public void motify(Course course){
        courseService.motify(course);
    }
}
