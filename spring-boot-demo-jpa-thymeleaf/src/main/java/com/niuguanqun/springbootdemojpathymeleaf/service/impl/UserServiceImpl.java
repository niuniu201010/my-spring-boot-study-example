package com.niuguanqun.springbootdemojpathymeleaf.service.impl;

import com.niuguanqun.springbootdemojpathymeleaf.model.User;
import com.niuguanqun.springbootdemojpathymeleaf.repository.UserRepository;
import com.niuguanqun.springbootdemojpathymeleaf.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void edit(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }
}


