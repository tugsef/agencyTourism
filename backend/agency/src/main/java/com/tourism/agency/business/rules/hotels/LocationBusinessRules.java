package com.tourism.agency.business.rules.hotels;

import org.springframework.stereotype.Service;

import com.tourism.agency.core.utilities.exception.BusinessExeption;
import com.tourism.agency.dataAccess.abstracts.hotel.LocationRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class LocationBusinessRules {

	private LocationRepository repository;
	
	public void checkIfHotelIdExists(int hotelId) {
		if(this.repository.existsByHotelId(hotelId)) 
			throw new BusinessExeption("Hotel id already exists");
		
	}
	
	public void checkIfLatitudeAndLongitudeExists(String lat , String lng) {
		if(this.repository.existsByLatitudeAndLongitude(lat, lng))
			throw new BusinessExeption("Latitude and Longitude already exists");
	}
	
}
