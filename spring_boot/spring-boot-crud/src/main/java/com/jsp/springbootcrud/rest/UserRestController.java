package com.jsp.springbootcrud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springbootcrud.Service.UserService;
import com.jsp.springbootcrud.dto.User;

@RestController
@RequestMapping("/coffee")
public class UserRestController {
	
	@Autowired
	private UserService service;
	
	
	@PostMapping
	public ResponseEntity<String> createUser(@ModelAttribute User user){
		String status = service.upset(user);
		
		return new ResponseEntity<>(status, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id){
		User user =service.getById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> allUsers = service.getAllUser();
		return new ResponseEntity<>(allUsers, HttpStatus.OK);
		
	}
	
	@PutMapping("/user")
	public ResponseEntity<String> updateuser(@RequestBody User user){
		String status = service.upset(user);
		return new ResponseEntity<> (status, HttpStatus.OK);
	}
	
	public ResponseEntity<String> delteuser(@PathVariable int id){
		String status = service.deleteById(id);
		
		return new ResponseEntity<>(status, HttpStatus.OK);
	}
 			
	
}
