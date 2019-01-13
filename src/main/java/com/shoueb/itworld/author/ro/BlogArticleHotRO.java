package com.shoueb.itworld.author.ro;

import com.shoueb.itworld.author.model.BlogArticleHot;

/**
 * @Description:
 * @Author: yuangui.hu
 * @Date: 2019/1/13 11:21
 */
public class BlogArticleHotRO extends BlogArticleHot {
    /**
     *系列名称
     */
    private String seriesTitle;

    public String getSeriesTitle() {
        return seriesTitle;
    }

    public void setSeriesTitle(String seriesTitle) {
        this.seriesTitle = seriesTitle;
    }
}
