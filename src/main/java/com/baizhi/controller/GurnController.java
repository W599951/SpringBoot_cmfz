package com.baizhi.controller;


import com.baizhi.entity.Gurn;
import com.baizhi.service.GurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/gurn")
public class GurnController {

    @Autowired
    private GurnService gurnService;

    @RequestMapping("/findAll")
    public @ResponseBody Map<String,Object> findByPage(Integer page, Integer rows){
        Map<String,Object> map = new HashMap<String,Object>();
        Long totals = gurnService.findTotals();
        List<Gurn> byPage = gurnService.findByPage(page, rows);
        map.put("total",totals);
        map.put("rows",byPage);
        return map;
    }
    @RequestMapping("/save")
    public String save(Gurn gurn, MultipartFile file, HttpServletRequest request) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("back/easyui/gurn");
        System.out.println(realPath);
        file.transferTo(new File(realPath, file.getOriginalFilename()));
        gurn.setHeadPic(file.getOriginalFilename());
        gurnService.save(gurn);
        return null;
    }
    @RequestMapping("/delete")
    @ResponseBody
    public void delete(String id){
        gurnService.remove(id);
    }
    @RequestMapping("/delBatchRows")
    @ResponseBody
    public String delBatchRows(String[] id) {
        for (String s : id) {
            gurnService.remove(s);
        }
        return "redirect:/gurn/findAll";
    }
    @RequestMapping("/findOne")
    public @ResponseBody Gurn findOne(String id){
        return gurnService.queryOne(id);
    }
    @RequestMapping("update")
    @ResponseBody
    public void motify(Gurn gurn){
        System.out.println(gurn);
        gurnService.motify(gurn);
    }
}
