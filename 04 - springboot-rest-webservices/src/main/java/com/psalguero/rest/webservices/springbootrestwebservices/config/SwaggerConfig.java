package com.psalguero.rest.webservices.springbootrestwebservices.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	private static final Set<String> DEFAULT_CONSUMES_API = 
			new HashSet<String>(Arrays.asList("application/json", "application/xml"));

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.consumes(DEFAULT_CONSUMES_API)
				.apiInfo(configurationApiInfo());
	}
	
	private ApiInfo configurationApiInfo() {
		return new ApiInfoBuilder()
				.title("Spring Boot REST API")
                .description("\"Spring Boot REST API\"")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .contact(new Contact("Patrick Salguero", "https://patrick-salguero.com", "patrick.salguero.avalos@gmail.com"))
                .build();
	}
}
