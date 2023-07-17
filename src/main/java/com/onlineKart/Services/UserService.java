package com.onlineKart.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlineKart.models.User;

@Service
public interface UserService {
	public List<User> getUserByDate(String date);
	public User addNewUser(User user);
	public User getUserFromId(int id);
	public List<User> getUsers();
	public User updateUser(User user);
	public void deleteUser(int id);
	public List<User> addAllUsers(List<User> users);
}
