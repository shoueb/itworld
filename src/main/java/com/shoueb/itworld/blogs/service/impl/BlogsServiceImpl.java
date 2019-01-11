package com.shoueb.itworld.blogs.service.impl;

import com.shoueb.itworld.blogs.service.BlogsService;
import com.shoueb.itworld.demo.dao.TestMapper;
import com.shoueb.itworld.demo.pojo.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: TODO
 * @Author: admin
 * @Date: 2018/12/28 16:51
 */
@Service
public class BlogsServiceImpl implements BlogsService {
    @Autowired
    private TestMapper testMapper;
    @Override
    public List<Test> queryBlogsAll(){
        return testMapper.selectAll();
    }
}
