package com.onlineKart.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineKart.Repositories.CategoryRepo;
import com.onlineKart.Services.ProductService;
import com.onlineKart.models.Category;
import com.onlineKart.models.Product;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryRepo categoryRepo;
	@PostMapping("/add")
	public ResponseEntity<Product> addnewproduct(@RequestBody Product product)
	{
		return new ResponseEntity<Product>(productService.addNewProduct(product), HttpStatus.OK);
	}
	
	@PostMapping("/adding/{id}")
	public ResponseEntity<Product> neweradd(@RequestBody Product Product,@PathVariable("id")String id)
	{
		System.out.println(id);
		Category categoy=categoryRepo.findById(id).orElse(null);
		Product.setCategory(categoy);
		return new ResponseEntity<Product>(productService.addNewProduct(Product), HttpStatus.OK);
	}


//	System.out.println("comming ");
//	String id=product.getCategory().getCategoryId();
//	System.out.println("id is"+id);
//	Category categoy=categoryRepo.findById(id).orElse(null);
//	System.out.println("****"+categoy);
////	Product product=new Product();
//	product.setCategory(categoy);
//	return new ResponseEntity<Product>(productService.addNewProduct(product), HttpStatus.OK);
}
