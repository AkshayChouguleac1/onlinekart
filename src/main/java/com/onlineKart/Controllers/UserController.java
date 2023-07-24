package com.onlineKart.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineKart.Services.UserService;
import com.onlineKart.models.UserProfile;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	@GetMapping("/h")
	public String call()
	{
		return "hello";
	}
	
	@GetMapping("/fh")
	public String fcall()
	{
		return "hello";
	}
	
	@PostMapping("/signup")
	public ResponseEntity<UserProfile> addUSerProfile(@RequestBody UserProfile userProfile )
	{
		return new ResponseEntity(userService.addNewUser(userProfile),HttpStatus.OK);
	}

}
