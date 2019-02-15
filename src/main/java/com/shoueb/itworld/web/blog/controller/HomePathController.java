package com.shoueb.itworld.web.blog.controller;

import com.shoueb.itworld.blog.model.BlogArticleHot;
import com.shoueb.itworld.blog.ro.BlogArticleHotRO;
import com.shoueb.itworld.common.controller.BaseController;
import com.shoueb.itworld.common.enums.BlogEditorRecommendEnum;
import com.shoueb.itworld.common.enums.BlogShowHomeEnum;
import com.shoueb.itworld.common.enums.BlogShowPositionEnum;
import com.shoueb.itworld.common.enums.SeriesTypeEnum;
import com.shoueb.itworld.web.blog.service.BlogArticleService;
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
    /**
     * 博客Service
     */
    @Autowired
    private BlogArticleService blogArticleService;

    /**
     * @return 跳转到首页
     **/
    @GetMapping(value = "/")
    public String index(){
        request.setAttribute("home","active");
        //条件
        String page= request.getParameter("page");
        String showPosition= request.getParameter("position");
        String language= request.getParameter("language");
        if(StringUtils.isBlank(page)){
            page="0";
        }
        if(StringUtils.isBlank(showPosition)){
            showPosition= BlogShowPositionEnum.ESSENCE.getKey();
        }
        if(StringUtils.isBlank(language)){
            language="";
        }
        //就近原则
        BlogArticleHot blogArticleHot=new BlogArticleHot();
        blogArticleHot.setShowPosition(showPosition);
        blogArticleHot.setLanguageType(language);
        blogArticleHot.setPage(Integer.valueOf(page));
        //servce 调用
        //1：头部推荐【3条】
        List<BlogArticleHotRO> homeRecommendArticle= blogArticleService.queryHomeRecommendArticle();
        //2：编辑推荐【10条】
        blogArticleHot.setRows(10);
        blogArticleHot.setEditorRecommend(BlogEditorRecommendEnum.EDITOR_RECOMMEND.getKey());
        List<BlogArticleHotRO> editorRecommendArticle= blogArticleService.queryEditorRecommendArticle(blogArticleHot);
        //2：最新实践【10条】
        blogArticleHot.setEditorRecommend(BlogEditorRecommendEnum.ALL.getKey());
        blogArticleHot.setSeriesType(SeriesTypeEnum.PRACTICE.getKey());
        List<BlogArticleHotRO> practiceArticleList= blogArticleService.queryPracticeArticleList(blogArticleHot);

        //3：精选15条 文章【15条】
        blogArticleHot.setRows(15);
        blogArticleHot.setEditorRecommend(BlogEditorRecommendEnum.ALL.getKey());
        blogArticleHot.setSeriesType(SeriesTypeEnum.ALL.getKey());
        List<BlogArticleHotRO> homeArticle= blogArticleService.queryHomeArticle(blogArticleHot);
        //设置值
        request.setAttribute("homeRecommendArticleList",homeRecommendArticle);
        request.setAttribute("editorRecommendArticleList",editorRecommendArticle);
        request.setAttribute("practiceArticleList",practiceArticleList);
        request.setAttribute("homeArticleList",homeArticle);
        //回显
        request.setAttribute("showPosition",showPosition);
        request.setAttribute("language",language);
        request.setAttribute("page",page);
        //跳转
        return "web/blog/home";
    }
}
