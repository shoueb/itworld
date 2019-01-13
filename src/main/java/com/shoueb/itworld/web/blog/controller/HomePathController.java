package com.shoueb.itworld.web.blog.controller;

import com.shoueb.itworld.author.model.BlogArticleHot;
import com.shoueb.itworld.common.controller.BaseController;

import com.shoueb.itworld.web.author.service.LoginService;
import com.shoueb.itworld.web.blog.service.HomeServcie;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Description: 首页
 * @Author: yuangui.hu
 * @Date: 2019/1/12 13:22
 */
@Controller
@RequestMapping("/")
public class HomePathController extends BaseController {
    @Autowired
    HomeServcie homeServcie;
    /**
     * @return 跳转到首页
     **/
    @GetMapping("/")
    public String index(){
       String page= request.getParameter("page");
       if(StringUtils.isBlank(page)){
           page="1";
       }
        //1：主页推荐【3条】  2：编辑推荐【20条】 3：首页的文章【15条】
        List<BlogArticleHot> homeRecommendArticle= homeServcie.queryHomeRecommendArticle();
        List<BlogArticleHot> editorRecommendArticle= homeServcie.queryEditorRecommendArticle();
        List<BlogArticleHot> homeArticle= homeServcie.queryHomeArticle(Integer.valueOf(page));
        request.setAttribute("homeRecommendArticleList",homeRecommendArticle);
        request.setAttribute("editorRecommendArticleList",editorRecommendArticle);
        request.setAttribute("homeArticleList",homeArticle);
        return "web/blog/home";
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
