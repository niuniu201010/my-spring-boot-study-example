package com.niuguanqun.springbootdemoshiro.controller;

import com.niuguanqun.springbootdemoshiro.model.UserInfo;
import com.niuguanqun.springbootdemoshiro.service.UserInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

    /**
     * 用户查询
     *
     * @return
     */
    @RequestMapping("/userList")
    @RequiresPermissions("userInfo:view")//权限管理;
    public String userList(Model model) {
        List<UserInfo> userInfoList = userInfoService.getAllUserList();
        model.addAttribute("userList", userInfoList);
        return "userList";
    }

    /**
     * 用户添加
     *
     * @return
     */
    @RequestMapping("/userDetail")
    @RequiresPermissions("userInfo:detail")//权限管理;
    public String userInfo(Integer id, Model model) {
        try {
            UserInfo userInfo = userInfoService.findByUid(id);
            model.addAttribute("user", userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "userInfo";
    }

    /**
     * 用户添加
     *
     * @return
     */
    @RequestMapping("/userAdd")
    @RequiresPermissions("userInfo:add")//权限管理;
    public String userInfoAdd() {
        return "userInfoAdd";
    }

    /**
     * 用户删除
     *
     * @return
     */
    @RequestMapping("/userDel")
    @RequiresPermissions("userInfo:del")//权限管理;
    public String userDel() {
        return "userInfoDel";
    }
}