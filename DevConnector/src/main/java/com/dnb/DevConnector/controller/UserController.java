package com.dnb.DevConnector.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnb.DevConnector.dto.Profile;
import com.dnb.DevConnector.dto.User;
import com.dnb.DevConnector.exceptions.IdNotFoundException;
import com.dnb.DevConnector.exceptions.InvalidEmailException;
import com.dnb.DevConnector.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping("/create")
	public User createUser(@RequestBody User user) {
		return user;
	}
	
	@GetMapping("/getid/{user_id}")
	public ResponseEntity<?> getUserById
	(@PathVariable("user_id") String user_id) throws IdNotFoundException {
		Optional<User> optional = userService.getUserBymail(user_id);
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		else {
			throw new IdNotFoundException("Id not valid");
		}
	}

	@DeleteMapping("/{user_id}")
	public ResponseEntity<?> deleteUserById
	(@PathVariable("user_id") String user_id) throws IdNotFoundException, InvalidEmailException{
		if(userService.getUserBymail(user_id)!=null) {
			userService.deleteUserByMail(user_id);
			return ResponseEntity.ok("Deleted");
		}
		else {
			throw new IdNotFoundException("ID is not valid");
		}
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAllUser() {
		Iterable<User> listofUser = userService.getAllUsers();
		return ResponseEntity.ok(listofUser);

	}
}
