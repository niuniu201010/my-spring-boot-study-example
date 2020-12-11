package com.niuguanqun.springbootdemojpa.service.impl;

import com.niuguanqun.springbootdemojpa.model.UserDetail;
import com.niuguanqun.springbootdemojpa.param.UserDetailParam;
import com.niuguanqun.springbootdemojpa.repository.UserDetailRepository;
import com.niuguanqun.springbootdemojpa.service.UserDetailService;
import com.niuguanqun.springbootdemojpa.utils.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailService {

    @Resource
    private UserDetailRepository userDetailRepository;

    @Override
    public Page<UserDetail> findByCondition(UserDetailParam detailParam, Pageable pageable) {

        return userDetailRepository.findAll((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<Predicate>();
            //equal 示例
            if (!StringUtils.isNullOrEmpty(detailParam.getIntroduction())) {
                predicates.add(cb.equal(root.get("introduction"), detailParam.getIntroduction()));
            }
            //like 示例
            if (!StringUtils.isNullOrEmpty(detailParam.getRealName())) {
                predicates.add(cb.like(root.get("realName"), "%" + detailParam.getRealName() + "%"));
            }
            //between 示例
            if (detailParam.getMinAge() != null && detailParam.getMaxAge() != null) {
                Predicate agePredicate = cb.between(root.get("age"), detailParam.getMinAge(), detailParam.getMaxAge());
                predicates.add(agePredicate);
            }
            //lessThanOrEqualTo 小于等于
            //lessThan 小于
            //greaterThanOrEqualTo 大于等于
            //greaterThan 大于
            if (detailParam.getMinAge() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("age"), detailParam.getMinAge()));
            }
            return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
        }, pageable);

    }
}
