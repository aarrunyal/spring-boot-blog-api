package com.blog.payloads;

import java.util.Date;

import com.blog.entities.Category;
import com.blog.entities.User;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class PostDto {

	private Long id;
	private String title;
	private String content;
	private String image;
	private Date createdDate;
//	
	private CategoryDto category;
	private UserDto user;


	
	
}
