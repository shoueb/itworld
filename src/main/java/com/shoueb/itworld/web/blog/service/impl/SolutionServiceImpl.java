package com.shoueb.itworld.web.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.shoueb.itworld.blog.mapper.BlogArticleHotMapper;
import com.shoueb.itworld.blog.model.BlogArticleHot;
import com.shoueb.itworld.common.enums.BlogEditorRecommendEnum;
import com.shoueb.itworld.common.enums.BlogShowHomeEnum;
import com.shoueb.itworld.common.enums.BlogShowPositionEnum;
import com.shoueb.itworld.common.enums.SeriesShowEnum;
import com.shoueb.itworld.web.blog.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolutionServiceImpl implements SolutionService {
    /**
     * 热门博客Mapper
     */
    @Autowired
    private BlogArticleHotMapper blogArticleHotMapper;

    @Override
    public List<BlogArticleHot> querySolutionRecommendArticle() {
        PageHelper.startPage(0,3);
        BlogArticleHot blogArticleHot=new BlogArticleHot();
        blogArticleHot.setShowPosition(BlogShowPositionEnum.ESSENCE.getKey());
        blogArticleHot.setShowHome(BlogShowHomeEnum.YES.getKey());
        blogArticleHot.setEditorRecommend(BlogEditorRecommendEnum.YES.getKey());
        blogArticleHot.setArticleType(SeriesShowEnum.SOLUTION.getKey());

        return blogArticleHotMapper.queryHomeRecommendArticle(blogArticleHot);
    }

    @Override
    public List<BlogArticleHot> queryEditorRecommendArticle(BlogArticleHot blogArticleHot) {
        PageHelper.startPage(0,20);
        return blogArticleHotMapper.queryEditorRecommendArticle(blogArticleHot);
    }

    @Override
    public List<BlogArticleHot> querySolutionArticle(BlogArticleHot blogArticleHot) {
        PageHelper.startPage(blogArticleHot.getPage(),15);
        return blogArticleHotMapper.queryHomeArticle(blogArticleHot);
    }
}
