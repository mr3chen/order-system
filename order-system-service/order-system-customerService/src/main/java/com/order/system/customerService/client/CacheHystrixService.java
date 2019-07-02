package com.order.system.customerService.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.order.system.common.result.ServiceResult;
import com.order.system.customerService.client.CacheService;
import com.order.system.customerService.common.vo.UserInfoVO;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CacheHystrixService {

	@Resource
	CacheService cacheService;

	@HystrixCommand(fallbackMethod = "fallbackCacheLoginInfo")
	public ServiceResult cacheLoginInfo(String key, UserInfoVO value, Long expireTime) {
		return cacheService.cacheLoginInfo(key, value, expireTime);
	}

	public ServiceResult fallbackCacheLoginInfo(String key, UserInfoVO value, Long expireTime) {
		log.info("cache Service cacheLoginInfo fallback");
		return ServiceResult.error(0, "cache Service cacheLoginInfo fallback");
	}

}
