package com.onlineKart.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
	@Id
	private String userId;
	private String firstName;
	private String lastName;
	private int Age;
	private long ContactNo;
	private String emailId;
	private String userRole;
	private String password;
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Address> addresses; 

}
