package com.intellect.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.intellect.entity.User;
import com.intellect.service.UserService;


@RestController
public class UserResource {
	
	@Autowired
	UserService userService;
	
	@PutMapping("/user")
	public String createUser(@RequestBody User user) {
		userService.saveUser(user);
		return null;
		
	}
	
	@PostMapping("/user")
	public Integer updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return null;
		
	}
	
	@GetMapping("/user/{id}")
	public Integer fetchUser(@PathVariable String userId) {
		userService.getUser(userId);
		return null;
		
	}
	
	@DeleteMapping("/user/{id}")
	public Integer deleteUser(@PathVariable String userId) {
		userService.deleteUser(userId);
		return null;
	}

}
