package com.onlineKart.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	@Id
	@GeneratedValue(generator = "prod_seq")
	@GenericGenerator(name = "prod_seq",strategy = "com.onlineKart.Utils.idGenerators.ProductIdGenerator")
	String productId;
	String productName;
	double price;
	//Here I am keeping cascadeType.persist 
	//Use persist() for saving new entities (e.g., entities with null ID or entities that are new and not yet persisted(saved in db)).
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	Category category; 


}
