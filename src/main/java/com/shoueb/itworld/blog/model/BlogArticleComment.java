package com.shoueb.itworld.blog.model;

import com.shoueb.itworld.common.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;
/**
 * @Description:文章评论
 * @Author: zzq
 * @Date: 2019/1/22
 */
@Table(name= "t_blog_article_comment")
@Data
public class BlogArticleComment extends BaseEntity implements Serializable {

    /**
     *用户ID
     * */
    private Long authorId;
    /**
    * 文章ID
    * */
    private Long articleId;
    /**
    *评论内容
    * */
    private String content;
    /**
     *数据状态1正常 0 删除
     */
    private String deleteFlag;

    /**
     *状态0新建1发布2审核通过3审核不通过4系统删除
     */
    private String status;
    /**
    * 收获点赞数
    * */
    private Long favorCount;
}
