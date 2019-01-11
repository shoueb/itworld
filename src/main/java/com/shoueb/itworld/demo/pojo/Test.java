package com.shoueb.itworld.demo.pojo;

import com.shoueb.itworld.common.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by justin on 16/2/28.
 */
@Entity
@Table(name="t_test")
public class Test extends BaseEntity implements Serializable {
    /**
     * 账号
     */
    private String name;
    /**
     * 标题
     */
    private String title;
    /**
     * 简介
     */
    private String mem;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMem() {
        return mem;
    }

    public void setMem(String mem) {
        this.mem = mem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
