package com.yao.vuedemo.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    @Autowired
    protected SqlSessionTemplate sessionTemplate;

    public List findByName(String name){
        PageHelper.startPage(1,2);
        PageInfo pageInfo=new PageInfo<>(sessionTemplate.selectList("UserMapper.findByName",name));
        return pageInfo.getList();
    }
}
