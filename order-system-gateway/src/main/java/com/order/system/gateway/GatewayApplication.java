package com.order.system.gateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients 
@EnableCircuitBreaker 
@EnableZuulProxy  //开启zuul网关服务功能
//禁用spring自动配置数据库
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class GatewayApplication {
	public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}




