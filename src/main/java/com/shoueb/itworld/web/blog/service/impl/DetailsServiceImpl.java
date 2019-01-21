package com.shoueb.itworld.web.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.shoueb.itworld.author.mapper.AuthorUserMapper;
import com.shoueb.itworld.author.mapper.BlogArticleHotMapper;
import com.shoueb.itworld.author.model.AuthorUser;
import com.shoueb.itworld.author.model.BlogArticleHot;
import com.shoueb.itworld.common.enums.BlogEditorRecommendEnum;
import com.shoueb.itworld.common.enums.BlogShowHomeEnum;
import com.shoueb.itworld.common.enums.BlogShowPositionEnum;
import com.shoueb.itworld.web.blog.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DetailsServiceImpl implements DetailsService {
    @Autowired
    private BlogArticleHotMapper blogArticleHotMapper;
    @Autowired
    private AuthorUserMapper authorUserMapper;
    @Override
    public List<BlogArticleHot> queryEditorRecommendArticle() {
        PageHelper.startPage(0,20);
        BlogArticleHot blogArticleHot=new BlogArticleHot();
        blogArticleHot.setShowPosition(BlogShowPositionEnum.ESSENCE.getKey());
        blogArticleHot.setShowHome(BlogShowHomeEnum.YES.getKey());
        blogArticleHot.setEditorRecommend(BlogEditorRecommendEnum.YES.getKey());
        return blogArticleHotMapper.queryEditorRecommendArticle(blogArticleHot);
    }

    @Override
    public BlogArticleHot queryArticleById(Long id) {
        return blogArticleHotMapper.queryArticleById(id);
    }


    @Override
    public AuthorUser queryAuthorById(Long id) {
        return authorUserMapper.queryAuthorById(id);
    }


}
