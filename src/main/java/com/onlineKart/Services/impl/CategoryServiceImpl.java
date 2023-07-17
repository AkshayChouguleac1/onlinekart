package com.onlineKart.Services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.onlineKart.Repositories.CategoryRepo;
import com.onlineKart.Services.CategoryService;
import com.onlineKart.models.Category;

public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepo categoryRepo;
	
	@Override
	public Category addNewCategory(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public Category getCategoryFromId(String id) {
		return categoryRepo.findById(id).orElse(null);
	}

	@Override
	public List<Category> getCategories() {
		return categoryRepo.findAll();
	}

	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCategory(String id) {
		this.categoryRepo.deleteById(id);
		
	}

	@Override
	public List<Category> addAllCategories(List<Category> categories) {
		return this.categoryRepo.saveAll(categories);
	}
}
