package com.onlineKart.Controllers;


import java.util.List;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineKart.Repositories.CategoryRepo;
import com.onlineKart.Services.CategoryService;
import com.onlineKart.models.Category;
import com.onlineKart.models.Reply;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
@Autowired
	private CategoryService categoryService;

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private CustomMessage customMessage;
	@Autowired
	private Reply reply;
	
	//by using direct msg field
    @PostMapping("/addCatBysendbody")
	public ResponseEntity<Object> addCategoryBysendingCustommsg(@RequestBody Category category )
	{
     String name=category.getCategoryName();
     Category cat	=categoryRepo.findByCategoryName(name);
     if(cat!=null)
     {
    	 
         return ResponseEntity.status(HttpStatus.CONFLICT).body("Category already exists.");
     }
    else
    {
        return new ResponseEntity<Object>(categoryService.addNewCategory(category),HttpStatus.OK);

    }    	
  }
	
	//By setting header and sending error msg in header
	 @PostMapping("/addCatBysendHeader")
		public ResponseEntity<Category> addCategory(@RequestBody Category category )
		{
	     String name=category.getCategoryName();
	     Category cat	=categoryRepo.findByCategoryName(name);
	     HttpHeaders headers=new HttpHeaders();
	     
	     if(cat!=null)
	     {
	    	     headers.add("error-msg","categoy already exist");
	    	     return new ResponseEntity<Category>(headers,HttpStatus.OK);
	     }
	    else
	    {
	        return new ResponseEntity<Category>(categoryService.addNewCategory(category),HttpStatus.OK);

	    }    	
	  }

    
//    @GetMapping("/your-endpoint")
//    public ResponseEntity<String> yourEndpoint() {
//        // Your logic here
//        String responseBody = "Your response";
//        
//        // Create HttpHeaders and set the desired header
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Custom-Header", "Your-Header-Value");
//
//        // Return the ResponseEntity with the response body and headers
//        return new ResponseEntity<>(responseBody, headers, HttpStatus.OK);
//    }
//    
   
    

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
