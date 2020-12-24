package com.niuguanqun.springbootdemoshiro.dao;

import com.niuguanqun.springbootdemoshiro.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoDao extends JpaRepository<UserInfo, Long> {
    /**
     * 通过 username 查找用户信息
     *
     * @param username
     * @return
     */
    UserInfo findByUsername(String username);


    /**
     * 通过 uid 查找用户信息
     *
     * @param uid
     * @return
     */
    UserInfo findByUid(Integer uid);
}