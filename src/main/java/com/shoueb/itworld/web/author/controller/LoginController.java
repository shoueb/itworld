package com.shoueb.itworld.web.author.controller;

import com.google.common.base.Preconditions;
import com.shoueb.itworld.author.model.AuthorUser;
import com.shoueb.itworld.common.controller.BaseController;
import com.shoueb.itworld.common.exception.BusinessException;
import com.shoueb.itworld.common.result.ResultRO;
import com.shoueb.itworld.common.utils.MD5Utils;
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
    @RequestMapping(value = "doLogin" ,method = {RequestMethod.POST})
    @ResponseBody
    public ResultRO doLogin(@RequestParam(value="username") String userName,
                            @RequestParam(value="pwd") String pwd){
        try {
            //验证条件
            Preconditions.checkNotNull(userName, "用户名不能为空");
            Preconditions.checkNotNull(pwd, "密码不能为空");
            if(userName.length()<6){
                return ResultRO.error("用户名或密码错误");
            }
            if(pwd.length()<6){
                return ResultRO.error("用户名或密码错误");
            }
            //密码  用户名+密码  唯一   用户名唯一
            pwd= MD5Utils.md5Password(userName.trim()+pwd);
            //设置值===对象
            AuthorUser authorUser=new AuthorUser();
            authorUser.setUserName(userName);
            authorUser.setPwd(pwd);
            //调用service
            ResultRO resultRO=loginService.login(authorUser);
            //返回值判断是否成功
            if(resultRO==null || resultRO.isError()){
                //我不认为你是对  互不信任原则
                throw new BusinessException("用户名或密码错误");
            }
            //做成功的事
            request.getSession().setAttribute("author",resultRO.getData());
            //告诉调用者
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
