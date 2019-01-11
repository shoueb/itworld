package com.shoueb.itworld.author.model;

import com.shoueb.itworld.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "t_author_user")
public class AuthorUser extends BaseEntity {

    private String muuid;
    private String userName;

    private String pwd;

    private String khName;

    private String khUuid;

    private String realName;

    private String codeType;

    private String codeNo;

    private Long authorFollowCount;

    private Long myFollowCount;

    private String status;

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

}