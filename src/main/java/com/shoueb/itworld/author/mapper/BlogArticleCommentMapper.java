package com.shoueb.itworld.author.mapper;

import com.shoueb.comm.MyMapper;
import com.shoueb.itworld.author.model.BlogArticleComment;
import com.shoueb.itworld.author.ro.BlogArticleCommentRO;

import java.util.List;

public interface BlogArticleCommentMapper extends MyMapper<BlogArticleComment> {
    List<BlogArticleCommentRO> queryArticleCommentById(Long id);
/*    List<BlogArticleCommentRO> queryAllCommentId(Long id);*/
}
