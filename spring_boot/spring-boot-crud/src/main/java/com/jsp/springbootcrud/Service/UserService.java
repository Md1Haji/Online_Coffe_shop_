package com.jsp.springbootcrud.Service;

import java.util.List;

import com.jsp.springbootcrud.dto.User;

public interface UserService {

	
	public  String upset(User user);
		
	public User getById( int id); 
		
	public List<User> getAllUser();
	
	public String deleteById(int id);
}
