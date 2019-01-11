package com.shoueb.itworld.blogs.controller;

import com.shoueb.itworld.blogs.service.BlogsService;
import com.shoueb.itworld.demo.pojo.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Description: TODO
 * @Author: admin
 * @Date: 2018/12/28 16:49
 */
@RequestMapping("/")
@Controller
public class BlogsController {
    @Autowired
    private BlogsService blogsService;

    @RequestMapping("/")
    public String index(Model model){
        List<Test> listBlogs= blogsService.queryBlogsAll();
        model.addAttribute("listBlogs",listBlogs);
        return "demo/test";
    }
}
