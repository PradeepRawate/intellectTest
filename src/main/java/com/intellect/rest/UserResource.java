package com.intellect.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intellect.entity.User;
import com.intellect.service.UserService;


@RestController
@RequestMapping("/api")
public class UserResource {
	
	@Autowired
	UserService userService;
	
	@PutMapping("/user")
	public String createUser(@RequestBody User user) {
		return userService.saveUser(user);
		
	}
	
	@PostMapping("/user")
	public String updateUser(@RequestBody User user) {
		return userService.updateUser(user);
		
	}
	
	@GetMapping("/user/{userId}")
	public User fetchUser(@PathVariable("userId") String userId) {
		return userService.getUser(userId);
		
	}
	
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable String userId) {
		return userService.deleteUser(userId);
	}

}
