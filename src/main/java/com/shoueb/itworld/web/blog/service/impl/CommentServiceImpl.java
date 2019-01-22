package com.shoueb.itworld.web.blog.service.impl;

import com.shoueb.itworld.author.mapper.BlogArticleCommentMapper;
import com.shoueb.itworld.author.ro.BlogArticleCommentRO;
import com.shoueb.itworld.web.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:  评论Service
 * @Author: zzq
 * @Date: 2019/1/22
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    BlogArticleCommentMapper blogArticleCommentMapper;



    @Override
    public List<BlogArticleCommentRO> queryArticleCommentById(Long id) {
        return blogArticleCommentMapper.queryArticleCommentById(id);
    }

/*    @Override
    public List<BlogArticleCommentRO> queryAllCommentId(Long id) {
        return blogArticleCommentMapper.queryAllCommentId(id);
    }*/
}
