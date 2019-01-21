package com.shoueb.itworld.author.mapper;

import com.shoueb.comm.MyMapper;
import com.shoueb.itworld.author.model.AuthorUser;

public interface AuthorUserMapper extends MyMapper<AuthorUser> {
    AuthorUser loginByNameAndPwd(String userName,String pwd);
    /*
    * 搜索作者的信息
    * */


    AuthorUser queryAuthorById(Long id);
}
