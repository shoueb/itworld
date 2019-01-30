
package com.shoueb.itworld.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

/**
 * @Description: 基础表
 * @Author: yuangui.hu
 * @Date: 2018/12/16 13:40
 */
public class BaseEntity {
    /**
     * 唯一主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 创建者
     */
    @Column(name = "create_by_id")
    private Long createById;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
    /**
     * 修改ID
     */
    @Column(name = "update_by_id")
    private Long updateById;
    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    @Transient
    @JsonIgnore
    private Integer page = 1;

    @Transient
    @JsonIgnore
    private Integer rows = 10;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Long getCreateById() {
        return createById;
    }

    public void setCreateById(Long createById) {
        this.createById = createById;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateById() {
        return updateById;
    }

    public void setUpdateById(Long updateById) {
        this.updateById = updateById;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
