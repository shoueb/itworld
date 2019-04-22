package com.shoueb.itworld.member;

import com.shoueb.itworld.author.mapper.AuthorUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: yuangui.hu
 * @Date: 2019/3/12 16:49
 */
@RestController("for")
public class ForUpdateTestController {
    @Autowired
    private AuthorUserMapper authorUserMapper;
    @RequestMapping("lock")
    @Transactional
    public String lock(){
        System.out.println("start lock");
        Long id= authorUserMapper.lock(1);
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end lock");
        return id.toString();
    }

    @RequestMapping("get")
    @Transactional
    public String get(){
        System.out.println("start get");
        Long id= authorUserMapper.lock(1);
        System.out.println("end get");
        return id.toString();
    }
}
