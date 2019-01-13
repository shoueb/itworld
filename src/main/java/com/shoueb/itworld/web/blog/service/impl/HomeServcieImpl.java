package com.shoueb.itworld.web.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.shoueb.itworld.author.mapper.BlogArticleHotMapper;
import com.shoueb.itworld.author.model.BlogArticleHot;
import com.shoueb.itworld.common.enums.BlogEditorRecommendEnum;
import com.shoueb.itworld.common.enums.BlogShowHomeEnum;
import com.shoueb.itworld.common.enums.BlogShowPositionEnum;
import com.shoueb.itworld.web.blog.service.HomeServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:  首页Service
 * @Author: yuangui.hu
 * @Date: 2019/1/13 10:41
 */
@Service
public class HomeServcieImpl  implements HomeServcie {
    /**
     * 热门博客Mapper
     */
    @Autowired
    private BlogArticleHotMapper blogArticleHotMapper;

    /**
     *
     * @return
     */
    @Override
    public List<BlogArticleHot> queryHomeRecommendArticle() {
        PageHelper.startPage(0,3);
        BlogArticleHot blogArticleHot=new BlogArticleHot();
        blogArticleHot.setShowPosition(BlogShowPositionEnum.ESSENCE.getKey());
        blogArticleHot.setShowHome(BlogShowHomeEnum.YES.getKey());
        blogArticleHot.setEditorRecommend(BlogEditorRecommendEnum.YES.getKey());
        return blogArticleHotMapper.queryHomeRecommendArticle(blogArticleHot);
    }

    /**
     *
     * @return
     */
    @Override
    public List<BlogArticleHot> queryEditorRecommendArticle(BlogArticleHot blogArticleHot) {
        PageHelper.startPage(0,20);
        return blogArticleHotMapper.queryEditorRecommendArticle(blogArticleHot);
    }

    /**
     * return blogArticleHotMapper.selectAll();
     * @return
     */
    @Override
    public List<BlogArticleHot> queryHomeArticle(BlogArticleHot blogArticleHot) {
        PageHelper.startPage(blogArticleHot.getPage(),15);
        return blogArticleHotMapper.queryHomeArticle(blogArticleHot);
    }
}
