package com.shoueb.itworld.web.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.shoueb.itworld.author.mapper.AuthorUserMapper;
import com.shoueb.itworld.blog.mapper.BlogArticleHotMapper;
import com.shoueb.itworld.author.model.AuthorUser;
import com.shoueb.itworld.blog.model.BlogArticleHot;
import com.shoueb.itworld.blog.ro.BlogArticleHotRO;
import com.shoueb.itworld.common.enums.BlogEditorRecommendEnum;
import com.shoueb.itworld.common.enums.BlogShowHomeEnum;
import com.shoueb.itworld.common.enums.BlogShowPositionEnum;
import com.shoueb.itworld.web.blog.service.BlogArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@CacheConfig(cacheNames = "blog_")
@Service
public class BlogArticleServiceImpl implements BlogArticleService {
    /**
     * 热门博客Mapper
     */
    @Autowired
    private BlogArticleHotMapper blogArticleHotMapper;
    @Autowired
    private AuthorUserMapper authorUserMapper;

    /**
     *主页推荐【3条】
     * @return 返回主页推荐结果集
     */
    @Cacheable(key="'article_'")
    @Override
    public List<BlogArticleHotRO> queryHomeRecommendArticle() {
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
    public List<BlogArticleHotRO> queryEditorRecommendArticle(BlogArticleHot blogArticleHot) {
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
    public List<BlogArticleHotRO> queryHomeArticle(BlogArticleHot blogArticleHot) {
        //分页不统计
        PageHelper.startPage(blogArticleHot.getPage(),blogArticleHot.getRows(),false);
        return blogArticleHotMapper.queryHomeArticle(blogArticleHot);
    }

    @Override
    public BlogArticleHot queryArticleById(Long id) {
        return blogArticleHotMapper.queryArticleById(id);
    }


    @Override
    public AuthorUser queryAuthorById(Long id) {
        return authorUserMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据uid获取文章
     * @param uid
     * @return
     */
    @Cacheable( key="'article_uid'+#uid")
    @Override
    public BlogArticleHotRO queryArticleByUid(String uid) {
        return blogArticleHotMapper.queryArticleByUid(uid);
    }
}
