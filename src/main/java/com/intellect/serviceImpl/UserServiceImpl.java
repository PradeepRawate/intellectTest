package com.intellect.serviceImpl;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;

import com.intellect.entity.User;
import com.intellect.repository.UserRepository;
import com.intellect.service.UserService;

public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public String saveUser(User user) {
		User userNew = new User();
		if(user.getId() != null) {
			return updateUser(user);
		} else {
			AtomicInteger nextId = new AtomicInteger();
			user.setId(Integer.toString(nextId.incrementAndGet()));
			userNew = userRepository.saveUser(user);
			return "User Created Successfully ! User Id is : "+ user.getId();
		}
	}

	@Override
	public String updateUser(User user) {
		if(user.getId() == null) {
			return saveUser(user);
		} else {
			userRepository.saveUser(user);
		}
		return "User Updated Successfully ! User Id is : "+ user.getId();
	}

	@Override
	public User getUser(String userId) {
		List<User> users = userRepository.getUsers();
		for (User userToFetch : users) {
			if(userId == userToFetch.getId())
				return userToFetch;
		}
		return null;
	}

	@Override
	public String deleteUser(String userId) {
		User user = new User();
		List<User> users = userRepository.getUsers();
		for (User userToFetch : users) {
			if(userId == userToFetch.getId())
				user.setIsActive(false);
		}
		userRepository.saveUsers(users);
		return "User Deleted Successfully : "+ user.getId();
	}
}
