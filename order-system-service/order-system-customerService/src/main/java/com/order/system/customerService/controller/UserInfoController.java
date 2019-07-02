package com.order.system.customerService.controller;

import com.alibaba.fastjson.JSON;
import com.order.system.common.result.ServiceResult;
import com.order.system.customerService.common.query.TestQuery;
import com.order.system.customerService.common.query.UserRegRequest;
import com.order.system.customerService.client.CacheService;
import com.order.system.customerService.common.query.UserLoginRequest;
import com.order.system.customerService.common.vo.UserInfoVO;
import com.order.system.customerService.service.IUserInfoService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.util.Objects;

/**
 * @author: zhonghao
 * @date: 2019/01/23 11:36:32
 * @description: UserInfo控制器
 */

@Api(value = "用户相关接口")
@RestController
@RequestMapping("/user")
@Slf4j
public class UserInfoController {
    @Resource
    private IUserInfoService userInfoService;

    /**
     * 注册
     */
    @PostMapping("/register.do")
    public ServiceResult register(@Validated @RequestBody UserRegRequest userRegRequest) {
        Objects.requireNonNull(userRegRequest);
        if (userInfoService.register(userRegRequest)) {
            return ServiceResult.success("注册成功");
        }
        return ServiceResult.error("注册失败");

    }

    /**
     * 登录
     */
    @PostMapping("/login.do")
    public ServiceResult login(@RequestBody UserLoginRequest userLoginQuery) {
        Objects.requireNonNull(userLoginQuery);
        log.info("登录参数：{}", JSON.toJSONString(userLoginQuery));
        return userInfoService.loginByPhoneORAccount(userLoginQuery.getPhone(), userLoginQuery.getAccount(),
                userLoginQuery.getPassword());
    }


    /**
     * test
     */
    @PostMapping("/test.do")
    public ServiceResult login(@RequestBody TestQuery testQuery, HttpServletRequest request) {
        System.out.println("test.do:" + JSON.toJSONString(testQuery));
        return ServiceResult.success();
    }


}
