package com.niuguanqun.springbootdemomybatisxml.mapper;

import com.niuguanqun.springbootdemomybatisxml.model.User;

import java.util.List;


public interface UserMapper {

    List<User> getAll();

    User getOne(Long id);

    List<User> getUserList(User user);

    void insert(User user);

    void update(User user);

    void delete(Long id);

}