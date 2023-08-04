package com.onlineKart.Controllers;


import java.util.List;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineKart.Repositories.CategoryRepo;
import com.onlineKart.Services.CategoryService;
import com.onlineKart.models.Category;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
@Autowired
	private CategoryService categoryService;

	@Autowired
	private CategoryRepo categoryRepo;
	
    @PostMapping("/add")
	public ResponseEntity<Category> addCategory(@RequestBody Category category )
	{
		return new ResponseEntity<Category>(categoryService.addNewCategory(category),HttpStatus.OK);
	}
    

    
    @GetMapping("/getall")
   public ResponseEntity<List<Category>> getallCategories()
   {
	   return new ResponseEntity(categoryService.getCategories(),HttpStatus.OK);
   }

    @DeleteMapping("/delete/{categoryId}")
	public ResponseEntity<HttpStatus> deleteCategory(@PathVariable(name = "categoryId") String categoryId  )
	{
    	categoryRepo.deleteById(categoryId);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}
