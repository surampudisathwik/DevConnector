package com.dnb.DevConnector.services;

import java.util.Optional;

import com.dnb.DevConnector.dto.User;
import com.dnb.DevConnector.exceptions.InvalidEmailException;

public interface UserService {
	 	public User createUser(User user);
	    public Optional<User> getUserBymail(String userId);
	    public boolean deleteUserByMail(String userId) throws InvalidEmailException ;
	    public Iterable<User> getAllUsers();

}
