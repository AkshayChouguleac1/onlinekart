package com.onlineKart.models;

import java.util.List;

import jakarta.persistence.OneToMany;

public class User {
	private String userId;
	private String firstName;
	private String lastName;
	private int Age;
	private long ContactNo;
	private String emailId;
	private String userRole;
	private String password;
	@OneToMany
	private List<Address> addresses;  

}
