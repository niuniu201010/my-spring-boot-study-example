package com.niuguanqun.springbootdemomongodbmulti;

import com.niuguanqun.springbootdemomongodbmulti.model.User;
import com.niuguanqun.springbootdemomongodbmulti.repository.db1.UserDB1Repository;
import com.niuguanqun.springbootdemomongodbmulti.repository.db2.UserDB2Repository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MuliDatabaseTest {

    @Autowired
    private UserDB1Repository userDB1Repository;

    @Autowired
    private UserDB2Repository userDB2Repository;

    @Test
    public void TestSave() {
        System.out.println("************************************************************");
        System.out.println("测试开始");
        System.out.println("************************************************************");
        this.userDB1Repository.save(new User("小张", "123456"));
        this.userDB2Repository.save(new User("小王", "654321"));
        List<User> db1UserList = this.userDB1Repository.findAll();
        for (User db1user : db1UserList) {
            System.out.println(db1user.toString());
        }
        List<User> db2UserList = this.userDB2Repository.findAll();
        for (User db2user : db2UserList) {
            System.out.println(db2user.toString());
        }
        System.out.println("************************************************************");
        System.out.println("测试完成");
        System.out.println("************************************************************");
    }

}
