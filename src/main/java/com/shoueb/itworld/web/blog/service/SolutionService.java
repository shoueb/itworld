package com.shoueb.itworld.web.blog.service;

import com.shoueb.itworld.blog.model.BlogArticleHot;

import java.util.List;

public interface SolutionService {
    List<BlogArticleHot> querySolutionRecommendArticle();

    List<BlogArticleHot> queryEditorRecommendArticle(BlogArticleHot blogArticleHot);

    List<BlogArticleHot> querySolutionArticle(BlogArticleHot blogArticleHot);
}
