package com.niuguanqun.springbootdemomybatisxml.mapper;


import com.niuguanqun.springbootdemomybatisxml.enums.UserSexEnum;
import com.niuguanqun.springbootdemomybatisxml.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testInsert() throws Exception {
        userMapper.insert(new User("aa", "a123456", UserSexEnum.MAN));
        userMapper.insert(new User("bb", "b123456", UserSexEnum.WOMAN));
        userMapper.insert(new User("cc", "b123456", UserSexEnum.WOMAN));

        Assert.assertEquals(3, userMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<User> users = userMapper.getAll();
        if (users == null || users.size() == 0) {
            System.out.println("Table User is null");
        } else {
            for (User user : users) {
                System.out.println(user.toString());
            }
        }
    }


    @Test
    public void testUpdate() throws Exception {
        User queryUser = new User();
        queryUser.setUserName("aa");
        List<User> userList = userMapper.getUserList(queryUser);

        if (userList != null) {
            for (User user : userList) {
                System.out.println(user);
                user.setNickName("neo");
                userMapper.update(user);
                Assert.assertEquals("neo", userMapper.getOne(user.getId()).getNickName());
            }
        }
    }


}