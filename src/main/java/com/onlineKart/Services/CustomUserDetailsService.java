package com.onlineKart.Services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.onlineKart.models.UserProfile;

@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		try {
			UserProfile userProfile=userService.findByEmailId(username);
			return new User(userProfile.getEmailId(),userProfile.getPassword(), new ArrayList<>());
		} catch (Exception e) {
			throw new UsernameNotFoundException("User not found !!");
		}
//		if(username.equals("akshay"))
//		{
//			UserProfile userProfile=userService.findByEmailId(username);
//			return new User(userProfile.getFirstName(),userProfile.getPassword(), new ArrayList<>());
//		}
//		else
//		{
//			throw new UsernameNotFoundException("hvhhvhvjhv");
//		}
		}

}
