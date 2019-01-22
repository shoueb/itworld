package com.shoueb.itworld.web.blog.controller;


import com.shoueb.itworld.author.model.AuthorUser;
import com.shoueb.itworld.author.model.BlogArticleComment;
import com.shoueb.itworld.author.model.BlogArticleHot;
import com.shoueb.itworld.author.ro.BlogArticleCommentRO;
import com.shoueb.itworld.common.controller.BaseController;
import com.shoueb.itworld.common.enums.BlogShowHomeEnum;
import com.shoueb.itworld.common.enums.BlogShowPositionEnum;
import com.shoueb.itworld.web.blog.service.CommentService;
import com.shoueb.itworld.web.blog.service.DetailsService;
import com.shoueb.itworld.web.blog.service.HomeServcie;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private HomeServcie homeServcie;
    @Autowired
    private DetailsService detailsService;

    @Autowired
    private CommentService commentService;
    /**
     * @return 跳转到首页
     **/
    @GetMapping(value = "/")
    public String index(){
        //条件
        String page= request.getParameter("page");
        if(StringUtils.isBlank(page)){
            page="1";
        }
        String showPosition= request.getParameter("position");
        String language= request.getParameter("language");
        BlogArticleHot blogArticleHot=new BlogArticleHot();
        if(StringUtils.isBlank(showPosition)){
            showPosition= BlogShowPositionEnum.ESSENCE.getKey();
        }
        if(StringUtils.isBlank(language)){
            language="";
        }
        blogArticleHot.setShowPosition(showPosition);
        blogArticleHot.setLanguageType(language);
        blogArticleHot.setShowHome(BlogShowHomeEnum.YES.getKey());
        blogArticleHot.setPage(Integer.valueOf(page));
        //servce 调用
        //1：主页推荐【3条】  2：编辑推荐【20条】 3：首页的文章【15条】
        List<BlogArticleHot> homeRecommendArticle= homeServcie.queryHomeRecommendArticle();
        List<BlogArticleHot> editorRecommendArticle= homeServcie.queryEditorRecommendArticle(blogArticleHot);
        List<BlogArticleHot> homeArticle= homeServcie.queryHomeArticle(blogArticleHot);
        //设置值
        request.setAttribute("homeRecommendArticleList",homeRecommendArticle);
        request.setAttribute("editorRecommendArticleList",editorRecommendArticle);
        request.setAttribute("homeArticleList",homeArticle);
        //回显
        request.setAttribute("showPosition",showPosition);
        request.setAttribute("language",language);
        request.setAttribute("page",page);

        return "web/blog/home";
    }

    /**
     * 根据ID获取博客详情
     * @param model
     * @return
     */
    @GetMapping("details")
    public String details(Model model){
        String id= request.getParameter("id");
        if(StringUtils.isBlank(id)){
            //报错跳转到404
        }
        BlogArticleHot article = detailsService.queryArticleById(Long.valueOf(id));
        Long authorId = article.getAuthorId();
        AuthorUser authorMessage = detailsService.queryAuthorById(authorId );
        List<BlogArticleHot> editorRecommendArticleList = detailsService.queryEditorRecommendArticle();
        List<BlogArticleComment> articleCommentROList = commentService.queryArticleCommentById(Long.valueOf(id));

        model.addAttribute("article",article);
        model.addAttribute("author",authorMessage);
        model.addAttribute("editorRecommendArticleList",editorRecommendArticleList);
        model.addAttribute("comments",articleCommentROList);

        return "web/blog/details";
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
