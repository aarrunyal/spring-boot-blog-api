package com.blog.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="categories")
public class Category {

	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private Long id;
	@Column(name="title", nullable = false)
	private String title;
	@Column(name="category_id", nullable = true)
	private Long categoryId;
	private String description;
	
	@OneToMany(mappedBy = "category", cascade= CascadeType.ALL)
	private List<Post> posts = new ArrayList<>();
	
	public Category() {
		
	}
	
	
//	public Category(String title, Long category_id) {
//		super();
//		this.title = title;
//		this.category_id = category_id;
//	}
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
	public void setCategoryId(Long categoryId) {
		this.categoryId= categoryId;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<Post> getPosts() {
		return posts;
	}


	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	
	
	
	

	
	
	
	
	
	
}
