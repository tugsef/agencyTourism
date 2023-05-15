package com.tourism.agency.dataAccess.abstracts.users;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourism.agency.entities.user.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
