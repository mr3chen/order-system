package org.order.system.registration.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MasterRegistrationApplication {
	public static void main(String[] args) {
		SpringApplication.run(MasterRegistrationApplication.class, args);
	}
}
