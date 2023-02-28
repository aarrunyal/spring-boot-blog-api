package com.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.blog.entities.User;
import com.blog.exception.ResourceNotFoundException;
import com.blog.payloads.UserDto;
import com.blog.repositories.UserRepository;
import com.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepo;
	private ModelMapper modelMapper;

	public UserServiceImpl(UserRepository userRepository, ModelMapper mapper) {
		this.userRepo = userRepository;
		this.modelMapper = mapper;
	}

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToEntity(userDto);
		User savedUser = this.userRepo.save(user);
		return this.entityToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Long userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow((() -> new ResourceNotFoundException("User", "id", userId)));

		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setAbout(userDto.getAbout());
		User updateUser = this.userRepo.save(user);
		return this.entityToDto(updateUser);
	}

	@Override
	public UserDto getUserById(Long userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow((() -> new ResourceNotFoundException("User", "id", userId)));
		return this.entityToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = this.userRepo.findAll();
		
		List<UserDto> userDtos = users.stream()
				.map(user->this.entityToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Long userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow((() -> new ResourceNotFoundException("User", "id", userId)));
		this.userRepo.delete(user);

	}

	private User dtoToEntity(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		return user;
	}

	private UserDto entityToDto(User user) {
		UserDto userDto  = this.modelMapper.map(user, UserDto.class);
		return userDto;
	}

}
