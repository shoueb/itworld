package com.shoueb.itworld.author.mapper;

import com.shoueb.comm.MyMapper;
import com.shoueb.itworld.author.model.BlogArticleHot;

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
    List<BlogArticleHot> queryHomeRecommendArticle(BlogArticleHot blogArticleHot);
    List<BlogArticleHot> queryHomeArticle(BlogArticleHot blogArticleHot);
    List<BlogArticleHot> queryEditorRecommendArticle(BlogArticleHot blogArticleHot);
}
