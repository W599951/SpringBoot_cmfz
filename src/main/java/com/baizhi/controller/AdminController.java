package com.baizhi.controller;


import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/update")
    public @ResponseBody
    Map<String, Object> update(Admin admin, String oldpassword, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String,Object>();
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        Admin admin1 = adminService.queryOneAdmin(name);
        if (oldpassword.equals(admin1.getPassword())) {
            adminService.motity(admin);
            map.put("success", true);
        } else {
            map.put("success", false);
        }
        return map;
    }

    @RequestMapping("/login")
    public String login(Admin admin, HttpServletRequest request, HttpServletResponse response,String code) {
        HttpSession session = request.getSession();
        Admin admin1 = adminService.login(admin);
        String validationCode = (String) session.getAttribute("validationCode");
        if (validationCode.equals(code)) {
            if (admin1 != null) {
                session.setAttribute("name", admin1.getName());
                return "redirect:/back/main/main.jsp";
            } else {
                return "redirect:/back/user/login.jsp";
            }
        } else {
            return "redirect:/back/user/login.jsp";
        }
    }

    @RequestMapping("/exit")
    public String exit(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("name");
        return "redirect:/back/user/login.jsp";
    }
}
