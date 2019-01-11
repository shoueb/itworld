package com.shoueb.itworld.web.author.controller;

import com.shoueb.itworld.author.model.AuthorUser;
import com.shoueb.itworld.common.controller.BaseController;
import com.shoueb.itworld.common.exception.BusinessException;
import com.shoueb.itworld.common.result.ResultRO;
import com.shoueb.itworld.web.author.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 会员登录
 * @Author: yuangui.hu
 * @Date: 2019/1/11 15:00
 */
@RestController("webLoginController")
@RequestMapping("/")
public class LoginController extends BaseController {
    /**
     * 日志
     */
    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
    /**
     * 注入LoginService
     */
    @Autowired
    private LoginService loginService;

    /***
     * 登录
     * @param userName 用户名
     * @param pwd  密码
     * @return 返回登录结果集
     */
    @RequestMapping(value = "doLogin" ,method = RequestMethod.POST)
    @ResponseBody
    public ResultRO doLogin(@RequestParam("username") String userName,@RequestParam("pwd") String pwd){
        try {
            AuthorUser authorUser=new AuthorUser();
            authorUser.setUserName(userName);
            authorUser.setPwd(pwd);
            loginService.login(authorUser);
            return ResultRO.success();
        }catch (BusinessException buss){
            LOG.error("登录失败",buss.getMessage());
            return ResultRO.error(buss.getMessage());
        }catch (Exception o){
            LOG.error("登录失败",o);
            return ResultRO.error("用户名或密码错误");
        }
    }
}
