package com.shoueb.itworld.web.blog.service;

import com.shoueb.itworld.author.model.AuthorUser;
import com.shoueb.itworld.author.model.BlogArticleHot;

import java.util.List;

public interface DetailsService {
    List<BlogArticleHot> queryEditorRecommendArticle();
    BlogArticleHot queryArticleById(Long id);

/*
* 作者相关信息
* */
    AuthorUser queryAuthorById(Long id);
}
