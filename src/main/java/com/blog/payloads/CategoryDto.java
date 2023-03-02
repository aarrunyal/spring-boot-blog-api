package com.blog.payloads;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

public class CategoryDto {

	
	private Long id;
	
	@NotEmpty
	private String title;
	
	private Long categoryId;
	
	
	
	
	
	public CategoryDto() {
		
	}

//	
	
	public String getTitle() {
		return title;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long category_id) {
		this.categoryId = category_id;
	}
	
}
