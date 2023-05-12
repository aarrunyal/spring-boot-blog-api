package com.blog.security;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.blog.entities.User;
import com.blog.exception.ResourceNotFoundException;
import com.blog.repositories.UserRepository;

@Component
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
//	@Autowired
//	private ModelMapper modelMapper;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user =  userRepository.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("User", "email :"+username, (long) 1));
//		return this.modelMapper.map(user, CustomUserDetails.class);
		
		
		Optional<User> user = userRepository.findByEmail(username);
		return user.map(CustomUserDetails::new).orElseThrow(()->new ResourceNotFoundException("User", "email :"+username, (long) 1));

	}

}
