package com.psalguero.rest.webservices.springbootrestwebservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.psalguero.rest.webservices.springbootrestwebservices.beans.User;
import com.psalguero.rest.webservices.springbootrestwebservices.services.UserDaoService;

@RestController
public class UserController {
	
	@Autowired
	private UserDaoService userDaoService;
	
	@GetMapping("/users")
	public List<User> findAll() {
		return userDaoService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User findOne(@PathVariable Integer id) {
		return userDaoService.findById(id);
	}
}
