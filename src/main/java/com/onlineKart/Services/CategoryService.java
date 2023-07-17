package com.onlineKart.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlineKart.models.Category;

@Service
public interface CategoryService {
	public List<Category> getCategoryByDate(String date);
	public Category addNewCategory(Category category);
	public Category getCategoryFromId(int id);
	public List<Category> getCategorys();
	public Category updateCategory(Category category);
	public void deleteCategory(int id);
	public List<Category> addAllCategorys(List<Category> categorys);
}
