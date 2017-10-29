package com.intellect.service;

import com.intellect.entity.User;

public interface UserService {

	public String saveUser(User user);

	public User getUser(String userId);

	public String updateUser(User user);

	public String deleteUser(String userId);
}
