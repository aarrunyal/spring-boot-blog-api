package com.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDto {

	
	
	public UserDto() {
		
	}
	
	private Long id;
	
	@NotEmpty
	@Size(min=4, message = "First Name must be minimum of 4 characters")
	private String firstName;
	
	@NotEmpty
	@Size(min=4, message = "Last Name must be minimum of 4 characters")
	private String lastName;
	
	@NotEmpty
	@Email(message="Email address is not valid !!")
	private String email;
	
	@NotEmpty
	private String about;
	
	@NotEmpty(message="Email cannot be empty")
	@Size(min=4, max = 10, message="Password must be minimum of 4 chars and maximum of 10 chars")
//	@Pattern(regexp = "pattern here")
	private String password;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
