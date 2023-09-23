package com.dnb.DevConnector.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dnb.DevConnector.dto.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{

}
