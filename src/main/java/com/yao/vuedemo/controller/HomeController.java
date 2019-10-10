package com.yao.vuedemo.controller;

import com.yao.vuedemo.ResultBean;
import com.yao.vuedemo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private UserDao userDao;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(String name){
        String msg="hello,"+name;
        System.out.println(msg);
        return msg;
    }
    @RequestMapping("/findByName")
    @ResponseBody
    public List findByName(String name){
        return userDao.findByName(name);
    }
    @ResponseBody
    @RequestMapping("/login")
    public String login(String userName,String password){
        return userName+"登录成功";
    }

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public ResultBean getUserInfo(){
        return new ResultBean("用户");
    }

}
