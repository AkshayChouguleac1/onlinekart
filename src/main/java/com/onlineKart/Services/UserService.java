package com.onlineKart.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlineKart.models.User;

@Service
public interface UserService {
	public User addNewUser(User user);
	public User getUserFromId(String id);
	public List<User> getUsers();
	public User updateUser(User user);
	public void deleteUser(String id);
	public List<User> addAllUsers(List<User> users);
}
