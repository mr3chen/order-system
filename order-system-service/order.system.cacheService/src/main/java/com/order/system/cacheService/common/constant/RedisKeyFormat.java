package com.order.system.cacheService.common.constant;

public class RedisKeyFormat {

    //CUSTOMER
    public static final String CUSTOMER_LOGIN = "ORDER_SYSTEM:CUSTOMER:LOGIN:%s";


    public static void main(String[] args) {
        System.out.println(String.format(CUSTOMER_LOGIN, "xxx"));
    }

}
