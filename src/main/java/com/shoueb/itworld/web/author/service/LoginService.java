package com.shoueb.itworld.web.author.service;

import com.shoueb.itworld.author.model.AuthorUser;
import com.shoueb.itworld.common.result.ResultRO;

/**
 * @Description: 登录
 * @Author: admin
 * @Date: 2019/1/11 15:06
 */
public interface LoginService {
    ResultRO login(AuthorUser authorUser);
}
