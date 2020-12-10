package com.niuguanqun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController 注解 ：返回的内容就是Return 里的内容，不会返回 页面

@RestController
public class BeginController {
    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }




    @RequestMapping("/testBuy")
    public String testBuy() {
        String path = "http://www.hxzyzx.net";
        if (path.indexOf(".hxzyzx.net") > -1) {
            String mweb_url = "&redirect_url=http://keadmin.xhe.cn/jumpToWXSuccessPage";
            System.out.println(mweb_url);

        }
        return "asdf";
    }




}
