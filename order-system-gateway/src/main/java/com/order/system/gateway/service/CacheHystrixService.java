package com.order.system.gateway.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.order.system.common.result.ServiceResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CacheHystrixService {

    @Autowired
    CacheService cacheService;

    @HystrixCommand(fallbackMethod = "fallbackCacheLoginInfo")
    public ServiceResult cacheLoginInfo(String key, Object value, Long expireTime) {
        return cacheService.cacheLoginInfo(key, value, expireTime);
    }

    public ServiceResult fallbackCacheLoginInfo(String key, Object value, Long expireTime) {
        log.info("cache Service cacheLoginInfo fallback");
        return ServiceResult.error(0, "cache Service cacheLoginInfo fallback");
    }

    @HystrixCommand(fallbackMethod = "fallbackGetLoginInfo")
    public ServiceResult getLoginInfo(String key) {
        return cacheService.getLoginInfo(key);
    }

    public ServiceResult fallbackGetLoginInfo(String key) {
        log.info("cache Service getLoginInfo fallback,key:{}", key);
        return ServiceResult.error(0, "cache Service getLoginInfo fallback");
    }


}
