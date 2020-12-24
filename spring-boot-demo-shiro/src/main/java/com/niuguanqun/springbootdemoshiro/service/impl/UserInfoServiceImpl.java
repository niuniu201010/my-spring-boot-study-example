package com.niuguanqun.springbootdemoshiro.service.impl;

import com.niuguanqun.springbootdemoshiro.dao.UserInfoDao;
import com.niuguanqun.springbootdemoshiro.model.UserInfo;
import com.niuguanqun.springbootdemoshiro.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {


    @Resource
    private UserInfoDao userInfoDao;

    /**
     * 通过username查找用户信息
     *
     * @param username
     * @return
     */
    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoDao.findByUsername(username);
    }

    @Override
    public List<UserInfo> getAllUserList() {
        return userInfoDao.findAll();
    }


    @Override
    public UserInfo findByUid(Integer uid) {
        return userInfoDao.findByUid(uid);
    }

}
