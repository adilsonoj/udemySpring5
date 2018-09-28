package com.aulaspring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aulaspring.entity.User;

public interface UserRepository extends MongoRepository<User, Long>{
	
	User findByName(String name);
	

}
