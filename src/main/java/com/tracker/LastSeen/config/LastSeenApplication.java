package com.tracker.LastSeen.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.tracker.LastSeen"})
public class LastSeenApplication {

	public static void main(String[] args) {
		SpringApplication.run(LastSeenApplication.class, args);
	}

}
