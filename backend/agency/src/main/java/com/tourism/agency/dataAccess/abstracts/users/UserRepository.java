package com.tourism.agency.dataAccess.abstracts.users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourism.agency.entities.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
Optional<User> findByUsername(String name);
	
	Boolean existsByUsername(String username);
	
	Boolean existsByEmail(String email);
	
}
