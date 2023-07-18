package com.onlineKart.models;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class OrderModel {
	@Id
	String orderId;
	@OneToOne(cascade = CascadeType.ALL)
	User user;
	@Temporal(TemporalType.DATE)
	Date orderDate;
	String orderPriority; //low , medium , high
	@OneToMany(mappedBy = "orderModel",cascade = CascadeType.ALL)
	List<Product> products;
}
