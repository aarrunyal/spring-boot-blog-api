package com.blog.services;

import java.util.List;

import com.blog.entities.User;
import com.blog.payloads.UserDto;

public interface UserService {

	UserDto createUser(UserDto userDto);
	
	UserDto updateUser(UserDto userDto, Long userId);
	
	UserDto getUserById(Long userId);
	
	List<UserDto> getAllUsers();
	
	void deleteUser(Long userId);
}
