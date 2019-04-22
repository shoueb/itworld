package com.shoueb.itworld.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: yuangui.hu
 * @Date: 2019/3/15 11:42
 */
@Controller
@RequestMapping("/")
public class ExportController {
    @RequestMapping("export_index")
    public String exportIndex(){
        return "blogs/export";
    }
    @RequestMapping("export")
    @ResponseBody
    public List export(){
        List<String> list=new ArrayList<>();
        for (int i=0;i<10000;i++){
            list.add("list"+i);
        }
        return list;
    }
}
