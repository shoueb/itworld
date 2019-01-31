package com.shoueb.itworld.blog.ro;

import com.shoueb.itworld.blog.model.BlogArticleHot;
import lombok.Data;

/**
 * @Description:
 * @Author: yuangui.hu
 * @Date: 2019/1/13 11:21
 */
@Data
public class BlogArticleHotRO extends BlogArticleHot {
    /**
     *系列名称
     */
    private String seriesTitle;
    /**
     *武侠名称
     */
    private String khName;
    /**
     * 文章内容
     **/
    private String content;
}
