package com.psalguero.rest.webservices.springbootrestwebservices.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.psalguero.rest.webservices.springbootrestwebservices.beans.User;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	private static int userCount = 3;
	
	static {
		users.add(new User(1, "Patrick Salguero", new Date()));
		users.add(new User(2, "Marcelino Salguero", new Date()));
		users.add(new User(3, "Raquel Avalos", new Date()));		
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User findById(Integer id) {
		return users.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
	}
	
	public int deleteUser(Integer id) {
		Iterator<User> iterator = users.iterator();
		int success = 0;
		while(iterator.hasNext()) {
			if(iterator.next().getId() == id){
				iterator.remove();
				success =1;
				break;
			}
		}
		return success;
	}
	
	public User save(User user) {
		if(user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
}
