package com.onlineKart.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineKart.models.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, String> {
	
	public Category findByCategoryId(String id);

}
