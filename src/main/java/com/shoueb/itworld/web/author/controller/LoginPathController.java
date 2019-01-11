package com.shoueb.itworld.web.author.controller;

import com.shoueb.itworld.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description: 会员登录
 * @Author: yuangui.hu
 * @Date: 2019/1/11 15:00
 */
@Controller("webLoginPathController")
@RequestMapping("/")
public class LoginPathController extends BaseController {
    /**
     * 跳转到登录页面
     * @return 跳转到登录页面
     */
    @RequestMapping(value = "login" ,method = RequestMethod.GET)
    public String login(){
        //web前端跳转到  web 文件下
        return "web/login";
    }

}
