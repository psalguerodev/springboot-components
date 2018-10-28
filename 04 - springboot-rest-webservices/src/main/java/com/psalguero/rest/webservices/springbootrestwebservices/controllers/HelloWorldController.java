package com.psalguero.rest.webservices.springbootrestwebservices.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.psalguero.rest.webservices.springbootrestwebservices.beans.HelloWorldBean;

@RestController
public class HelloWorldController {
	
	@GetMapping("/hello-world")
	public String sayHellow() {
		return "Hellow World with Spring Boot - Rest Services";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public  HelloWorldBean sayHellowBean() {
		return new HelloWorldBean("Hellow World with Spring Boot Bean - Rest Services");
	}
	
	@GetMapping("/hello-world-bean/{name}")
	public HelloWorldBean sayHellowBeanPath(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hellow World <%s> with Spring Boot Bean - Rest Services", name));
	}
	
}
