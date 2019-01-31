package com.shoueb.itworld.blog.mapper;

import com.shoueb.comm.MyMapper;
import com.shoueb.itworld.blog.model.BlogArticleHot;
import com.shoueb.itworld.blog.ro.BlogArticleHotRO;

import java.util.List;
/**
 * @Description: 热门博客 Mapper
 * @Author: yuangui.hu
 * @Date: 2019/1/12 13:22
 */
public interface BlogArticleHotMapper extends MyMapper<BlogArticleHot> {
    /**
     * 查询首页推荐
     * @return
     */
    List<BlogArticleHotRO> queryHomeRecommendArticle(BlogArticleHot blogArticleHot);

    /**
     *查询文章
     * @param blogArticleHot
     * @return
     */
    List<BlogArticleHotRO> queryHomeArticle(BlogArticleHot blogArticleHot);

    /**
     *编辑推荐
     * @param blogArticleHot
     * @return
     */
    List<BlogArticleHotRO> queryEditorRecommendArticle(BlogArticleHot blogArticleHot);

    /**
     *
     * @param id
     * @return
     */
    BlogArticleHot queryArticleById(Long id);

    /**
     * 根据uid获取文章
     * @param uid
     * @return
     */
    BlogArticleHot queryArticleByUid(String uid);
}
