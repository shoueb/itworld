package com.shoueb.itworld.web.blog.controller;

import com.shoueb.itworld.blog.model.BlogArticleHot;
import com.shoueb.itworld.common.controller.BaseController;
import com.shoueb.itworld.common.enums.BlogShowHomeEnum;
import com.shoueb.itworld.common.enums.BlogShowPositionEnum;
import com.shoueb.itworld.common.enums.SeriesShowEnum;
import com.shoueb.itworld.web.blog.service.SolutionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
/*

*
 * @Description: 首页
 * @Author: zzq
 * @Date: 2019/1/24


*/


@Controller
@RequestMapping("/solution")
public class SolutionPathController extends BaseController {

    @Autowired
    private SolutionService solutionService;
/*


     *
     * @return 跳转到系列
     *

*/


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
        blogArticleHot.setArticleType(SeriesShowEnum.SOLUTION.getKey());

        blogArticleHot.setPage(Integer.valueOf(page));

        List<BlogArticleHot> solutionRecommendArticle= solutionService.querySolutionRecommendArticle();
        List<BlogArticleHot> editorRecommendArticle= solutionService.queryEditorRecommendArticle(blogArticleHot);
        List<BlogArticleHot> solutionArticle= solutionService.querySolutionArticle(blogArticleHot);
        //设置值
        request.setAttribute("solutionRecommendArticleList",solutionRecommendArticle);
        request.setAttribute("editorRecommendArticleList",editorRecommendArticle);
        request.setAttribute("solutionArticleList",solutionArticle);
        //回显
        request.setAttribute("showPosition",showPosition);
        request.setAttribute("language",language);
        request.setAttribute("page",page);

        return "web/blog/solution";
    }

}
