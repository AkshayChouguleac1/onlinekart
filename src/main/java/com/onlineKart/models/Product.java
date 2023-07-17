package com.onlineKart.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
	String productId;
	String productName;
	double price;
	@ManyToOne
	Category category; //Many products can belong to one category
	@ManyToMany
	String orderId;
}
