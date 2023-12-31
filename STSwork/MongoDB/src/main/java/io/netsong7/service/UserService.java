package io.netsong7.service;

import java.util.List;

import io.netsong7.model.User;


public interface UserService {
	User createUser(User user);
	List<User> getAllUsers();
	User getUserById(String id);
	void deleteUserById(String id);
}
