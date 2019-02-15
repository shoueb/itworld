package com.shoueb.itworld.blog.model;

import com.shoueb.itworld.common.entity.BaseEntity;
import lombok.Data;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description: 博客文章
 * @Author: zzq
 * @Date: 2019/1/12
 */
@Table(name = "t_blog_article")
@Data
public class BlogArticle extends BaseEntity implements Serializable {
    /**
     *UUID
     */
    private String  uid;
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
     *AI评论
     */
    private String aiComment;
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
     *实践父类文章ID ,自己为0
     */
    private Long practiceParentId;
    /**
     *数据状态1正常 0 删除
     */
    private String deleteFlag;
    /**
     *显示位置 0默认1候选2精选
     */
    private String showPosition;
    /**
     *编辑推荐  1是0否
     */
    private String editorRecommend;
    /**
     *状态0新建1发布2审核通过3审核不通过4系统删除
     */
    private String status;

}