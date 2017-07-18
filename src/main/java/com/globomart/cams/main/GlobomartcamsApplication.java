package com.globomart.cams.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@ComponentScan(basePackages = "com.globomart")
@EnableWebMvc
@EnableAutoConfiguration
@EntityScan(basePackages = "com.globomart")
@PropertySource(name = "catalogproperties", value = { "classpath:application.properties"}, ignoreResourceNotFound = true)
@EnableJpaRepositories("com.globomart.cams")
@EnableTransactionManagement
public class GlobomartcamsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlobomartcamsApplication.class, args);
	}

	@Bean(name = "objectMapper")
	public ObjectMapper getObjectMapper() {
		return new ObjectMapper();
	}
}
