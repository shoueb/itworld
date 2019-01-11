package com.shoueb.itworld.demo.dao;

import com.shoueb.comm.MyMapper;
import com.shoueb.itworld.demo.pojo.Test;

/**
 * Created by Jason on 2017/3/2.
 */
public interface TestMapper extends MyMapper<Test> {
    Test getTestById(Long id);
}
