package com.psalguero.rest.webservices.springbootrestwebservices.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.psalguero.rest.webservices.springbootrestwebservices.beans.User;
import com.psalguero.rest.webservices.springbootrestwebservices.exceptions.UserNotFoundException;
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
	public Resource<User> findOne(@PathVariable Integer id) {
		User userFind = userDaoService.findById(id);
		if(userFind == null) {
			throw new UserNotFoundException("ID=" + id);
		}
		
		Resource<User> resource = new Resource<User>(userFind);
		
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findAll());
		
		resource.add(linkTo.withRel("all-users"));
		
		return resource;
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteById(@PathVariable Integer id) {
		int success = userDaoService.deleteUser(id);
		
		if(success == 0) {
			throw new UserNotFoundException("ID="+id);
		}
	}

	@PostMapping("/users")
	public ResponseEntity save(@Valid @RequestBody User user) {
		User savedUser = userDaoService.save(user);
		URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(user.getId())
						.toUri();
		
		return ResponseEntity.created(location).build();
	}
}
