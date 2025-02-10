package in.webearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.webearn.entity.User;
import in.webearn.projection.UserProjection;
import in.webearn.repository.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;
	
	public List<UserProjection> getUserHavingAgeGreaterThan(Integer age){
		return userRepo.findByAgeGreaterThan(age);
	}
	
	public String saveUsers(List<User> users) {
		userRepo.saveAll(users);
		return "Users save in data base successfully";
	}
}
