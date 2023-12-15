package io.netsong7.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.netsong7.model.User;

public interface UserRepository extends MongoRepository<User, String>{

	
}
