package com.niuguanqun.springbootdemoshiro.service;


import com.niuguanqun.springbootdemoshiro.model.UserInfo;

import java.util.List;

public interface UserInfoService {
    /**
     * 通过username查找用户信息
     *
     * @param username
     * @return
     */
    public UserInfo findByUsername(String username);


    List<UserInfo> getAllUserList();


    UserInfo findByUid(Integer uid);
}