package com.intellect.repository;

import java.util.List;

import com.intellect.entity.User;

public interface UserRepository {
	
	User saveUser(User user);

	List<User> getUsers();
	
	void saveUsers(List<User> users);

}
