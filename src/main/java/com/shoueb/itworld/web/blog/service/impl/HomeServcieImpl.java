package com.shoueb.itworld.web.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.shoueb.itworld.author.mapper.BlogArticleHotMapper;
import com.shoueb.itworld.author.model.BlogArticleHot;
import com.shoueb.itworld.web.blog.service.HomeServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: yuangui.hu
 * @Date: 2019/1/13 10:41
 */
@Service
public class HomeServcieImpl  implements HomeServcie {
    @Autowired
    private BlogArticleHotMapper blogArticleHotMapper;

    /**
     *
     * @return
     */
    @Override
    public List<BlogArticleHot> queryHomeRecommendArticle() {
        PageHelper.startPage(0,3);
        return blogArticleHotMapper.queryHomeRecommendArticle();
    }

    /**
     *
     * @return
     */
    @Override
    public List<BlogArticleHot> queryEditorRecommendArticle() {
        return blogArticleHotMapper.selectAll();
    }

    /**
     * return blogArticleHotMapper.selectAll();
     * @return
     */
    @Override
    public List<BlogArticleHot> queryHomeArticle(int pageNum) {
        PageHelper.startPage(pageNum,15);
        return blogArticleHotMapper.selectAll();
    }
}
