package com.onlineKart.Services;

import java.util.Optional;

import com.onlineKart.models.RefreshToken;

public interface RefreshTokenService {
	public RefreshToken createRefreshToken(String username);
	public Optional<RefreshToken> findByRefreshToken(String token);
	public RefreshToken verifyExpiration(RefreshToken token);
	
}
