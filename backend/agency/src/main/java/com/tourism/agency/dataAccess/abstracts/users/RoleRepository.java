package com.tourism.agency.dataAccess.abstracts.users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourism.agency.entities.user.ERole;
import com.tourism.agency.entities.user.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	Optional<Role> findByName(ERole name);
}
