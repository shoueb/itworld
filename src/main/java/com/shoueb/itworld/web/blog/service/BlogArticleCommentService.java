package com.shoueb.itworld.web.blog.service;

import com.shoueb.itworld.blog.model.BlogArticleComment;
import java.util.List;

/**
 * @Description: 博客评论
 * @Author: zzq
 * @Date: 2019/1/22
 */
public interface BlogArticleCommentService {
    /**
     * 获取评论数据
     * @param id
     * @return
     */
    List<BlogArticleComment> queryArticleCommentById(Long id);
}
