package com.onlineKart.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Category {
	@Id
	@GeneratedValue(generator = "cat_seq")
	@GenericGenerator(name = "cat_seq",strategy = "com.onlineKart.Utils.idGenerators.CategoryIdGenerator")
	String categoryId;
	String categoryName;
	 private String imageUrl;
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
	@JsonManagedReference
	List<Product> products;
}
