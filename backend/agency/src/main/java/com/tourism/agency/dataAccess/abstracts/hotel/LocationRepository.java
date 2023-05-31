package com.tourism.agency.dataAccess.abstracts.hotel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourism.agency.entities.hotel.Location;

public interface LocationRepository extends JpaRepository<Location, Integer>{

	boolean existsByHotelId(int hotelId);
	boolean existsByLatitudeAndLongitude(String latitude , String longitude);
	List<Location> findByCity(String city);
}
