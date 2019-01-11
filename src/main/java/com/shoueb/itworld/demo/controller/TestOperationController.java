package com.shoueb.itworld.demo.controller;

import com.github.pagehelper.PageHelper;
import com.shoueb.itworld.demo.dao.TestMapper;
import com.shoueb.itworld.demo.pojo.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Description: Test表操作  采用Tk 也就是通用Mapper
 * @Author: admin
 * @Date: 2018/12/16 13:40
 */
@RestController
@RequestMapping("/test")
public class TestOperationController {
    private static final Logger LOG = LoggerFactory.getLogger(TestOperationController.class);
    @Autowired
    private TestMapper testMapper;
    @RequestMapping("save")
    public String save() {
        //mybatis 【半自动 】 xml -->mapper
        //tk操作
        Test test=new Test();
        test.setName("ddddddfdf");
        testMapper.insert(test);
        return "ok";
    }
    @RequestMapping("update")
    public String update(){
        Test test=new Test();
        test.setId(36L);
        test.setName("3333");
        //相应字段为null的时候不修改 只修改非null的值  根据主键 id
        testMapper.updateByPrimaryKeySelective(test);
        //全部修改  根据主键 id
//        testMapper.updateByPrimaryKey(test);
        return "ok";
    }


    @RequestMapping("getTestById/{id}")
    public Test getTestById(@PathVariable("id") Long id){
        //自定义方法的查询
      return   testMapper.getTestById(id);
    }
    @RequestMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id){
        //url  ==  ..../delete/36  传到id进去
        testMapper.deleteByPrimaryKey(id);
        return "ok";
    }
    @RequestMapping("del")
    public String del(@RequestParam("id") Long id){
        //url  ==  ..../delete?id=36  传到id进去
        testMapper.deleteByPrimaryKey(id);
        return "ok";
    }
    //全部：查询
    @RequestMapping("all")
    public List<Test> all(){
        return  testMapper.selectAll();
    }

    //全部：根据name模糊查询
    @RequestMapping("query")
    public List<Test> queryTestLikeName(){
        String name="dd";
        Example example=new Example(Test.class);
        //创建一个查询条件
        Example.Criteria criteria= example.createCriteria();
        criteria.andLike("name","%"+name+"%");
        return  testMapper.selectByExample(example);
    }

    //分页：根据name模糊查询 分页 每页显示3条
    @RequestMapping("queryPage")
    public List<Test> queryPage(){
        String name="dd";
        PageHelper.startPage(1,3);
        Example example=new Example(Test.class);
        //创建一个查询条件
        Example.Criteria criteria= example.createCriteria();
        criteria.andLike("name","%"+name+"%");
        return  testMapper.selectByExample(example);
    }
}
