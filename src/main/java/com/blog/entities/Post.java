package com.blog.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="posts")
@Getter
@Setter
@NoArgsConstructor
public class Post {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=100, nullable = false)
	private String title;
	
	@Column(length=10000, nullable = true)
	private String content;
	
	@Column( nullable = true)
	private String image;
	
	@Column( nullable = true, name="created_date")
	private Date createdDate;

	@ManyToOne
	private User user;
	
	@ManyToOne
	private Category category;
	
}
