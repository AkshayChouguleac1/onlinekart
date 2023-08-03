package com.onlineKart.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineKart.Repositories.ProductRepo;
import com.onlineKart.Services.ProductService;
import com.onlineKart.models.Product;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepo productRepo;
	
	@PostMapping("/add")
	public ResponseEntity<Product> addnewproduct(@RequestBody Product Product)
	{
		return new ResponseEntity<Product>(productService.addNewProduct(Product), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<HttpStatus> deleteCategory(@PathVariable(name = "productId") String productId  )
	{
		productRepo.deleteById(productId);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

}
