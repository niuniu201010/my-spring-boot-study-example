package com.niuguanqun.springbootdemodockercompose.repository;


import com.niuguanqun.springbootdemodockercompose.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  VisitorRepository extends JpaRepository<Visitor, Long> {
    Visitor findByIp(String ip);
}

