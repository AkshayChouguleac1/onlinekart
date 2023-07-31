package com.onlineKart.Services;

import java.util.Optional;

import com.onlineKart.models.RefreshTokenGenerator;

public interface RefreshTokenService {
	
	public RefreshTokenGenerator createRefreshToken(String username);
	public RefreshTokenGenerator findByRefreshToken(String token);
	public RefreshTokenGenerator verifyExpiration(RefreshTokenGenerator token);

}
