package com.shoueb.itworld.author.mapper;

import com.shoueb.comm.MyMapper;
import com.shoueb.itworld.author.model.BlogArticleHot;

import java.util.List;

public interface BlogArticleHotMapper extends MyMapper<BlogArticleHot> {
    List<BlogArticleHot> queryHomeRecommendArticle();
}
