package com.aulaspring.repository;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.aulaspring.entity.User;


public interface UserRepository extends MongoRepository<User, Long>{
	
	User findByName(String name);
	
	@Query("{ 'email' : ?0 }")
	User findByEmailQuery(String email);
	
//	@Query("select u from User u")
//	List<User> findByJpql();
	

}
