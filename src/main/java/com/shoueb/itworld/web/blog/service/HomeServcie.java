package com.shoueb.itworld.web.blog.service;

import com.shoueb.itworld.author.model.BlogArticleHot;

import java.util.List;

/**
 * @Description:
 * @Author: yuangui.hu
 * @Date: 2019/1/13 10:41
 */
public interface HomeServcie {
    /**
     * 主页推荐【3条】
     * @return
     */
    List<BlogArticleHot> queryHomeRecommendArticle();

    /**
     * 编辑推荐【20条】
     * @return
     */
    List<BlogArticleHot> queryEditorRecommendArticle();

    /**
     * 首页的文章【15条】
     * @return
     */
    List<BlogArticleHot> queryHomeArticle();

}
