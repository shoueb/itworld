package com.shoueb.itworld.blogs.service;

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

public interface BlogsService {
     List<Test> queryBlogsAll();
}
