package com.intellect.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.intellect.entity.User;

@Repository
public interface UserRepository {
	
	User saveUser(User user);

	List<User> getUsers();
	
	void saveUsers(List<User> users);

}
