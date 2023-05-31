package com.tourism.agency.business.rules.hotels;

import org.springframework.stereotype.Service;

import com.tourism.agency.core.utilities.exception.BusinessExeption;
import com.tourism.agency.dataAccess.abstracts.hotel.HotelsRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@Data
@AllArgsConstructor
public class HotelBussinessRules {

	private HotelsRepository repository;
	
	public void existsByName(String name) {
		if (this.repository.existsByName(name))
			throw new BusinessExeption("Hotel name already exists");
	}
}
