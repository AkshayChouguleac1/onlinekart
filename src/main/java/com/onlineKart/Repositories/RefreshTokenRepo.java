package com.onlineKart.Repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineKart.models.RefreshToken;

@Repository
public interface RefreshTokenRepo extends JpaRepository<RefreshToken, Integer>{
	Optional<RefreshToken> findByRefreshToken(String token);

}
