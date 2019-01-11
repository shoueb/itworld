package com.shoueb.comm;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Description: 通用Mapper
 * @Author: admin
 * @Date: 2018/12/16 13:26
 */
public interface MyMapper <T> extends Mapper<T>, MySqlMapper<T> {
    //TODO
    //FIXME 特别注意，该接口不能被扫描到，否则会出错
}
