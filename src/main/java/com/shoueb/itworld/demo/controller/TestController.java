package com.shoueb.itworld.demo.controller;

import com.github.pagehelper.PageHelper;
import com.shoueb.itworld.demo.dao.TestMapper;
import com.shoueb.itworld.demo.pojo.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 测试例子
 * @Author: admin
 * @Date: 2018/12/16 13:40
 */
@RestController
@RequestMapping("/")
public class TestController {
    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);
    @Autowired
    private TestMapper testMapper;
    @RequestMapping("save")
    public String save() {
        for (int i = 0; i < 20; i++){
            Test test = new Test();
            test.setName("sdsd"+i);
            testMapper.insert(test);
        }
        return "ok";
    }
    @RequestMapping("all")
    public List<Test> all(){
        LOG.info("test all");
        return testMapper.selectAll();
    }
    @RequestMapping("page/{page}")
    public List<Test> page(@PathVariable("page") Integer page){
        LOG.info("test page");
        PageHelper.startPage(page,10);
        return testMapper.selectAll();
    }
    @RequestMapping("getById/{id}")
    public Test getById(@PathVariable("id") Long id){
        return testMapper.selectByPrimaryKey(id);
    }
}
