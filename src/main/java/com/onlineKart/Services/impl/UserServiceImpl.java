package com.onlineKart.Services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineKart.Repositories.UserRepo;
import com.onlineKart.Services.UserService;
import com.onlineKart.models.User;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepo userRepo;
	
	@Override
	public User addNewUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User getUserFromId(String id) {
		return userRepo.findById(id).orElse(null);
	}

	@Override
	public List<User> getUsers() {
		return userRepo.findAll();
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(String id) {
		this.userRepo.deleteById(id);
		
	}

	@Override
	public List<User> addAllUsers(List<User> users) {
		return this.userRepo.saveAll(users);
	}
}
