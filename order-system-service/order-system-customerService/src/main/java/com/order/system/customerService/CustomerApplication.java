package com.order.system.customerService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.order.system.customerService.dao")
@ComponentScan(basePackages = { "com.order.system.customerService.controller",
		"com.order.system.customerService.service", "com.order.system.customerService.dao",
		"com.order.system.customerService.config", "com.order.system.customerService.client" })
// 禁用spring自动配置数据库
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class})
@EnableTransactionManagement(proxyTargetClass = true)
@EnableFeignClients(basePackages = "com.order.system.customerService.client")
@EnableCircuitBreaker
@EnableEurekaClient
public class CustomerApplication {
	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}
}
