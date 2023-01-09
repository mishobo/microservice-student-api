package com.husseinabdallah.studentdataapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class StudentDataApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentDataApiApplication.class, args);
	}

	@Bean
	public WebClient.Builder getWebClient(){
		return WebClient.builder();
	}

}
