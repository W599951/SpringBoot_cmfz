package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("save")
    public String add(User user,String code){
        user.setPassword(DigestUtils.md5Hex(user.getPassword()+code));//MD5加密 密码
        user.setSalt(code);//设置颜值
        userService.save(user);
        //保存用户
        return null;
    }
    //用户登录
    @RequestMapping("/login")
    public String login(User user){
        User login = userService.login(user);//用户登录
        if(login!=null){
            return null;//登录成功进行流程跳转
        }else{
            return null;//登录失败
        }
    }

    //修改用户
    @RequestMapping("/update")
    public String update(User user){
        userService.motify(user);
        return null;
    }
}
