package com.baizhi.controller;


import com.baizhi.entity.Article;
import com.baizhi.service.ArticleService;
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
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/save")
    @ResponseBody
    public String save(Article article, MultipartFile file, HttpServletRequest request) throws IOException {
        System.out.println(article);
        String realPath = request.getSession().getServletContext().getRealPath("back/easyui/article");
        System.out.println(realPath);
        file.transferTo(new File(realPath, file.getOriginalFilename()));
        article.setImgPath(file.getOriginalFilename());
        articleService.save(article);
        return null;
    }

    @RequestMapping("/delBatchRows")
    @ResponseBody
    public String delBatchRows(String[] id) {
        for (String s : id) {
            articleService.remove(s);
        }
        return "redirect:/article/findAll";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public void delete(String id) {
        articleService.remove(id);
    }

    @RequestMapping("/findAll")
    public @ResponseBody
    Map<String, Object> findByPage(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Article> byPage = articleService.findByPage(page, rows);
        Long totals = articleService.findTotals();
        map.put("total", totals);
        map.put("rows", byPage);
        return map;
    }

    @RequestMapping("/findOne")
    public @ResponseBody
    Article findOne(String id) {
        return articleService.queryOne(id);
    }

    @RequestMapping("update")
    public @ResponseBody void motify(Article article){
        articleService.motify(article);

    }
}
