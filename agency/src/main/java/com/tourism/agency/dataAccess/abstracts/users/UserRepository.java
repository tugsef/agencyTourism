package com.tourism.agency.dataAccess.abstracts.users;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourism.agency.entities.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	}
