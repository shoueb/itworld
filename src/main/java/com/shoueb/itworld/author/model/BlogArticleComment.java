package com.shoueb.itworld.author.model;

import com.shoueb.itworld.common.entity.BaseEntity;

import javax.persistence.Table;
import java.io.Serializable;
/**
 * @Description:文章评论
 * @Author: zzq
 * @Date: 2019/1/22
 */
@Table(name= "t_blog_article_comment")
public class BlogArticleComment extends BaseEntity implements Serializable {

    /*
     *用户ID
     * */
    private Long authorId;
    /*
    * 文章ID
    * */
    private Long articleId;
    /*
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
    private String stauts;

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getStauts() {
        return stauts;
    }

    public void setStauts(String stauts) {
        this.stauts = stauts;
    }

}
