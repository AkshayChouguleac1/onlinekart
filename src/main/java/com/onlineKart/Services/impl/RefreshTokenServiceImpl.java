package com.onlineKart.Services.impl;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineKart.Repositories.RefreshTokenRepo;
import com.onlineKart.Repositories.UserRepo;
import com.onlineKart.Services.RefreshTokenService;
import com.onlineKart.models.RefreshTokenGenerator;

@Service
public class RefreshTokenServiceImpl implements RefreshTokenService{
	
	@Autowired
	private RefreshTokenRepo refreshTokenRepo;
	@Autowired
	private UserRepo userRepo;
	
public RefreshTokenGenerator createRefreshToken(String username)
	{
		RefreshTokenGenerator refreshToken=	 new RefreshTokenGenerator();
		refreshToken.setUserProfile(userRepo.findByEmailId(username));
		refreshToken.setRefreshToken(UUID.randomUUID().toString());
		refreshToken.setExpiryDate(Instant.now().plusMillis(600000));
		return refreshTokenRepo.save(refreshToken);
		
	}

	public RefreshTokenGenerator findByRefreshToken(String refreshToken) {
		return refreshTokenRepo.findByRefreshToken(refreshToken);
	}



	@Override
	public RefreshTokenGenerator verifyExpiration(RefreshTokenGenerator refreshToken) {
		
		if(refreshToken.getExpiryDate().compareTo(Instant.now())<0)
		{
			refreshTokenRepo.delete(refreshToken);
			throw new RuntimeException(refreshToken.getRefreshToken()+" Refresh token was expired please sign in again");
		}
		return refreshToken;
	}



}
