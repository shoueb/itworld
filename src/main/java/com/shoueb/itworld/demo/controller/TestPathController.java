package com.shoueb.itworld.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: 访问jsp
 * @Author: admin
 * @Date: 2018/12/16 13:40
 */
@Controller
@RequestMapping("/")
public class TestPathController {
    @RequestMapping("/demo/test")
    public String index(){
        return "demo/test";
    }

}
