package com.easyblog.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication(exclude = {ElasticsearchDataAutoConfiguration.class})
public class EasyBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyBlogApplication.class, args);
	}

}
