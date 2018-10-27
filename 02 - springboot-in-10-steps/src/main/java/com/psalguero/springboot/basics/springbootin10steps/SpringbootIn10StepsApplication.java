package com.psalguero.springboot.basics.springbootin10steps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootIn10StepsApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = 
					SpringApplication.run(SpringbootIn10StepsApplication.class, args);

		System.out.println(String.format("Application ID -name: %s", applicationContext.getId()));

		for (String context :
				applicationContext.getBeanDefinitionNames()) {
			System.out.println(context);
		}
	}
}
