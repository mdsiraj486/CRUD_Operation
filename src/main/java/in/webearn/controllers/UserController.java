package in.webearn.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.webearn.entity.User;
import in.webearn.projection.UserProjection;
import in.webearn.repository.UserRepo;
import in.webearn.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService service;
	
	@Autowired
	private UserRepo repo;
	
	@GetMapping(value="/get/{age}")
	public List<UserProjection> getUsers(@PathVariable("age") Integer age){
		System.out.println(age);
		List<UserProjection> byAgeGreaterThan = repo.findByAgeGreaterThan(age);
		System.out.println(byAgeGreaterThan);
		return repo.findByAgeGreaterThan(age);
	}
	
	@PostMapping(value = "/saveAll")
	public String saveAllUser(@RequestBody List<User> users) {
		users.forEach(System.out::println);
		System.out.println("++++++++++++++++++++++++++++++");
		 List<User> saveAll = repo.saveAll(users);
		System.out.println(saveAll);
		return "Ok";
	}
}
