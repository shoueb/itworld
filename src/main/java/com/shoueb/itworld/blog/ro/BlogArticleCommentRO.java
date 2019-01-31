package com.shoueb.itworld.blog.ro;

import com.shoueb.itworld.blog.model.BlogArticleComment;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 文章评论
 * @Author: zzq
 * @Date: 2019/1/22
 */
@Data
public class BlogArticleCommentRO extends BlogArticleComment implements Serializable {
    /**
     * 作者名称
     **/
    private String khName;
    /**
    * 用户头像
    **/
    private String imgUrl;
}

