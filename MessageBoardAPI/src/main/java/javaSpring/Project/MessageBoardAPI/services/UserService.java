package javaSpring.Project.MessageBoardAPI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import javaSpring.Project.MessageBoardAPI.models.User;
import javaSpring.Project.MessageBoardAPI.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepo;
	
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	// Retrieve all users
	public List<User> allUsers() {
		return userRepo.findAll();
	}
	
	// Retrieve by id
	public User userById(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}
		return null;
	}
	
	// Create User
	public User createUser(User user) {
		return userRepo.save(user);
	}
	
	// Delete a user
	public void deleteUserById(Long id) {
		Optional<User> optionalUser =  userRepo.findById(id);
		
		if(optionalUser.isPresent()) {
			userRepo.deleteById(id);
		}
	}
}
