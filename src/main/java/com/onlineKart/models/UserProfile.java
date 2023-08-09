package com.onlineKart.models;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

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
public class UserProfile {
	@Id
	@GeneratedValue(generator = "userprofile_seq")
	@GenericGenerator(name = "userprofile_seq",strategy = "com.onlineKart.Utils.idGenerators.UserProfileIdGenerator")
	private String userId;
	private String firstName;
	private String lastName;
	private int age;
	private long contactNo;
	private String emailId;
	private String userRole;
	private String password;
	@JsonManagedReference
	@OneToMany(mappedBy = "userProfile",cascade = CascadeType.ALL)
	private List<Address> addresses;
	@JsonManagedReference
	@OneToOne(mappedBy = "userProfile",cascade = CascadeType.ALL,orphanRemoval = true)
    private RefreshToken refreshToken;

}
