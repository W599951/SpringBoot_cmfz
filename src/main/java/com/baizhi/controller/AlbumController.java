package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
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
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping("/save")
    @ResponseBody
    public String save(Album album, MultipartFile file, HttpServletRequest request) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("back/easyui/album");
        System.out.println(realPath);
        file.transferTo(new File(realPath, file.getOriginalFilename()));
        albumService.save(album);
        album.setCoverImg(file.getOriginalFilename());
        return null;
    }

    @RequestMapping("/findAll")
    public @ResponseBody Map<String, Object> findByPage(Integer page, Integer rows){
        Map<String, Object> map = new HashMap<String, Object>();
        List<Album> byPage = albumService.findByPage(page,rows);
        Long totals = albumService.findTotals();
        map.put("total",totals);
        map.put("rows",byPage);
        return map;
    }

    @RequestMapping("/delBatchRows")
    @ResponseBody
    public String delBatchRows(String[] id) {
        for (String s : id) {
            albumService.remove(s);
        }
        return "redirect:/article/findAll";
    }

    @RequestMapping("/delete")
    public void delete(String id) {
        albumService.remove(id);
    }
    @RequestMapping("/findOne")
    public @ResponseBody
    Album findOne(String id) {
        return albumService.queryOne(id);
    }

    @RequestMapping("update")
    public void motify(Album album){
        albumService.motify(album);

    }
}
