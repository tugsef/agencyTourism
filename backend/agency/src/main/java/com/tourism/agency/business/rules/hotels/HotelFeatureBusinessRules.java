package com.tourism.agency.business.rules.hotels;

import org.springframework.stereotype.Service;

import com.tourism.agency.core.utilities.exception.BusinessExeption;
import com.tourism.agency.dataAccess.abstracts.hotel.HotelFeaturesRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@Data
@AllArgsConstructor
public class HotelFeatureBusinessRules {
	
	private HotelFeaturesRepository repository;
	
	public void existsByPropertyAndHotelId(String property, int hotelId) {
		if (this.repository.existsByPropertyAndHotelId(property, hotelId))
			throw new BusinessExeption("Hotel feature already exists");
	}
	
	
}
