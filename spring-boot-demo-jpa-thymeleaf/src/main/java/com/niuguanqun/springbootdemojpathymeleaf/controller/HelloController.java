package com.niuguanqun.springbootdemojpathymeleaf.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Api(value = "hello 接口", tags = {"测试", "hello world"})
public class HelloController {

    @GetMapping("/hello")
    @ApiOperation(value = "打招呼")
    @ApiImplicitParam(name = "name", value = "姓名", required = true, defaultValue = "world", dataType = "String", paramType = "query")
    public String hello(Model model, String name) {
        model.addAttribute("name", name);
        return "hello";
    }
}
