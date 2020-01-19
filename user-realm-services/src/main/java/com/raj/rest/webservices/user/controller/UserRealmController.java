package com.raj.rest.webservices.user.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.raj.rest.webservices.user.User;
import com.raj.rest.webservices.user.UserRepository;
import com.raj.rest.webservices.user.exception.DuplicateRealmNameException;
import com.raj.rest.webservices.user.exception.InvalidRealmNameException;

@RestController
public class UserRealmController {
	
	@Autowired
	private UserRepository userRepo;

	@GetMapping("/service/user/realm")
	public List<User> retrieveAllUser(){
		return userRepo.findAll();
	}
	
	@GetMapping("/service/user/realm/{id}")
	public Optional<User> retrieveUser(@PathVariable int id) {
		Optional<User> user = userRepo.findById(id);
		if(!user.isPresent())
			throw new Error("Id- "+id);
		
		return user;
	}
	
		
	
	@PostMapping("/service/user/realm")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User findByName = userRepo.findByName(user.getName());
		
		if(findByName!=null) {
		    if(user.getName().equals(findByName.getName())) {
			throw new DuplicateRealmNameException("DuplicateRealmName");
		    }
		}
		
		if(user.getName()==null) {
			throw new InvalidRealmNameException();
		}
		User saveUser = userRepo.save(user);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(saveUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
}
