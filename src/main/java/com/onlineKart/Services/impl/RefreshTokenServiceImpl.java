package com.onlineKart.Services.impl;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineKart.Repositories.RefreshTokenRepo;
import com.onlineKart.Repositories.UserRepo;
import com.onlineKart.Services.RefreshTokenService;
import com.onlineKart.models.RefreshToken;

@Service
public class RefreshTokenServiceImpl implements RefreshTokenService{
	
    @Autowired
    private RefreshTokenRepo refreshTokenRepo;
    
    @Autowired
    private UserRepo userRepo;

    public RefreshToken createRefreshToken(String username) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUserProfile(userRepo.findByEmailId(username));
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        refreshToken.setExpiryDate(Instant.now().plusMillis(600000));
        return refreshTokenRepo.save(refreshToken);
    }


    public Optional<RefreshToken> findByRefreshToken(String refreshToken) {
        return refreshTokenRepo.findByRefreshToken(refreshToken);
    }


    public RefreshToken verifyExpiration(RefreshToken refreshToken) {
        if (refreshToken.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenRepo.delete(refreshToken);
            throw new RuntimeException(refreshToken.getRefreshToken() + " Refresh token was expired. Please make a new signin request");
        }
        return refreshToken;
    }
}
