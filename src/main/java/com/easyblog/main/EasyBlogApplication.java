package com.easyblog.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class EasyBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyBlogApplication.class, args);
	}

}
