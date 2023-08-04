package com.onlineKart.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class OrderModel {
	@Id
	@GeneratedValue(generator = "ord_seq")
	@GenericGenerator(name = "ord_seq",strategy = "com.onlineKart.Utils.idGenerators.OrderIdGenerator")
	String orderId;
	String userId;
	@Temporal(TemporalType.DATE)
	Date orderDate;
	String orderPriority; 
	@OneToMany(cascade = CascadeType.ALL)
	List<Product> products;
}
