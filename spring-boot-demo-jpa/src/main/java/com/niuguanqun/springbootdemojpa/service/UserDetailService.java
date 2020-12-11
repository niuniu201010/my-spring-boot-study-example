package com.niuguanqun.springbootdemojpa.service;

import com.niuguanqun.springbootdemojpa.model.UserDetail;
import com.niuguanqun.springbootdemojpa.param.UserDetailParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserDetailService {
    public Page<UserDetail> findByCondition(UserDetailParam detailParam, Pageable pageable);
}
