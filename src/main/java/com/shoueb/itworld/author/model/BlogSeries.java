package com.shoueb.itworld.author.model;

import com.shoueb.itworld.common.entity.BaseEntity;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description: 博客系列
 * @Author: zzq
 * @Date: 2019/1/12
 */
@Table(name = "t_blog_series")
public class BlogSeries extends BaseEntity implements Serializable {
    /**
     *标题
     */
    private String seriesTitle;
    /**
     *简介
     */
    private String seriesMem;
    /**
     *作者ID
     */
    private Long authorId;
    /**
     *状态0新建1发布2审核通过3审核不通过4系统删除
     */
    private String status;
    /**
     *系列类别0散文1系列文章2解决方案3优秀开源
     */
    private String seriesType;
    /**
     *数据状态1正常0删除
     */
    private String deleteFlag;

    public String getSeriesTitle() {
        return seriesTitle;
    }

    public void setSeriesTitle(String seriesTitle) {
        this.seriesTitle = seriesTitle;
    }

    public String getSeriesMem() {
        return seriesMem;
    }

    public void setSeriesMem(String seriesMem) {
        this.seriesMem = seriesMem;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSeriesType() {
        return seriesType;
    }

    public void setSeriesType(String seriesType) {
        this.seriesType = seriesType;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }


}
