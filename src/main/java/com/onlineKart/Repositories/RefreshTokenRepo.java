package com.onlineKart.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineKart.models.RefreshTokenGenerator;

@Repository
public interface RefreshTokenRepo extends JpaRepository<RefreshTokenGenerator, Integer>{
	
	public RefreshTokenGenerator findByRefreshToken(String refreshToken);

}
