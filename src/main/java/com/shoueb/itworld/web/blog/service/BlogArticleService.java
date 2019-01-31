package com.shoueb.itworld.web.blog.service;

import com.shoueb.itworld.author.model.AuthorUser;
import com.shoueb.itworld.blog.model.BlogArticleHot;

import java.util.List;

public interface BlogArticleService {

    /**
     * 主页推荐【3条】
     * @return
     */
    List<BlogArticleHot> queryHomeRecommendArticle();

    /**
     * 编辑推荐【20条】
     * @return
     */
    List<BlogArticleHot> queryEditorRecommendArticle(BlogArticleHot blogArticleHot);

    /**
     * 首页的文章【15条】
     * @return
     */
    List<BlogArticleHot> queryHomeArticle(BlogArticleHot blogArticleHot);


    /**
     *
     * @return
     */
    List<BlogArticleHot> queryEditorRecommendArticle();

    /**
     *
     * @param id
     * @return
     */
    BlogArticleHot queryArticleById(Long id);

    /**
     * 获取作者
     * @param id
     * @return
     */
    AuthorUser queryAuthorById(Long id);

    /**
     *
     * @param uid
     * @return
     */
    BlogArticleHot queryArticleByUid(String uid);
}
