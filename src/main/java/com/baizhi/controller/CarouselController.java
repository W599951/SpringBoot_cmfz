package com.baizhi.controller;


import com.baizhi.entity.Carousel;
import com.baizhi.service.CarouselService;
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
@RequestMapping("/carousel")
public class CarouselController {

    @Autowired
    private CarouselService carouselService;

    @RequestMapping("/save")
    @ResponseBody
    public String save(Carousel carousel, MultipartFile file, HttpServletRequest request) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("back/easyui/carousel");
        System.out.println(realPath);
        file.transferTo(new File(realPath, file.getOriginalFilename()));
        carousel.setImgPath(file.getOriginalFilename());
        carouselService.save(carousel);
        return null;
    }

    @RequestMapping("/delBatchRows")
    @ResponseBody
    public String delBatchRows(String[] id) {
        for (String s : id) {
            carouselService.remove(s);
        }
        return "redirect:/carousel/findAll";
    }

    @RequestMapping("/delete")
    public void delete(String id) {
        carouselService.remove(id);
    }

    @RequestMapping("/findAll")
    public @ResponseBody
    Map<String, Object> findByPage(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Carousel> byPage = carouselService.findByPage(page, rows);
        Long totals = carouselService.findTotals();
        map.put("total", totals);
        map.put("rows", byPage);
        return map;
    }

    @RequestMapping("/findOne")
    public @ResponseBody
    Carousel findOne(String id) {
        return carouselService.queryOne(id);
    }

    @RequestMapping("update")
    public void motify(Carousel carousel){
        carouselService.motify(carousel);
    }
}
