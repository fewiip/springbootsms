package com.example.sms_sender_api.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder().group("smssenderapi-public").pathsToMatch("/sendsms/**").build();
	}
}
