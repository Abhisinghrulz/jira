package com.fk.jira;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class JiraApplication {

	public static void main(String[] args) {
		SpringApplication.run(JiraApplication.class, args);
	}

}
