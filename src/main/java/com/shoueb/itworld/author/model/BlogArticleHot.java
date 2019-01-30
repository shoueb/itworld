package com.shoueb.itworld.author.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.shoueb.itworld.common.entity.BaseEntity;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description:热门博客
 * @Author: zzq
 * @Date: 2019/1/12
 */
@Table(name= "t_blog_article_hot")
public class BlogArticleHot extends BaseEntity implements Serializable {
    /**
     *作者ID
     */
    private Long authorId;
    /**
     *标题
     */
    private String articleTitle;
    /**
     *系列ID
     */
    private Long articleSeriesId;
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
     * 是否在首页显示 1是0否
     */
    private String showHome;
    /**
     *编辑推荐  1是0否
     */
    private String editorRecommend;

    /**
     *状态0新建1发布2审核通过3审核不通过4系统删除
     */
    private String status;
    /*
    * 文章内容
    * */
    private String content;

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
        this.articleTitle = articleTitle;
    }

    public Long getArticleSeriesId() {
        return articleSeriesId;
    }

    public void setArticleSeriesId(Long articleSeriesId) {
        this.articleSeriesId = articleSeriesId;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    public String getLanguageType() {
        return languageType;
    }

    public void setLanguageType(String languageType) {
        this.languageType = languageType;
    }

    public String getArticleMem() {
        return articleMem;
    }

    public void setArticleMem(String articleMem) {
        this.articleMem = articleMem;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getImgUrlMin() {
        return imgUrlMin;
    }

    public void setImgUrlMin(String imgUrlMin) {
        this.imgUrlMin = imgUrlMin;
    }

    public String getImgUrlMax() {
        return imgUrlMax;
    }

    public void setImgUrlMax(String imgUrlMax) {
        this.imgUrlMax = imgUrlMax;
    }

    public String getContentKeys() {
        return contentKeys;
    }

    public void setContentKeys(String contentKeys) {
        this.contentKeys = contentKeys;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
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
        this.deleteFlag = deleteFlag;
    }

    public String getShowPosition() {
        return showPosition;
    }

    public void setShowPosition(String showPosition) {
        this.showPosition = showPosition;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getEditorRecommend() {
        return editorRecommend;
    }

    public void setEditorRecommend(String editorRecommend) {
        this.editorRecommend = editorRecommend;
    }

    public String getShowHome() {
        return showHome;
    }

    public void setShowHome(String showHome) {
        this.showHome = showHome;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
