package io.netsong7.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.netsong7.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{
	public Users findByUsername(String username);
}

