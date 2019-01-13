package com.shoueb.itworld.author.model;


import com.shoueb.itworld.common.entity.BaseEntity;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description: 博客文章
 * @Author: zzq
 * @Date: 2019/1/12
 */
@Table(name = "t_blog_article")
public class BlogArticle extends BaseEntity implements Serializable {
    /**
     *作者ID
     */
    private Long authorId;
    /**
     *标题
     */
    private String articleTitle;
    /**
     *文章类型
     */
    private String articleType;
    /**
     *技术语言类型
     */
    private String languageType;
    /**
     *简介
     */
    private String articleMem;
    /**
     *文章内容地址
     */
    private String contentUrl;
    /**
     *小图片地址
     */
    private String imgUrlMin;
    /**
     *大图片地址
     */
    private String imgUrlMax;
    /**
     *文章关键字
     */
    private String contentKeys;
    /**
     *开源地址
     */
    private String githubUrl;
    /**
     *评论总数
     */
    private Long commentCount;
    /**
     *阅读总数
     */
    private Long readCount;
    /**
     *实践总数
     */
    private Long practiceCount;
    /**
     *数据状态1正常 0 删除
     */
    private String deleteFlag;
    /**
     *显示位置 0默认1候选2精选
     */
    private String showPosition;
    /**
     *状态0新建1发布2审核通过3审核不通过4系统删除
     */
    private String status;

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType == null ? null : articleType.trim();
    }

    public String getLanguageType() {
        return languageType;
    }

    public void setLanguageType(String languageType) {
        this.languageType = languageType == null ? null : languageType.trim();
    }

    public String getArticleMem() {
        return articleMem;
    }

    public void setArticleMem(String articleMem) {
        this.articleMem = articleMem == null ? null : articleMem.trim();
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl == null ? null : contentUrl.trim();
    }

    public String getImgUrlMin() {
        return imgUrlMin;
    }

    public void setImgUrlMin(String imgUrlMin) {
        this.imgUrlMin = imgUrlMin == null ? null : imgUrlMin.trim();
    }

    public String getImgUrlMax() {
        return imgUrlMax;
    }

    public void setImgUrlMax(String imgUrlMax) {
        this.imgUrlMax = imgUrlMax == null ? null : imgUrlMax.trim();
    }
    public String getContentKeys() {
        return contentKeys;
    }

    public void setContentKeys(String contentKeys) {
        this.contentKeys = contentKeys  == null ? null : contentKeys.trim();;
    }


    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl == null ? null : githubUrl.trim();
    }

    public Long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }

    public Long getReadCount() {
        return readCount;
    }

    public void setReadCount(Long readCount) {
        this.readCount = readCount;
    }

    public Long getPracticeCount() {
        return practiceCount;
    }

    public void setPracticeCount(Long practiceCount) {
        this.practiceCount = practiceCount;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }

    public String getShowPosition() {
        return showPosition;
    }

    public void setShowPosition(String showPosition) {
        this.showPosition = showPosition == null ? null : showPosition.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }


}