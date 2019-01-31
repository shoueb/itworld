package com.shoueb.itworld.blog.mapper;

import com.shoueb.comm.MyMapper;
import com.shoueb.itworld.blog.model.BlogArticleComment;

import java.util.List;

/**
 * 博客评论
 */
public interface BlogArticleCommentMapper extends MyMapper<BlogArticleComment> {

    List<BlogArticleComment> queryArticleCommentById(Long id);
}
