package com.shoueb.itworld.author.ro;

import com.shoueb.itworld.author.model.BlogArticleComment;
/**
 * @Description:
 * @Author: zzq
 * @Date: 2019/1/22
 */
public class BlogArticleCommentRO extends BlogArticleComment {
    /*
     * 作者名称
     * */
    private String khName;
    /*
    * 用户头像
    * */
    private String imgUrl;


    public String getKhName() {
        return khName;
    }

    public void setKhName(String khName) {
        this.khName = khName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }


}

