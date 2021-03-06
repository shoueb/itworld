package com.shoueb.itworld.web.blog.controller;

import com.shoueb.itworld.author.model.AuthorUser;
import com.shoueb.itworld.blog.model.BlogArticleComment;
import com.shoueb.itworld.blog.model.BlogArticleHot;
import com.shoueb.itworld.blog.ro.BlogArticleHotRO;
import com.shoueb.itworld.common.controller.BaseController;
import com.shoueb.itworld.common.enums.BlogShowHomeEnum;
import com.shoueb.itworld.web.blog.service.BlogArticleCommentService;
import com.shoueb.itworld.web.blog.service.BlogArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
/**
 * @Description: 博客文章
 * @Author: yuangui.hu
 * @Date: 2019/1/31 11:36
 */
@Controller
@RequestMapping("/")
public class BlogArticlePathController extends BaseController {
    /**
     * 博客Service
     */
    @Autowired
    private BlogArticleService blogArticleService;
    /**
     * 评论Service
     */
    @Autowired
    private BlogArticleCommentService blogArticleCommentService;
    /**
     * 根据ID获取博客详情
     * @return
     */
    @GetMapping("article/{uid}")
    public String article(@PathVariable("uid") String uid){
        //根据uid获取博客----》为什么不用id获取博客   防止他人遍历我们的文章
        BlogArticleHotRO article = blogArticleService.queryArticleByUid(uid);
        AuthorUser authorUser = blogArticleService.queryAuthorById(article.getAuthorId() );
        BlogArticleHot blogArticleHot=new BlogArticleHot();
        blogArticleHot.setShowHome(BlogShowHomeEnum.YES.getKey());
        blogArticleHot.setPage(1);
        blogArticleHot.setRows(20);
        List<BlogArticleHotRO> editorRecommendArticle= blogArticleService.queryEditorRecommendArticle(blogArticleHot);
        List<BlogArticleComment> articleCommentROList = blogArticleCommentService.queryArticleCommentById(article.getId());

        request.setAttribute("article",article);
        request.setAttribute("author",authorUser);
        request.setAttribute("editorRecommendArticleList",editorRecommendArticle);
        request.setAttribute("comments",articleCommentROList);

        return "/web/blog/article";
    }

}
