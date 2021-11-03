package com.kubetestui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class KubetestUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KubetestUiApplication.class, args);
	}

	@Bean
	public RestTemplate getResttemplate() {
		return new RestTemplate();
	}
}
