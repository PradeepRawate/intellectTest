package com.intellect.service;

import org.springframework.stereotype.Component;

import com.intellect.entity.User;

@Component
public interface UserService {

	public String saveUser(User user);

	public User getUser(String userId);

	public String updateUser(User user);

	public String deleteUser(String userId);
}
