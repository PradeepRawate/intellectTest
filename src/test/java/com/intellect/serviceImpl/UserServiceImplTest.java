package com.intellect.serviceImpl;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.intellect.entity.User;
import com.intellect.repository.UserRepository;


@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest{
	
	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	UserServiceImpl userService;
	
	@Test
	public void shouldSaveUser() {
		when(userRepository.saveUser(any(User.class))).thenReturn(buildUser());
		String result = userService.saveUser(buildNewUser());
		assertTrue(result.contains("Created"));
		
	}
	
	@Test
	public void shouldUpdateUser() {
		when(userRepository.saveUser(any(User.class))).thenReturn(buildUser());
		String result = userService.updateUser(buildUser());
		assertTrue(result.contains("Updated"));
		
	}

	private User buildUser() {
		User user = buildNewUser();
		user.setId("1");
		return user;
	}
	
	private User buildNewUser() {
		User user = new User();
		user.setFname("Pradeep");
		return user;
	}

}
