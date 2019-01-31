package com.shoueb.itworld.web.blog.service.impl;

import com.shoueb.itworld.blog.mapper.BlogArticleCommentMapper;
import com.shoueb.itworld.blog.model.BlogArticleComment;

import com.shoueb.itworld.web.blog.service.BlogArticleCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:  评论Service
 * @Author: yuangui.hu
 * @Date: 2019/1/31
 */
@Service
public class BlogArticleCommentServiceImpl implements BlogArticleCommentService {
    /**
     * 文章评论
     */
    @Autowired
    BlogArticleCommentMapper blogArticleCommentMapper;

    @Override
    public List<BlogArticleComment> queryArticleCommentById(Long id) {
        return blogArticleCommentMapper.queryArticleCommentById(id);
    }
}
