package com.niuguanqun.springbootdemojpa.repository;

import com.niuguanqun.springbootdemojpa.model.Address;
import com.niuguanqun.springbootdemojpa.model.UserDetail;
import com.niuguanqun.springbootdemojpa.model.UserInfo;
import com.niuguanqun.springbootdemojpa.param.UserDetailParam;
import com.niuguanqun.springbootdemojpa.service.UserDetailService;
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
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDetailRepositoryTests {

    @Resource
    private AddressRepository addressRepository;
    @Resource
    private UserDetailRepository userDetailRepository;
    @Resource
    private UserDetailService userDetailService;

    @Test
    public void testSaveAddress() {
        Address address = new Address();
        address.setUserId(1L);
        address.setCity("北京");
        address.setProvince("北京");
        address.setStreet("分钟寺");
        addressRepository.save(address);
    }

    @Test
    public void testSaveUserDetail() {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);
        UserDetail userDetail = new UserDetail();
        userDetail.setUserId(3L);
        userDetail.setHobby("吃鸡游戏");
        userDetail.setAge(28);
        userDetail.setIntroduction("一个爱玩的人");
        userDetailRepository.save(userDetail);
    }

    @Test
    public void testFindByCondition()  {
        int page=0,size=10;
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        UserDetailParam param=new UserDetailParam();
        param.setIntroduction("程序员");
        param.setMinAge(10);
        param.setMaxAge(30);
        Page<UserDetail> page1=userDetailService.findByCondition(param,pageable);
        for (UserDetail userDetail:page1){
            System.out.println("userDetail: "+userDetail.toString());
        }
    }

    /**
     * 多表联合查询
     */
    @Test
    public void testUserInfo() {
        // user 和 userDetail 两表联合查询
        List<UserInfo> userInfos = userDetailRepository.findUserInfo("吃鸡游戏");
        for (UserInfo userInfo : userInfos) {
            System.out.println("userInfo: " + userInfo.getUserName() + "-" + userInfo.getEmail() + "-" + userInfo.getHobby() + "-" + userInfo.getIntroduction());
        }
    }


}