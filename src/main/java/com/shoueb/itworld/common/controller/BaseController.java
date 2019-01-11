package com.shoueb.itworld.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 基础Controller
 * @Author: admin
 * @Date: 2019/1/11 15:05
 */
public class BaseController  {
    private static final Logger LOG = LoggerFactory.getLogger(BaseController.class);
    @Autowired
    public HttpServletRequest request;
}
