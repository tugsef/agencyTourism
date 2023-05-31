package com.tourism.agency.dataAccess.abstracts.hotel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourism.agency.entities.hotel.HotelFeature;

public interface HotelFeaturesRepository extends JpaRepository<HotelFeature, Integer> {

	boolean existsByPropertyAndHotelId(String property , int hotelId );
	List<HotelFeature> getByPropertyAndActive (String property , boolean active);
}
