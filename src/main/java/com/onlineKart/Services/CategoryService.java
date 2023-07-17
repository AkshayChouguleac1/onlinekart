package com.onlineKart.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlineKart.models.Category;

@Service
public interface CategoryService {
	public Category addNewCategory(Category category);
	public Category getCategoryFromId(String id);
	public List<Category> getCategories();
	public Category updateCategory(Category category);
	public void deleteCategory(String id);
	public List<Category> addAllCategories(List<Category> categorys);
}
