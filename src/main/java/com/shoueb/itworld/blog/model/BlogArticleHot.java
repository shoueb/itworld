package com.shoueb.itworld.blog.model;

import com.shoueb.itworld.common.entity.BaseEntity;
import lombok.Data;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description:热门博客
 * @Author: zzq
 * @Date: 2019/1/12
 */
@Table(name= "t_blog_article_hot")
@Data
public class BlogArticleHot extends BaseEntity implements Serializable {
    /**
     *UUID
     */
    private String  uid;
    /**
     *文章ID
     */
    private Long articleId;
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
     * 系列类别0散文1系列文章2解决方案3优秀开源
     */
    private String seriesType;
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
}
