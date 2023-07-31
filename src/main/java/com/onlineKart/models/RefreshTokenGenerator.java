package com.onlineKart.models;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RefreshTokenGenerator {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String refreshToken;
	private Instant expiryDate;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private UserProfile userProfile;

}
