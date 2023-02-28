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
	
	private Long category_id;
	
	
	
	
	
	public CategoryDto() {
		super();
	}


	public CategoryDto(String title, Long category_id) {
		super();
		this.title = title;
		this.category_id = category_id;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}
	
}
