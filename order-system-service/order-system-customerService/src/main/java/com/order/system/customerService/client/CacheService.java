package com.order.system.customerService.client;

import com.order.system.common.result.ServiceResult;
import com.order.system.customerService.common.vo.UserInfoVO;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient("cache")
public interface CacheService {
    @RequestMapping(method = RequestMethod.POST, value = "/login/cacheLoginInfo.do", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    ServiceResult cacheLoginInfo(@RequestParam("key") final String key,
                                 @RequestBody final UserInfoVO value,
                                 @RequestParam("expireTime") final Long expireTime);

}
