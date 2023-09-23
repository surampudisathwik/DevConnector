package com.dnb.DevConnector.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.DevConnector.dto.User;
import com.dnb.DevConnector.exceptions.InvalidEmailException;
import com.dnb.DevConnector.repo.UserRepository;

@Service
public class UserServiceImplementation implements UserService {
	@Autowired
	UserRepository userRepository;
	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public Optional<User> getUserBymail(String userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId);
	}

	@Override
	public boolean deleteUserByMail(String userId) throws InvalidEmailException {
		if(userRepository.existsById(userId))
		{
			 userRepository.deleteById(userId);
		}
		else throw new InvalidEmailException("Email is Not Found!!");
		if(userRepository.existsById(userId)) return false;
		else return true;
	}

	@Override
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}



}
