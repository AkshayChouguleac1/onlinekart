package com.onlineKart.models;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString
public class RefreshToken {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tokenId;
	
	private String refreshToken;
	
	private Instant expiryDate;
	@OneToOne
	@JoinColumn(name = "user_id")
	private UserProfile userProfile;
}
