package com.niuguanqun.springbootdemoweb.repository;

import java.text.DateFormat;
import java.util.Date;

import com.niuguanqun.springbootdemoweb.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws Exception {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

//        userRepository.save(new User("bb2", "bb@126.com", "bb", "bb123456", formattedDate));
//        userRepository.save(new User("cc3", "cc@126.com", "cc", "cc123456", formattedDate));

//		Assert.assertEquals(9, userRepository.findAll().size());
//        Assert.assertEquals("bb2", userRepository.findByUserNameOrEmail("bb", "xxx126.com").getNickName());

        //添加记录
//        userRepository.save(new User("aa1", "aa@126.com", "aa", "aa123456", formattedDate));
        //查找记录
        User user = userRepository.findByUserNameOrEmail("bb", "xxx126.com");
        //删除记录
//        userRepository.delete(userRepository.findByUserName("aa"));

        //修改记录
        user.setNickName("update-a-1");
        userRepository.save(user);
    }

}