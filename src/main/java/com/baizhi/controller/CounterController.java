package com.baizhi.controller;


import com.baizhi.entity.Counter;
import com.baizhi.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/counter")
public class CounterController {

    @Autowired
    private CounterService counterService;

    @RequestMapping("/findAll")
    public @ResponseBody Map<String,Object> findByPage(Integer page, Integer rows){
        Map<String,Object> map = new HashMap<String,Object>();
        Long totals = counterService.findTotals();
        List<Counter> byPage = counterService.findByPage(page, rows);
        map.put("total",totals);
        map.put("rows",byPage);
        return map;
    }
    @RequestMapping("/save")
    public void save(Counter counter){
        counterService.save(counter);
    }
    @RequestMapping("/delete")
    @ResponseBody
    public void delete(String id){
        counterService.remove(id);
    }
    @RequestMapping("/delBatchRows")
    @ResponseBody
    public String delBatchRows(String[] id) {
        for (String s : id) {
            counterService.remove(s);
        }
        return "redirect:/counter/findAll";
    }
    @RequestMapping("/findOne")
    public @ResponseBody Counter findOne(String id){
        return counterService.queryOne(id);
    }
    @RequestMapping("update")
    public  void motify(Counter counter){
        counterService.motify(counter);
    }
}
