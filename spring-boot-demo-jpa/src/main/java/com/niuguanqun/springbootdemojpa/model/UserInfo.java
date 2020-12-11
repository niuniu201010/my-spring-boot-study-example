package com.niuguanqun.springbootdemojpa.model;

/**
 * 联合查询结果属性映射接口
 * 来接收连表查询后字段值
 */
public interface UserInfo {

    String getUserName();
    String getEmail();
    String getHobby();
    String getIntroduction();

}
