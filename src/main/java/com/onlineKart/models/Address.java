package com.onlineKart.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
public class Address {
	@Id
	@GeneratedValue(generator = "address_seq")
	@GenericGenerator(name = "address_seq",strategy = "com.onlineKart.Utils.idGenerators.AddressIdGenerator")
	String addressId;
	String addressline;
	int pincode;
	String city;
	@ManyToOne
	@JsonBackReference
	UserProfile userProfile;
}
