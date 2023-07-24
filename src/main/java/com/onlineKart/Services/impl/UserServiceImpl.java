package com.onlineKart.Services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineKart.Repositories.UserRepo;
import com.onlineKart.Services.UserService;
import com.onlineKart.models.UserProfile;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepo userRepo;
	
	@Override
	public UserProfile addNewUser(UserProfile user) {
		return userRepo.save(user);
	}

	@Override
	public UserProfile getUserFromId(String id) {
		return userRepo.findById(id).orElse(null);
	}

	@Override
	public List<UserProfile> getUsers() {
		return userRepo.findAll();
	}

	@Override
	public UserProfile updateUser(UserProfile user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(String id) {
		this.userRepo.deleteById(id);
		
	}

	@Override
	public List<UserProfile> addAllUsers(List<UserProfile> users) {
		return this.userRepo.saveAll(users);
	}

	@Override
	public UserProfile findByEmailId(String username) {
		return this.userRepo.findByEmailId(username);
	}
}
