package com.onlineKart.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlineKart.models.UserProfile;

@Service
public interface UserService {
	public UserProfile addNewUser(UserProfile user);
	public UserProfile getUserFromId(String id);
	public List<UserProfile> getUsers();
	public UserProfile updateUser(UserProfile user);
	public void deleteUser(String id);
	public List<UserProfile> addAllUsers(List<UserProfile> users);
	public UserProfile findByEmailId(String username);
}
