package com.onlineKart.models;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
	@Id
	String orderId;
	@ManyToOne
	User orderedBy;
	@Temporal(TemporalType.DATE)
	Date orderDate;
	String orderPriority; //low , medium , high
	@ManyToMany
	List<Product> productsPurchased;
}
