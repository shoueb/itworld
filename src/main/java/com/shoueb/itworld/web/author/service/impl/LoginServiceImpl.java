package com.shoueb.itworld.web.author.service.impl;

import com.google.common.base.Preconditions;
import com.shoueb.itworld.author.mapper.AuthorUserMapper;
import com.shoueb.itworld.author.model.AuthorUser;
import com.shoueb.itworld.common.exception.BusinessException;
import com.shoueb.itworld.common.result.ResultRO;
import com.shoueb.itworld.web.author.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Description: 登录Service实现
 * @Author: yuangui.hu
 * @Date: 2019/1/11 15:07
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AuthorUserMapper authorUserMapper;
    /**
     * 登录实现
     * @param authorUser 作者信息
     * @return
     */
    @Override
    @Transactional
    public ResultRO login(AuthorUser authorUser) {
        //校验参数
        //采用guava断言   注意Controller需要进行try catch
        Preconditions.checkNotNull(authorUser, "参数不能为空");
        Preconditions.checkNotNull(authorUser.getUserName(), "用户名不能为空");
        Preconditions.checkNotNull(authorUser.getPwd(), "密码不能为空");
        //注意采用MyBatis统一Mapper的 Example 【可以学一下】
        Example example=new Example(AuthorUser.class);
        example.createCriteria().andEqualTo("userName",authorUser.getUserName());
        List<AuthorUser> list= authorUserMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list) || list.size()>1){
            throw new BusinessException("用户名或密码错误");
        }
        AuthorUser authorUserRo=list.get(0);
        if(! authorUser.getPwd().equals(authorUserRo.getPwd())){
            throw new BusinessException("用户名或密码错误");
        }
        return ResultRO.success(authorUserRo);
    }
}
