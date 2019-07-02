package com.order.system.gateway.service;

import com.order.system.common.result.ServiceResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient("cache")
public interface CacheService {
	@RequestMapping(method = RequestMethod.POST, value = "/login/cacheLoginInfo", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	ServiceResult cacheLoginInfo(@RequestParam("key") final String key, @RequestParam("value") final Object value,
			@RequestParam("expireTime") final Long expireTime);

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/login/getLoginInfo", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	ServiceResult getLoginInfo(@RequestParam("key") final String key);
}
