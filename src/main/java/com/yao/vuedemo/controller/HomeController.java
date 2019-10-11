package com.yao.vuedemo.controller;

import com.yao.vuedemo.ResultBean;
import com.yao.vuedemo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
    @ResponseBody
    public ResultBean uploadFile(@RequestBody MultipartFile multipartFile){
        try {
            byte[] bytes=multipartFile.getBytes();
            BufferedOutputStream stream=new BufferedOutputStream(new FileOutputStream(new File("D:/developkit/SPACEOFIDEA/vuedemo/src/main/resources/temp.jpg")));
            stream.write(bytes);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResultBean("成功上传");
    }

}
