package com.niuguanqun.springbootdemojpathymeleaf.repository;


import com.niuguanqun.springbootdemojpathymeleaf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findById(long id);

    @Override
    void deleteById(Long id);
}