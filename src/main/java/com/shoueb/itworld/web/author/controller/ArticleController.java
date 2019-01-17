package com.shoueb.itworld.web.author.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/article/")
public class ArticleController {

    @RequestMapping("manage")
    public String goManage(){
        return "/web/author/articleManage";
    }

    @GetMapping("content")
    public String goContent(){
        return "/web/author/articleContent";
    }

    @GetMapping("review")
    public String goReview(){
        return "/web/author/articleReview";
    }
}
