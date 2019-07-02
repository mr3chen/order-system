package org.order.system.registration.backup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BackupRegistrationApplication {
	public static void main(String[] args) {
		SpringApplication.run(BackupRegistrationApplication.class, args);
	}
}
