package com.ygback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
@EntityScan({"com.ygback.domain", "com.ygback.models", "com.ygback.restapi"})
@ComponentScan(basePackages = {"com.ygback.domain","com.ygback.restapi", "com.ygback.service", "com.ygback.repositories"})

public class YgbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(YgbackApplication.class, args);
	}

}
