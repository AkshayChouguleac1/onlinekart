package com.onlineKart.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineKart.models.UserProfile;

public interface UserRepo extends JpaRepository<UserProfile, String>{
	
	public UserProfile findByEmailId(String emailId);

}
