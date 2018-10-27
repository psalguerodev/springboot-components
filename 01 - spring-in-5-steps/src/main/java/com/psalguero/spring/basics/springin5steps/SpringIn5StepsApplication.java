package com.psalguero.spring.basics.springin5steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringIn5StepsApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(SpringIn5StepsApplication.class, args);

		 BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);

		int result  = binarySearch.binarySearch(new int[]{0, 3}, 3);

		System.out.println(result);

	}
}
