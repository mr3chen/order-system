//package com.order.system.gateway.filter.pre;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.common.collect.ImmutableList;
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//import com.order.system.gateway.common.constant.FilterOrder;
//import com.order.system.gateway.common.constant.FilterType;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Optional;
//
///**
// * 授权url拦截器
// * 对需要认证的url进行签名认证
// *
// * @author zhongh2
// */
//@Slf4j
//@Component
//public class AuthUrlFilter extends ZuulFilter {
//
//    @Value("${authUrl}")
//    private static String authUrlStr;
//
//    private static final ObjectMapper mapper = new ObjectMapper();
//
//    private static ImmutableList authUrlImList;
//
//    public void init() {
//        try {
//            if (authUrlImList != null)
//                return;
//
//            String[] authUrlArray = authUrlStr.split(",");
//            authUrlImList = ImmutableList.copyOf(authUrlArray);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public Object run() {
//        log.info("start AuthUrlFilter ---");
//        RequestContext ctx = RequestContext.getCurrentContext();
//        if (!Boolean.parseBoolean(ctx.get("isSuccess").toString())) {
//            log.info("上一个Filter失败，不进行处理");
//            return null;
//        }
//        init();
//        System.out.println("authUrlStr" + authUrlStr);
//        HttpServletRequest request = ctx.getRequest();
//        String requestUrl = request.getRequestURL().toString();
//
//        Optional.ofNullable(requestUrl).filter(x -> authUrlImList.contains(x)).ifPresent(v -> {
//            //valid sig
//            System.out.println("需要校验签名的url:" + requestUrl);
//        });
//
//        return null;
//    }
//
//    /**
//     * shouldFilter代表这个过滤器是否生效 true代表生效，false代表不生效
//     */
//    @Override
//    public boolean shouldFilter() {
//        return true;
//    }
//
//    @Override
//    public int filterOrder() {
//        return FilterOrder.SECOND;
//    }
//
//    @Override
//    public String filterType() {
//        return FilterType.PRE;
//    }
//}
