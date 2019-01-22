package com.shoueb.itworld.web.blog.service;


import com.shoueb.itworld.author.ro.BlogArticleCommentRO;

import java.util.List;

/**
 * @Description:
 * @Author: zzq
 * @Date: 2019/1/22
 */
public interface CommentService {
    List<BlogArticleCommentRO> queryArticleCommentById(Long id);
   /* List<BlogArticleCommentRO> queryAllCommentId(Long id);*/
}
