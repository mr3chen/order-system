package com.order.system.gateway.filter.pre;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.order.system.common.result.ServiceResult;
import com.order.system.gateway.common.constant.FilterOrder;
import com.order.system.gateway.common.constant.FilterType;
import com.order.system.gateway.filter.Wrapper.PostBodyRequestWrapper;
import com.order.system.gateway.model.UserInfo;
import com.order.system.gateway.service.CacheHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.Optional;

/**
 * 登陆拦截过滤器
 *
 * @author zhongh2
 */
@Slf4j
@Component
public class LoginFilter extends ZuulFilter {

    @Autowired
    CacheHystrixService cacheHystrixService;

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public Object run() {
        log.info("start LoginFilter ---");
        RequestContext ctx = RequestContext.getCurrentContext();
        if (!Boolean.parseBoolean(ctx.get("isSuccess").toString())) {
            log.info("上一个Filter失败，不进行处理");
            return null;
        }
        HttpServletRequest request = ctx.getRequest();
//        String loginSecret = request.getHeader("loginSecret"); // 登陆密钥放在请求头里面
        String loginSecret = "C7bSJRok";
        Optional.ofNullable(loginSecret).ifPresent((String v) -> {
            ServiceResult loginInfoResult = cacheHystrixService.getLoginInfo(loginSecret);
            Optional.ofNullable(loginInfoResult).filter(x -> "200".equals(x.getCode().toString())).ifPresent((ServiceResult j) -> {
                //make loginInfo push requestBody
                try {
                    UserInfo userInfo = mapper.readValue(JSON.toJSONString(j.getData()), UserInfo.class);
                    System.out.println("登录用户信息为：" + JSON.toJSONString(userInfo));
                    HttpServletRequestWrapper wrapper = new PostBodyRequestWrapper(request, userInfo);
                    ctx.setRequest(wrapper);
                    ctx.getZuulRequestHeaders().put(HttpHeaders.CONTENT_TYPE, "application/json");
                } catch (IOException e) {
                    e.printStackTrace();
                    ctx.set("isSuccess", "false"); //标记

                }
            });
        });
        log.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());
        return null;
    }

    /**
     * shouldFilter代表这个过滤器是否生效 true代表生效，false代表不生效
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public int filterOrder() {
        return FilterOrder.THIRD;
    }

    @Override
    public String filterType() {
        return FilterType.PRE;
    }

}
