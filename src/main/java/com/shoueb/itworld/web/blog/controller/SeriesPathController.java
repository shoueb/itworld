package com.shoueb.itworld.web.blog.controller;


import com.shoueb.itworld.author.model.BlogArticleHot;
import com.shoueb.itworld.common.controller.BaseController;
import com.shoueb.itworld.common.enums.BlogShowHomeEnum;
import com.shoueb.itworld.common.enums.BlogShowPositionEnum;
import com.shoueb.itworld.common.enums.SeriesShowEnum;
import com.shoueb.itworld.web.blog.service.SeriesService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Description: 首页
 * @Author: zzq
 * @Date: 2019/1/24
 */
@Controller
@RequestMapping("/series")
public class SeriesPathController extends BaseController {

    @Autowired
    private SeriesService seriesService;


    /**
     * @return 跳转到系列
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
        blogArticleHot.setArticleType(SeriesShowEnum.SERIAL.getKey());

        blogArticleHot.setPage(Integer.valueOf(page));

        List<BlogArticleHot> seriesRecommendArticle= seriesService.querySeriesRecommendArticle();
        List<BlogArticleHot> editorRecommendArticle= seriesService.queryEditorRecommendArticle(blogArticleHot);
        List<BlogArticleHot> seriesArticle= seriesService.querySeriesArticle(blogArticleHot);
        //设置值
        request.setAttribute("seriesRecommendArticleList",seriesRecommendArticle);
        request.setAttribute("editorRecommendArticleList",editorRecommendArticle);
        request.setAttribute("seriesArticleList",seriesArticle);
        //回显
        request.setAttribute("showPosition",showPosition);
        request.setAttribute("language",language);
        request.setAttribute("page",page);

        return "web/blog/series";
    }

}
