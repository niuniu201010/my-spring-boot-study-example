package com.niuguanqun.springbootdemomybatisxmlmulidatasource.controller;


import java.util.List;

import com.niuguanqun.springbootdemomybatisxmlmulidatasource.mapper.db1.User1Mapper;
import com.niuguanqun.springbootdemomybatisxmlmulidatasource.mapper.db2.User2Mapper;
import com.niuguanqun.springbootdemomybatisxmlmulidatasource.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class UserController {

    @Resource
    private User1Mapper user1Mapper;

    @Resource
    private User2Mapper user2Mapper;

    @RequestMapping("/getUsers")
    public List<User> getUsers() {
        List<User> users=user1Mapper.getAll();
        return users;
    }

    @RequestMapping("/getUser")
    public User getUser(Long id) {
        User user=user2Mapper.getOne(id);
        return user;
    }

    @RequestMapping("/add")
    public void save(User user) {
        user2Mapper.insert(user);
    }

    @RequestMapping(value="update")
    public void update(User user) {
        user2Mapper.update(user);
    }

    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        user1Mapper.delete(id);
    }


}