package com.niuguanqun.springbootdemomybatisxmlmulidatasource.mapper.db1;


import com.niuguanqun.springbootdemomybatisxmlmulidatasource.enums.UserSexEnum;
import com.niuguanqun.springbootdemomybatisxmlmulidatasource.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class User1MapperTest {

    @Resource
    private User1Mapper userMapper;

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
            System.out.println("is null");
        } else {
            System.out.println(users.size());
        }
    }


    @Test
    public void testUpdate() throws Exception {
        User user = userMapper.getOne(28l);
        System.out.println(user.toString());
        user.setNickName("李四");
        userMapper.update(user);
        Assert.assertTrue(("李四".equals(userMapper.getOne(28l).getNickName())));
    }

}