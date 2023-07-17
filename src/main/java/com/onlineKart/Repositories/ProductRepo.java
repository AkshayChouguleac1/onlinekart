package com.onlineKart.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineKart.models.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product, String>{

}
