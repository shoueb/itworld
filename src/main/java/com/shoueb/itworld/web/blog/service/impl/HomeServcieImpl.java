package com.shoueb.itworld.web.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.shoueb.itworld.author.mapper.BlogArticleHotMapper;
import com.shoueb.itworld.author.model.BlogArticleHot;
import com.shoueb.itworld.common.enums.BlogEditorRecommendEnum;
import com.shoueb.itworld.common.enums.BlogShowHomeEnum;
import com.shoueb.itworld.common.enums.BlogShowPositionEnum;
import com.shoueb.itworld.web.blog.service.HomeServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:  首页Service
 * @Author: yuangui.hu
 * @Date: 2019/1/13 10:41
 */
@CacheConfig(cacheNames = "hot")
@Service
public class HomeServcieImpl  implements HomeServcie {
    /**
     * 热门博客Mapper
     */
    @Autowired
    private BlogArticleHotMapper blogArticleHotMapper;

    /**
     *主页推荐【3条】
     * @return 返回主页推荐结果集
     */
    @Cacheable(key="'article_'")
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
     *编辑推荐【20条】
     * @return
     */
    @Cacheable( key="'edre_lgt'+#blogArticleHot.languageType")
    @Override
    public List<BlogArticleHot> queryEditorRecommendArticle(BlogArticleHot blogArticleHot) {
        PageHelper.startPage(blogArticleHot.getPage(),blogArticleHot.getRows());
        return blogArticleHotMapper.queryEditorRecommendArticle(blogArticleHot);
    }

    /**
     * 查询文章
     * @return
     */
    @Cacheable( key="'article_p'+#blogArticleHot.page+'_l'" +
            "+#blogArticleHot.languageType+'_sh'+#blogArticleHot.showHome+'_sp'+#blogArticleHot.showPosition")
    @Override
    public List<BlogArticleHot> queryHomeArticle(BlogArticleHot blogArticleHot) {
        //分页不统计
        PageHelper.startPage(blogArticleHot.getPage(),blogArticleHot.getRows(),false);
        return blogArticleHotMapper.queryHomeArticle(blogArticleHot);
    }
}
