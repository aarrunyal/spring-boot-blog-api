package com.blog.services;

import java.util.List;

import com.blog.entities.Category;
import com.blog.entities.Post;
import com.blog.entities.User;
import com.blog.payloads.PostDto;


public interface PostService {

	PostDto createPost(PostDto postDto, Long userId, Long categoryId);
	
	PostDto updatePost(PostDto postDto, Long postId);
	
	PostDto getPostById(Long postId);
	
	List<PostDto> getAllPosts();
	
	void deletePost(Long postId);

//	get all post by category id
	List<PostDto> getPostByCategoryId(Long categoryId);
	
//	get all post by user id
	List<PostDto> getPostByUserId(Long userId);
	
// 	search post by key
	List<PostDto> seachPosts(String key);
}
