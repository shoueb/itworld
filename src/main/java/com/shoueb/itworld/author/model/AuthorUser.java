package com.shoueb.itworld.author.model;

import com.shoueb.itworld.common.entity.BaseEntity;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "t_author_user")
public class AuthorUser extends BaseEntity implements Serializable {
    /**
     *用户唯一ID
     */
    private String muuid;
    /**
     *用户名
     */
    private String userName;
    /**
     *密码
     */
    private String pwd;
    /**
     *武侠昵称
     */
    private String khName;
    /**
     *武侠id
     */
    private String khUuid;
    /**
     *姓名
     */
    private String realName;
    /**
     *身份类型
     */
    private String codeType;
    /**
     *身份证码
     */
    private String codeNo;
    /**
     *作者关注我数量
     */
    private Long authorFollowCount;
    /**
     *我关注的作者数量
     */
    private Long myFollowCount;
    /**
     *状态 0冻结 1正常
     */
    private String status;

    /*
    * 用户头像
    * */
    private String imgUrl;
    /*
    * 用户收获喜欢数
    *
    * */
    private Long favorCount;

    /*
    * 用户已写字数
    * */
    private Long writenCount;

    public String getMuuid() {
        return muuid;
    }

    public void setMuuid(String muuid) {
        this.muuid = muuid == null ? null : muuid.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getKhName() {
        return khName;
    }

    public void setKhName(String khName) {
        this.khName = khName == null ? null : khName.trim();
    }

    public String getKhUuid() {
        return khUuid;
    }

    public void setKhUuid(String khUuid) {
        this.khUuid = khUuid == null ? null : khUuid.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType == null ? null : codeType.trim();
    }

    public String getCodeNo() {
        return codeNo;
    }

    public void setCodeNo(String codeNo) {
        this.codeNo = codeNo == null ? null : codeNo.trim();
    }

    public Long getAuthorFollowCount() {
        return authorFollowCount;
    }

    public void setAuthorFollowCount(Long authorFollowCount) {
        this.authorFollowCount = authorFollowCount;
    }

    public Long getMyFollowCount() {
        return myFollowCount;
    }

    public void setMyFollowCount(Long myFollowCount) {
        this.myFollowCount = myFollowCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Long getFavorCount() {
        return favorCount;
    }

    public void setFavorCount(Long favorCount) {
        this.favorCount = favorCount;
    }

    public Long getWritenCount() {
        return writenCount;
    }

    public void setWritenCount(Long writenCount) {
        this.writenCount = writenCount;
    }


}