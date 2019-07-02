package com.order.system.cacheService.controller;

import javax.annotation.Resource;

import com.order.system.cacheService.common.constant.RedisKeyFormat;
import com.order.system.cacheService.model.UserInfoVO;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.order.system.cacheService.client.RedisClient;
import com.order.system.common.result.ServiceResult;

import lombok.extern.slf4j.Slf4j;

/**
 * 用户登陆相关cache
 *
 * @author zhongh2
 */
@RestController
@RequestMapping("/login")
@Slf4j
public class LoginCaCheController {

    @Resource
    RedisClient redisClient;

    /**
     * 缓存登陆信息
     */
    @PostMapping("/cacheLoginInfo")
    public ServiceResult cacheLoginInfo(@RequestParam(value = "key") String key, @RequestBody UserInfoVO value, @RequestParam(value = "expireTime") Long expireTime) {
        log.info("缓存登陆信息参数：key:{},value:{},expireTime:{}", key, JSON.toJSONString(value), expireTime);
        Preconditions.checkNotNull(key);
        Preconditions.checkNotNull(value);
        Preconditions.checkNotNull(expireTime);
        Preconditions.checkArgument(redisClient.set(String.format(RedisKeyFormat.CUSTOMER_LOGIN, key), value, expireTime), "缓存登陆信息失败");
        return ServiceResult.success();
    }


    /**
     * 获取登录信息
     */
    @GetMapping("/getLoginInfo")
    public ServiceResult getLoginInfo(String key) {
        Preconditions.checkNotNull(key);
        Object value = redisClient.get(String.format(RedisKeyFormat.CUSTOMER_LOGIN, key));
        return ServiceResult.success(value);
    }


}
