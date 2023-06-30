package com.tourism.agency.dataAccess.abstracts.hotel.room;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourism.agency.entities.hotel.HotelImages;

public interface HotelImageRepository extends JpaRepository<HotelImages, Integer> {
	
	boolean existsByUrl(String url);
}
