package com.onlineKart.Services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineKart.Repositories.ProductRepo;
import com.onlineKart.Services.ProductService;
import com.onlineKart.models.Product;
import com.onlineKart.models.Product;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductRepo productRepo;
	
	@Override
	public Product addNewProduct(Product product) {
		return productRepo.save(product);
	}

	@Override
	public Product getProductFromId(String id) {
		return productRepo.findById(id).orElse(null);
	}

	@Override
	public List<Product> getProducts() {
		return productRepo.findAll();
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(String id) {
		this.productRepo.deleteById(id);
		
	}

	@Override
	public List<Product> addAllProducts(List<Product> products) {
		return this.productRepo.saveAll(products);
	}
}
