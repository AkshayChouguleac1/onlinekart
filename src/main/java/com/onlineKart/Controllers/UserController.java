package com.onlineKart.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineKart.Services.UserService;
import com.onlineKart.models.UserProfile;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "http://localhost:4200")

public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/signup")
	public ResponseEntity<UserProfile> addUSerProfile(@RequestBody UserProfile userProfile )
	{
		return new ResponseEntity(userService.addNewUser(userProfile),HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<UserProfile>>  fetchAllUser()
	{
		return new ResponseEntity(userService.getUsers(),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/del/{userId}")
	public ResponseEntity<?>deleteuser(@PathVariable String userId)
	{
		userService.deleteUser(userId);
		return ResponseEntity.ok(HttpStatus.OK);
		
	}

}
