package com.niuguanqun.springbootdemojpathymeleaf.controller;

import com.niuguanqun.springbootdemojpathymeleaf.model.User;
import com.niuguanqun.springbootdemojpathymeleaf.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@Api(value = "user 接口", tags = {"用户", "后台"})
public class UserController {

    @Resource
    UserService userService;


    @GetMapping("/")
    public String index() {
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<User> users = userService.getUserList();
        model.addAttribute("users", users);
        return "user/list";
    }

    @GetMapping("/toAdd")
    public String toAdd() {
        return "user/userAdd";
    }

    @PostMapping("/add")
    public String add(User user) {
        userService.save(user);
        return "redirect:/list";
    }

    @GetMapping("/toEdit")
    public String toEdit(Model model, Long id) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "user/userEdit";
    }

    @PutMapping("/edit")
    public String edit(User user) {
        userService.edit(user);
        return "redirect:/list";
    }


    @DeleteMapping("/delete")
    public String delete(Long id) {
        userService.delete(id);
        return "redirect:/list";
    }
}
