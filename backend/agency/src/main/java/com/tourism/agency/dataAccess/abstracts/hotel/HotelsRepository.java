package com.tourism.agency.dataAccess.abstracts.hotel;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourism.agency.entities.hotel.Hotel;

public interface HotelsRepository extends JpaRepository<Hotel, Integer> {
	
	boolean existsByName(String name);
}
