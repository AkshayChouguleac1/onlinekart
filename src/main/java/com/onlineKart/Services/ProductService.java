package com.onlineKart.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlineKart.models.Product;

@Service
public interface ProductService {
	public Product addNewProduct(Product product);
	public Product getProductFromId(String id);
	public List<Product> getProducts();
	public Product updateProduct(Product product);
	public void deleteProduct(String id);
	public List<Product> addAllProducts(List<Product> products);
}
