package com.onlineKart.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.onlineKart.models.Reply;

@Component
public class CustomMessage {
	
	@Autowired
	private Reply reply;
	
	public ResponseEntity<String> callmsg()
	{
		Reply reply=new Reply("not found");
		return new ResponseEntity(reply,HttpStatus.OK);
	}
	

}
