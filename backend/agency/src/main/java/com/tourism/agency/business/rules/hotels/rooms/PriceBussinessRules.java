package com.tourism.agency.business.rules.hotels.rooms;

import org.springframework.stereotype.Service;

import com.tourism.agency.core.utilities.exception.BusinessExeption;
import com.tourism.agency.dataAccess.abstracts.hotel.room.PriceRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class PriceBussinessRules {

	private PriceRepository repository;
	
	public void checkIfByRoomIdAndType(int roomId , String type) {
		if(this.repository.existsByRoomIdAndType(roomId, type))
			throw new BusinessExeption("Room and type already exists");
	}
}
