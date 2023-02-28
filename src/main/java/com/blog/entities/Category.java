package com.blog.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="categories")
public class Category {

	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private Long id;
	@Column(name="title", nullable = false)
	private String title;
	private Long category_id;
	
	
	
	
	
	public Category(String title, Long category_id) {
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
