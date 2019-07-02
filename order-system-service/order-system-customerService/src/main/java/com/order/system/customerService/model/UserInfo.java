package com.order.system.customerService.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_user_info")
public class UserInfo {
	@Id
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 用户姓名，限制长度不能超过10个中文
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户性别(0:未知，1：男，2：女)
     */
    @Column(name = "user_sex")
    private Integer userSex;

    /**
     * 用户手机号码
     */
    @Column(name = "user_phone")
    private String userPhone;

    /**
     * 用户注册时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 用户密码加密盐值
     */
    private String salt;

    /**
     * 用户密码，md5加密
     */
    @Column(name = "PASSWORD")
    private String password;

    /**
     * 用户账号
     */
    private String account;

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取用户姓名，限制长度不能超过10个中文
     *
     * @return user_name - 用户姓名，限制长度不能超过10个中文
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户姓名，限制长度不能超过10个中文
     *
     * @param userName 用户姓名，限制长度不能超过10个中文
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取用户性别(0:未知，1：男，2：女)
     *
     * @return user_sex - 用户性别(0:未知，1：男，2：女)
     */
    public Integer getUserSex() {
        return userSex;
    }

    /**
     * 设置用户性别(0:未知，1：男，2：女)
     *
     * @param userSex 用户性别(0:未知，1：男，2：女)
     */
    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    /**
     * 获取用户手机号码
     *
     * @return user_phone - 用户手机号码
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * 设置用户手机号码
     *
     * @param userPhone 用户手机号码
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * 获取用户注册时间
     *
     * @return create_date - 用户注册时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置用户注册时间
     *
     * @param createDate 用户注册时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取用户密码加密盐值
     *
     * @return solt - 用户密码加密盐值
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置用户密码加密盐值
     *
     * @param solt 用户密码加密盐值
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 获取用户密码，md5加密
     *
     * @return PASSWORD - 用户密码，md5加密
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置用户密码，md5加密
     *
     * @param password 用户密码，md5加密
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取用户账号
     *
     * @return account - 用户账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置用户账号
     *
     * @param account 用户账号
     */
    public void setAccount(String account) {
        this.account = account;
    }
}