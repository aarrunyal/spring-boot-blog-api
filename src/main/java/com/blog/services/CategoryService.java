package com.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.payloads.CategoryDto;
import com.blog.payloads.UserDto;

public interface CategoryService {

	CategoryDto createCategory(CategoryDto categoryDto);
	
	CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId);
	
	CategoryDto getCategoryById(Long categoryId);
	
	List<CategoryDto> getAllCategories();
	
	void deleteCategory(Long categoryId);
}
