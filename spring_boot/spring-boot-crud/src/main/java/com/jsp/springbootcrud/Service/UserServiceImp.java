package com.jsp.springbootcrud.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.springbootcrud.dto.User;
import com.jsp.springbootcrud.repo.UserRepository;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public String upset(User user) {
		  //upset (insert / update basedd on pk)
			repository.save(user);
			
			return "sucess";
	}

	@Override
	public User getById(int id) {
		Optional<User> findById =repository.findById(id);
		
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<User> getAllUser() {
		return repository.findAll();
	}

	@Override
	public String deleteById(int id) {
		if(repository.existsById(id)) {
			repository.deleteById(id);
			return "Delete Success";
		}else {
			return "No record Found";
		}
		
	}

}
