package com.onlineKart.models;

import java.sql.Date;
import java.util.List;

import org.apache.catalina.User;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
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
	String orderId;
	User orderedBy;
	@Temporal(TemporalType.DATE)
	Date orderDate;
	String orderPriority; //low , medium , high
	@ManyToMany
	List<Product> productsPurchased;
}
