package com.shoueb.itworld.web.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: 首页
 * @Author: yuangui.hu
 * @Date: 2019/1/12 13:22
 */
@Controller
@RequestMapping("/")
public class HomePathController {
    /**
     * @return 跳转到首页
     **/
    @GetMapping("/")
    public String index(){
        return "web/home";
    }

    @GetMapping("details")
    public String details(){
        return "web/details";
    }

    @GetMapping("weblogin")
    public String login(){
        return "web/webLogin";
    }

    @GetMapping("singup")
    public String sinup(){
        return  "web/singup";
    }

}
