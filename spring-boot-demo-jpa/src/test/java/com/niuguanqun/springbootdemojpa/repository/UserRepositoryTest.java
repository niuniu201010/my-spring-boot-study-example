package com.niuguanqun.springbootdemojpa.repository;

import com.niuguanqun.springbootdemojpa.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Resource
    private UserRepository userRepository;

    /**
     * 添加记录
     */
    @Test
    public void testSave() {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        userRepository.save(new User("aa", "aa123456", "aa@126.com", "aa", formattedDate));
        userRepository.save(new User("bb", "bb123456", "bb@126.com", "bb", formattedDate));
        userRepository.save(new User("cc", "cc123456", "cc@126.com", "cc", formattedDate));

//		Assert.assertEquals(3, userRepository.findAll().size());
//		Assert.assertEquals("bb", userRepository.findByUserNameOrEmail("bb", "bb@126.com").getNickName());
//		userRepository.delete(userRepository.findByUserName("aa"));
    }


    /**
     * 基础sql查询（不需手动写sql,自动继承的方法）
     */
    @Test
    public void testBaseQuery() {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);
        User user = new User("ff", "ff123456", "ff@126.com", "ff", formattedDate);
        List<User> allUserList = userRepository.findAll();
        Optional<User> userById = userRepository.findById(3L);
        User save = userRepository.save(user);
        user.setId(2L);
        userRepository.delete(user);
        //返回目前数据表中的记录数
        long count = userRepository.count();
        //是否存在id=3的记录，返回true/false
        boolean b = userRepository.existsById(3L);
    }

    /**
     * 自定义sql
     */
    @Test
    public void testCustomSql() {
        //修改数据表记录的字段值
        //修改id=3的记录的username字段为‘neo’
        int neo = userRepository.modifyById("neo", 3L);
        userRepository.deleteById(3L);
        //根据email查询记录
        User byEmail = userRepository.findByEmail("ff@126.com");
    }


    /**
     * 分页查询
     */
    @Test
    public void testPageQuery() {
        testSave();
        //page 页码（第一页页码为0）
        //size 每页记录数
        int page = 0, size = 3;
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);

        Page<User> userPageAll = userRepository.findALL(pageable);
        //查询结果总记录数
        int allCount = userPageAll.getSize();
        //查询结果集
        List<User> userList = userPageAll.getContent();
        //分页对象
        Pageable allPageable = userPageAll.getPageable();
        int pageSize = allPageable.getPageSize();//每页记录数
        int pageNumber = allPageable.getPageNumber();//当前页码（第一页是0）

        Page<User> userPageList = userRepository.findByNickName("aa", pageable);

        System.out.println(userPageList);

    }

}