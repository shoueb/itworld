package com.shoueb.itworld.web.blog.service;

import com.shoueb.itworld.blog.model.BlogArticleHot;

import java.util.List;

public interface SeriesService {
    List<BlogArticleHot> querySeriesRecommendArticle();

    List<BlogArticleHot> queryEditorRecommendArticle(BlogArticleHot blogArticleHot);

    List<BlogArticleHot> querySeriesArticle(BlogArticleHot blogArticleHot);
}
