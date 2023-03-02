package com.blog.payloads;

import java.util.Date;

import com.blog.entities.Category;
import com.blog.entities.User;

import jakarta.persistence.Column;

public class PostDto {

	private Long id;
	private String title;
	private String content;
	private String image;
	private Date createdDate;
//	
	private CategoryDto category;
	private UserDto user;
	
	public PostDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}
//




	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}





	public CategoryDto getCategory() {
		return category;
	}





	public void setCategory(CategoryDto category) {
		this.category = category;
	}





	public UserDto getUser() {
		return user;
	}





	public void setUser(UserDto user) {
		this.user = user;
	}

	
	

	
	
}
